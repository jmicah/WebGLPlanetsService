/* 
 * AppUserRepo.java 
 * 
 * Version: 
 *     $Id$ 
 * 
 * Revisions: 
 *     $Log$ 
 */
package com.planets.app.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.planets.app.model.AppUser;

/**
 * Application User repository.
 * 
 */
@Repository
public interface AppUserRepo extends JpaRepository<AppUser, Long>, AppUserRepoCustom {

    /**
     * Retrieve user by id.
     * 
     * @param id
     *            Long
     * 
     * @return AppUser
     */
    public AppUser findById(Long id);

    /**
     * Retrieve user by email.
     * 
     * @param email
     *            Long
     * 
     * @return AppUser
     * 
     */
    public AppUser findByEmail(String email);

}
