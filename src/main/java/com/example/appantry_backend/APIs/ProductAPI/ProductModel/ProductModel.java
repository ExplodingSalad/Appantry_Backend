package com.example.appantry_backend.APIs.ProductAPI.ProductModel;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "products") //TODO create table & columns in Postgres
public class ProductModel {

    // Product ID Column, GenerationType.Identity refers to auto incr in Postgres
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productId;

    @Column(name = "product_name")
    private String productName;


    @Column(name = "product_storedquantity")
    private Integer storedProductQuantity;


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

    public Integer getStoredProductQuantity() {
        return storedProductQuantity;
    }

    public void setStoredProductQuantity(Integer storedProductQuantity) {
        this.storedProductQuantity = storedProductQuantity;
    }
}
