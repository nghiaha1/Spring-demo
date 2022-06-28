package com.spring.springordersecuritydemo.seeder;

import com.github.javafaker.Faker;
import com.spring.springordersecuritydemo.entity.User;
import com.spring.springordersecuritydemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class UserSeeder {
    public static List<User> users;
    public static final int NUMBER_OF_USER = 30;

    @Autowired
    UserRepository userRepository;

    public void userSeeder() {
        Faker faker = new Faker();
        users = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_USER; i++) {
            users.add(User.builder()
                            .id(UUID.randomUUID().toString())
                            .username(faker.name().username())
                    .build());
        }
        userRepository.saveAll(users);
    }
}
