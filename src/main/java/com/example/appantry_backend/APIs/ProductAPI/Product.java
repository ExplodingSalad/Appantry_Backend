package com.example.appantry_backend.APIs.ProductAPI;

import com.example.appantry_backend.APIs.GroceriesListAPI.GroceriesList;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "products") //TODO create more columns
public class Product {

    public enum Category {
        Dairy,
        Fruit,
        Vegetable,
        Meat,
        Grains
    }

    // Product ID Column, GenerationType.Identity refers to auto incr in Postgres
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productId;

    @Column(name = "product_name")
    @NotNull
    private String productName;

    @Column(name = "product_vendor")
    private String productVendor;

    @Enumerated(EnumType.STRING)
    @Column(name = "product_category")
    private Category productCategory;

    @Column(name = "product_storedquantity")
    private Integer productStoredQuantity;

    @JsonIgnore
    @ManyToMany(mappedBy = "products")
    private List<GroceriesList> groceriesLists;

    public List<GroceriesList> getGroceriesLists() {
        return groceriesLists;
    }

    public void setGroceriesLists(List<GroceriesList> groceriesLists) {
        this.groceriesLists = groceriesLists;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getProductStoredQuantity() {
        return productStoredQuantity;
    }

    public void setProductStoredQuantity(Integer storedProductQuantity) {
        this.productStoredQuantity = storedProductQuantity;
    }

    public String getProductVendor() {
        return productVendor;
    }

    public void setProductVendor(String productVendor) {
        this.productVendor = productVendor;
    }

    public Category getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(Category category) {
        this.productCategory = category;
    }
}
