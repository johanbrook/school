package orig2011.v6;

import java.awt.Dimension;
import java.awt.Graphics;

/**
 * A game tile manages painting of a special area of the screen.
 * 
 * Whenever the object should paint itself, it is told what size and position
 * that should be used to paint it.
 */
public interface GameTile {

	/**
	 * Draws itself in a given graphics context, position and size.
	 * 
	 * @param g
	 *            graphics context to draw on.
	 * @param x
	 *            pixel x coordinate of the tile to be drawn.
	 * @param y
	 *            pixel y coordinate of the tile to be drawn.
	 * @param d
	 *            size of this object in pixels.
	 */
	public void draw(Graphics g, int x, int y, Dimension d);
}
