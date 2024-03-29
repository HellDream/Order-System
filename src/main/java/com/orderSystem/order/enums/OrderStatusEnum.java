package com.orderSystem.order.enums;

import lombok.Getter;

@Getter
public enum OrderStatusEnum {
    NEWORDER(0,"New Order"),
    FINISHED(1, "Order Finished"),
    CANCELED(2,"Order Canceled");
    private Integer code;
    private String message;

    OrderStatusEnum(Integer code, String message) {
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