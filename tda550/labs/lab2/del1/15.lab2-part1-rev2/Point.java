package geometri;

import java.awt.*;

/**
 * A class describing a single point.
 * 
 * @author Johan Brook and Robin Andersson
 */
public class Point extends Shape {
	
	// Constants
	
	private final int POINT_SIZE = 1;
	
	
	// Constructors
	
	/**
	 * Create a new <code>Point</code> on a position.
	 * 
	 * @param x The X coordinate
	 * @param y The Y coordinate
	 * @param c The color
	 * @throws IllegalPositionException If the coordinates are negative
	 */
	public Point(int x, int y, Color c) 
			throws IllegalPositionException {}
	
	/**
	 * Create a new <code>Point</code> based on an existing
	 * <code>GeometricalForm</code>.
	 * 
	 * @param f The given form
	 * @param c The color
	 */
	public Point(GeometricalForm f, Color c) {}
	
	
	// Public methods
	
	/**
	 * {@inheritDoc}
	 * @return The area for a <code>Point</code> is 0 (zero).
	 */
	@Override
	public int area() {}


	/**
	 * <p>Draw a point.</p>
	 * 
	 * {@inheritDoc}
	 */
	@Override
	public void fill(Graphics g) {}

	/**
	 * {@inheritDoc}
	 * @return The perimeter of a <code>Point</code> is 0 (zero).
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
