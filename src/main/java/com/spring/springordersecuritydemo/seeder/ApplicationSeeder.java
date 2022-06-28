package com.spring.springordersecuritydemo.seeder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ApplicationSeeder implements CommandLineRunner {
    private boolean isCreate = false;
    @Autowired
    UserSeeder userSeeder;
    @Autowired
    OrderSeeder orderSeeder;
    @Autowired
    ProductSeeder productSeeder;

    @Override
    public void run(String... args) throws Exception {
        if (isCreate) {
            userSeeder.userSeeder();
            productSeeder.productSeeder();
            orderSeeder.orderSeeder();
        }
    }
}
