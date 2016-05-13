package com.planets.game.model;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.planets.app.WebServerInit;
import com.planets.app.model.AppUser;
import com.planets.app.model.repo.AppUserRepo;
import com.planets.game.enums.RaceType;
import com.planets.game.model.repo.GameRepo;
import com.planets.game.model.repo.PlayerRepo;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = WebServerInit.class)
public class PlayerTests {

	@Autowired
	private PlayerRepo playerRepo;
	
	@Autowired
	private GameRepo gameRepo;
	
	@Autowired
	private AppUserRepo userRepo;
		
	@Before
	public void setUp() {
		userRepo.create("aggiejack@mailinator.com", "Jack", "Daniels");
	}
	
	@Test
	public void testCreateAndDeletePlayer() {
		
		// Create game and add a player.
		AppUser user = userRepo.findByEmail("aggiejack@mailinator.com");
		Game game = gameRepo.create(user, 500, 500);
		Assert.assertEquals("There are already players in the repo.", 0, playerRepo.count());
		Player player = playerRepo.create(RaceType.FEDERATION, game);
		Assert.assertEquals("The expected number of players does not match.", 1, playerRepo.count());
		Assert.assertEquals("The user we received does not match the given owner.", null, player.getOwner());
		Assert.assertEquals("The game we received does not match the given game.", game, player.getGame());
		
		// Delete player
		playerRepo.delete(player);
		Assert.assertEquals("The game was deleted.", 1, gameRepo.count());
		Assert.assertEquals("The game is still associated with a player.", 0, game.getPlayers().size());
		Assert.assertEquals("The user was deleted.", 1, userRepo.count());
		Assert.assertEquals("The user is still associated with a player.", 0, user.getPlayers().size());
		Assert.assertEquals("The player was not deleted.", 0, playerRepo.count());
		
	}
	
	@Test
	public void testCreateMultiplePlayers() {
		
		// Create game and add players.
		AppUser user = userRepo.findByEmail("aggiejack@mailinator.com");
		Game game = gameRepo.create(user, 500, 500);
		Assert.assertEquals("There are already players in the repo.", 0, playerRepo.count());
		playerRepo.create(RaceType.BIRDMEN, game);
		playerRepo.create(RaceType.COLONIES, game);
		playerRepo.create(RaceType.CRYSTALS, game);
		playerRepo.create(RaceType.CYBORG, game);
		playerRepo.create(RaceType.EMPIRE, game);
		playerRepo.create(RaceType.FASCISTS, game);
		playerRepo.create(RaceType.FEDERATION, game);
		playerRepo.create(RaceType.LIZARDS, game);
		playerRepo.create(RaceType.PRIVATEERS, game);
		playerRepo.create(RaceType.REBELS, game);
		playerRepo.create(RaceType.ROBOTS, game);
		Assert.assertEquals("The expected number of players does not match.", 11, playerRepo.count());
		
		// Create a different game and add more players.
		Game game2 = gameRepo.create(user, 100, 100);
		playerRepo.create(RaceType.BIRDMEN, game2);
		playerRepo.create(RaceType.COLONIES, game2);		
		Assert.assertEquals("The expected number of players does not match.", 13, playerRepo.count());
		Assert.assertEquals("The expected number of players does not match.", 11, game.getPlayers().size());
		Assert.assertEquals("The expected number of players does not match.", 2, game2.getPlayers().size());
	}
	
	@Test
	public void testCascadeDeleteGame() {
		// Create game and add a player.
		AppUser user = userRepo.findByEmail("aggiejack@mailinator.com");
		Game game = gameRepo.create(user, 500, 500);
		Assert.assertEquals("There are already players in the repo.", 0, playerRepo.count());
		Player player = playerRepo.create(RaceType.FEDERATION, game);
		Assert.assertEquals("The expected number of players does not match.", 1, playerRepo.count());
		Assert.assertEquals("The user we received does not match the given owner.", null, player.getOwner());
		Assert.assertEquals("The game we received does not match the given game.", game, player.getGame());
		
		// Delete game
		gameRepo.delete(game);
		Assert.assertEquals("The user was deleted.", 1, userRepo.count());
		Assert.assertEquals("The game was not deleted.", 0, gameRepo.count());
		Assert.assertEquals("The players were not deleted.", 0, playerRepo.count());
	}
	
	@After
	public void cleanUp() {
		playerRepo.deleteAll();
		gameRepo.deleteAll();
		userRepo.deleteAll();
	}
	
}
