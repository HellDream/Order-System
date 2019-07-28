package com.orderSystem.order.dtos;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class ProductInfoDTO {

    private String productId;
    private String productName;
    private String productDescription;
    private BigDecimal price;
    private String productIcon;

}
