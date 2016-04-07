package com.planets.game.model;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.planets.app.WebServerInit;
import com.planets.app.model.AppUser;
import com.planets.app.model.repo.AppUserRepo;
import com.planets.game.enums.Native;
import com.planets.game.enums.RaceType;
import com.planets.game.model.repo.PlanetRepo;
import com.planets.game.model.repo.PlayerRepo;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = WebServerInit.class)
public class PlanetTests {

	@Autowired
	private PlanetRepo planets;
	
	@Autowired
	private PlayerRepo players;
	
	@Autowired
	private AppUserRepo users;
	
	@Test
	public void testNothing() {
		Assert.assertEquals(4, 2+2);
	}
	
//	/**
//	 * Test creating and deleting a planet.
//	 */
//	@Test
//	public void testcreate() {
//		Planet planet = planets.create("Earth", 50, 1500, 1700, Native.HUMANOIDS);
//		
//		Assert.assertEquals(1,planets.findAll().size());
//		
//		Assert.assertEquals("Earth",planet.getName());
//		Assert.assertEquals(50,planet.getTemp());
//		Assert.assertEquals(1500,planet.getCoordinates().get("x").intValue());
//		Assert.assertEquals(1700,planet.getCoordinates().get("y").intValue());
//		Assert.assertEquals(Native.HUMANOIDS,planet.getNatives());
//		
//		planets.delete(planet);
//		Assert.assertEquals(0,planets.findAll().size());
//		
//	}
//	
//	/**
//	 * Test persistence.
//	 */
//	@Test
//	public void testPlanetPersistence() {
//		
//		Planet planet = planets.create("Earth", 50, 1500, 1700, Native.HUMANOIDS);
//				
//		Assert.assertEquals("Earth",planet.getName());
//		Assert.assertEquals(50,planet.getTemp());
//		Assert.assertEquals(1500,planet.getCoordinates().get("x").intValue());
//		Assert.assertEquals(1700,planet.getCoordinates().get("y").intValue());
//		Assert.assertEquals(Native.HUMANOIDS,planet.getNatives());
//		
//		AppUser user = users.create("kirk@planets.com", "James", "Kirk");
//		Player player = players.create(RaceType.FEDERATION);
//		user.addPlayer(player);
//		users.save(user);
//		
//		planet.setColonistsHappiness(80);
//		planet.setColonistsTaxRate(10);
//		planet.setCoordinates(1000, 1000);
//		planet.setDefenses(20);
//		planet.setDuraniumInGround(1000);
//		planet.setDuraniumOnSurface(100);
//		planet.setDuraniumRate(10);
//		planet.setFactories(100);
//		planet.setMines(100);
//		planet.setMolybdenumInGround(2000);
//		planet.setMolybdenumOnSurface(200);
//		planet.setMolybdenumRate(20);
//		planet.setMoney(10000);
//		planet.setName("Mars");
//		planet.setNatives(Native.BOVINOIDS);
//		planet.setNativesHappiness(90);
//		planet.setNativesPopulation(20000);
//		planet.setNativesTaxRate(100);
//		planet.setNeutroniumInGround(3000);
//		planet.setNeutroniumOnSurface(300);
//		planet.setNeutroniumRate(30);
//		planet.setColonistPopulation(10000);
//		planet.setPlayer(player);
//		planet.setSupplies(500);
//		planet.setTemp(0);
//		planet.setTritaniumInGround(4000);
//		planet.setTritaniumOnSurface(400);
//		planet.setTritaniumRate(40);
//		
//		planets.save(planet);
//		Long planetId = planet.getId();
//		Long playerId = player.getId();
//		Long userId = user.getId();
//				
//		planet = planets.findById(planetId);
//		player = players.findById(playerId);
//		user = users.findOne(userId);
//		
//		Assert.assertEquals(80,planet.getColonistsHappiness());
//		Assert.assertEquals(10,planet.getColonistsTaxRate());
//		Assert.assertEquals(1000,planet.getCoordinates().get("y").intValue());
//		Assert.assertEquals(1000,planet.getCoordinates().get("x").intValue());
//		Assert.assertEquals(20,planet.getDefenses());
//		Assert.assertEquals(1000,planet.getDuraniumInGround());
//		Assert.assertEquals(100,planet.getDuraniumOnSurface());
//		Assert.assertEquals(10,planet.getDuraniumRate());
//		Assert.assertEquals(100,planet.getFactories());
//		Assert.assertEquals(100,planet.getMines());
//		Assert.assertEquals(2000,planet.getMolybdenumInGround());
//		Assert.assertEquals(200,planet.getMolybdenumOnSurface());
//		Assert.assertEquals(20,planet.getMolybdenumRate());
//		Assert.assertEquals(10000,planet.getMoney());
//		Assert.assertEquals("Mars",planet.getName());
//		Assert.assertEquals(Native.BOVINOIDS,planet.getNatives());
//		Assert.assertEquals(90,planet.getNativesHappiness());
//		Assert.assertEquals(20000,planet.getNativesPopulation());
//		Assert.assertEquals(100,planet.getNativesTaxRate());
//		Assert.assertEquals(3000,planet.getNeutroniumInGround());
//		Assert.assertEquals(300,planet.getNeutroniumOnSurface());
//		Assert.assertEquals(30,planet.getNeutroniumRate());
//		Assert.assertEquals(10000,planet.getColonistPopulation());
//		Assert.assertEquals(player.getId(),planet.getPlayer().getId());
//		Assert.assertEquals(500,planet.getSupplies());
//		Assert.assertEquals(0,planet.getTemp());
//		Assert.assertEquals(4000,planet.getTritaniumInGround());
//		Assert.assertEquals(400,planet.getTritaniumOnSurface());
//		Assert.assertEquals(40,planet.getTritaniumRate());
//		
//		planets.delete(planet);
//		users.delete(user);
//		players.delete(player);
//		
//		Assert.assertEquals(0,planets.findAll().size());
//		Assert.assertEquals(0,players.findAll().size());
//		Assert.assertEquals(0,users.findAll().size());
//		
//	}
	
	
}
