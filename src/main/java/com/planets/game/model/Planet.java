package com.planets.game.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.planets.game.model.Game;
import com.planets.game.enums.Government;
import com.planets.game.enums.Native;
import com.planets.game.model.Player;

@Entity
@Table(name = "planet")
public class Planet {

	private static final Logger logger = LoggerFactory.getLogger(Planet.class);
	
	@Id
	@GeneratedValue
	public Long id;
	
	@Column(length=255)
	public String name;
	
	public int temp;
	
	public int xCoordinate;
	public int yCoordinate;
	
	public Native natives;
	
	public int nativesPopulation;
	public int nativesTaxRate;
	public int nativesHappiness;
	public Government nativesGovernment;
	
	public int tritaniumOnSurface;
	public int tritaniumInGround;
	public int tritaniumRate;
	
	public int duraniumOnSurface;
	public int duraniumInGround;
	public int duraniumRate;
	
	public int molybdenumOnSurface;
	public int molybdenumInGround;
	public int molybdenumRate;
	
	public int neutroniumOnSurface;
	public int neutroniumInGround;
	public int neutroniumRate;
	
	public int colonistsPopulation;
	public int colonistsTaxRate;
	public int colonistsHappiness;
	
	public int supplies;
	public int money;
	
	public int factories;
	public int mines;
	public int defenses;
	
	@ManyToOne (
			targetEntity = Player.class,
			cascade = {CascadeType.PERSIST}
			)
	public Player player;
	
	@ManyToOne (
			targetEntity = Game.class,
			cascade = {CascadeType.PERSIST}
			)
	public Game game;
	
	@ManyToMany (
			targetEntity = Planet.class,
			cascade = {CascadeType.PERSIST}
			)
	@JoinTable(name="connecting_planets")
	public List<Planet> connectingPlanets;
	
	@ManyToMany (
			targetEntity = Planet.class,
			cascade = {CascadeType.PERSIST}
			)
	@JoinTable(name="connecting_gravatonic_planets")
	public List<Planet> connectingGravatonicPlanets;
	
	@ManyToMany (
			targetEntity = Planet.class,
			cascade = {CascadeType.PERSIST}
			)
	@JoinTable(name="connecting_jump_planets")
	public List<Planet> connectingJumpPlanets;
	
	protected Planet(String name, int temp, int x, int y, Native natives) {
		
		this.name = name;
		this.temp = temp;		
		this.xCoordinate = x;
		this.yCoordinate = y;
		this.natives = natives;
		
		this.connectingPlanets = new ArrayList<Planet>();
		this.connectingGravatonicPlanets = new ArrayList<Planet>();
		this.connectingJumpPlanets = new ArrayList<Planet>();
				
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return this.id;
	}
	
