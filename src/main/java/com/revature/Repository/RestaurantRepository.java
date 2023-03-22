package com.revature.Repository;

import com.revature.Model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RestaurantRepository  extends JpaRepository<Restaurant, Long> {

    List<Restaurant> findRestaurantByRestaurantName(String restaurantName);

    Restaurant findRestaurantByRestaurantAddress(String restaurantAddress);

    Restaurant deleteRestaurantByRestaurantId(Long restaurantID);

}
