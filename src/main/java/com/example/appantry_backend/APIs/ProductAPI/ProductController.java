package com.example.appantry_backend.APIs.ProductAPI;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ProductController {

    final ProductService productService;
    final ModelMapper modelMapper;

    // Constructor Injection
    public ProductController(ProductService productService, ModelMapper modelMapper) {
        this.productService = productService;
        this.modelMapper = modelMapper;
    }

    // GET all products
    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public List<ProductDto> readProducts() {
        return productService.getProducts().stream()
                .map(post -> modelMapper.map(post, ProductDto.class))
                .collect(Collectors.toList());
    }

    // GET specific product
    @RequestMapping(value = "/product/{product_id}", method = RequestMethod.GET)
    public ProductDto readSpecificProduct(@PathVariable(value = "product_id") Long id) {
        return productService.getSpecificProduct(id)
                .map(prod -> modelMapper.map(prod, ProductDto.class))
                .orElseThrow(NoSuchElementException::new);
    }

    // POST (create resource)
    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public ResponseEntity<String> createProduct(@Valid @RequestBody ProductDto productDto) {

        // convert input DTO to Entity
        Product productRequest = modelMapper.map(productDto, Product.class);

        Product product = productService.createProduct(productRequest);

        // convert Entity to DTO
        ProductDto productResponse = modelMapper.map(product, ProductDto.class);

        return new ResponseEntity<String>("Item added: " + productResponse, HttpStatus.OK);
    }

    // TODO: When not providing old values that should not be overwritten,
    //  it replaces with null -> fix to use default values
    // PUT (update resource)
    @RequestMapping(value = "/product/{product_id}", method = RequestMethod.PUT)
    public ResponseEntity<ProductDto> updateProduct(@PathVariable(value = "product_id") Long id,
                                                @RequestBody ProductDto productDto) {

        // convert DTO to Entity
        Product productRequest = modelMapper.map(productDto, Product.class);

        Product product = productService.updateProduct(productRequest, id);

        // convert Entity to DTO
        ProductDto productResponse = modelMapper.map(product, ProductDto.class);

        return ResponseEntity.ok().body(productResponse);
    }

    // DELETE
    @RequestMapping(value = "/product/{product_id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteProduct(@PathVariable(value = "product_id") Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.status(HttpStatus.OK).body("Item successfully deleted");
    }


}
