package com.revature.Controller;

import com.revature.Model.*;
import com.revature.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:3000"}, allowCredentials = "true")
public class CustomerController {
	CustomerService customerService;

	@Autowired
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}

	@PostMapping("customer/register")
	public Customer newCustomer(@RequestBody Customer customer) {
		return customerService.newCustomer(customer);
	}

	@GetMapping(value = "reservations", params = {"customer"})
	public List<Reservation> getCustomerReservations(@RequestParam("customer") long customer_id,
		@RequestHeader("sessionToken") long sessionToken) {
		return customerService.getReservations(customer_id, sessionToken);
	}
}
