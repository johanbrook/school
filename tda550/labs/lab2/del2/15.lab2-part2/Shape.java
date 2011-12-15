package geometri;

// TODO Skriv om hjälpmetoden som kastar exception om koordinater är fel

import java.awt.*;


/**
 * Abstract class for describing an arbitrary shape. 
 * 
 * Includes common properties
 * such as X and Y coordinates, and a color.
 * 
 * Subclasses must implement the rest of the <code>GeometricalForm</code> interface.
 * 
 * @author Johan Brook and Robin Andersson
 */
public abstract class Shape implements GeometricalForm {
	
	
	// Instance variables
	
	/** The X coordinate of the shape */
	private int xPos;
	/** The Y coordinate of the shape */
	private int yPos;
	/** The color of the shape */
	private Color color;
	
	
	// Constructors
	
	/**
	 * Default constructor for a <code>Shape</code>. Sets coordinates and color.
	 * 
	 * @param x The X coordinate
	 * @param y The Y coordinate
	 * @param color The color
	 * @throws IllegalPositionException If the coordinates are negative
	 */
	public Shape(int x, int y, Color color) throws IllegalPositionException {
		checkValidPosition(x, y);
		
		this.xPos = x;
		this.yPos = y;
		this.color = color;
	}
	
	
	/**
	 * Default constructor when creating subforms based on an existing
	 * <code>GeometricalForm</code>.
	 * 
	 * @param f The given form
	 * @param color The color
	 */
	public Shape(GeometricalForm f, Color color)  {
		this.xPos = f.getX();
		this.yPos = f.getY();
		this.color = color;
	}
	
	
	// Public methods
	
	/**
	 * {@inheritDoc}
	 */
	public int getX(){
		return this.xPos;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public int getY(){
		return this.yPos;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public Color getColor(){
		return this.color;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void move(int dx, int dy) 
			throws IllegalPositionException {
		
		checkValidPosition(this.xPos + dx, this.yPos + dy, 
							"You can't move the object out of the canvas!");
		
		this.xPos += dx;
		this.yPos += dy;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void place(int x, int y)
			throws IllegalPositionException {
		
		checkValidPosition(x, y);
		
		this.xPos = x;
		this.yPos = y;
	}

	/**
	 * Checks for an illegal position and throws exception.
	 * 
	 * @param p1 The first coordinate/value
	 * @param p2 The second coordinate/value
	 * @throws IllegalPositionException If the values are negative
	 */
	protected void checkValidPosition(int p1, int p2) 
		throws IllegalPositionException {
		
		checkValidPosition(p1, p2, "The positions can't be negative!");
	}
	
	
	
	/**
	 * Checks for an illegal position and throws exception. The message
	 * for the exception may be provided.
	 * 
	 * @param p1 The first coordinate/value
	 * @param p2 The second coordinate/value
	 * @param message The message for the exception object
	 * @throws IllegalPositionException If the values are negative
	 */
	protected void checkValidPosition(int p1, int p2, String message) 
		throws IllegalPositionException {
			
		if(p1 < 0 || p2 < 0){
			throw new IllegalPositionException(message);
		}
	}
	

	@Override
	public String toString() {
		
		// We're able to use perimeter() and area() here.
		// Smooooth dynamic binding :)
		
		return getClass().toString() + 
				" [X=" + getX() + 
				", Y=" + getY() + 
				", Color=" + getColor() + 
				", perimeter=" + perimeter() + 
				", area="+ area() + 
				"]";
	}

	
	/**
	 * Check if this Shape is equal to another shape in regard
	 * to color. Does not override {@link Object#equals(Object)}.
	 * 
	 * @param obj A {@link GeometricalForm}
	 * @return True if the object is not null and the colors are equal
	 *
	 */	
	protected boolean equals(GeometricalForm obj){
		
		if(this == obj){
			return true;
		}
		if(obj == null){
			return false;
		}
		
		return this.color.equals(obj.getColor());
	}
	
	
	/**
	 * Returns the hashcode based on color.
	 * 
	 * @return The hashcode for this line
	 */
	@Override
	public int hashCode(){
		final int prime = 31;
		int hash = 1;
		
		hash = prime * hash + this.color.hashCode();
		
		return hash;
	}
	
	
	/**
	 * {@inheritDoc}
	 */
	public int compareTo(GeometricalForm f) {
		
		if(this.area() != f.area()){
			return this.area() - f.area();
		}
		
		else{
			return this.perimeter() - f.perimeter();
		}
				
	}

	
	
}
