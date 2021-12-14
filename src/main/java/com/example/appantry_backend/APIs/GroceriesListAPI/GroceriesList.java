package com.example.appantry_backend.APIs.GroceriesListAPI;

import com.example.appantry_backend.APIs.ProductAPI.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "lists")
public class GroceriesList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "list_id")
    private Long listId;

    @Column(name = "list_name")
    private String listName;


    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "lists_products",
            joinColumns = @JoinColumn(name = "listId", referencedColumnName = "list_id"),
            inverseJoinColumns = @JoinColumn(name = "productId", referencedColumnName = "product_id")
    )
    private Set<Product> products;

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public Long getListId() {
        return listId;
    }

    public void setListId(Long listId) {
        this.listId = listId;
    }

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }
}
