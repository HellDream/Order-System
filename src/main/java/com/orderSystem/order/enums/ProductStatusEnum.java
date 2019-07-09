package com.orderSystem.order.enums;

import lombok.Getter;

@Getter
public enum  ProductStatusEnum {
    UP(0, "On Sale"),
    DOWN(1, "Off Sale");
    private Integer code;

    private String message;

    ProductStatusEnum(Integer code, String message) {
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
