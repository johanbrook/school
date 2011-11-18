package geometri;

import java.awt.Color;
import java.awt.Graphics;

/**
 * A class describing a rectangle with a width and height.
 * 
 * @author Johan Brook and Robin Andersson
 */
public class Rectangle extends Shape {

	private int width;
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
		
		if(width < 0 || height < 0){
			throw new IllegalArgumentException("Measures can't be negative!");
		}
		
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
		return (this.width*2) + (this.height*2);
	}

	@Override
	public String toString() {
		return super.toString() + " [width=" + width + ", height=" + height + "]";
	}
	
	
	@Override
	public int hashCode(){
		final int prime = 31;
		int hash = 1;
		
		hash = prime * hash + this.width;
		hash = prime * hash + this.height;
		hash = prime * hash + this.getColor().hashCode();
		
		return hash;
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
		
		return 	super.equals(obj) &&
				this.width == other.width && 
				this.height == other.height;
	
		
	}

}
