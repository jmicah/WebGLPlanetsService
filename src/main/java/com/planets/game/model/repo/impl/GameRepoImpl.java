package com.planets.game.model.repo.impl;

import java.util.Iterator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.planets.app.model.AppUser;
import com.planets.app.model.repo.AppUserRepo;
import com.planets.game.model.Game;
import com.planets.game.model.Player;
import com.planets.game.model.repo.GameRepo;
import com.planets.game.model.repo.GameRepoCustom;
import com.planets.game.model.repo.PlayerRepo;

public class GameRepoImpl implements GameRepoCustom {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private GameRepo gameRepo;

	@Autowired
	private AppUserRepo appUserRepo;
	
	@Autowired
    private PlayerRepo playerRepo;
	
	@PersistenceContext
	EntityManager em;
	
	@Override
	public Game create(Long id) {
		Game game = gameRepo.findById(id);
		if (game == null) {
			return gameRepo.save(new Game(id));
		}
		return game;
	}

	@Override
	public Game create(AppUser owner, int planetLimit, int shipLimit) {
		return gameRepo.save(new Game(owner, planetLimit, shipLimit));
	}
	
	@Override
	@Transactional
	public void delete(Game game) {
		AppUser owner = game.getOwner();
		if(owner!=null) {
			game.setOwner(null);
			appUserRepo.save(owner);
		}
		
		Iterator<Player> pit = game.getPlayers().iterator();
		int i = game.getPlayers().size();
		while (pit.hasNext()) {
			i--;
			Player p = pit.next();
			logger.debug("Removing player: " + p.getId());
			playerRepo.delete(p);
			if(i>0) {
				pit.remove();
			} else {
				break;
			}
		}
		
		em.remove(em.contains(game) ? game : em.merge(game));
		
	}

}
