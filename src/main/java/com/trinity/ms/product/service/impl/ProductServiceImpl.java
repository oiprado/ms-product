package com.trinity.ms.product.service.impl;

import com.trinity.commons.model.Category;
import com.trinity.commons.model.Product;
import com.trinity.ms.product.payload.request.CreateProductRequest;
import com.trinity.ms.product.payload.request.EditProductRequest;
import com.trinity.ms.product.payload.response.ProductResponse;
import com.trinity.ms.product.repository.CategoryRepository;
import com.trinity.ms.product.repository.ProductRepository;
import com.trinity.ms.product.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.Predicate;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository repository;

    @Override
    public ProductResponse create(CreateProductRequest request) {

        ProductResponse response = new ProductResponse();
        Product product = new Product();
        BeanUtils.copyProperties(request, product);
        try {
            Category category = repository.findCategoryById(request.getCategoryId());
            product.setCategoryId(category);
            productRepository.save(product);
            response.setContent(true);
        }catch (Exception e){
            response.setContent(false);
        }

         return response;
    }

    @Override
    @Transactional
    public ProductResponse edit(EditProductRequest request) {
        ProductResponse response = new ProductResponse();
        try {
            Product product = productRepository.findById(request.getId()).get();
            BeanUtils.copyProperties(request, product);
            Category category = repository.findCategoryById(request.getCategoryId());
            product.setCategoryId(category);
            productRepository.save(product);
            response.setContent(true);
        }catch (Exception e){
            response.setContent(false);
        }
        return response;
    }

    @Override
    public ProductResponse remove(Product product) {
        return null;
    }

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public Page<Product> getProducts(Pageable pageable, Map<String, String> searchParams) {

        Specification specification = (Specification) (root, criteriaQuery, criteriaBuilder) -> {
            Predicate[] args = searchParams
                .keySet()
                    .stream()
                        .filter( key -> !(key.equals("page") || key.equals("size")) )
                        .map(key-> {
                            String value = searchParams.get(key);
                            if(value.contains("*")) {
                                value = value.replace("*", "%");
                                return criteriaBuilder.like(root.get(key), value);
                            } else {
                                return criteriaBuilder.equal(root.get(key), searchParams.get(key));
                            }
                        })
                        .toArray(Predicate[]::new);
            return criteriaBuilder.and(args);
        };

        return productRepository.findAll(specification, pageable);
    }


}
