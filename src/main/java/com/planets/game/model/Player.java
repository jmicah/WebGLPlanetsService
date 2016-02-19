package com.planets.game.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.planets.app.model.AppUser;
import com.planets.game.enums.RaceType;

@Entity
@Table(name = "player")
public class Player {

	@Id
	@GeneratedValue
	private Long id;
	
	public RaceType raceType;
	
	@ManyToOne(
			targetEntity = AppUser.class,
			cascade = {CascadeType.PERSIST}
			)
	public AppUser user;
	
	@ManyToOne(
			targetEntity = Game.class,
			cascade = {CascadeType.PERSIST}
			)
	public Game game;
	
	protected Player(RaceType race, AppUser user){
		this.raceType = race;
		this.user = user;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return this.id;
	}
	
	public void setUser(AppUser user) {
		this.user = user;
	}

	public AppUser getUser() {
		return this.user;
	}
	
	public void setRaceType(RaceType race) {
		this.raceType = race;
	}

	public RaceType getRaceType() {
		return this.raceType;
	}
}
