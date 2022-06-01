package org.luoke.ice.util.web.response;

/**
 * @author luoke
 * @date 2022/6/1 9:27
 */
public enum ResultEnum implements BaseResponseResult {
    /**
     * 成功
     */
    SUCCESS(200,"！"),
    /**
     * 请求的数据格式不符
     */
    BODY_NOT_MATCH(400,"请求的数据格式不符！"),
    /**
     * 请求的数字签名不匹配
     */
    SIGNATURE_NOT_MATCH(401,"请求的数字签名不匹配！"),
    /**
     * 未找到该资源
     */
    NOT_FOUND(404,"未找到该资源！"),
    /**
     * 服务器内部错误
     */
    INTERNAL_SERVER_ERROR(500, "服务器内部错误！"),
    /**
     * 服务器正忙，请稍后再试
     */
    SERVER_BUSY(503,"服务器正忙，请稍后再试！");

    private final int status;
    private final String message;

    ResultEnum(int status, String message) {
        this.status = status;
        this.message = message;
    }

    @Override
    public int getStatus() {
        return status;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
