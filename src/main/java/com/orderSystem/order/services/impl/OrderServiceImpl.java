package com.orderSystem.order.services.impl;

import com.orderSystem.order.dao.OrderDetailRepository;
import com.orderSystem.order.dao.OrderMasterRepository;
import com.orderSystem.order.dtos.CartDTO;
import com.orderSystem.order.dtos.OrderDTO;
import com.orderSystem.order.entities.OrderDetail;
import com.orderSystem.order.entities.OrderMaster;
import com.orderSystem.order.entities.ProductInfo;
import com.orderSystem.order.enums.OrderStatusEnum;
import com.orderSystem.order.enums.ResultEnum;
import com.orderSystem.order.exceptions.OrderException;
import com.orderSystem.order.services.OrderService;
import com.orderSystem.order.services.ProductInfoService;
import com.orderSystem.order.utils.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMasterRepository orderMasterRepository;
    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Autowired
    private ProductInfoService productInfoService;

    @Override
    @Transactional
    public OrderDTO creatOrder(OrderDTO orderDTO) {
        orderDTO.setOrderId(KeyUtil.generateUniqueKey());
        BigDecimal totalPrice = new BigDecimal(BigInteger.ZERO);
        for (OrderDetail orderDetail : orderDTO.getOrderDetails()) {
            ProductInfo productInfo = productInfoService.findByProductId(orderDetail.getProductId());
            if (productInfo == null) {
                throw new OrderException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            totalPrice = totalPrice.add(
                    orderDetail.getProductPrice().multiply(
                            new BigDecimal(orderDetail.getProductQuantity())
                    ));
            orderDetail.setDetailId(KeyUtil.generateUniqueKey());
            orderDetail.setOrderId(orderDTO.getOrderId());
            BeanUtils.copyProperties(productInfo, orderDetail);
            orderDetailRepository.save(orderDetail);
        }

        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderAmount(totalPrice);
        BeanUtils.copyProperties(orderDTO, orderMaster);
        orderMasterRepository.save(orderMaster);

        List<CartDTO> cartDTOList = orderDTO.getOrderDetails().stream().map(e ->
                new CartDTO(e.getProductId(), e.getProductQuantity())).collect(Collectors.toList());
        productInfoService.decreaseStock(cartDTOList);
        return orderDTO;
    }

    @Override
    public OrderDTO findOne(String orderId) {
        OrderMaster orderMaster = orderMasterRepository.findByOrderId(orderId);
        if(orderMaster==null){
            throw new OrderException(ResultEnum.ORDER_NOT_EXIST);
        }
        List<OrderDetail> orderDetails = orderDetailRepository.findByOrderId(orderId);
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster, orderDTO);
        orderDTO.setOrderDetails(orderDetails);
        return orderDTO;
    }

    @Override
    public Page<OrderDTO> findOrderList(String buyerOpenId, Pageable pageable) {
        Page<OrderMaster> orderMasters = orderMasterRepository.findByBuyerOpenid(buyerOpenId,pageable);
        List<OrderDTO> orderDTOList = orderMasters.getContent()
                .stream().map(this::convert2OrderDTO).collect(Collectors.toList());
        return new PageImpl<>(orderDTOList,pageable,orderMasters.getTotalElements());
    }

    private OrderDTO convert2OrderDTO(OrderMaster orderMaster) {
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderDTO, orderMaster);
        return orderDTO;
    }

    @Override
    public OrderDTO updateOrder(OrderDTO orderDTO, int orderStatus) {
        OrderMaster orderMaster = new OrderMaster();
        if(!orderDTO.getOrderStatus().equals(OrderStatusEnum.NEWORDER.getCode())){
            throw new OrderException(ResultEnum.ORDER_STATUS_ERR);
        }
        // todo: cancel order; finish order;
        if(orderStatus==OrderStatusEnum.CANCELED.getCode()){
            orderDTO.setOrderStatus(OrderStatusEnum.CANCELED.getCode());
            BeanUtils.copyProperties(orderDTO, orderMaster);
            OrderMaster updateResult = orderMasterRepository.save(orderMaster);
        }else if(orderStatus==OrderStatusEnum.FINISHED.getCode()){

        }
        return orderDTO;
    }

    private void cancel(OrderDTO orderDTO){

    }

    private void finish(OrderDTO orderDTO){

    }


}
