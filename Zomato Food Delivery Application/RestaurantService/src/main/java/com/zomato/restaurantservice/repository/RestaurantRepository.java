package com.zomato.restaurantservice.repository;

import com.zomato.restaurantservice.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long>
{
}
