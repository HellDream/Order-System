package com.orderSystem.order.dtos;

import lombok.Data;
import lombok.Setter;

@Data
@Setter
public class ResultDTO<T> {
    private Integer code;
    private String msg;
    private T data;
}
