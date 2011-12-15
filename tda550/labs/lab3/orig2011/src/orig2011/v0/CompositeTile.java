package orig2011.v0;

import java.awt.Dimension;
import java.awt.Graphics;

/**
 * A game tile combined of two other tiles.
 * 
 * Whenever the object paints itself, the bottom tile is painted first,
 * then the top tile is painted on top.
 */
public class CompositeTile extends GameTile {
	private final GameTile bottomTile;
	private final GameTile topTile;

	public CompositeTile(final GameTile bottom, final GameTile top) {
		this.bottomTile = bottom;
		this.topTile = top;
	}

	public GameTile getTop() {
		return this.topTile;
	}

	public GameTile getBottom() {
		return this.bottomTile;
	}

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
	@Override
	public void draw(final Graphics g, final int x, final int y,
				final Dimension d) {
		this.bottomTile.draw(g, x, y, d);
		this.topTile.draw(g, x, y, d);
	}
}
