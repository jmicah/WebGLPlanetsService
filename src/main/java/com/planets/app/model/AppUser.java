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
import java.util.List;

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
			targetEntity = Player.class,
			cascade = { PERSIST }
			)
	private List<Player> players = new ArrayList<Player>();
    
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
	public List<Player> getPlayers() {
		return this.players;
	}

	/**
	 * @param player
	 * @return The updated list of players.
	 */
	public List<Player> addPlayer(Player player) {
		this.players.add(player);
		return this.players;
	}
	
	/**
	 * @param player
	 * @return The updated list of players.
	 */
	public List<Player> removePlayer(Player player) {
		this.players.remove(player);
		return this.players;
	}

}
