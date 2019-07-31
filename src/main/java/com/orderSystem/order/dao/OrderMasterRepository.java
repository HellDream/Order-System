package com.orderSystem.order.dao;

import com.orderSystem.order.entities.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderMasterRepository extends JpaRepository<OrderMaster, String> {
    Page<OrderMaster> findByBuyerOpenid(String buyerOpenId, Pageable pageable);
    OrderMaster findByOrderId(String orderId);
    Page<OrderMaster> findByOrderStatus(Integer orderStatus);
}
