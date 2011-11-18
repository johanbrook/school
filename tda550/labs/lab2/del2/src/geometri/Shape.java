package geometri;

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
		if(x < 0 || y < 0){
			throw new IllegalPositionException("The coordinates can't be negative!");
		}
		
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
		
		if(this.xPos + dx < 0 || this.yPos + dy < 0){
			throw new IllegalPositionException("You can't move the form out of the canvas!");
		}
		
		this.xPos += dx;
		this.yPos += dy;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void place(int x, int y)
			throws IllegalPositionException {
		
		if(x < 0 || y < 0){
			throw new IllegalPositionException("The parameters can't be negative!");
		}
		
		this.xPos = x;
		this.yPos = y;
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
	 * to color.
	 * 
	 * @return True if the object is not null and the colors are equal
	 */
	@Override
	public boolean equals(Object obj){
		if(this == obj){
			return true;
		}
		if(obj == null){
			return false;
		}
		
		return this.color.equals( ((GeometricalForm) obj).getColor() );
	}
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int compareTo(GeometricalForm f) {
		
		if(this.area() != f.area()){
			return this.area() - f.area();
		}
		else{
			return this.perimeter() - f.perimeter();
		}
		
	}

	
	
}
