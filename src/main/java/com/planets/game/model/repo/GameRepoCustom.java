package com.planets.game.model.repo;

import com.planets.app.model.AppUser;
import com.planets.game.model.Game;

public interface GameRepoCustom {

	public Game create(Long id);
	
	public Game create(AppUser owner, int planetLimit, int shipLimit);
	
}
