package orig2011.v4;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;

public class SquareTile implements GameTile {
	private final Color fillColor;
	private final Color strokeColor;
	private final Stroke stroke;

	public SquareTile(final Color color) {
		this(color, color);
	}

	public SquareTile(final Color strokeColor, final Color fillColor) {
		this(strokeColor, fillColor, 1.0);
	}

	public SquareTile(final Color strokeColor, final Color fillColor,
			final double thickness) {
		this.strokeColor = strokeColor;
		this.fillColor = fillColor;
		if (thickness > 0) {
			this.stroke =
					new BasicStroke((float) thickness, BasicStroke.CAP_SQUARE,
							BasicStroke.JOIN_MITER);
		} else {
			this.stroke = null;
		}
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
		g2.setColor(this.fillColor);
		g2.fillRect(x, y, x + d.width, y + d.height);
		if (this.stroke != null) {
			g2.setStroke(this.stroke);
			g2.setColor(this.strokeColor);
			g.drawRect(x, y, d.width, d.height);
		}
	}
}
