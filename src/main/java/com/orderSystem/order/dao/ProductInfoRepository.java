package com.orderSystem.order.dao;

import com.orderSystem.order.entities.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductInfoRepository extends JpaRepository<ProductInfo, String> {
    List<ProductInfo> findByProductStatus(Integer productStatus);
    List<ProductInfo> findByProductNameContains(String productName);
    ProductInfo findByProductId(String productId);
}
