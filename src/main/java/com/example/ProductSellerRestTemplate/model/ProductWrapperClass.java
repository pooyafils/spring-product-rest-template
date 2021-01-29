package com.example.ProductSellerRestTemplate.model;

import java.util.ArrayList;
import java.util.List;

public class ProductWrapperClass  {

    private List<Product> products;
    ProductWrapperClass(){
        products=new ArrayList<>();
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
