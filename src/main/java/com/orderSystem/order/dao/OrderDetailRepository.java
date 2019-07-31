package com.orderSystem.order.dao;

import com.orderSystem.order.entities.OrderDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {
    Page<OrderDetail> findByProductNameContains(String containsProductName);
    List<OrderDetail> findByOrderId(String orderId);

}
