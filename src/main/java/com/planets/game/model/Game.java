package com.planets.game.model;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
			optional = true,
			targetEntity = AppUser.class,
			cascade = { PERSIST, REMOVE }
			)
	@JoinColumn(name="owner_id")
	private AppUser owner;
	
	@OneToMany (
			targetEntity = Player.class,
			cascade = { PERSIST }
			)
	private List<Player> players = new ArrayList<Player>();
	
	private int planetLimit;
	private int shipLimit;
	
	public Game() {}
	
	public Game(Long id) {
		this.id = id;
	}
	
	public Game(int planetLimit, int shipLimit) {
		
		this.planetLimit = planetLimit;
		this.shipLimit = shipLimit;
		
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setOwner(AppUser owner) {
		if (sameAsFormer(owner)) {
			System.out.println("Same as former owner.");
			return;
		}

	    this.owner = owner;
	}
	
	public AppUser getOwner() {
		return owner;
	}

	private boolean sameAsFormer(AppUser newOwner) {
		System.out.println("Old: " + owner + " vs New: " + newOwner);
		return owner==null ? newOwner == null : owner.equals(newOwner);
	}
	
	public void setPlanetLimit(int planetLimit) {
		this.planetLimit = planetLimit;
	}

	public int getPlanetLimit() {
		return planetLimit;
	}

	public void setShipLimit(int shipLimit) {
		this.shipLimit = shipLimit;
	}

	public int getShipLimit() {
		return shipLimit;
	}

	public List<Player> getPlayers() {
		return this.players;
	}

	public void addPlayer(Player player) {
		players.add(player);
	}
	
}
