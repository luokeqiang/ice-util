package org.luoke.ice.util.web.response;

/**
 * @author luoke
 * @date 2022/6/1 9:26
 */
public interface BaseResponseResult {
    /**
     * 响应状态码
     */
    int getStatus();

    /**
     *  响应消息描述
     */
    String getMessage();
}