	public void setName(String name) {
		this.name = name;
		
	}

	
	public String getName() {
		return this.name;
	}

	
	public void setTemp(int temp) {
		this.temp = temp;
		
	}

	
	public int getTemp() {
		return this.temp;
	}

	
	public void setCoordinates(int x, int y) {
		logger.debug("New Coords: " + x + ", " + y);
		this.xCoordinate = x;
		this.yCoordinate = y;		
	}

	
	public Map<String, Integer> getCoordinates() {
		Map<String, Integer> coords = new HashMap<String, Integer>();
		coords.put("x", this.xCoordinate);
		coords.put("y", this.yCoordinate);
		
		return coords;
	}

	
	public void setNatives(Native natives) {
		this.natives = natives;
		
	}

	
	public Native getNatives() {
		return this.natives;
	}

	
	public void setNativesPopulation(int amount) {
		this.nativesPopulation = amount;
		
	}

	
	public int getNativesPopulation() {
		return this.nativesPopulation;
	}

	
	public void setNativesTaxRate(int rate) {
		this.nativesTaxRate = rate;
		
	}

	
	public int getNativesTaxRate() {
		return this.nativesTaxRate;
	}

	
	public void setNativesHappiness(int amount) {
		this.nativesHappiness = amount;
		
	}

	
	public int getNativesHappiness() {
		return this.nativesHappiness;
		
	}
	
	
	public void setNativesGovernment(Government government) {
		this.nativesGovernment = government;
	}
	
	 
	public Government getNativesGovernment() {
		return this.nativesGovernment;
	}

	
	public void setTritaniumOnSurface(int amount) {
		this.tritaniumOnSurface = amount;
		
	}

	
	public int getTritaniumOnSurface() {
		return this.tritaniumOnSurface;
	}

	
	public void setTritaniumInGround(int amount) {
		this.tritaniumInGround = amount;
		
	}

	
	public int getTritaniumInGround() {
		return this.tritaniumInGround;
	}

	
	public void setTritaniumRate(int rate) {
		this.tritaniumRate = rate;
		
	}

	
	public int getTritaniumRate() {
		return this.tritaniumRate;
		
	}

	
	public void setDuraniumOnSurface(int amount) {
		this.duraniumOnSurface = amount;		
	}

	
	public int getDuraniumOnSurface() {
		return this.duraniumOnSurface;
	}

	
	public void setDuraniumInGround(int amount) {
		this.duraniumInGround = amount;
	}

	
	public int getDuraniumInGround() {
		return this.duraniumInGround;
	}

	
	public void setDuraniumRate(int rate) {
		this.duraniumRate = rate;
	}

	
	public int getDuraniumRate() {
		return this.duraniumRate;
	}

	
	public void setMolybdenumOnSurface(int amount) {
		this.molybdenumOnSurface = amount;
	}

	
	public int getMolybdenumOnSurface() {
		return this.molybdenumOnSurface;
	}

	
	public void setMolybdenumInGround(int amount) {
		this.molybdenumInGround = amount;
	}

	
	public int getMolybdenumInGround() {
		return this.molybdenumInGround;
	}

	
	public void setMolybdenumRate(int rate) {
		this.molybdenumRate = rate;
	}

	
	public int getMolybdenumRate() {
		return this.molybdenumRate;
	}

	
	public void setNeutroniumOnSurface(int amount) {
		this.neutroniumOnSurface = amount;
	}

	
	public int getNeutroniumOnSurface() {
		return this.neutroniumOnSurface;
	}

	
	public void setNeutroniumInGround(int amount) {
		this.neutroniumInGround = amount;
	}

	
	public int getNeutroniumInGround() {
		return this.neutroniumInGround;
	}

	
	public void setNeutroniumRate(int rate) {
		this.neutroniumRate = rate;
	}

	
	public int getNeutroniumRate() {
		return this.neutroniumRate;
	}

	
	public void setSupplies(int amount) {
		this.supplies = amount;
	}

	
	public int getSupplies() {
		return this.supplies;
	}

	
	public void setMoney(int amount) {
		this.money = amount;
	}

	
	public int getMoney() {
		return this.money;
	}

	
	public void setFactories(int amount) {
		this.factories = amount;
	}

	
	public int getFactories() {
		return this.factories;
	}

	
	public void setMines(int amount) {
		this.mines = amount;
	}

	
	public int getMines() {
		return this.mines;
	}

	
	public void setDefenses(int amount) {
		this.defenses = amount;
	}

	
	public int getDefenses() {
		return this.defenses;
	}

	
	public void setPlayer(Player player) {
		this.player = player;		
	}

	
	public Player getPlayer() {
		return this.player;
	}

	
	public void setColonistPopulation(int amount) {
		this.colonistsPopulation = amount;
	}

	
	public int getColonistPopulation() {
		return this.colonistsPopulation;
	}

	
	public void setColonistsTaxRate(int rate) {
		this.colonistsTaxRate = rate;
	}

	
	public int getColonistsTaxRate() {
		return this.colonistsTaxRate;
	}

	
	public void setColonistsHappiness(int amount) {
		this.colonistsHappiness = amount;
	}

	
	public int getColonistsHappiness() {
		return this.colonistsHappiness;
	}

	
	public void addConnectingPlanet(Planet planet) {
		this.connectingPlanets.add(planet);
	}

	
	public List<Planet> getConnectingPlanets() {
		return this.connectingPlanets;
	}

	
	public void addConnectingGravatonicPlanet(Planet planet) {
		this.connectingGravatonicPlanets.add(planet);
	}

	
	public List<Planet> getConnectingGravatonicPlanets() {
		return this.connectingGravatonicPlanets;
	}

	
	public void addConnectingJumpPlanet(Planet planet) {
		this.connectingJumpPlanets.add(planet);
	}

	
	public List<Planet> getConnectingJumpPlanets() {
		return this.connectingJumpPlanets;
	}	

}
