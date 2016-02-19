/* 
 * AppUserRepoCustom.java 
 * 
 * Version: 
 *     $Id$ 
 * 
 * Revisions: 
 *     $Log$ 
 */
package com.planets.app.model.repo;

import com.planets.app.model.AppUser;

/**
 * 
 */
public interface AppUserRepoCustom {

    /**
     * method to create user based on id
     * 
     * @param id
     *            Long
     */
    public AppUser create(Long id);

    public AppUser create(String email, String firstName, String lastName, String role);

}
