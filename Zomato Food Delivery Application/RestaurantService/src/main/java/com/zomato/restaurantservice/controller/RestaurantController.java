package com.zomato.restaurantservice.controller;

import com.zomato.restaurantservice.DTO.RestaurantDto;
import com.zomato.restaurantservice.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController
{
    @Autowired
    private RestaurantService restaurantService;

    @PostMapping
    public ResponseEntity<RestaurantDto> createRestaurant(@RequestBody RestaurantDto restaurantDto)
    {
        RestaurantDto createdRestaurant = restaurantService.createRestaurant(restaurantDto);
        return new ResponseEntity<>(createdRestaurant, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestaurantDto> getRestaurantById(@PathVariable Long id)
    {
        RestaurantDto restaurantDto = restaurantService.getRestaurantById(id);
        return ResponseEntity.ok(restaurantDto);
    }
}
