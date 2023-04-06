package com.revature.Repository;

import com.revature.Model.Restaurant;
import java.util.List;

public interface RestaurantRepository extends UserRepository<Restaurant> {
    List<Restaurant> findAllByName(String restaurantName);
    List<Restaurant> findAllByAddress(String restaurantAddress);
}
