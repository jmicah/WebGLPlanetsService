package com.planets.game.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.planets.game.model.Player;

@Repository
public interface PlayerRepo extends JpaRepository<Player, Long>, PlayerRepoCustom {

	public Player findById(Long id);
	
}
