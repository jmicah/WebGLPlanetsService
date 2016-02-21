package com.planets.game.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.planets.app.model.AppUser;
import com.planets.game.model.IonStorm;
import com.planets.game.model.MineField;
import com.planets.game.model.Planet;
import com.planets.game.model.Player;
import com.planets.game.model.Ship;

@Entity
@Table(name = "game")
public class Game {

	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne (
			targetEntity = AppUser.class,
			cascade = {CascadeType.PERSIST}
			)
	public AppUser owner;
	
	@OneToMany (
			targetEntity = Player.class,
			cascade = {CascadeType.PERSIST}
			)
	public List<Player> players;
	
	public int mapHeight;
	public int mapWidth;
	
	@OneToMany (
			targetEntity = Planet.class,
			cascade = {CascadeType.PERSIST}
			)
	public List<Planet> planets;
	
	@OneToMany (
			targetEntity = Ship.class,
			cascade = {CascadeType.PERSIST}
			)
	public List<Ship> ships;
	
	@OneToMany (
			targetEntity = MineField.class,
			cascade = {CascadeType.PERSIST}
			)
	public List<MineField> mines;
	
	@OneToMany (
			targetEntity = IonStorm.class,
			cascade = {CascadeType.PERSIST}
			)
	public List<IonStorm> storms;
	
	public int planetLimit;
	public int shipLimit;
	
	public Game() {}
	
	public Game(Long id) {
		this.id = id;
	}
	
	public Game(AppUser owner, int height, int width, int planetLimit) {
		
		this.owner = owner;
		
		this.players = new ArrayList<Player>();
		
		this.mapHeight = height;
		this.mapWidth = width;
		this.planetLimit = planetLimit;
		
		this.planets = new ArrayList<Planet>();
		this.ships = new ArrayList<Ship>();
		this.mines = new ArrayList<MineField>();
		this.storms = new ArrayList<IonStorm>();
		
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

	public void setMapHeight(int height) {
		this.mapHeight = height;
	}

	public int getMapHeight() {
		return this.mapHeight;
	}

	public void setMapWidth(int width) {
		this.mapWidth = width;
	}

	public int getMapWidth() {
		return this.mapWidth;
	}

	public List<Planet> getPlanets() {
		return this.planets;
	}

	public void addPlanet(Planet planet) {
		this.planets.add(planet);
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

	public List<MineField> getMines() {
		return this.mines;
	}

	public void addMineField(MineField minefield) {
		this.mines.add(minefield);
	}
	
	public List<IonStorm> getStorms() {
		return this.storms;
	}
	
	public void addStorm(IonStorm storm) {
		this.storms.add(storm);
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
