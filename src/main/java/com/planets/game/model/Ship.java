package com.planets.game.model;

import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.planets.game.model.Game;
import com.planets.game.enums.RaceType;
import com.planets.game.enums.ShipHull;
import com.planets.game.enums.ShipMission;

@Entity
@Table(name = "ship")
public class Ship {

	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne (
			targetEntity = Game.class,
			cascade = {CascadeType.PERSIST}
			)
	public Game game;
	
	public Ship() {}
	
	public Ship(Long id) {
		this.id = id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public void setHull(ShipHull hull) {
		// TODO Auto-generated method stub
		
	}

	
	public ShipHull getHull() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public void setName(String name) {
		// TODO Auto-generated method stub
		
	}

	
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public void setCoordinates(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	
	public Map<String, Integer> getCoordinates() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public void setDestination(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	
	public Map<String, Integer> getDestination() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public void setDamage(int damage) {
		// TODO Auto-generated method stub
		
	}

	
	public int getDamage() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public void setShield(int shield) {
		// TODO Auto-generated method stub
		
	}

	
	public int getShield() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public void setMission(ShipMission mission) {
		// TODO Auto-generated method stub
		
	}

	
	public ShipMission getMission() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public void setFriendlyCode(String fc) {
		// TODO Auto-generated method stub
		
	}

	
	public String getFriendlyCode() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public void setEnemy(RaceType enemy) {
		// TODO Auto-generated method stub
		
	}

	
	public RaceType getEnemy() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public void setEngines(int engineTech) {
		// TODO Auto-generated method stub
		
	}

	
	public int getEngines() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public void setBeams(int beamTech) {
		// TODO Auto-generated method stub
		
	}

	
	public int getBeams() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public void setBeamCount(int beamNum) {
		// TODO Auto-generated method stub
		
	}

	
	public int getBeamCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public void setTubes(int tubeTech) {
		// TODO Auto-generated method stub
		
	}

	
	public int getTubes() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public void setTubeCount(int tubeNum) {
		// TODO Auto-generated method stub
		
	}

	
	public int getTubeCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public void setTorpedoes(int torpedoes) {
		// TODO Auto-generated method stub
		
	}

	
	public void getTorpedoes() {
		// TODO Auto-generated method stub
		
	}

	
	public void setFighters(int fighters) {
		// TODO Auto-generated method stub
		
	}

	
	public void getFighters() {
		// TODO Auto-generated method stub
		
	}

	
	public void setSupply(int supply) {
		// TODO Auto-generated method stub
		
	}

	
	public void getSupply() {
		// TODO Auto-generated method stub
		
	}

	
	public void setNeutronium(int neutronium) {
		// TODO Auto-generated method stub
		
	}

	
	public void getNeutronium() {
		// TODO Auto-generated method stub
		
	}

	
	public void setColonists(int colonists) {
		// TODO Auto-generated method stub
		
	}

	
	public void getColonists() {
		// TODO Auto-generated method stub
		
	}

	
	public void setMolybdenum(int molybdenum) {
		// TODO Auto-generated method stub
		
	}

	
	public void getMolybdenum() {
		// TODO Auto-generated method stub
		
	}

	
	public void setDuranium(int duranium) {
		// TODO Auto-generated method stub
		
	}

	
	public void getDuranium() {
		// TODO Auto-generated method stub
		
	}

	
	public void setTritanium(int tritanium) {
		// TODO Auto-generated method stub
		
	}

	
	public void getTritanium() {
		// TODO Auto-generated method stub
		
	}

}

