package com.planets.game.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "game_state")
public abstract class AbstractGameState implements GameState {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private int height;
	private int width;
	
	@OneToMany (
			targetEntity = Planet.class,
			cascade = {CascadeType.PERSIST}
			)
	private List<Planet> planets = new ArrayList<Planet>();
	
	@OneToMany (
			targetEntity = Ship.class,
			cascade = {CascadeType.PERSIST}
			)
	private List<Ship> ships = new ArrayList<Ship>();
	
	@OneToMany (
			targetEntity = MineField.class,
			cascade = {CascadeType.PERSIST}
			)
	private List<MineField> mines = new ArrayList<MineField>();
	
	@OneToMany (
			targetEntity = IonStorm.class,
			cascade = {CascadeType.PERSIST}
			)
	private List<IonStorm> storms = new ArrayList<IonStorm>();
	
	public AbstractGameState(){};
	
	public AbstractGameState(int height, int width) {
		this.height = height;
		this.width = width;
	}

	public void setMapHeight(int height) {
		this.height = height;
	}

	public int getMapHeight() {
		return this.height;
	}

	public void setMapWidth(int width) {
		this.width = width;
	}

	public int getMapWidth() {
		return this.width;
	}

	public List<Planet> getPlanets() {
		return this.planets;
	}

	public void addPlanet(Planet planet) {
		this.planets.add(planet);
	}
	
	public void removePlanet(Planet planet) {
		this.planets.remove(planet);
	}
	
	public Planet findPlanetByName(String name){
		for(Planet planet : this.planets) {
			if(planet.getName().equals(name))
				return planet;
		}
		return null;
	}
	
	public List<Ship> getShips() {
		return this.ships;
	}
	
	public void addShip(Ship ship) {
		this.ships.add(ship);
	}
	
	public void removeShip(Ship ship) {
		this.ships.remove(ship);
	}

	public List<MineField> getMines() {
		return this.mines;
	}

	public void addMineField(MineField minefield) {
		this.mines.add(minefield);
	}
	
	public void removeMineField(MineField minefield) {
		this.mines.remove(minefield);
	}
	
	public List<IonStorm> getStorms() {
		return this.storms;
	}
	
	public void addStorm(IonStorm storm) {
		this.storms.add(storm);
	}
	
	public void removeStorm(IonStorm storm) {
		this.storms.remove(storm);
	}
	
}
