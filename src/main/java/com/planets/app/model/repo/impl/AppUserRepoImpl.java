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

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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

    @PersistenceContext
	EntityManager em;
        
    /**
     * {@inheritDoc}
     */
    @Override
    public AppUser create(Long uin) {
        AppUser user = appUserRepo.findByUin(uin);
        if (user == null) {
            return appUserRepo.save(new AppUser(uin));
        }
        return user;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AppUser create(String email, String firstName, String lastName) {
        AppUser user = appUserRepo.findByEmail(email);
        if (user == null) {
            return appUserRepo.save(new AppUser(email, firstName, lastName));
        }
        return user;
    }

}
