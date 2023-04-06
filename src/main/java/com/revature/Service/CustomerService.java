package com.revature.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

import com.revature.Repository.*;
import com.revature.Model.*;
import java.util.List;

@Service
@Transactional
public class CustomerService {
	CustomerRepository customerRepository;
	UserService userService;

	@Autowired
	public CustomerService(CustomerRepository customerRepository, UserService userService) {
		this.customerRepository = customerRepository;
		this.userService = userService;
	}

	public Customer newCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	public List<Reservation> getReservations(long id, long sessionToken) {
		Customer c = userService.validate(Customer.class , id, sessionToken);
		return c.getReservations();
	}
}
