package com.orderSystem.order.exceptions;

import com.orderSystem.order.enums.ResultEnum;

public class OrderException extends RuntimeException {
    private Integer code;

    public OrderException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        code = resultEnum.getCode();
    }
}
