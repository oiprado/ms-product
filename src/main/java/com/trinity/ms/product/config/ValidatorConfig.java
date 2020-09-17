package com.trinity.ms.product.config;


import com.trinity.commons.Validator;
import com.trinity.commons.model.Product;
import com.trinity.ms.product.validator.category.CategoryValidator;
import com.trinity.ms.product.validator.product.ProductValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class ValidatorConfig {

    @Bean
    public List<Validator<Product>> productValidators() {
        List<Validator<com.trinity.commons.model.Product>> validators = new ArrayList<>();

        validators.add(new ProductValidator());

        return validators;
    }

    @Bean
    public List<Validator<com.trinity.commons.model.Category>> categoriesValidators() {
        List<Validator<com.trinity.commons.model.Category>> validators = new ArrayList<>();

        validators.add(new CategoryValidator());

        return validators;
    }
}
