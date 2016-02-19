/* 
 * AppUserRepoImpl.java 
 * 
 * Version: 
 *     $Id$ 
 * 
 * Revisions: 
 *     $Log$ 
 */
package com.planets.app.model.repo.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.planets.app.model.AppUser;
import com.planets.app.model.repo.AppUserRepo;
import com.planets.app.model.repo.AppUserRepoCustom;

/**
 * 
 */
public class AppUserRepoImpl implements AppUserRepoCustom {

    @Autowired
    private AppUserRepo appUserRepo;

    /**
     * {@inheritDoc}
     */
    @Override
    public AppUser create(Long id) {
        AppUser user = appUserRepo.findById(id);
        if (user == null) {
            return appUserRepo.save(new AppUser(id));
        }
        return user;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AppUser create(String email, String firstName, String lastName, String role) {
        AppUser user = appUserRepo.findByEmail(email);
        if (user == null) {
            return appUserRepo.save(new AppUser(email, firstName, lastName, role));
        }
        return user;
    }

}
