package com.planets.game.model;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.DETACH;
import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.REFRESH;
import static javax.persistence.CascadeType.PERSIST;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.planets.app.model.AppUser;
import com.planets.game.model.Player;

@Entity
@Table(name = "game")
public class Game {

	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne (
			cascade = { DETACH, REFRESH, MERGE },
			optional = false
			)
	public AppUser owner;
	
	@OneToMany (
			targetEntity = Player.class,
			cascade = { PERSIST }
			)
	public List<Player> players = new ArrayList<Player>();
	
	public int planetLimit;
	public int shipLimit;
	
	public Game() {}
	
	public Game(Long id) {
		this.id = id;
	}
	
	public Game(AppUser owner, int planetLimit, int shipLimit) {
		
		this.owner = owner;
		this.planetLimit = planetLimit;
		this.shipLimit = shipLimit;
		
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return this.id;
	}
	
	public AppUser getOwner() {
		return this.owner;
	}

	public void setPlanetLimit(int planetLimit) {
		this.planetLimit = planetLimit;
	}

	public int getPlanetLimit() {
		return this.planetLimit;
	}

	public void setShipLimit(int shipLimit) {
		this.shipLimit = shipLimit;
	}

	public int getShipLimit() {
		return this.shipLimit;
	}

	public List<Player> getPlayers() {
		return this.players;
	}

	public void addPlayer(Player player) {
		this.players.add(player);
	}
	
}
