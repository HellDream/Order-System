package com.orderSystem.order.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ProductListDTO {
    private String categoryName;
    private Integer categoryType;
    @JsonProperty("productInfoList")
    private List<ProductInfoDTO> productDTOS;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(Integer categoryType) {
        this.categoryType = categoryType;
    }

    public List<ProductInfoDTO> getProductDTOS() {
        return productDTOS;
    }

    public void setProductDTOS(List<ProductInfoDTO> productDTOS) {
        this.productDTOS = productDTOS;
    }
}
