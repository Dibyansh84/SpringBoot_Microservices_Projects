package com.zomato.orderservice.service;

import com.zomato.orderservice.DTO.OrderDto;

public interface OrderService
{
    OrderDto placeOrder(OrderDto orderDto);
}
