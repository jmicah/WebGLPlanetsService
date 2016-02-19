package com.planets.game.model.repo;

import com.planets.game.enums.Native;
import com.planets.game.model.Planet;

public interface PlanetRepoCustom {

	public Planet create(Long id);
	
	public Planet create(String name, int temp, int x, int y,
			Native natives);
	
}
