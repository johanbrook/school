package geometri;

// TODO Skriv om hjälpmetoden Line

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
		
	/** Whether the line is going downwards or upwards */
	private boolean slopeUp;
	
	
	/**
	 * Create a new <code>Line</code> at a position, with and end point
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

		checkValidPosition(x2, y2);
		
		calculateDeltaAndSlope(x, y, x2, y2);
	}
	
	
	/**
	 * Create a new <code>Line</code> on the same position 
	 * as another <code>GeometricalForm</code>.
	 * 
	 * @param f1 The given form
	 * @param f2 Another {@link GeometricalForm}
	 * @param c The color
	 */
	public Line(GeometricalForm f1, GeometricalForm f2, Color c) {
		// Avoid calling "this()" so we don't throw an exception here:
		super(f1.getX() < f2.getX() ? f1 : f2, c);
		
		calculateDeltaAndSlope(f1.getX(), f1.getY(), f2.getX(), f2.getY());
	}
	
	
	// Private methods
	
	/**
	 * Calculate and set instance variables delta x,
	 * delta y, and the boolean slope variable.
	 * 
	 * @param x1 X1
	 * @param y1 Y1
	 * @param x2 X2
	 * @param y2 Y2
	 */
	private void calculateDeltaAndSlope(int x1, int y1, int x2, int y2){
		
		this.dx = Math.abs(x2 - x1);
		this.dy = Math.abs(y2 - y1);
		
		// Cast to double, otherwise the arithmetic operation
		// would yield an integer, making the boolean
		// comparison more blunt:
		
		this.slopeUp = (double) (x2 - x1) / (y2 - y1) < 0;
	}
		
	
	// Public methods
	
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
		
		if(this.slopeUp){
			g.drawLine(getX(), getY() + this.dy, getX() + this.dx, getY());
		}
		else{
			g.drawLine(getX(), getY(), getX() + this.dx, getY() + this.dy);
		}
	}
	


	@Override
	public String toString() {
		return super.toString() + 
				" [x2=" + this.getX() + this.dx + 
				", y2=" + getY() + this.dy + "]";
	}
	
	
	/**
	 * Returns the hashcode based on perimeter (length) and
	 * color. See {@link Shape#hashCode()}.
	 * 
	 * @return The hashcode for this line
	 */
	@Override
	public int hashCode(){
		final int prime = 31;
		int hash = super.hashCode();
		
		hash = prime * hash + this.perimeter();
		
		return hash;
	}
	
	/**
	 * Indicates if this line is equal to another line.
	 * 
	 * <p>We've chosen not to check if the slopes of the lines
	 * have the same boolean value, since we think lines should
	 * be compared for color and length (perimeter) only.</p>
	 * 
	 * @return True if the rectangles are equal, otherwise false
	 */
	@Override
	public boolean equals(Object obj){
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		
		Line other = (Line) obj;
		
		return 	super.equals(other) && 
				this.perimeter() == other.perimeter(); 
		
	}
	
	
}


