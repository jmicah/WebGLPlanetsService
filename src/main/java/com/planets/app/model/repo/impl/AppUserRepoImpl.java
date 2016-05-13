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

import java.util.Iterator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.planets.app.model.AppUser;
import com.planets.app.model.repo.AppUserRepo;
import com.planets.app.model.repo.AppUserRepoCustom;
import com.planets.game.model.Game;
import com.planets.game.model.Player;
import com.planets.game.model.repo.GameRepo;
import com.planets.game.model.repo.PlayerRepo;

/**
 * 
 */
public class AppUserRepoImpl implements AppUserRepoCustom {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
    @Autowired
    private AppUserRepo appUserRepo;
    
    @Autowired
    private GameRepo gameRepo;

    @Autowired
    private PlayerRepo playerRepo;
    
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
    
    @Override
	@Transactional
	public void delete(AppUser user) {
    
	    Iterator<Game> git = user.getGames().iterator();
		int i = user.getGames().size();
		while (git.hasNext()) {
			i--;
			Game g = git.next();
			logger.debug("Removing game: " + g.getId());
			g.setOwner(null);
			gameRepo.save(g);
			if(i>0) {
				git.remove();
			} else {
				break;
			}
		}
		
		Iterator<Player> pit = user.getPlayers().iterator();
		i = user.getPlayers().size();
		while (pit.hasNext()) {
			i--;
			Player p = pit.next();
			logger.debug("Removing player: " + p.getId());
			p.setOwner(null);
			playerRepo.save(p);
			if(i>0) {
				pit.remove();
			} else {
				break;
			}
		}
	
		em.remove(em.contains(user) ? user : em.merge(user));
	}

}
