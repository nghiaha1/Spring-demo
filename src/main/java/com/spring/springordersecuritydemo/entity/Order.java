package com.spring.springordersecuritydemo.entity;

import com.spring.springordersecuritydemo.entity.base.BaseEntity;
import com.spring.springordersecuritydemo.entity.enums.OrderSimpleStatus;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "orders")
public class Order extends BaseEntity {
    @Id
    private String id;
    private String userId;
    private BigDecimal totalPrice;
    @Enumerated(EnumType.ORDINAL)
    private OrderSimpleStatus status;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private Set<OrderDetail> orderDetailSet;

    public void orderTotalPrice() {
        this.totalPrice = new BigDecimal(0);
        if (this.orderDetailSet != null && this.orderDetailSet.size() > 0) {
            for (OrderDetail orderDetail : orderDetailSet) {
                BigDecimal orderDetailTotalPrice = orderDetail.getUnitPrice().multiply(new BigDecimal(orderDetail.getQuantity()));
                this.totalPrice = this.totalPrice.add(orderDetailTotalPrice);
            }
        }
    }
}
