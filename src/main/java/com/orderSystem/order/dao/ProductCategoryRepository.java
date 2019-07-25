package com.orderSystem.order.dao;

import com.orderSystem.order.entities.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {
    ProductCategory findByCategoryId(Integer categoryId);
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
    List<ProductCategory> findByCategoryNameContains(String categoryName);
}
