package orig2011.v7;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * A listener on {@link ReversiModel}.
 * 
 * @author Johan Brook and Robin Andersson
 *
 */
public class ReversiScoreView implements PropertyChangeListener {

	
	/**
	 * Prints current score and whose turn it is.
	 * 
	 */
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		
		if(evt.getSource().getClass() == ReversiModel.class &&
			"nextTurn".equals(evt.getPropertyName())){
			
			ReversiModel m = (ReversiModel) evt.getSource();
			
			System.out.println( "It's "+ evt.getNewValue() + 
								"'s turn\n" +
								"White score: " + m.getWhiteScore() +
								"\tBlack score: " + m.getBlackScore());
		}
		
		
	}
	
	
}
