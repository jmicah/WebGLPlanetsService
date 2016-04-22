package com.planets.game.model.repo;

import com.planets.game.model.Game;

public interface GameRepoCustom {

	public Game create(Long id);
	
	public Game create(int planetLimit, int shipLimit);
	
}
