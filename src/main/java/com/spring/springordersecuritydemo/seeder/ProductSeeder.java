package com.spring.springordersecuritydemo.seeder;

import com.github.javafaker.Faker;
import com.spring.springordersecuritydemo.entity.Product;
import com.spring.springordersecuritydemo.entity.enums.ProductSimpleStatus;
import com.spring.springordersecuritydemo.repository.ProductRepository;
import com.spring.springordersecuritydemo.util.NumberUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class ProductSeeder {
    public static List<Product> products;
    private static final int NUMBER_OF_PRODUCT = 100;

    @Autowired
    ProductRepository productRepository;

    public void productSeeder() {
        Faker faker = new Faker();
        products = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_PRODUCT; i++) {
            products.add(Product.builder()
                            .id(UUID.randomUUID().toString())
                            .name(faker.name().name())
                            .detail(faker.lorem().sentence())
                            .price(new BigDecimal(NumberUtil.getRandomNumber(100, 1000) * 1000))
                            .thumbnails(faker.avatar().image())
                            .status(ProductSimpleStatus.ACTIVE)
                    .build());
        }
        productRepository.saveAll(products);
    }
}
