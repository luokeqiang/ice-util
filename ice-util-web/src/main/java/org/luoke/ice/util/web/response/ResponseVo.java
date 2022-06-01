package org.luoke.ice.util.web.response;

import java.util.HashMap;

/**
 * 封装 Controller 层返回对象
 * @author luoke
 * @date 2022/6/1 9:15
 */
public class ResponseVo extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;

    /**
     * 状态码
     */
    public static final String STATUS_TAG = "status";

    /**
     * 返回内容
     */
    public static final String MSG_TAG = "msg";

    /**
     * 数据对象
     */
    public static final String DATA_TAG = "data";

    private int status;

    private String msg;

    /**
     * 初始化一个新创建的 ResponseVo对象
     * @param status 状态码
     * @param msg 返回内容
     */
    public ResponseVo(int status, String msg ) { this(status, msg, null ); }

    /**
     * 初始化一个新创建的 ComResult对象
     */
    public ResponseVo(int status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        super.put(STATUS_TAG,status);
        super.put(MSG_TAG,msg);
        if(data != null) {
            super.put(DATA_TAG,data);
        }
    }

    /**
     *  返回成功，标准样式
     * @param status 状态吗
     * @param msg 消息描述
     * @param data 返回内容
     * @return ComResult
     */
    public static ResponseVo success(int status, String msg, Object data) {
        return new ResponseVo(status, msg, data);
    }

    /**
     * 返回成功，省略 status
     * @param msg 消息描述
     * @param data 返回内容
     * @return ComResult
     */
    public static ResponseVo success(String msg, Object data) {
        return new ResponseVo(ResultEnum.SUCCESS.getStatus(), msg, data);
    }

    /**
     * 返回成功，省略 status（默认为 200） 和 data
     * @param msg 消息描述
     * @return ComResult
     */
    public static ResponseVo success(String msg) {
        return new ResponseVo(ResultEnum.SUCCESS.getStatus(), msg, null);
    }

    /**
     * 成功
     * @param data 响应数据
     * @return {@link ResponseVo}
     */
    public static ResponseVo success(Object data) {
        return new ResponseVo(ResultEnum.SUCCESS.getStatus(), ResultEnum.SUCCESS.getMessage(),data);
    }

    /**
     * 返回错误
     * @param baseResponseResult {@link BaseResponseResult} 对象
     * @return {@link ResponseVo}
     */
    public static ResponseVo error(BaseResponseResult baseResponseResult) {
        return new ResponseVo(baseResponseResult.getStatus(),baseResponseResult.getMessage(),null);
    }

    /**
     * 返回错误，标准模式
     * @param status 状态吗
     * @param msg 消息描述
     * @param data 返回内容
     * @return ComResult
     */
    public static ResponseVo error(int status, String msg, Object data) {
        return new ResponseVo(status, msg, data);
    }

    /**
     * 返回错误，省略status
     * @param msg 消息描述
     * @param data 返回内容
     * @return ComResult
     */
    public static ResponseVo error(String msg, Object data) {
        return new ResponseVo(500, msg, data);
    }

    /**
     * 返回错误，省略status 和data
     * @param msg 消息描述
     * @return ComResult
     */
    public static ResponseVo error(String msg) {
        return error(msg, null);
    }

    /**
     * 返回错误，省略data
     * @param msg 消息描述
     * @return ComResult
     */
    public static ResponseVo error(int status,String msg) {
        return error(status,msg, null);
    }
}
