package com.orderSystem.order.dtos;

import lombok.Data;

import java.util.List;

@Data
public class ProductListDTO {
    private String categoryName;
    private Integer categoryType;
    private List<ProductInfoDTO> productDTOS;
}
