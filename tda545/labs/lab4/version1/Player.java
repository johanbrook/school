/** 
*	A player
*
*	@author Johan Brook (900720-0216), Robin Andersson (900122-0574)
*	@group 0
*	@assignment Lab 4
*	@date 2011-10-06
*/

import java.util.*;

public class Player extends Observable {
	
	private String name;
	private int points;
	private boolean isActive;
	
	/**
	*	Create a new player with a username
	*
	*	@param name The name of the player
	*/
	public Player(String name){
		this(name, false);
	}
	
	/**
	*	Create a new player with a name, and set to inactive/active
	*
	*	@param name The name of the player
	*	@param setActive Sets the player to active/inactive
	*/
	public Player(String name, boolean setActive){
		this.name = name;
		this.points = 0;
		this.isActive = setActive;
		
		setChanged();
		notifyObservers();
	}
	

	public void addPoint(){
		this.points++;
		setChanged();
		notifyObservers();
	}
	
	public String getName(){
		return this.name;
	}
	
	public int getPoints(){
		return this.points;
	}
	
	public boolean isActive(){
		return isActive;
	}
	
	public void setActive(boolean set){
		this.isActive = set;
		
		setChanged();
		notifyObservers();
	}
	
	public void toggleActive(){
		if(isActive()){
			setActive(false);
		}
		else{
			setActive(true);
		}
	}
	
}