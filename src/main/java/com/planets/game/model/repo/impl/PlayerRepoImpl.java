package com.planets.game.model.repo.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.planets.app.model.AppUser;
import com.planets.app.model.repo.AppUserRepo;
import com.planets.game.enums.RaceType;
import com.planets.game.model.Game;
import com.planets.game.model.Player;
import com.planets.game.model.repo.GameRepo;
import com.planets.game.model.repo.PlayerRepo;
import com.planets.game.model.repo.PlayerRepoCustom;

public class PlayerRepoImpl implements PlayerRepoCustom {

	@Autowired
	private PlayerRepo playerRepo;
		
	@Autowired
	private GameRepo gameRepo;

	@Autowired
	private AppUserRepo appUserRepo;
	
	@PersistenceContext
	EntityManager em;
	
	@Override
	public Player create(Long id) {
		Player player = playerRepo.findById(id);
		if (player == null) {
			return playerRepo.save(new Player(id));
		}
		return player;
	}

	@Override
	public Player create(RaceType race, Game game) {
			return playerRepo.save(new Player(race, game));
	}
	
	@Override
	@Transactional
	public void delete(Player player) {
		AppUser owner = player.getOwner();
		if(owner!=null) {
			player.setOwner(null);
			appUserRepo.save(owner);
		}
		
		Game game = player.getGame();
		if(game!=null) {
			player.setGame(null);
			gameRepo.save(game);
		}
		
		em.remove(em.contains(player) ? player : em.merge(player));
	}

}
