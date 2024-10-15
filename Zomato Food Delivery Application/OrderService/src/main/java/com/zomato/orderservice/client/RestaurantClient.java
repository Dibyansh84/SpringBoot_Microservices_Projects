package com.zomato.orderservice.client;

import com.zomato.orderservice.DTO.RestaurantDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "RESTAURANT-SERVICE")
public interface RestaurantClient
{
    @GetMapping("/api/restaurants/{id}")
    RestaurantDto getRestaurantById(@PathVariable Long id);
}
