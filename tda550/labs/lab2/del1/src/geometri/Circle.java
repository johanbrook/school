package geometri;

import java.awt.Color;
import java.awt.Graphics;

/**
 * A class describing a circle with a radius.
 * 
 * @author Johan Brook and Robin Andersson
 */
public class Circle extends Shape {

	// Instance variables
	
	private int radius;
	
	
	// Constructors
	
	/**
	 * Create a new <code>Circle</code> with coordinates, radius and a color.
	 * 
	 * @param x The X coordinate
	 * @param y The Y coordinate
	 * @param radius The radius
	 * @param color The color
	 * @throws IllegalPositionException If the coordinates are negative
	 */
	public Circle(int x, int y, int radius, Color color) 
			throws IllegalPositionException {}

	/**
	 * Create a new <code>Circle</code> on the same position as another <code>GeometricalForm</code>.
	 * 
	 * @param f The given form
	 * @param radius The radius
	 * @param c The color
	 */
	public Circle(GeometricalForm f, int radius, Color c) {}

	
	// Public methods
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int area() {}
	
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

	/**
	 * <p>Fills a circle.</p>
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

}
