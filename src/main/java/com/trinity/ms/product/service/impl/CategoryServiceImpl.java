package com.trinity.ms.product.service.impl;

import com.trinity.commons.Validator;
import com.trinity.commons.model.Category;
import com.trinity.ms.product.exception.ProductValidatorException;
import com.trinity.ms.product.payload.response.ProductResponse;
import com.trinity.ms.product.repository.CategoryRepository;
import com.trinity.ms.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private List<Validator<Category>> categoriesValidators;

    @Override
    public ProductResponse create(Category category) {

        ProductResponse productResponse = new ProductResponse();
        List<String> validatorMessage = null;

        try{
            validatorMessage = categoriesValidators
                    .stream()
                    .filter( categoryValidator -> !categoryValidator.validate(category) )
                    .map( categoryValidator -> categoryValidator.getMessage() )
                    .collect(Collectors.toList());

            if(validatorMessage.size() > 0){
                throw new ProductValidatorException();
            }

            categoryRepository.save(category);
            productResponse.setContent(true);
            return productResponse;
        }catch (ProductValidatorException ex){
            productResponse.setValidator(validatorMessage);
            return productResponse;
        }
    }

    @Override
    public ProductResponse edit(Category category) {
        ProductResponse productResponse = new ProductResponse();

        try{
            categoryRepository.save(category);
            productResponse.setContent(true);
            return productResponse;
        }catch (ProductValidatorException ex){
            return productResponse;
        }
    }

    @Override
    public ProductResponse remove(Integer id) {
        ProductResponse response = new ProductResponse();
        try{
            categoryRepository.deleteById(id);
            response.setContent(true);
            return response;
        }catch (Exception ex){
            response.setContent(false);
            return response;
        }
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public List<Category> getAllParentCategories() {
        return categoryRepository.findCategoriesByParentIdIsNull();
    }

    @Override
    public List<Category> getCategoriesByParentId(Integer categoryId) {

        Category category = getCategoryById(categoryId);

        return categoryRepository.findCategoriesByParentId(category);
    }

    @Override
    public Category getCategoryById(Integer id) {
        return categoryRepository.findCategoryById(id);
    }

}
