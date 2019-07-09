package com.orderSystem.order.dao;

import com.orderSystem.order.entities.SellerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerInfoRepository extends JpaRepository<SellerInfo, String> {
}
