package com.orangeguinee.api_park_orange.service;


import com.orangeguinee.api_park_orange.model.AppRole;
import com.orangeguinee.api_park_orange.model.Users;

import java.util.List;

public interface AccountService {
    Users addNewUser(Users user);
    AppRole addNewRole(AppRole role);

    void addRoleToUser(String username, String roleName);

    Users loadUserByUsername(String username);
    List<Users> listUsers();

}
