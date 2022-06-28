package com.spring.springordersecuritydemo.entity.search;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FilterParameter {
    private String keyword;
    private int page;
    private int limit;
    private String userId;
    private LocalDateTime start;
    private LocalDateTime end;
    private int status;
}
