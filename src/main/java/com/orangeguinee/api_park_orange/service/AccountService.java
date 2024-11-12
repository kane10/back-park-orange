package com.orangeguinee.api_park_orange.service;


import com.orangeguinee.api_park_orange.model.AppRole;
import com.orangeguinee.api_park_orange.model.AppUser;

import java.util.List;

public interface AccountService {
    AppUser addNewUser(AppUser user);
    AppRole addNewRole(AppRole role);

    void addRoleToUser(String username, String roleName);

    AppUser loadUserByUsername(String username);
    List<AppUser> listUsers();

}
