package com.zomato.orderservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "order_details")
public class Order
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "restaurant_id")
    private Long restaurantId;
    @Column(name = "order_name")
    private String name;
    @Column(name = "ordered_items")
    private String items;
    @Column(name = "total_amount")
    private Double totalAmount;
    @Column(name = "order_date")
    private String orderDate;
}
