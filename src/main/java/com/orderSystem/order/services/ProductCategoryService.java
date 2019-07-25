package com.orderSystem.order.services;

import com.orderSystem.order.entities.ProductCategory;

import java.util.List;

public interface ProductCategoryService {
     ProductCategory findOne(Integer productId);
     List<ProductCategory> findAll();
     List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypes);
     ProductCategory save(ProductCategory productCategory);
     List<ProductCategory> findByCategoryNameContains(String categoryName);

}
