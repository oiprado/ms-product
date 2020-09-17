package com.trinity.ms.product.validator.product;


import com.trinity.commons.Validator;
import com.trinity.commons.model.Product;

public class ProductValidator implements Validator<Product> {
    @Override
    public boolean validate(Product entity) {
        return true;
    }

    @Override
    public String getMessage() {
        return "Product validator";
    }
}
