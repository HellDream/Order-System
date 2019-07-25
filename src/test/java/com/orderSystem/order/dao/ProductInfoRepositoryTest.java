package com.orderSystem.order.dao;

import com.orderSystem.order.entities.ProductInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {
    @Autowired
    private ProductInfoRepository repository;
    @Test
    public void findByProductStatus() {
    }

    @Test
    public void findByProductNameContains() {
    }

    @Test
    public void save(){
        ProductInfo productInfo = new ProductInfo();
        productInfo.setCategoryType(3);
        productInfo.setProductName("productName 1");
        productInfo.setProductId("123456");
        productInfo.setProductDescription("productName 1,productName 1,productName 1");
        productInfo.setProductPrice(new BigDecimal(5.00));
        productInfo.setProductStock(100);
        repository.save(productInfo);
    }
}