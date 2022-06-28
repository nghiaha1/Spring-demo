package com.spring.springordersecuritydemo.entity.search;

import com.spring.springordersecuritydemo.entity.Order;
import com.spring.springordersecuritydemo.entity.OrderDetail;
import com.spring.springordersecuritydemo.entity.Product;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;

public class OrderSpecification implements Specification<Order> {

    private SearchCriteria searchCriteria;
    public OrderSpecification(SearchCriteria searchCriteria) {
        this.searchCriteria = searchCriteria;
    }

    @Override
    public Predicate toPredicate(Root<Order> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        switch (searchCriteria.getOperator()) {
            case EQUALS:
                return criteriaBuilder.equal(root.get(searchCriteria.getKey()), searchCriteria.getValue());
            case GREATER_THAN:
                return criteriaBuilder.greaterThan(root.get(searchCriteria.getKey()), String.valueOf(searchCriteria.getValue()));
            case GREATER_THAN_OR_EQUALS:
                return criteriaBuilder.greaterThanOrEqualTo(root.get(searchCriteria.getKey()), String.valueOf(searchCriteria.getValue()));
            case LESS_THAN:
                return criteriaBuilder.lessThan(root.get(searchCriteria.getKey()), String.valueOf(searchCriteria.getValue()));
            case LESS_THAN_OR_EQUALS:
                return criteriaBuilder.lessThanOrEqualTo(root.get(searchCriteria.getKey()), String.valueOf(searchCriteria.getValue()));
            case JOIN:
                Join<OrderDetail, Product> orderDetailProductJoin = root.join("orderDetailSet").join("product");
                Predicate predicate = criteriaBuilder.or(
                        //tìm trong order record có ID giống giá trị truyền vào
                        criteriaBuilder.like(root.get("id"), "%" + searchCriteria.getValue() + "%"),
                        //hoặc tìm trong bảng product record có name giống giá trị
                        criteriaBuilder.like(orderDetailProductJoin.get("name"), "%" + searchCriteria.getValue() + "%")
                );
            return predicate;
        }
        return null;
    }
}
