package com.planets.game.model.repo.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.planets.game.model.Game;
import com.planets.game.model.repo.GameRepo;
import com.planets.game.model.repo.GameRepoCustom;

public class GameRepoImpl implements GameRepoCustom {

	@Autowired
	private GameRepo gameRepo;

	@Override
	public Game create(Long id) {
		Game game = gameRepo.findById(id);
		if (game == null) {
			return gameRepo.save(new Game(id));
		}
		return game;
	}

	@Override
	public Game create(int planetLimit, int shipLimit) {
		return gameRepo.save(new Game(planetLimit, shipLimit));
	}

}
