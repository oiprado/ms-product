package com.trinity.ms.product.payload.request;

import lombok.Data;

@Data
public class CreateProductRequest {
    private Integer categoryId;
    private String name;
    private String description;
    private Float price;
    private Integer quantity;
    private String code;
}
