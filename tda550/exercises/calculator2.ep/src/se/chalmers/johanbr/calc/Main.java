package se.chalmers.johanbr.calc;

import java.awt.EventQueue;

import se.chalmers.johanbr.calc.core.Calculator;
import se.chalmers.johanbr.calc.gui.MainFrame;


/**
 * A simple pocket calculator
 * 
 * Class holding the main method. Entry point of application
 * 
 * NOTE: This doesn't use the MVC model
 * 
 * @author hajo
 * 
 */
public class Main {

	public static void main(String[] args) {

		// The GUI should be fully constructed
		// before any event handling starts
		// Do it like this (a thread)
		EventQueue.invokeLater(new Runnable() {

			public void run() {
				new MainFrame(new Calculator()).setVisible(true);
			}
		});

	}
}
