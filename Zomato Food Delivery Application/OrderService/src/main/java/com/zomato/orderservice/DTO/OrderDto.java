package com.zomato.orderservice.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto
{
    private Long id;
    private Long userId;
    private Long restaurantId;
    private String name;
    private String items;
    private Double totalAmount;
    private String orderDate;
}
