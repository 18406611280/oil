package com.grainoil.common.enums;

/**
 * @Author: chenminghong
 * @Date: 2021/5/13 15:22
 */
public enum  ResultCode {

    SUCCESS(0,"成功"),

    FAIL(400,"失败"),

    UNAUTHORIZED(401,"未认证"),

    NOT_FOUND(404,"接口不存在"),

    INTERNAL_SERVER_ERROR(500,"服务器内部错误");

    public int code;
    public String message;

    ResultCode(int code,String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
