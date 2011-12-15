package orig2011.v7;

import java.beans.PropertyChangeListener;

/**
 * Classes implementing this interface are observable
 * with a <code>PropertyChangeListener</code>.
 * 
 * @author Johan Brook and Robin Andersson
 *
 */
public interface IObservable {
	
	/**
	 * Add an observer for this object.
	 * 
	 * @param observer The observer
	 */
	 public void addObserver(PropertyChangeListener observer);
	 
	 /**
	  * Removes an observer for this object.
	  * 
	  * @param observer The observer.
	  */
	 public void removeObserver(PropertyChangeListener observer);
}
