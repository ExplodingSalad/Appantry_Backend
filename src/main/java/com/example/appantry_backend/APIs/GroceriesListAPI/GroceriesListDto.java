package com.example.appantry_backend.APIs.GroceriesListAPI;

import com.example.appantry_backend.APIs.ProductAPI.ProductDto;
import lombok.Data;
import java.util.Set;

@Data
public class GroceriesListDto {

    private Long id;
    private String listName;
    private Set<ProductDto> products;

}
