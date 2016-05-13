package com.planets.game.model.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.planets.app.model.AppUser;
import com.planets.game.model.Game;

@Repository
public interface GameRepo extends JpaRepository<Game, Long>, GameRepoCustom {

	public Game findById(Long id);
	
	public List<Game> findByOwner(AppUser owner);
	
	@Override
	public void delete(Game game);
	
}
