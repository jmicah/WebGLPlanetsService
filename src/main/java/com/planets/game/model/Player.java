package com.planets.game.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.planets.app.model.AppUser;
import com.planets.game.enums.RaceType;

/**
 * Player entity.
 * 
 * A player is Race or Faction in a game. It could
 * be controlled/owned by an AppUser or by the
 * computer.
 * 
 * @author Micah Cooper
 *
 */
@Entity
@Table(name = "player")
public class Player {

	@Id
	@GeneratedValue
	public Long id;
	
	public RaceType raceType;
	
	@ManyToOne (optional = true)
	@JoinColumn(name="owner_id")
	public AppUser owner;
	
	@ManyToOne
	@JoinColumn(name="game_id")
	public Game game;
	
	public Player() {}
	
	public Player(Long id) {
		this.id = id;
	}
	
	public Player(RaceType race, Game game){
		this.raceType = race;
		
		this.setGame(game);
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return this.id;
	}
	
	public void setOwner(AppUser owner) {
		if (sameAsFormerOwner(owner)) {
			return;
		}

	    AppUser oldOwner = this.owner;
	    this.owner = owner;

	    if (oldOwner!=null)
	      oldOwner.removePlayer(this);

	    if (owner!=null)
	      owner.addPlayer(this);
	}

	public AppUser getOwner() {
		return this.owner;
	}
	
	private boolean sameAsFormerOwner(AppUser newOwner) {
		return owner==null ? newOwner == null : owner.equals(newOwner);
	}
	
	public void setGame(Game game) {
		if (sameAsFormerGame(game)) {
			return;
		}

	    Game oldGame = this.game;
	    this.game = game;

	    if (oldGame!=null)
	    	oldGame.removePlayer(this);

	    if (game!=null)
	    	game.addPlayer(this);
	}
	
	public Game getGame() {
		return this.game;
	}
	
	private boolean sameAsFormerGame(Game newGame) {
		return game==null ? newGame == null : game.equals(newGame);
	}
	
	public void setRaceType(RaceType race) {
		this.raceType = race;
	}

	public RaceType getRaceType() {
		return this.raceType;
	}
}
