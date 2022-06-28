package com.spring.springordersecuritydemo.restapi;

import com.spring.springordersecuritydemo.entity.Product;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/products")
public class ProductApi {
    @RequestMapping(method = RequestMethod.GET)
    public Product get() {
        return new Product();
    }
}
