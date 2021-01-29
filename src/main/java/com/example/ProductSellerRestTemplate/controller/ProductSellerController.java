package com.example.ProductSellerRestTemplate.controller;

import com.example.ProductSellerRestTemplate.model.Product;
import com.example.ProductSellerRestTemplate.templates.ProductTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductSellerController {
    @Autowired
    ProductTemplate productTemplate;
    @GetMapping
    public ResponseEntity<Product> getById(){
        Product p=productTemplate.getById(12);
        return ResponseEntity.ok(p);
    }
}
