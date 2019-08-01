package com.orderSystem.order.services.impl;

import com.orderSystem.order.dao.ProductInfoRepository;
import com.orderSystem.order.dtos.CartDTO;
import com.orderSystem.order.entities.ProductInfo;
import com.orderSystem.order.enums.ResultEnum;
import com.orderSystem.order.exceptions.ProductException;
import com.orderSystem.order.services.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class ProductInfoServiceImpl implements ProductInfoService {
    @Autowired
    private ProductInfoRepository repository;
    @Override
    public List<ProductInfo> findByProductStatus(Integer productStatus) {
        return repository.findByProductStatus(productStatus);
    }

    @Override
    public List<ProductInfo> findByProductNameContains(String productName) {
        return repository.findByProductNameContains(productName);
    }

    @Override
    public ProductInfo findByProductId(String productId) {
        return repository.findByProductId(productId);
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return repository.save(productInfo);
    }

    @Override
    public void increaseStock(List<CartDTO> cartDTOList) {
        for(CartDTO dto:cartDTOList){
            ProductInfo productInfo = repository.findByProductId(dto.getProductId());
            productInfo.setProductStock(productInfo.getProductStock()+dto.getProductQuantity());
            save(productInfo);
        }
    }

    @Override
    @Transactional
    public void decreaseStock(List<CartDTO> cartDTOList) {
        for(CartDTO dto:cartDTOList){
            ProductInfo productInfo = repository.findByProductId(dto.getProductId());
            if(productInfo.getProductStock()<dto.getProductQuantity()){
                throw new ProductException(ResultEnum.PRODUCT_STOCK_ERROR);
            }
            productInfo.setProductStock(productInfo.getProductStock()-dto.getProductQuantity());
            repository.save(productInfo);
        }
    }
}
