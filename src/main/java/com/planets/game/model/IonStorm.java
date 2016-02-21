package com.planets.game.model;

import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.planets.game.model.Game;
import com.planets.game.enums.StormStatus;
import com.planets.game.enums.StormStrength;

@Entity
@Table(name = "storm")
public class IonStorm {

	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne (
			targetEntity = Game.class,
			cascade = {CascadeType.PERSIST}
			)
	public Game game;
	
	public IonStorm() {}
	
	public IonStorm(Long id) {
		this.id = id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return this.id;
	}
	
	public void setStrength(StormStrength strength) {
		// TODO Auto-generated method stub

	}

	
	public StormStrength getStrength() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public void setHeading(Long x, Long y) {
		// TODO Auto-generated method stub

	}

	
	public Map<String, Long> getHeading() {
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

	
	public void setRadius(Long radius) {
		// TODO Auto-generated method stub

	}

	
	public Long getRadius() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public void setStatus(StormStatus status) {
		// TODO Auto-generated method stub

	}

	
	public StormStatus getStatus() {
		// TODO Auto-generated method stub
		return null;
	}
}
