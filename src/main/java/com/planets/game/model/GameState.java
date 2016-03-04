package com.planets.game.model;

import java.util.List;

public interface GameState {

	/**
	 * @param height
	 */
	public void setMapHeight(int height);
	
	/**
	 * @return The map height
	 */
	public int getMapHeight();
	
	/**
	 * @param width
	 */
	public void setMapWidth(int width);
	
	/**
	 * @return The map width
	 */
	public int getMapWidth();
	
	/**
	 * @return All planets specific to game
	 */
	public List<Planet> getPlanets();
	
	/**
	 * @param planet
	 */
	public void addPlanet(Planet planet);
	
	/**
	 * @param planet
	 */
	public void removePlanet(Planet planet);
	
	/**
	 * @param name
	 * @return A planet specific to game
	 */
	public Planet findPlanetByName(String name);
	
	/**
	 * @return All ships specific to game
	 */
	public List<Ship> getShips();
	
	/**
	 * @param ship
	 */
	public void addShip(Ship ship);
	
	/**
	 * @param ship
	 */
	public void removeShip(Ship ship);
	
	/**
	 * @return All minefields specific to game
	 */
	public List<MineField> getMines();
	
	/**
	 * @param minefield
	 */
	public void addMineField(MineField minefield);
	
	/**
	 * @param minefield
	 */
	public void removeMineField(MineField minefield);
	
	/**
	 * @return All Ion storms specific to game
	 */
	public List<IonStorm> getStorms();
	
	/**
	 * @param storm
	 */
	public void addStorm(IonStorm storm);
	
	/**
	 * @param storm
	 */
	public void removeStorm(IonStorm storm);
	
}
