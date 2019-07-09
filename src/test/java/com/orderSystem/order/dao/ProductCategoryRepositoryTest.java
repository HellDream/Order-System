package com.orderSystem.order.dao;

import com.orderSystem.order.entities.ProductCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {
    @Autowired
    private ProductCategoryRepository repository;

    @Test
    public void test1(){
        ProductCategory productCategory = new ProductCategory("category_1",1);
        repository.save(productCategory);
    }

    @Test
    public void findByCategoryTypeInTest() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        List<ProductCategory>productCategories = repository.findByCategoryTypeIn(list);
        System.out.println(productCategories.size());
    }
}