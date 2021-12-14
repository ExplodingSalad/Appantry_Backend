package com.example.appantry_backend.APIs.Products_GroceriesListsAPI;

import com.example.appantry_backend.APIs.GroceriesListAPI.GroceriesList;
import com.example.appantry_backend.APIs.ProductAPI.Product;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "product_grocerieslist_mapping")
public class ProductsGroceriesListEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mapping_id")
    private Long mappingId;

    @OneToMany
    @Column(name = "product_id")
    private Set<Product> products;

    @ManyToOne
    @JoinColumn(name = "list_id")
    private GroceriesList groceriesList;

    public Long getMappingId() {
        return mappingId;
    }

    public void setMappingId(Long mappingId) {
        this.mappingId = mappingId;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public GroceriesList getGroceriesList() {
        return groceriesList;
    }

    public void setGroceriesList(GroceriesList groceriesList) {
        this.groceriesList = groceriesList;
    }
}
