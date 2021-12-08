package com.example.appantry_backend.APIs.ProductAPI.ProductRepository;

import com.example.appantry_backend.APIs.ProductAPI.ProductModel.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, Long> {

}
