package geometri;

import java.awt.*;


/*
 * Den andra konstruktorn kommer även den att kasta exception. Tillåtet?
 */

public abstract class Shape implements GeometricalForm {
	
	
	// Instance variables
	
	private int xPos;
	private int yPos;
	private Color color;
	
	
	// Constructors
	
	public Shape(int x, int y, Color color) throws IllegalPositionException {
		if(x < 0 || y < 0){
			throw new IllegalPositionException("The coordinates can't be negative!");
		}
		
		this.xPos = x;
		this.yPos = y;
		this.color = color;
	}
	
	
	public Shape(GeometricalForm f, Color color)  {
		this.xPos = f.getX();
		this.yPos = f.getY();
		this.color = color;
	}
	
	
	// Public methods
	
	public int getX(){
		return this.xPos;
	}
	
	public int getY(){
		return this.yPos;
	}
	
	public Color getColor(){
		return this.color;
	}
	
	
	public void move(int dx, int dy) throws IllegalPositionException {
		if(dx < 0 || dy < 0){
			throw new IllegalPositionException("The parameters can't be negative!");
		}
		
		this.xPos += dx;
		this.yPos += dy;
	}
	
	public void place(int x, int y) throws IllegalPositionException {
		if(x < 0 || y < 0){
			throw new IllegalPositionException("The parameters can't be negative!");
		}
		
		this.xPos = x;
		this.yPos = y;
	}
	
	
}
