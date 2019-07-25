package com.orderSystem.order.services.impl;

import com.orderSystem.order.entities.ProductCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryServiceImplTest {
    @Autowired
    private ProductCategoryServiceImpl service;
    @Test
    public void findOne() {
        ProductCategory category = service.findOne(2);
        assertNotNull(category);
    }

    @Test
    public void findAll() {
        assertNotNull(service.findAll());
    }

    @Test
    public void findByCategoryTypeIn() {
        List<Integer> types = new ArrayList<>();
        types.addAll(Arrays.asList(1,3));
        assertNotNull(service.findByCategoryTypeIn(types));
    }

    @Test
    @Transactional
    public void save() {
        ProductCategory productCategory = new ProductCategory("category_4",4);
        assertNotNull(service.save(productCategory));
    }
}