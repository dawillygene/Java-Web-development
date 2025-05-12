package com.dawilly.registration.Repositories;

import com.dawilly.registration.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User, Long>{
    User findByUsername(String username);
}
