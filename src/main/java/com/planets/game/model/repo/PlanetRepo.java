package com.planets.game.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.planets.game.model.Planet;

@Repository
public interface PlanetRepo extends JpaRepository<Planet, Long>, PlanetRepoCustom {

	
	public Planet findById(Long id);
	
	public Planet findByName(String name);
}
