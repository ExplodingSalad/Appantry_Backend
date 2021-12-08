package com.example.appantry_backend.APIs.ProductAPI.ProductController;

import com.example.appantry_backend.APIs.ProductAPI.ProductModel.ProductModel;
import com.example.appantry_backend.APIs.ProductAPI.ProductService.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProductController {

    ProductService productService;

    // Constructor Injection
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // GET all products
    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public List<ProductModel> readProducts() {
        return productService.getProducts();
    }

    // GET specific product
    @RequestMapping(value = "/product/{product_Id}", method = RequestMethod.GET)
    public Optional<ProductModel> readSpecificProduct(@PathVariable(value = "product_Id") Long id) {
        return productService.getSpecificProduct(id);
    }

    // POST (create resource)
    // @Valid
    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public ProductModel createProduct(@Valid @RequestBody ProductModel product) {
        return productService.createProduct(product);
    }

    // PUT (update resource)

    // DELETE


    // Bad Request Handler
    //generic response TODO create custom error responses
    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    Map<String,String> showCustomMessage(Exception e){


        Map<String,String> response = new HashMap<>();
        response.put("status","Your input is invalid");

        return response;
    }
}
