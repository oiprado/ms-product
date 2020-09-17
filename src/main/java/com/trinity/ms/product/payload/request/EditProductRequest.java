package com.trinity.ms.product.payload.request;

import lombok.Data;

@Data
public class EditProductRequest {
    private Integer id;
    private Integer categoryId;
    private String name;
    private String description;
    private Float price;
    private Integer quantity;
    private String code;
}
