package orig2011.v5;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JComponent;

/**
 * A view Component suitable for inclusion in an AWT Frame. Paints itself by
 * consulting its model.
 */
public class GameView extends JComponent implements PropertyChangeListener {

	/** Size of game model */
	private final Dimension modelSize;

	/** Size of every tile in the model */
	private final Dimension tileSize;

	/** The game model which is drawn */
	private GameModel model;

	/** The offscreen buffer */
	private Graphics offscreenGraphics;

	/** Image representing the offscreen graphics */
	private Image offscreenImage;

	/**
	 * Creates a view where each GameObject has side length 40 pixels..
	 */
	public GameView() {
		this(40);
	}

	/**
	 * Creates a view where each GameObject has a given size.
	 * 
	 * @param tileSide
	 *            side length in pixels of each GameObject.
	 */
	public GameView(final int tileSide) {
		this.tileSize = new Dimension(tileSide, tileSide);
		this.modelSize = Constants.getGameSize();
		Dimension preferredSize =
				new Dimension(this.modelSize.width * tileSide,
						this.modelSize.height * tileSide);
		setPreferredSize(preferredSize);
		
		
	}

	/**
	 * Updates the view with a new model.
	 */
	public void setModel(final GameModel model) {
		this.model = model;
		if(this.model != null)	
			this.model.addObserver(this);
		
		repaint();
	}

	/**
	 * This method ensures that the painting is performed double-buffered. This
	 * means there won't be any flicker when repainting all the time.
	 */
	@Override
	public void update(final Graphics g) {
		// Create an offscreen buffer (if we don't have one)
		if (this.offscreenImage == null) {
			Dimension size = getSize();

			this.offscreenImage = createImage(size.width, size.height);
			this.offscreenGraphics = this.offscreenImage.getGraphics();
		}

		// This will invoke painting correctly on the offscreen buffer
		super.update(this.offscreenGraphics);

		// Draw the contents of the offscreen buffer to screen.
		g.drawImage(this.offscreenImage, 0, 0, this);
	}

	/**
	 * Consults the model to paint the game matrix. If model is null, draws a
	 * default text.
	 */
	@Override
	public void paintComponent(final Graphics g) {
		// Check if we have a running game
		super.paintComponent(g);
		g.setColor(this.getBackground());
		g.fillRect(0, 0, getWidth(), getHeight());

		if (this.model != null) {

			// Draw all tiles by going over them x-wise and y-wise.
			for (int i = 0; i < this.modelSize.width; i++) {
				for (int j = 0; j < this.modelSize.height; j++) {
					GameTile tile = this.model.getGameboardState(i, j);
					tile.draw(g, i * this.tileSize.width, j
							* this.tileSize.height,
							this.tileSize);
				}
			}
		} else {
			g.setFont(new Font("Sans", Font.BOLD, 24));
			g.setColor(Color.BLACK);
			final char[] message = "No model chosen.".toCharArray(); 
			g.drawChars(message, 0, message.length, 50, 50);
		}
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		System.out.println(evt.getPropertyName());
		repaint();
	}
}
