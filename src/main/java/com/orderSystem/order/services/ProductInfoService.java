package com.orderSystem.order.services;

import com.orderSystem.order.entities.ProductInfo;

import java.util.List;

public interface ProductInfoService {
    List<ProductInfo> findByProductStatus(Integer productStatus);
    List<ProductInfo> findByProductNameContains(String productName);
    ProductInfo findByProductId(String productId);
}
