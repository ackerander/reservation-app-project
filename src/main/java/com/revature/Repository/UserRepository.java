package com.revature.Repository;

import com.revature.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByusername(String username);
    User findUserByusernameAndpasswd(String username, String password);
}
