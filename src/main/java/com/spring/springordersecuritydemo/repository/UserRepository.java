package com.spring.springordersecuritydemo.repository;

import com.spring.springordersecuritydemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
