package com.trinity.ms.product.service;

import com.trinity.commons.model.Category;
import com.trinity.ms.product.payload.response.ProductResponse;

import java.util.List;

public interface CategoryService {

    ProductResponse create(Category product);
    ProductResponse edit(Category product);
    ProductResponse remove(Integer id);
    List<Category> getAllCategories();
    List<Category> getAllParentCategories();
    List<Category> getCategoriesByParentId(Integer categoryId);
    Category getCategoryById(Integer id);
}
