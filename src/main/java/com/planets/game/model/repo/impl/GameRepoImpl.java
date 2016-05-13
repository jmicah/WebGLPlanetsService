package com.planets.game.model.repo.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.planets.app.model.AppUser;
import com.planets.app.model.repo.AppUserRepo;
import com.planets.game.model.Game;
import com.planets.game.model.repo.GameRepo;
import com.planets.game.model.repo.GameRepoCustom;

public class GameRepoImpl implements GameRepoCustom {

	@Autowired
	private GameRepo gameRepo;

	@Autowired
	private AppUserRepo appUserRepo;
	
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
		
		em.remove(em.contains(game) ? game : em.merge(game));
		
	}

}
