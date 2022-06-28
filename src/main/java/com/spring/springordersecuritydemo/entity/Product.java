package com.spring.springordersecuritydemo.entity;

import com.spring.springordersecuritydemo.entity.enums.ProductSimpleStatus;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
public class Product {
    @Id
    private String id;
    private String name;
    private String description;
    private BigDecimal price;
    private String detail;
    private String thumbnails;
    private ProductSimpleStatus status;
}