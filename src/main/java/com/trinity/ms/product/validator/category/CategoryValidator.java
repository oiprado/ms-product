package com.trinity.ms.product.validator.category;

import com.trinity.commons.Validator;
import com.trinity.commons.model.Category;

public class CategoryValidator implements Validator<Category> {
    @Override
    public boolean validate(Category entity) {
        return true;
    }

    @Override
    public String getMessage() {
        return "Category validator";
    }
}
