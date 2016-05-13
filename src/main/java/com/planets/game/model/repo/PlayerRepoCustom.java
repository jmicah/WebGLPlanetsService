package com.planets.game.model.repo;

import com.planets.game.enums.RaceType;
import com.planets.game.model.Game;
import com.planets.game.model.Player;

public interface PlayerRepoCustom {

	public Player create(Long id);
	
	public Player create(RaceType race, Game game);
	
	public void delete(Player player);
	
}
