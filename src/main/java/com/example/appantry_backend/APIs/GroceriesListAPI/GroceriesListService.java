package com.example.appantry_backend.APIs.GroceriesListAPI;

import com.example.appantry_backend.APIs.ProductAPI.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class GroceriesListService {

    GroceriesListRepository groceriesListRepository;

    // Constructor Injection
    public GroceriesListService(GroceriesListRepository groceriesListRepository) {
        this.groceriesListRepository = groceriesListRepository;
    }

    // Create Product
    public GroceriesList createGroceriesList(GroceriesList list) {
        return groceriesListRepository.save(list);
    }

    // Read Product ALL
    public List<GroceriesList> getGroceriesLists() {
        return groceriesListRepository.findAll();
    }

    // Read Product SPECIFIC
    public Optional<GroceriesList> getSpecificGroceriesList(Long id) {
        return groceriesListRepository.findById(id);
    }

    // Update Product
    /*
    public Product updateProduct(Product product, Long id) {
        Product updatedProduct = productRepository.findById(id).get();
        updatedProduct.setProductName(product.getProductName());
        updatedProduct.setProductVendor(product.getProductVendor());
        updatedProduct.setProductCategory(product.getProductCategory());
        updatedProduct.setProductStoredQuantity(product.getProductStoredQuantity());

        return productRepository.save(updatedProduct);
    }

     */

    // Delete Product
    public void deleteGroceriesList(Long id) {
        groceriesListRepository.deleteById(id);
    }

    /**
    public GroceriesList addProductToList(Set<Product> product, Long id) {

        GroceriesList updatedList = groceriesListRepository.findById(id).get();
        updatedList.setProduct(product);
        System.out.println(product);

        return groceriesListRepository.save(updatedList);
    }
     */
}
