package com.orangeguinee.api_park_orange.repository;

import com.orangeguinee.api_park_orange.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepo extends JpaRepository<Users, Long> {
    Users findByUsername(String username);
}
