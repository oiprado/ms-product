package com.trinity.ms.product.service;

import com.trinity.commons.model.Product;
import com.trinity.ms.product.payload.request.CreateProductRequest;
import com.trinity.ms.product.payload.request.EditProductRequest;
import com.trinity.ms.product.payload.response.ProductResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface ProductService {

    ProductResponse create(CreateProductRequest product);

    ProductResponse edit(EditProductRequest product);

    ProductResponse remove(Product product);

    List<Product> getProducts();

    Page<Product> getProducts(Pageable pageable, Map<String, String> params);
}
