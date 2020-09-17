package com.trinity.ms.product.payload.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProductResponse {
    private boolean content;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<String> validator;
}
