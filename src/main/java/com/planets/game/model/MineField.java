package com.planets.game.model;

import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "minefield")
public class MineField {

	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne (
			targetEntity = Game.class,
			cascade = {CascadeType.PERSIST}
			)
	public Game game;
	
	public MineField() {}
	
	public MineField(Long id) {
		this.id = id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return this.id;
	}
	
	
	public void setRadius(Long radius) {
		// TODO Auto-generated method stub

	}

	
	public Long getRadius() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public void setOwner(Player player) {
		// TODO Auto-generated method stub

	}

	
	public Player getOwner() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Boolean isWebMine() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public void setCoordinates(Long x, Long y) {
		// TODO Auto-generated method stub

	}

	
	public Map<String, Long> getCoordinates() {
		// TODO Auto-generated method stub
		return null;
	}
}
