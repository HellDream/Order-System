package com.orderSystem.order.dao;

import com.orderSystem.order.entities.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductInfoRepository extends JpaRepository<ProductInfo, String> {
}
