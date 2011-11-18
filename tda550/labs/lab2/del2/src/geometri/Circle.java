package geometri;

import java.awt.Color;
import java.awt.Graphics;

/**
 * A class describing a circle with a radius.
 * 
 * @author Johan Brook and Robin Andersson
 */
public class Circle extends Shape {

	/** The circle's radius */
	private int radius;
	
	/**
	 * Create a new circle with coordinates, radius and a color.
	 * 
	 * @param x The X coordinate
	 * @param y The Y coordinate
	 * @param radius The radius
	 * @param color The color
	 * @throws IllegalPositionException
	 */
	public Circle(int x, int y, int radius, Color color) 
			throws IllegalPositionException {
		super(x, y, color);
		
		this.radius = radius;
	}

	/**
	 * Create a new <code>Circle</code> on the same position as another <code>GeometricalForm</code>.
	 * 
	 * @param f The given form
	 * @param radius The radius
	 * @param c The color
	 */
	public Circle(GeometricalForm f, int radius, Color c) {
		super(f, c);
		
		this.radius = radius;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int area() {
		return (int) Math.PI * (radius*radius);
	}


	/**
	 * <p>Fills a circle.</p>
	 * 
	 * {@inheritDoc}
	 */
	@Override
	public void fill(Graphics g) {
		g.setColor(getColor());
		g.fillOval(getX(), getY(), radius*2, radius*2);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int perimeter() {
		return (int) Math.PI * radius * 2;
	}

	@Override
	public String toString() {
		return super.toString() + " [radius=" + radius + "]";
	}
	
	@Override
	public int hashCode(){
		final int prime = 31;
		int hash = 1;
		
		hash = prime * hash + this.radius;
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
		
		Circle other = (Circle) obj;
		
		return 	super.equals(obj) &&
				this.radius == other.radius; 
	
	}
	
	

}
