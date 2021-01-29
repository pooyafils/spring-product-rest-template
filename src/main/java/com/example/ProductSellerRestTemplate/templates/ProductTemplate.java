package com.example.ProductSellerRestTemplate.templates;

import com.example.ProductSellerRestTemplate.model.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ProductTemplate {

    public final String PRODUCT_PATH="spring_5_rest_backend_war/product/";
    @Value("${sfg.brewery.apihost}")
    private String apihost;
    private final RestTemplate restTemplate;

    public ProductTemplate(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();

    }
    public Product getById(int id){
        System.out.println(apihost+PRODUCT_PATH+"18");
        return restTemplate.getForObject(apihost+PRODUCT_PATH+18,Product.class);
    }
}
