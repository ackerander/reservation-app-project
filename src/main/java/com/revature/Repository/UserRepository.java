package com.revature.Repository;

import com.revature.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository<T extends User> extends JpaRepository<T, Long> {
    T findByUsernameAndPasswd(String username, String passwd);
}
