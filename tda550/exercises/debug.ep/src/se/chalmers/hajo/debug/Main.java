package se.chalmers.hajo.debug;

import java.awt.EventQueue;

import se.chalmers.hajo.debug.gui.MainFrame;


/**
 * Very quick and dirty application to exercise some 
 * debugging in Eclipse.
 * 
 * Application entry point (main method)
 * 
 * @author hajo
 *
 */
public class Main { 

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println("Debug started");
		// The GUI should be fully constructed
		// before any event handling starts
		// Do it like this !
		EventQueue.invokeLater(new Runnable() {

			public void run() {
				new MainFrame().setVisible(true);
			}
		});
	}

}
