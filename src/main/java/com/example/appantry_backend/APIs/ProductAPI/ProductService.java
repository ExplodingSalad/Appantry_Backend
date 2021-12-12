package com.example.appantry_backend.APIs.ProductAPI;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    ProductRepository productRepository;

    // Constructor Injection
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // Create Product
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }


    // Read Product ALL
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    // Read Product SPECIFIC
    // Uses optional, since ID could be non-existing
    public Optional<Product> getSpecificProduct(Long id) {
        return productRepository.findById(id);
    }

    // Update Product
    public Product updateProduct(Product product, Long id) {
        Product updatedProduct = productRepository.findById(id).get();
        updatedProduct.setProductName(product.getProductName());
        updatedProduct.setProductVendor(product.getProductVendor());
        updatedProduct.setProductCategory(product.getProductCategory());
        updatedProduct.setProductStoredQuantity(product.getProductStoredQuantity());

        //TODO handle null values --> overwrites current values with null

        return productRepository.save(updatedProduct);
    }

    // Delete Product
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
