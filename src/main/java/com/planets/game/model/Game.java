package com.planets.game.model;

import java.util.ArrayList;
import java.util.Collection;

import static javax.persistence.CascadeType.*;
import static javax.persistence.FetchType.EAGER;

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
	
	@ManyToOne (optional = true)
	@JoinColumn(name="owner_id")
	public AppUser owner;
	
	@OneToMany ( 
    		mappedBy = "game",
    		cascade = { MERGE },
    		fetch = EAGER,
    		targetEntity = Player.class
    		)
	public Collection<Player> players = new ArrayList<Player>();
	
	public int planetLimit;
	public int shipLimit;
	
	public Game() {}
	
	public Game(Long id) {
		this.id = id;
	}
	
	public Game(AppUser owner, int planetLimit, int shipLimit) {
		
		this.planetLimit = planetLimit;
		this.shipLimit = shipLimit;
		
		this.setOwner(owner);
		
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setOwner(AppUser owner) {
		if (sameAsFormer(owner)) {
			return;
		}

	    AppUser oldOwner = this.owner;
	    this.owner = owner;

	    if (oldOwner!=null)
	      oldOwner.removeGame(this);

	    if (owner!=null)
	      owner.addGame(this);
	}
	
	public AppUser getOwner() {
		return owner;
	}

	private boolean sameAsFormer(AppUser newOwner) {
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

	/**
	 * @return The list of players associated with this 
	 */
	public Collection<Player> getPlayers() {
		return this.players;
	}

	/**
	 * @param player
	 * 
	 */
	public void addPlayer(Player player) {
		if (players.contains(player))
			return;
		
		players.add(player);
		player.setGame(this);
	}
	
	/**
	 * @param player
	 * 			Player
	 */
	public void removePlayer(Player player) {
		if (!players.contains(player))
			return;
		
		players.remove(player);
		player.setGame(null);
	}
	
}
