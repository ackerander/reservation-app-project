package com.revature.Service;


import com.revature.Model.Reservation;
import com.revature.Model.Restaurant;
import com.revature.Model.User;
import com.revature.Repository.ReservationRepository;
import com.revature.Repository.RestaurantRepository;
import com.revature.Repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Component

public class RestaurantService {
    @Autowired
    RestaurantRepository restaurantRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ReservationRepository reservationRepository;
    @Autowired
    User user;

    @Autowired
    public RestaurantService(RestaurantRepository restaurantRepository){
        this.restaurantRepository = restaurantRepository;
    }

    /**
     * Sign up a new restaurant
     */



    /**
     * Create restaurant
     * @param restaurant
     * @return
     */
   public Restaurant createRestaurant(User user, Restaurant restaurant){
     if(!isValidUser(user)){
         System.out.println("User is not Valid");
         return null;
     }
//     restaurant.setRestaurantId(user.getId());
     Restaurant newRestaurant = restaurantRepository.save(restaurant);
     return newRestaurant;

   }


    /**
     * get all restaurant
     * @return
     */
   public List<Restaurant> getAllRestaurant(){
       List<Restaurant> restaurants = restaurantRepository.findAll();
       return  restaurants;

//        return restaurantRepository.findAll();
   }

    /**
     * getRestaurant by name
     */

    public List<Restaurant> getRestaurantByName(String name){
        return restaurantRepository.findRestaurantByRestaurantName(name);
    }

    /**
     * Delete restaurant
     */

    public Restaurant deleteRestaurantById(Long restaurantId){
        Optional<Restaurant> restaurantOptional = restaurantRepository.findById(restaurantId);
        Restaurant restaurant = restaurantOptional.get();
        restaurantRepository.delete(restaurant);
        return restaurant;
    }

    /**
     * update Restaurant by Id
     */
    public Restaurant updateRestaurantById(long restaurantId, Restaurant updatedRestaurant){
        Optional<Restaurant> restaurantOptional = restaurantRepository.findById(restaurantId);
        Restaurant restaurant = restaurantOptional.get();
        restaurant.setRestaurantAddress(updatedRestaurant.getRestaurantAddress());
        restaurant.setRestaurantPhone(updatedRestaurant.getRestaurantPhone());
        restaurant.setHoursOfOperation(updatedRestaurant.getHoursOfOperation());

        return  restaurant;
    }


    public Restaurant getRestaurantByAddress(String restaurantAddress) {
        return restaurantRepository.findRestaurantByRestaurantAddress(restaurantAddress);
    }


    private boolean isValidUser(User user){
        return user != null;
    }

}
