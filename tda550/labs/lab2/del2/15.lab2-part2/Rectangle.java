package geometri;

import java.awt.Color;
import java.awt.Graphics;

/**
 * A class describing a rectangle with a width and height.
 * 
 * @author Johan Brook and Robin Andersson
 */
public class Rectangle extends Shape {

	// Instance variables
	
	/** The width */
	private int width;
	
	/** The height */
	private int height;
	
	/**
	 * Create a new <code>Rectangle</code> based on a position, width,
	 * height, and a color.
	 * 
	 * @param x The X coordinate
	 * @param y The Y coordinate
	 * @param width The width
	 * @param height The height
	 * @param color The color
	 * @throws IllegalPositionException If the coordinates are negative
	 */
	public Rectangle(int x, int y, int width, int height, Color color) 
			throws IllegalPositionException {
		
		super(x, y, color);
		
		checkValidPosition(width, height);
		
		this.width = width;
		this.height = height;
	}

	/**
	 * Create a new <code>Rectangle</code> based on a given
	 * <code>GeometricalForm</code>. 
	 * 
	 * @param f The given form
	 * @param width The width
	 * @param height The height
	 * @param c The color
	 */
	public Rectangle(GeometricalForm f, int width, int height, Color c) {
		super(f, c);
		
		this.width = width;
		this.height = height;
	}

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int area() {
		return this.width * this.height;
	}

	

	/**
	 * <p>Fill a square.</p>
	 * 
	 * {@inheritDoc}
	 */
	@Override
	public void fill(Graphics g) {
		g.setColor(getColor());
		g.fillRect(getX(), getY(), this.width, this.height);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int perimeter() {
		return this.width * 2 + this.height * 2;
	}

	@Override
	public String toString() {
		return super.toString() + " [width=" + width + ", height=" + height + "]";
	}
	
	
	
	/**
	 * Indicates if this rectangle is equal to another rectangle.
	 * 
	 * @return True if the rectangles are equal, otherwise false
	 */
	@Override
	public boolean equals(Object obj){
		
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		
		
		Rectangle other = (Rectangle) obj;
		
		return 	super.equals(other) &&
				this.width == other.width && 
				this.height == other.height;
	}
	
	
	/**
	 * Returns the hashcode based on width, height, and
	 * color. See {@link Shape#hashCode()}.
	 * 
	 * @return The hashcode for this rectangle
	 */
	@Override
	public int hashCode(){
		final int prime = 31;
		int hash = super.hashCode();
		
		hash = prime * hash + this.width;
		hash = prime * hash + this.height;
		
		return hash;
	}

}
