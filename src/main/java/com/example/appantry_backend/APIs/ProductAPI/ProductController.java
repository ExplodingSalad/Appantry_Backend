package com.example.appantry_backend.APIs.ProductAPI;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;
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
        return Optional.ofNullable(productService.getSpecificProduct(id)
                .orElseThrow(() -> new NoSuchElementException()));
    }

    // POST (create resource)
    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public ResponseEntity<Object> createProduct(@Valid @RequestBody Product product) {
        productService.createProduct(product);
        return ResponseEntity.status(HttpStatus.OK).body("Item successfully added");
    }

    // PUT (update resource)
    @RequestMapping(value = "/product/{product_id}", method = RequestMethod.PUT)
    public Product updateProduct(@PathVariable(value = "product_id") Long id, @RequestBody Product product) {
        return productService.updateProduct(product, id);
    }

    // DELETE
    @RequestMapping(value = "/product/{product_id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteProduct(@PathVariable(value = "product_id") Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.status(HttpStatus.OK).body("Item successfully deleted");
    }


}
