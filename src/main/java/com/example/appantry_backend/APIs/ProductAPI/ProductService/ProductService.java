package com.example.appantry_backend.APIs.ProductAPI.ProductService;

import com.example.appantry_backend.APIs.ProductAPI.ProductModel.ProductModel;
import com.example.appantry_backend.APIs.ProductAPI.ProductRepository.ProductRepository;
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
    public ProductModel createProduct(ProductModel product) {
        return productRepository.save(product);
    }


    // Read Product ALL
    public List<ProductModel> getProducts() {
        return productRepository.findAll();
    }

    // Read Product SPECIFIC
    // Uses optional, since ID could be non-existing
    public Optional<ProductModel> getSpecificProduct(Long id) {
        return productRepository.findById(id);
    }

    // Update Product
    public ProductModel updateProduct(ProductModel product, Long id) {
        ProductModel updatedProduct = productRepository.findById(id).get();
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
