package orig2011.v7;

import java.awt.Dimension;


/**
 * An interface for all game models.
 * 
 */
public interface GameModel extends IObservable {


	/**
	 * This method is called repeatedly so that the game can update it's state.
	 * 
	 * @param lastKey
	 *            The most recent keystroke.
	 */
	public void gameUpdate(int lastKey) throws GameOverException;
	
	/**
	 * Returns a tile representing the state of the game for
	 * the given position x and y.
	 * 
	 * @param x The x coordinate
	 * @param y The y coordinate
	 * @return The tile for the given coordinates
	 */
	public GameTile getGameboardState(final int x, final int y);
	
	/**
	 * Returns a tile representing the state of the game for
	 * the given <code>Position</code>.
	 * 
	 * @param pos A position
	 * @return The tile for the given Position
	 */
	public GameTile getGameboardState(final Position pos);
	
	/**
	 * 
	 * @return The size of the game board 
	 */
	public Dimension getGameboardSize();
	
	/**
	 * Provides the update speed, e.g. the frequency the model
	 * wants the controller to call <code>gameUpdate()</code>.
	 * 
	 * @return The update speed
	 */
	public int getUpdateSpeed();
}
