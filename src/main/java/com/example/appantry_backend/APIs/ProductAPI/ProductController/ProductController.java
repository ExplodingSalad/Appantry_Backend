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

/**
 * TODO add query param
 * */

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
    @RequestMapping(value = "/product/{product_id}", method = RequestMethod.GET)
    public Optional<ProductModel> readSpecificProduct(@PathVariable(value = "product_Id") Long id) {
        return productService.getSpecificProduct(id);
    }

    // POST (create resource)
    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public ProductModel createProduct(@Valid @RequestBody ProductModel product) {
        return productService.createProduct(product);
    }

    // PUT (update resource)


    // DELETE
    @RequestMapping(value = "/product/{product_id}", method = RequestMethod.DELETE)
    public void deleteProduct(@PathVariable(value = "product_id") Long id) {
        productService.deleteProduct(id);
    }


}
