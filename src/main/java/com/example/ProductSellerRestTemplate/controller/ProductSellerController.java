package com.example.ProductSellerRestTemplate.controller;

import com.example.ProductSellerRestTemplate.model.Product;
import com.example.ProductSellerRestTemplate.templates.ProductTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping
    ResponseEntity<Product> postProduct(@RequestBody Product product){
        productTemplate.postProduct(product);
        return ResponseEntity.ok(product);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Product> edit(@PathVariable int id,@RequestBody Product product){
        System.out.println(product);
        productTemplate.editProduct(id,product);
        return ResponseEntity.ok(   product);

    }
}
