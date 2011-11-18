package geometri;

import java.awt.Color;

/**
 * A class describing a square with a side.
 * 
 * @author Johan Brook and Robin Andersson
 */
public class Square extends Rectangle {
	
	private int side;
	
	/**
	 * Create a new <code>Square</code> with a side length. 
	 * 
	 * @param x The X coordinate
	 * @param y The Y coordinate
	 * @param side The side length
	 * @param color The color
	 * @throws IllegalPositionException If the coordinates are negative
	 */
	public Square(int x, int y, int side, Color color) throws IllegalPositionException {
		super(x, y, side, side, color);
		this.side = side;
	}

	/**
	 * Create a new <code>Square</code> based on an existing
	 * <code>GeometricalForm</code>.
	 * 
	 * @param f The given form
	 * @param side The side length
	 * @param c The color
	 */
	public Square(GeometricalForm f, int side, Color c) {
		super(f, side, side, c);
		this.side = side;
	}

	/**
	 * Indicates if this square is equal to another square.
	 * 
	 * @return True if the squares are equal, otherwise false
	 */
	@Override
	public boolean equals(Object obj){
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		Square other = (Square) obj;
		
		return 	super.equals(obj) &&
				this.side == other.side;
	
		
	}

	
}
