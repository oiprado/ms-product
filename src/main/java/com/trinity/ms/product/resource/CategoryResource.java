package com.trinity.ms.product.resource;

import com.trinity.commons.model.Category;
import com.trinity.ms.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping(value = "/api")
@RestController
public class CategoryResource {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(method = RequestMethod.POST, value = "/category")
    public ResponseEntity create(Category category) {
        return ResponseEntity.ok(categoryService.create(category));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/category")
    public ResponseEntity edit(Category category) {
        return ResponseEntity.ok(categoryService.edit(category));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/category/{id}")
    public ResponseEntity remove(Category category) {
        return ResponseEntity.ok(categoryService.remove(category.getId()));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/category/{categoryId}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Integer categoryId) {
        return ResponseEntity.ok(categoryService.getCategoryById(categoryId));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/categories/{parentCategoryId}")
    public ResponseEntity<List<Category>> getAllCategoriesByParent(@PathVariable Integer parentCategoryId) {
        return ResponseEntity.ok(categoryService.getCategoriesByParentId(parentCategoryId));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/categories")
    public ResponseEntity<List<Category>> getAllCategories() {
        return ResponseEntity.ok(categoryService.getAllCategories());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/categories/parent")
    public ResponseEntity<List<Category>> getAllParentCategories() {
        return ResponseEntity.ok(categoryService.getAllParentCategories());
    }

}
