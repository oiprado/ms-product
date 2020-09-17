package com.trinity.ms.product.resource;

import com.trinity.ms.product.payload.request.CreateProductRequest;
import com.trinity.ms.product.payload.request.EditProductRequest;
import com.trinity.ms.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping(value = "/api")
@RestController
public class ProductResource {

    @Autowired
    private ProductService productService;

    @RequestMapping(method = RequestMethod.GET, value = "/products")
    public ResponseEntity<Page<com.trinity.commons.model.Product>> getProductsByParams(Pageable pageable, @RequestParam Map<String,String> searchParams){
        return ResponseEntity.ok(productService.getProducts(pageable, searchParams));
    }

    @RequestMapping(method =  RequestMethod.POST, value = "/product")
    public ResponseEntity create(@RequestBody CreateProductRequest request){
        return ResponseEntity.ok(productService.create(request));
    }

    @RequestMapping(method =  RequestMethod.PUT, value = "/product")
    public ResponseEntity edit(@RequestBody EditProductRequest request) {
        return ResponseEntity.ok(productService.edit(request));
    }

}
