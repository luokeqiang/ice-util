package org.luoke.ice.util.web.file;

import org.apache.commons.io.IOUtils;
import org.luoke.ice.util.web.request.HttpRangeData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @author luoke
 * @date 2022/10/14 12:07
 */
public class FileDownload {
    Logger log = LoggerFactory.getLogger(FileDownload.class);
    //path为本地文件路劲
    @RequestMapping("/preview/{path}")
    public void play(@PathVariable String path, HttpServletRequest request, HttpServletResponse response) {
        RandomAccessFile targetFile = null;
        OutputStream outputStream = null;
        try {
            outputStream = response.getOutputStream();
            response.reset();

            // 获取目标文件
            targetFile = getTargetFile(path);

            // 获取当前请求的文件长度
            long requestSize = getRequestSize(targetFile,request,response);

            // 执行文件写入
            writeData(requestSize, targetFile, outputStream);
        } catch (Exception e) {
            log.error("文件传输错误", e);
            throw new RuntimeException("文件传输错误");
        }finally {
            IOUtils.closeQuietly(outputStream,(e -> log.error("流释放错误", e)));
            IOUtils.closeQuietly(targetFile,(e -> log.error("文件流释放错误", e)));
        }
    }

    private void writeData(long requestSize, RandomAccessFile targetFile,OutputStream outputStream) throws IOException {
        //从磁盘读取数据流返回
        byte[] cache = new byte[4096];
        try {
            while (requestSize > 0) {
                int len = targetFile.read(cache);
                if (requestSize < cache.length) {
                    outputStream.write(cache, 0, (int) requestSize);
                } else {
                    outputStream.write(cache, 0, len);
                    if (len < cache.length) {
                        break;
                    }
                }
                requestSize -= cache.length;
            }
        } catch (IOException e) {
            // tomcat原话。写操作IO异常几乎总是由于客户端主动关闭连接导致，所以直接吃掉异常打日志
            //比如使用video播放视频时经常会发送Range为0- 的范围只是为了获取视频大小，之后就中断连接了
            log.info(e.getMessage());
        }
        outputStream.flush();
    }

    private RandomAccessFile getTargetFile(String fileName) throws FileNotFoundException {
        //打开文件
        File file = new File("E:\\"+fileName);
        if (!file.exists()) {
            throw new RuntimeException(String.format("文件【%s】不存在",file.getName()));
        }
        //使用RandomAccessFile读取文件
        return new RandomAccessFile(file, "r");
    }

    private long getRequestSize(RandomAccessFile targetFile, HttpServletRequest request, HttpServletResponse response) throws IOException {
        //获取请求头中Range的值
        String rangeString = request.getHeader(HttpHeaders.RANGE);
        long fileLength = targetFile.length();
        if (!StringUtils.hasText(rangeString)) {
            //如果Range为空则下载整个视频
            response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=test.mp4");
            //设置文件长度
            response.setHeader(HttpHeaders.CONTENT_LENGTH, String.valueOf(fileLength));
            return fileLength;
        }

        //分段下载视频
        //从Range中提取需要获取数据的开始和结束位置
        final HttpRangeData httpRangeData = parseHttpRange(rangeString);
        long requestStart = httpRangeData.start();
        long requestEnd = httpRangeData.end();
        long requestSize = (int) httpRangeData.requestSize(fileLength);
        //根据协议设置请求头
        response.setHeader(HttpHeaders.ACCEPT_RANGES, "bytes");
        response.setHeader(HttpHeaders.CONTENT_TYPE, "video/mp4");
        long length;
        if (requestEnd > 0) {
            length = requestEnd - requestStart + 1;
        } else {
            length = fileLength - requestStart;
            requestEnd = (fileLength -1);
        }
        response.setHeader(HttpHeaders.CONTENT_LENGTH, "" + length);
        response.setHeader(HttpHeaders.CONTENT_RANGE, String.format("bytes %s-%s/%s",requestStart, requestEnd, fileLength));
        //断点传输下载视频返回206
        response.setStatus(HttpServletResponse.SC_PARTIAL_CONTENT);
        //设置targetFile，从自定义位置开始读取数据
        targetFile.seek(requestStart);
        return requestSize;
    }

    private HttpRangeData parseHttpRange(String rangerText) {
        //从Range中提取需要获取数据的开始和结束位置
        long requestStart = 0;
        long requestEnd = 0;
        String[] ranges = rangerText.split("=");
        if (ranges.length > 1) {
            String[] rangeDatas = ranges[1].split("-");
            requestStart = Integer.parseInt(rangeDatas[0]);
            if (rangeDatas.length > 1) {
                requestEnd = Integer.parseInt(rangeDatas[1]);
            }
        }
        return new HttpRangeData(requestStart,requestEnd);
    }
}
