package com.revature.Controller;

import com.revature.Model.*;
import com.revature.Service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:3000"}, allowCredentials = "true")
public class ReservationController {
	ReservationService reservationService;

	@Autowired
	public ReservationController(ReservationService reservationService) {
		this.reservationService = reservationService;
	}

	@PostMapping(value = "reserve", params = {"customer", "restaurant"})
	public Reservation newReservation(@RequestParam("restaurant") long restaurant_id,
		@RequestParam("customer") long customer_id, @RequestBody Reservation reservation,
		@RequestHeader("sessionToken") long sessionToken) {
		return reservationService.registerReservation(restaurant_id, customer_id, sessionToken, reservation);
	}
}
