package com.example.appantry_backend.APIs.ProductAPI;

import lombok.Data;

@Data
public class ProductDto {

    private Long id;
    private String productName;
    private String productVendor;
    private String productCategory;
    private Integer productStoredQuantity;

}
