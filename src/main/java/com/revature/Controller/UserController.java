package com.revature.Controller;

import com.revature.Model.*;
import com.revature.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:3000"}, allowCredentials = "true")
public class UserController {
	UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping("login")
	public User login(@RequestBody User user) {
		return userService.login(user);
	}

	@PostMapping("logout/{id}")
	public User logout(@PathVariable("id") long id, @RequestHeader("sessionToken") long sessionToken) {
		return userService.logout(id, sessionToken);
	}
}
