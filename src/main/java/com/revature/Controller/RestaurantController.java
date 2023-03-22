package com.revature.Controller;
import com.revature.Model.Restaurant;
import com.revature.Model.User;
import com.revature.Service.ReservationService;
import com.revature.Service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.List;

@RestController
public class RestaurantController {

    RestaurantService restaurantService;


    @Autowired
    public RestaurantController(RestaurantService restaurantService){
        this.restaurantService = restaurantService;
    }

    /** 1. as a restaurant, I want to add/create restaurant
     * POST localhost/restaurant
     *
     * 2. as a restaurant, I want to update restaurant hours of operation, total seats address, or phone numbers
     * PATCH localhost:9000/restaurant/{id}
     *
     * 3. as a restaurant, I want to delete the restaurant
     * DELETE localhost:9000/restaurant/{id}
     *
     * as a restaurant, I want to see all reservations
     * GET localhost:9000/restaurant/reservations
     *
     *
     */

    /**
     * POST localhost:9000/restaurant
     * @param restaurant
     * @return
     */
    @PostMapping("restaurant")
    public Restaurant postRestaurant(@RequestBody User user, @RequestBody Restaurant restaurant){
       Restaurant newRestaurant = restaurantService.createRestaurant(user, restaurant);

       return newRestaurant;
    }

    /**
     * GET localhost:9000/restaurant
     */
    @GetMapping("restaurant")
    public List<Restaurant> getAllRestaurant(){
        return restaurantService.getAllRestaurant();
    }

    /**
     * GET localhost:9000/restaurant/{name}
     */
    @GetMapping("restaurant/{name}")
    public List<Restaurant> getRestaurantByName(@PathVariable String name){
        return restaurantService.getRestaurantByName(name);
    }

    /**
     * GET localhost:9000/restaurant/{address}
     */
    @GetMapping("restaurant/{address}")
    public Restaurant getRestaurantByAddress(@PathVariable String address){
        return restaurantService.getRestaurantByAddress(address);
    }
    /**
     * DELETE localhost:9000/restaurant/{id}
     */

    @DeleteMapping("restaurant/{id}")
    public Restaurant deleteRestaurantById(@PathVariable long id){
        return restaurantService.deleteRestaurantById(id);
    }

    /**
     * PATCH localhost:9000/restaurant/{id}
     */

    @PatchMapping("restaurant/{id}")
    public Restaurant updateRestaurant(@PathVariable long id, @RequestBody Restaurant restaurant){
        return restaurantService.updateRestaurantById(id, restaurant);
    }

}
