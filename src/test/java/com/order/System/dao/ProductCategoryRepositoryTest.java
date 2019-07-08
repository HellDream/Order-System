package com.order.System.dao;

import com.order.System.objects.ProductCategory;
import com.orderSystem.order.OrderApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = OrderApplication.class)
public class ProductCategoryRepositoryTest {
    @Resource
    private ProductCategoryRepository repository;

    @Test
    public void addOne(){
        ProductCategory category  =new ProductCategory();
        category.setCategoryName("甜品");
        category.setCategoryType(1);
        repository.save(category);
    }

}