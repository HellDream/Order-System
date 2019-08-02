package com.orderSystem.order.services;

import com.orderSystem.order.dtos.OrderDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OrderService {
    /**
    * @description:  创建订单
    * @param: OrderDTO
    * @return OrderDTO 主订单
    */
    OrderDTO creatOrder(OrderDTO orderDTO);

    /**
    * @description: 查询单个订单
    * @param: String orderId
    * @return OrderDTO
    */
    OrderDTO findOne(String orderId);
    /**
    * @description: 查询订单列表
    * @param: String openId, Pageable pageable
    * @return Page<OrderDTO>
    */
    Page<OrderDTO> findOrderList(String buyerOpenId, Pageable pageable);
    /**o
    * @description: 更新订单状态,0为新订单 1为完成订单，2为取消订单
    * @param: String orderId, Integer orderStatus;
    * @return OrderDTO
    */
    OrderDTO updateOrder(OrderDTO orderDTO, int orderStatus);

}
