package orig2011.v3;

import java.awt.Dimension;


/**
 * 
 */
public interface GameModel {


	

	/**
	 * This method is called repeatedly so that the game can update it's state.
	 * 
	 * @param lastKey
	 *            The most recent keystroke.
	 */
	public void gameUpdate(int lastKey) throws GameOverException;
	
	public GameTile getGameboardState(final int x, final int y);
	
	public GameTile getGameboardState(final Position pos);
	
	public Dimension getGameboardSize();
}
