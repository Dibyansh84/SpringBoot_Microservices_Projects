package com.zomato.orderservice.serviceImpl;

import com.zomato.orderservice.DTO.OrderDto;
import com.zomato.orderservice.entity.Order;
import com.zomato.orderservice.repository.OrderRepository;
import com.zomato.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService
{
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public OrderDto placeOrder(OrderDto orderDto)
    {
        //Convert DTO to entity.
        Order order = convertDtoToEntity(orderDto);
        Order placedOrder = orderRepository.save(order);
        //Convert entity to DTO
        return convertEntityToDto(placedOrder);
    }

    //Convert DTO to entity
    private Order convertDtoToEntity(OrderDto orderDto)
    {
        Order order = new Order();
        order.setId(orderDto.getId());
        order.setUserId(orderDto.getUserId());
        order.setRestaurantId(orderDto.getRestaurantId());
        order.setName(orderDto.getName());
        order.setItems(orderDto.getItems());
        order.setTotalAmount(orderDto.getTotalAmount());
        order.setOrderDate(orderDto.getOrderDate());
        return order;
    }
    //Convert entity to DTO
    private OrderDto convertEntityToDto(Order order)
    {
        OrderDto orderDto = new OrderDto();
        orderDto.setId(order.getId());
        orderDto.setUserId(order.getUserId());
        orderDto.setRestaurantId(order.getRestaurantId());
        orderDto.setName(order.getName());
        orderDto.setItems(order.getItems());
        orderDto.setTotalAmount(order.getTotalAmount());
        orderDto.setOrderDate(order.getOrderDate());
        return orderDto;
    }
}
