package com.example.ProductSellerRestTemplate.controller;

import com.example.ProductSellerRestTemplate.model.Product;
import com.example.ProductSellerRestTemplate.templates.ProductTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductSellerController {
    @Autowired
    ProductTemplate productTemplate;
    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable int id){
      //  Product p=productTemplate.getById(12);
        return ResponseEntity.ok(productTemplate.getById(id));
    }
    @GetMapping
    public ResponseEntity <Product[]> getAllProducts(){
        return productTemplate.getAllProduts();
    }
}
