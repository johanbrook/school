package geometri;

import java.awt.Color;
import java.awt.Graphics;

/**
 * A class describing a line with an end point.
 * 
 * @author Johan Brook and Robin Andersson
 */
public class Line extends Shape {
	
	// Instance variables
	
	/** Integer representing delta X */
	private int dx;
	
	/** Integer representing delta Y */
	private int dy;
		
	/** Whether the line is going downwards or upwards */
	private boolean slopeDown;
	
	
	// Constructors
	
	/**
	 * Create a new <code>Line</code> at a position, with and endpoint
	 * and color. 
	 * 
	 * @param x The first X coordinate
	 * @param y The first Y coordinate
	 * @param x2 The endpoint's X coordinate
	 * @param y2 The endpoint's Y coordinate
	 * @param color The color
	 * @throws IllegalPositionException If any of the position parameters
	 * 			are negative 
	 */
	public Line(int x, int y, int x2, int y2, Color color) 
			throws IllegalPositionException {}

	/**
	 * Create a new <code>Line</code> on the same position as another <code>GeometricalForm</code>.
	 * 
	 * @param f1 The given form
	 * @param f2
	 * @param c The color
	 */
	public Line(GeometricalForm f1, GeometricalForm f2, Color c) {}
	
	
	/**
		 * Calculate and set instance variables delta x,
		 * delta y, and the boolean slope variable.
		 * 
		 * @param x1 X1
		 * @param y1 Y1
		 * @param x2 X2
		 * @param y2 Y2
	 */
	private void calculateDeltaAndSlope(int x1, int y1, int x2, int y2) {}
	
	
	// Public methods
	
	/**
	 * {@inheritDoc}
	 * @return The area for a <code>Line</code> is 0 (zero)
	 */
	@Override
	public int area() {}
	

	
	/**
	 * {@inheritDoc}
	 * @return The perimeter for a <code>Line</code> is its length
	 */
	@Override
	public int perimeter() {}

	/**
	 * <p>Draw a line.</p>
	 * 
	 * {@inheritDoc}
	 */
	@Override
	public void fill(Graphics g) {}
	
	
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


