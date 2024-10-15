package com.zomato.restaurantservice.serviceImpl;

import com.zomato.restaurantservice.DTO.RestaurantDto;
import com.zomato.restaurantservice.repository.RestaurantRepository;
import com.zomato.restaurantservice.entity.Restaurant;
import com.zomato.restaurantservice.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantServiceImpl implements RestaurantService
{
    @Autowired
    private RestaurantRepository restaurantRepository;

    @Override
    public RestaurantDto createRestaurant(RestaurantDto restaurantDto)
    {
        //Convert DTO to entity.
        Restaurant restaurant = convertDtoToEntity(restaurantDto);
        Restaurant createdRestaurant = restaurantRepository.save(restaurant);

        //Convert entity to DTO.
        return convertEntityToDto(createdRestaurant);
    }

    @Override
    public RestaurantDto getRestaurantById(Long id)
    {
        Restaurant restaurant = restaurantRepository.findById(id).orElseThrow(() -> new RuntimeException("Restaurant not found !!!"));
        return convertEntityToDto(restaurant);
    }

    //Convert DTO to entity
    private Restaurant convertDtoToEntity(RestaurantDto restaurantDto)
    {
        Restaurant restaurant = new Restaurant();
        restaurant.setId(restaurantDto.getId());
        restaurant.setName(restaurantDto.getName());
        restaurant.setAddress(restaurantDto.getAddress());
        return restaurant;
    }

    //Convert entity to DTO.
    private RestaurantDto convertEntityToDto(Restaurant restaurant)
    {
        RestaurantDto restaurantDto = new RestaurantDto();
        restaurantDto.setId(restaurant.getId());
        restaurantDto.setName(restaurant.getName());
        restaurantDto.setAddress(restaurant.getAddress());
        return restaurantDto;
    }
}
