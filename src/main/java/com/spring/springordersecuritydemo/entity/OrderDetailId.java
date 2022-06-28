package com.spring.springordersecuritydemo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class OrderDetailId implements Serializable {
    private static final long serialVersionUID = -8185069038074605978L;
    @Column(name = "order_id")
    private String orderId;
    @Column(name = "product_id")
    private String productId;

}
