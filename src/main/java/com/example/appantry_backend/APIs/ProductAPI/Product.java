package com.example.appantry_backend.APIs.ProductAPI;

import javax.persistence.*;

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
    private String productName;

    @Column(name = "product_vendor")        /***/
    private String productVendor;

    @Enumerated(EnumType.STRING)
    @Column(name = "product_category")      /***/
    private Category productCategory;

    @Column(name = "product_storedquantity")
    private Integer productStoredQuantity;


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
