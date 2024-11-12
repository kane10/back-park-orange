package com.orangeguinee.api_park_orange.repository;

import com.orangeguinee.api_park_orange.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepo extends JpaRepository<AppUser, Long> {
    AppUser findByUsername(String username);
}
