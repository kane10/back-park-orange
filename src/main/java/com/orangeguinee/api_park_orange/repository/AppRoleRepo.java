package com.orangeguinee.api_park_orange.repository;

import com.orangeguinee.api_park_orange.model.AppRole;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepo extends JpaRepository<AppRole, Long> {
   AppRole findByRoleName(String roleName);
}
