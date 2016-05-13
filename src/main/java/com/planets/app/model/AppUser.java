/* 
 * AppUser.java 
 * 
 * Version: 
 *     $Id$ 
 * 
 * Revisions: 
 *     $Log$ 
 */
package com.planets.app.model;

import java.util.ArrayList;
import java.util.Collection;

import static javax.persistence.CascadeType.*;
import static javax.persistence.FetchType.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.planets.game.model.Game;
import com.planets.game.model.Player;

import edu.tamu.framework.model.AbstractCoreUserImpl;

/**
 * Application User entity.
 * 
 * A user is the actual person that owns an account. It differs
 * from the Player entity in the fact that a Player is a virtual
 * representation of the user in a game. Therefore you can have
 * multiple Players per user if they're playing multiple games.
 * 
 * @author Micah Cooper
 *
 */
@Entity
public class AppUser extends AbstractCoreUserImpl {
	
    @Column(nullable = false, unique = true)
    private String email;

    // encoded password
    @JsonIgnore
    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    /**
     * Games created/owned by the user.
     * NOT games they are playing. That is
     * determined by the the list of players.
     * 
     */
    @OneToMany ( 
    		mappedBy = "owner",
    		cascade = { MERGE },
    		fetch = EAGER,
    		targetEntity = Game.class
    		)
    private Collection<Game> games = new ArrayList<Game>();
    
    /**
     * Any Race/Faction that the user is
     * playing in any game.
     * 
     */
    @OneToMany (
    		mappedBy = "owner",			
			cascade = { MERGE },
			fetch = EAGER,
			targetEntity = Player.class
			)
	private Collection<Player> players = new ArrayList<Player>();
    
    /**
     * Constructor for the application user
     * 
     */
    public AppUser() {
        super();
    }

    /**
     * Constructor for application user with id passed.
     * 
     * @param UIN
     *            Long
     * 
     */
    public AppUser(Long uin) {
        super(uin);
    }

    /**
     * Constructor for application user with email, firstName and lastName passed.
     * 
     * @param email
     *            String
     * @param firstName
     *            String
     * @param lastName
     *            String
     * 
     */
    public AppUser(String email, String firstName, String lastName) {
    	this.email = email;
    	this.firstName = firstName;
    	this.lastName = lastName;
    	this.password = "password";
    }
    
    /**
     * Constructor for application user with email, firstName, lastName and password passed.
     * 
     * @param email
     * @param firstName
     * @param lastName
     * @param password
     */
    public AppUser(String email, String firstName, String lastName, String password) {
    	this.email = email;
    	this.firstName = firstName;
    	this.lastName = lastName;
    	this.password = password;
    }
        
    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     *            the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     *            the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 
     * @return firstName
     * 
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName
     *            String
     * 
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return lastName
     * 
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName
     *            String
     * 
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public Collection<Game> getGames() {
    	return games;
    }
    
    public void addGame(Game game) {
    	if (games.contains(game))
    		return;
    	
    	games.add(game);
    	game.setOwner(this);
    }
    
    public void removeGame(Game game) {
    	if (!games.contains(game))
    		return;
    	
    	games.remove(game);
    	game.setOwner(null);
    }
    
	/**
	 * @return The list of players associated with this 
	 */
	public Collection<Player> getPlayers() {
		return this.players;
	}

	/**
	 * @param player
	 * 
	 */
	public void addPlayer(Player player) {
		if (players.contains(player))
			return;
		
		players.add(player);
		player.setOwner(this);
	}
	
	/**
	 * @param player
	 * 			Player
	 */
	public void removePlayer(Player player) {
		if (!players.contains(player))
			return;
		
		players.remove(player);
		player.setOwner(null);
	}

}
