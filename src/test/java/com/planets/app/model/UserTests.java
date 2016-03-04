package com.planets.app.model;

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

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = WebServerInit.class)
public class UserTests {
	
	@Autowired
	private AppUserRepo userRepo;
	
	@Before
	public void setUp() {
		userRepo.deleteAll();
	}
	
	@Test
	public void testCreateAndDeleteUser() {
		
		// Test create user
		Assert.assertEquals("There are already users in the repo.", 0, userRepo.count());
		AppUser user = userRepo.create("aggiejack@mailinator.com","Jack","Daniels");
		Assert.assertEquals("The expected number of users does not match.", 1, userRepo.count());
		Assert.assertEquals("The user we received does not match the given email.", "aggiejack@mailinator.com", user.getEmail());
		Assert.assertEquals("The user we received does not match the given first name.", "Jack", user.getFirstName());
		Assert.assertEquals("The user we received does not match the given last name.", "Daniels", user.getLastName());
		Assert.assertEquals("The user we received does not match the given password.", "password", user.getPassword());
		Assert.assertEquals("The user we received does not have the correct number of players.", 0, user.getPlayers().size());
				
		// Test delete user
		userRepo.delete(user);			
		Assert.assertEquals("The user was not removed.", 0, userRepo.count());
		
	}
	
	@Test
	public void testDuplicateEmails() {
		
		// Create user
		userRepo.create("aggiejack@mailinator.com","Jack","Daniels");
		Assert.assertEquals("The expected number of users does not match.", 1, userRepo.count());
	
		// Create new user with same email
		userRepo.create("aggiejack@mailinator.com","Bob","Boring");
		Assert.assertEquals("The expected number of users does not match.", 1, userRepo.count());

	}
	
	@Test
	public void testUpdatingUserData() {
		
		// Create user
		Assert.assertEquals("There are already users in the repo.", 0, userRepo.count());
		AppUser user = userRepo.create("aggiejack@mailinator.com","Jack","Daniels");
		Assert.assertEquals("The expected number of users does not match.", 1, userRepo.count());
		Assert.assertEquals("The user we received does not match the given email.", "aggiejack@mailinator.com", user.getEmail());
		Assert.assertEquals("The user we received does not match the given first name.", "Jack", user.getFirstName());
		Assert.assertEquals("The user we received does not match the given last name.", "Daniels", user.getLastName());
		Assert.assertEquals("The user we received does not match the given password.", "password", user.getPassword());
		
		// Update user info
		user.setEmail("boring@mailinator.com");
		user.setFirstName("Bob");
		user.setLastName("Boring");
		user.setPassword("secret");
		userRepo.save(user);		
		user = userRepo.findByEmail("boring@mailinator.com");
		Assert.assertEquals("The user we received does not match the given email.", "boring@mailinator.com", user.getEmail());
		Assert.assertEquals("The user we received does not match the given first name.", "Bob", user.getFirstName());
		Assert.assertEquals("The user we received does not match the given last name.", "Boring", user.getLastName());
		Assert.assertEquals("The user we received does not match the given password.", "secret", user.getPassword());
		
	}
	
	@After
	public void cleanUp() {
		userRepo.deleteAll();
	}
	
}
