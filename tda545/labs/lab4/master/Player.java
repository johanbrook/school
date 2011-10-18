import java.util.*;

/** 
*	A player
*
*	@author Johan Brook (900720-0216), Robin Andersson (900122-0574)
*	@group 0
*	@assignment Lab 4
*	@date 2011-10-11
*/
public class Player extends Observable {
	
	// Instance variables
	
	private String name;
	private int points;
	private boolean isActive;
	
	/**
	*	Creates a new player based on a username and setActive as false
	*
	*	@param name The name of the player
	*/
	public Player(String name){
		this(name, false);
	}
	
	/**
	*	Creates a new player with a name, and sets it's state
	*
	*	@param name The name of the player
	*	@param setActive Sets the player's state
	*/
	public Player(String name, boolean setActive){
		this.name = name;
		this.points = 0;
		this.isActive = setActive;
		
		setChanged();
		notifyObservers();
	}
	
	/**
	*	Increments the player's total points by one
	*/
	public void addPoint(){
		this.points++;
		setChanged();
		notifyObservers();
	}
	
	/**
	*	Returns the player name
	*	
	*	@return The players name
	*/
	public String getName(){
		return this.name;
	}
	
	/**
	*	Returns the player's points
	*
	*	@return The player's points
	*/
	public int getPoints(){
		return this.points;
	}
	
	/**
	*	Resets the player's points and makes it inactive.
	*/
	public void reset(){
		this.points = 0;
		this.isActive = false;
		
		setChanged();
		notifyObservers();
	}
	
	/**
	*	Returns the player's state
	*	
	*	@return The player's state
	*/
	public boolean isActive(){
		return isActive;
	}
	
	/**
	*	Sets the player's state according to the parameter
	*
	*	@param set Sets the players state
	*/
	public void setActive(boolean set){
		this.isActive = set;
		
		setChanged();
		notifyObservers();
	}
	
	/**
	*	Inverts the player's state
	*/
	public void toggleActive(){
		setActive(!isActive);
	}
	
	
	/**
	*	This player's name.
	*
	*	@return The name
	*/
	public String toString(){
		return this.name;
	}
	
}