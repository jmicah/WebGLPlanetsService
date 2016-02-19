package com.planets.game.model.repo.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.planets.game.enums.Native;
import com.planets.game.model.Planet;
import com.planets.game.model.repo.PlanetRepo;
import com.planets.game.model.repo.PlanetRepoCustom;

public class PlanetRepoImpl implements PlanetRepoCustom {

	@Autowired
	private PlanetRepo planetRepo;

	@Override
	public Planet create(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Planet create(String name, int temp, int x, int y,
			Native natives) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
