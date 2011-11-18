package geometri;

import java.awt.Color;
import java.awt.Graphics;


/**
 * A class describing a line with end X and Y coordinates.
 * 
 * @author Johan Brook and Robin Andersson
 */
public class Line extends Shape {
	
	/** Integer representing delta X */
	private int dx;
	
	/** Integer representing delta Y */
	private int dy;
		
	/** Wether the line is going downwards or upwards */
	private boolean slopeDown;
	
	
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
			throws IllegalPositionException {
		super(Math.min(x, x2), Math.min(y, y2), color);
		
		if(x2 < 0 || y2 < 0){
			throw new IllegalPositionException("The coordinates can't be negative!");
		}
		 
		this.dx = Math.abs(x2 - x);
		this.dy = Math.abs(y2 - y);
		
		this.slopeDown = (x2 - x) / (y2 - y) < 0;
		
		int refX = Math.min(x, x2);
		int refY = Math.min(y, y2);
		
		if(!slopeDown){
			place(refX, refY);
		}
		
	}
	
	
	/**
	 * Create a new <code>Line</code> on the same position as another <code>GeometricalForm</code>.
	 * 
	 * @param f1 The given form
	 * @param f2
	 * @param c The color
	 */
	public Line(GeometricalForm f1, GeometricalForm f2, Color c) {
		// Avoid calling "this()" so we don't throw an exception here:
		super(f1.getX() < f2.getX() ? f1 : f2, c);
						
		
		this.dx = Math.abs(f2.getX() - f1.getX());
		this.dy = Math.abs(f2.getY() - f1.getY());
		
		this.slopeDown = (f2.getX() - f1.getX()) / (f2.getY() - f2.getY()) < 0;
		
	}
		
	
	
	/**
	 * {@inheritDoc}
	 * @return The area for a <code>Line</code> is 0 (zero)
	 */
	@Override
	public int area() {
		return 0;
	}


	/**
	 * {@inheritDoc}
	 * @return The perimeter for a <code>Line</code> is its length
	 */
	@Override
	public int perimeter() {
		return (int) Math.hypot(this.dy, this.dx);
	}

	

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void fill(Graphics g) {
		g.setColor(getColor());
		
		if(this.slopeDown){
			g.drawLine(getX(), getY(), getX() + this.dx, getY() + this.dy);
		}
		else{
			g.drawLine(getX(), getY() + dy, getX() + this.dx, getY());
		}
	}
	


	@Override
	public String toString() {
		return super.toString() + " [x2=" + this.getX() + this.dx + ", y2=" + getY() + this.dy + "]";
	}
	
	
	@Override
	public int hashCode(){
		final int prime = 31;
		int hash = 1;
		
		hash = prime * hash + this.perimeter();
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
		
		Line other = (Line) obj;
		
		return 	super.equals(obj) && 
				this.perimeter() == other.perimeter(); 
		
	}
	
	
}


