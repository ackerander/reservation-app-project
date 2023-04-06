package com.revature.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

import com.revature.Repository.*;
import com.revature.Model.*;
import java.util.List;

@Service
@Transactional
public class UserService {
	UserRepository<User> userRepository;

	@Autowired
	public UserService(UserRepository<User> userRepository) {
		this.userRepository = userRepository;
	}

	public <T extends User> T validate(Class<T> userClass, long id, long sessionToken) {
		User u = userRepository.findById(id).get();
		if (!userClass.isInstance(u) || u.getSessionToken() < 0 || u.getSessionToken() != sessionToken)
			return null;
		return (T)u;
	}
	
	public User login(User user) {
		User u = userRepository.findByUsernameAndPasswd(user.getUsername(), user.getPasswd());
		if (u != null)
			u.setSessionToken((long)(Math.random() * Long.MAX_VALUE));
		return u;
	}

	public User logout(long id, long sessionToken) {
		User u = userRepository.findById(id).get();
		if (u == null || u.getSessionToken() < 0 || u.getSessionToken() != sessionToken)
			return null;
		u.setSessionToken(-1);
		return u;
	}
}
