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
		Planet planet = planetRepo.findById(id);
		if (planet == null) {
			return planetRepo.save(new Planet(id));
		}
		return planet;
	}

	@Override
	public Planet create(String name, int temp, int x, int y,
			Native natives) {
		Planet planet = planetRepo.findByName(name);
		if (planet == null) {
			return planetRepo.save(new Planet(name, temp, x, y, natives));
		}
		return planet;
	}
	
}
