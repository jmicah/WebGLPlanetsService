package com.planets.game.model.repo.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.planets.app.model.AppUser;
import com.planets.app.model.repo.AppUserRepo;
import com.planets.game.enums.RaceType;
import com.planets.game.model.Player;
import com.planets.game.model.repo.PlayerRepo;
import com.planets.game.model.repo.PlayerRepoCustom;

public class PlayerRepoImpl implements PlayerRepoCustom {

	@Autowired
	private PlayerRepo playerRepo;
		
	@Override
	public Player create(Long id) {
		Player player = playerRepo.findById(id);
		if (player == null) {
			return playerRepo.save(new Player(id));
		}
		return player;
	}

	@Override
	public Player create(RaceType race) {
			return playerRepo.save(new Player(race));
	}

}
