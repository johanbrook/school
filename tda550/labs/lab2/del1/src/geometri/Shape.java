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
	
	private int xPos;
	private int yPos;
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
	public Shape(int x, int y, Color color) 
			throws IllegalPositionException {}
	
	/**
	 * Default constructor when creating subforms based on an existing
	 * <code>GeometricalForm</code>.
	 * 
	 * @param f The given form
	 * @param color The color
	 */
	public Shape(GeometricalForm f, Color color)  {}
	
	
	// Public methods
	
	/**
	 * {@inheritDoc}
	 */
	public int getX(){}
	
	/**
	 * {@inheritDoc}
	 */
	public int getY(){}
	
	/**
	 * {@inheritDoc}
	 */
	public Color getColor(){}
	
	/**
	 * {@inheritDoc}
	 */
	public void move(int dx, int dy) 
			throws IllegalPositionException {}
	
	/**
	 * {@inheritDoc}
	 */
	public void place(int x, int y) 
			throws IllegalPositionException {}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int compareTo(GeometricalForm f) {}
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {}
	
	
	
}
