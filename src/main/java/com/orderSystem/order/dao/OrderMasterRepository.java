package com.orderSystem.order.dao;

import com.orderSystem.order.entities.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderMasterRepository extends JpaRepository<OrderMaster, String> {
}
