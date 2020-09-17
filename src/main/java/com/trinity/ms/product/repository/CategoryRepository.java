package com.trinity.ms.product.repository;

import com.trinity.commons.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    Category findCategoryById(Integer id);

    List<Category> findCategoriesByParentId(Category parentId);

    List<Category> findCategoriesByParentIdIsNull();
}
