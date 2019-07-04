package com.order.System.enums;

public enum PayStatusEnum {
    WAIT(0, "Waiting Payment"),
    SUCCESS(1, "Paid");
    private Integer code;
    private String message;

    PayStatusEnum(Integer code, String message) {
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
