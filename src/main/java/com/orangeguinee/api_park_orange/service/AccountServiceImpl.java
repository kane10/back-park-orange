package com.orangeguinee.api_park_orange.service;

import com.orangeguinee.api_park_orange.model.AppRole;
import com.orangeguinee.api_park_orange.model.AppUser;
import com.orangeguinee.api_park_orange.repository.AppRoleRepo;
import com.orangeguinee.api_park_orange.repository.AppUserRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    private AppUserRepo appUserRepo;
    private AppRoleRepo appRoleRepo;

    public AccountServiceImpl(AppUserRepo appUserRepo, AppRoleRepo appRoleRepo) {
        this.appUserRepo = appUserRepo;
        this.appRoleRepo = appRoleRepo;
    }




    @Override
    public AppUser addNewUser(AppUser user) {

        return appUserRepo.save(user);
    }

    @Override
    public AppRole addNewRole(AppRole role) {

        return appRoleRepo.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        AppUser user = appUserRepo.findByUsername(username);
        AppRole role = appRoleRepo.findByRoleName(roleName);
        //Affection du role a l'utilisateur

        user.getAppRoles().add(role);


    }

    @Override
    public AppUser loadUserByUsername(String username) {

        return appUserRepo.findByUsername(username);
    }

    @Override
    public List<AppUser> listUsers() {

        return appUserRepo.findAll();
    }
}
