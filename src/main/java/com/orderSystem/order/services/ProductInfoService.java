package com.orderSystem.order.services;

import com.orderSystem.order.dtos.CartDTO;
import com.orderSystem.order.entities.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductInfoService {
    List<ProductInfo> findByProductStatus(Integer productStatus);
    List<ProductInfo> findByProductNameContains(String productName);
    ProductInfo findByProductId(String productId);
    Page<ProductInfo> findAll(Pageable pageable);
    ProductInfo save(ProductInfo productInfo);
    /* todo: stock service */
    void increaseStock(List<CartDTO> cartDTOList);
    void decreaseStock(List<CartDTO> cartDTOList);

}
