package com.orderSystem.order.exceptions;

import com.orderSystem.order.enums.ResultEnum;

public class ProductException extends RuntimeException {
    private Integer code;

    public ProductException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        code = resultEnum.getCode();
    }
}
