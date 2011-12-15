package geometri;

import java.awt.Color;
import java.awt.Graphics;

/**
 * A class describing a rectangle.
 * 
 * @author Johan Brook and Robin Andersson
 */
public class Rectangle extends Shape {
	
	// Instance variables
	
	/** The width */
	private int width;
	
	/** The height */
	private int height;
	
	
	// Constructors
	
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
			throws IllegalPositionException {}

	/**
	 * Create a new <code>Rectangle</code> based on a given
	 * <code>GeometricalForm</code>. 
	 * 
	 * @param f The given form
	 * @param width The width
	 * @param height The height
	 * @param c The color
	 */
	public Rectangle(GeometricalForm f, int width, int height, Color c) {}

	
	// Public methods
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int area() {}


	/**
	 * <p>Fill a square.</p>
	 * 
	 * {@inheritDoc}
	 */
	@Override
	public void fill(Graphics g) {}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int perimeter() {}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object obj) {}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode(){}

}
