package com.spring.springordersecuritydemo.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Product {
    @Id
    private String id;
    private String name;
    private String description;
    private String detail;
    private String thumbnails;
}