package com.meguru.blog.common;

public enum ResultCodeEnum {
    SUCCESS(200,"success"),
    EMAIL_ERROR(501,"emailError"),
    PASSWORD_ERROR(503,"passwordError"),
    NOTLOGIN(504,"notLogin"),
    USERNAME_USED(505,"userNameUsed"),
    SERVER_ERROR(506,"serverError");

    private Integer code;
    private String message;
    private ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
    public Integer getCode() {
        return code;
    }
    public String getMessage() {
        return message;
    }
}
