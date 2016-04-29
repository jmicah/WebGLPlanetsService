package com.planets.game.model;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.planets.app.WebServerInit;
import com.planets.app.model.AppUser;
import com.planets.app.model.repo.AppUserRepo;
import com.planets.game.model.repo.GameRepo;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = WebServerInit.class)
public class GameTests {

	@Autowired
	private GameRepo gameRepo;
	
	@Autowired
	private AppUserRepo userRepo;
		
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Before
	public void setUp() {
		userRepo.create("aggiejack@mailinator.com", "Jack", "Daniels");
	}
	
	@Test
	public void testCreateAndDeleteGame() {
		
		// Test create game
		Assert.assertEquals("There are already games in the repo.", 0, gameRepo.count());
		AppUser user = userRepo.findByEmail("aggiejack@mailinator.com");
		Game game = gameRepo.create(500, 300);
		user.addGame(game);
		userRepo.save(user);
		Assert.assertEquals("The expected number of games does not match.", 1, gameRepo.count());
		Assert.assertEquals("The game we received does not match the given owner.", user, game.getOwner());
		Assert.assertEquals("The game we received does not match the given planet limit.", 500, game.getPlanetLimit());
		Assert.assertEquals("The game we received does not match the given ship limit.", 300, game.getShipLimit());
		
		//Verify User Relationship
		Assert.assertEquals("The number of games owned by the user does not macht.", 1, user.getGames().size());
		
		// Test delete game
		gameRepo.delete(game);
		Assert.assertEquals("The game was not removed.", 0, gameRepo.count());
		
	}
	
	@Test
	public void testUpdatingGameData() {
		
		// Create game
		Assert.assertEquals("There are already games in the repo.", 0, gameRepo.count());
		AppUser user = userRepo.findByEmail("aggiejack@mailinator.com");
		logger.debug("Found user: " + user.getFirstName());
		Game game = gameRepo.create(500, 300);
		user.addGame(game);
		userRepo.save(user);
		Assert.assertEquals("The expected number of games does not match.", 1, gameRepo.count());
		Assert.assertEquals("The game we received does not match the given owner.", user, game.getOwner());
		Assert.assertEquals("The game we received does not match the given planet limit.", 500, game.getPlanetLimit());
		Assert.assertEquals("The game we received does not match the given ship limit.", 300, game.getShipLimit());
		
		// Update game info
		game.setPlanetLimit(400);
		game.setShipLimit(200);
		gameRepo.save(game);
		game = gameRepo.findByOwner(user).get(0);
		Assert.assertEquals("The game we received does not match the given planet limit.", 400, game.getPlanetLimit());
		Assert.assertEquals("The game we received does not match the given ship limit.", 200, game.getShipLimit());

	}
	
	@Test
	public void testCascadeDeleteUser() {
		
		// Create game
		Assert.assertEquals("There are already games in the repo.", 0, gameRepo.count());
		AppUser user = userRepo.findByEmail("aggiejack@mailinator.com");
		Game game = gameRepo.create(500, 300);
		user.addGame(game);
		userRepo.save(user);
		Assert.assertEquals("The expected number of games does not match.", 1, gameRepo.count());
		Assert.assertEquals("The game we received does not match the given owner.", user, game.getOwner());
		Assert.assertEquals("The game we received does not match the given planet limit.", 500, game.getPlanetLimit());
		Assert.assertEquals("The game we received does not match the given ship limit.", 300, game.getShipLimit());
		
		// Delete user
		userRepo.delete(user);
		Assert.assertEquals("The game was deleted.", 1, gameRepo.count());
		Assert.assertEquals("The user was not delete.", 0, userRepo.count());
	}
	
	@Test
	public void testCascadeDeleteGame() {
		
		// Create game
		Assert.assertEquals("There are already games in the repo.", 0, gameRepo.count());
		AppUser user = userRepo.findByEmail("aggiejack@mailinator.com");
		Game game = gameRepo.create(500, 300);
		user.addGame(game);
		userRepo.save(user);
		Assert.assertEquals("The expected number of games does not match.", 1, gameRepo.count());
		Assert.assertEquals("The game we received does not match the given owner.", user, game.getOwner());
		Assert.assertEquals("The game we received does not match the given planet limit.", 500, game.getPlanetLimit());
		Assert.assertEquals("The game we received does not match the given ship limit.", 300, game.getShipLimit());
		
		// Delete user
		gameRepo.delete(game);
		Assert.assertEquals("The user was delete.", 1, userRepo.count());
		Assert.assertEquals("The game was not deleted.", 0, gameRepo.count());
	}
	
	@After
	public void cleanUp() {
		gameRepo.deleteAll();
		userRepo.deleteAll();
	}

}
