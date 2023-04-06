package com.revature.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.revature.Model.*;
import com.revature.Repository.*;
import jakarta.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ReservationService {
	ReservationRepository reservationRepository;
	RestaurantRepository restaurantRepository;
	CustomerRepository customerRepository;
	UserService userService;

	@Autowired
	public ReservationService(ReservationRepository reservationRepository, RestaurantRepository restaurantRepository, CustomerRepository customerRepository, UserService userService) {
		this.reservationRepository = reservationRepository;
		this.restaurantRepository = restaurantRepository;
		this.customerRepository = customerRepository;
		this.userService = userService;
	}

	public Reservation registerReservation(long restaurant_id, long customer_id, long sessionToken, Reservation reservation) {
		Customer c = userService.validate(Customer.class, customer_id, sessionToken);
		if (c == null)
			return null;
		Restaurant r = restaurantRepository.findById(restaurant_id).get();
		reservation.setRestaurant(r);
		reservation.setCustomer(c);

		Reservation newRes = reservationRepository.save(reservation);
		reservationRepository.insertReservation(customer_id, restaurant_id, newRes.getId());
		return newRes;
	}
}
