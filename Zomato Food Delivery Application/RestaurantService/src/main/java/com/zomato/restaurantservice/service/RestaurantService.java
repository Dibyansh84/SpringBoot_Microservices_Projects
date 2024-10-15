package com.zomato.restaurantservice.service;

import com.zomato.restaurantservice.DTO.RestaurantDto;

public interface RestaurantService
{
    //create a restaurant
    RestaurantDto createRestaurant(RestaurantDto restaurantDto);

    //get restaurant details by id
    RestaurantDto getRestaurantById(Long id);
}
