package orig2011.v7;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;

public class CrossTile implements GameTile {
	/** The color of the cross */
	private final Color color;
	private final Stroke stroke;

	/**
	 * Creates a diagonal cross game tile.
	 * 
	 * @param color
	 *            the color of the cross.
	 */
	public CrossTile(final Color color, final double thickness) {
		this.color = color;
		this.stroke =
				new BasicStroke((float) thickness, BasicStroke.CAP_SQUARE,
						BasicStroke.JOIN_MITER);
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
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(this.color);
		g2.setStroke(this.stroke);
		g.drawLine(x, y, x + d.width, y + d.height);
		g.drawLine(x, y + d.height, x + d.width, y);
	}
}
