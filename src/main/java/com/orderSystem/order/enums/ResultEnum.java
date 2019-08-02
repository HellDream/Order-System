package com.orderSystem.order.enums;

public enum ResultEnum {
    PRODUCT_NOT_EXIST(-1, "Product does not exist"),
    PRODUCT_STOCK_ERROR(-2, "Incorrect product stock"),
    ORDER_NOT_EXIST(-3, "Order does not exist"),
    ORDER_STATUS_ERR(-4, "Order status error");
    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
