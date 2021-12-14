package com.example.appantry_backend.APIs.ProductAPI;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
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
    public List<Product> readProducts() {
        return productService.getProducts();
    }

    // GET specific product
    @RequestMapping(value = "/product/{product_id}", method = RequestMethod.GET)
    public Optional<Product> readSpecificProduct(@PathVariable(value = "product_id") Long id) {
        return productService.getSpecificProduct(id);
        //TODO handle non-existant products
    }

    // POST (create resource)
    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public Product createProduct(@Valid @RequestBody Product product) {
        return productService.createProduct(product);
    }

    // PUT (update resource)
    @RequestMapping(value = "/product/{product_id}", method = RequestMethod.PUT)
    public Product updateProduct(@PathVariable(value = "product_id") Long id, @RequestBody Product product) {
        return productService.updateProduct(product, id);
    }

    // DELETE
    @RequestMapping(value = "/product/{product_id}", method = RequestMethod.DELETE)
    public void deleteProduct(@PathVariable(value = "product_id") Long id) {
        productService.deleteProduct(id);
    }


}
