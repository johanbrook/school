package se.chalmers.hajo.calc.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;

import se.chalmers.hajo.calc.con.Constants;
import se.chalmers.hajo.calc.ctrl.ICalculator;
import se.chalmers.hajo.calc.op.OpFactory;


/**
 * Main (and only) GUI window for calculator
 * 
 * @author hajo
 * 
 */
@SuppressWarnings("serial")
public class MainFrame extends JFrame {
	private JPanel jPnlDisplay;
	private JPanel jPnlButtons;
	private JTextField jTxtFldDisplay;
	private ICalculator calc;

	// Constants for the keys
	private static final String KEYS = "7 8 9 / 4 5 6 * 1 2 3 - 0 . = + C";
	// The separator char for the keys
	private static final String KEYS_DELIMITER = " ";
	// Using one single listener for all buttons
	private Action buttonAction = new AbstractAction() {

		@Override
		public void actionPerformed(ActionEvent evt) {
			// Set in initGUI()
			String cmd = evt.getActionCommand();
			System.out.print(cmd + " ");
			if (cmd.equals(".")) {
				jTxtFldDisplay.setText(calc.enterPoint());
			} else if (cmd.equals("C")) {
				jTxtFldDisplay.setText(calc.enterClear());
			} else if (cmd.equals("=")) {
				jTxtFldDisplay.setText(calc.enterEqual());
			} else if (cmd.matches("[0-9]")) {
				jTxtFldDisplay.setText(calc.enterDigit(cmd));
			} else if (cmd.matches("[+-/*]")) {
				jTxtFldDisplay.setText(calc.enterOp(OpFactory.getBinOp(cmd)));
			} else {
				throw new IllegalArgumentException("No match for pressed key");
			}
			System.out.println(calc);
		}
	};

	public MainFrame(ICalculator calc) {
		this.calc = calc;
		initGUI();
		jTxtFldDisplay.setText(calc.enterClear()); // Force display of 0
	}

	// Create the GUI components and build the GUI
	private void initGUI() {
		try {
			BorderLayout thisLayout = new BorderLayout();
			getContentPane().setLayout(thisLayout);
			this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			this.setTitle("Calculator");
			{
				jPnlDisplay = new JPanel();
				getContentPane().add(jPnlDisplay, BorderLayout.NORTH);
				jPnlDisplay.setBorder(BorderFactory
						.createEtchedBorder(BevelBorder.LOWERED));
				{
					// TODO Bug comment out next row
					jTxtFldDisplay = new JTextField();
					jPnlDisplay.add(jTxtFldDisplay);
					jTxtFldDisplay.setEditable(false);
					jTxtFldDisplay.setFont(new java.awt.Font("Andale Mono", 1,
							16));
					jTxtFldDisplay.setColumns(Constants.N_DIGITS);
					jTxtFldDisplay.setBorder(BorderFactory
							.createCompoundBorder(null, BorderFactory
									.createBevelBorder(BevelBorder.LOWERED)));
				}
			}
			{
				jPnlButtons = new JPanel();
				getContentPane().add(jPnlButtons, BorderLayout.CENTER);
				GridLayout jPnlButtonsLayout = new GridLayout(5, 4);
				jPnlButtonsLayout.setHgap(5);
				jPnlButtonsLayout.setVgap(5);
				jPnlButtonsLayout.setColumns(1);
				jPnlButtons.setLayout(jPnlButtonsLayout);
				jPnlButtons.setBorder(BorderFactory
						.createEtchedBorder(BevelBorder.LOWERED));
				for (String str : KEYS.split(KEYS_DELIMITER)) {
					JButton b = new JButton();
					// Order matters! Must be like this
					b.setAction(buttonAction);
					b.setActionCommand(str);
					b.setText(str);
					jPnlButtons.add(b);
				}
			}
			{
				this.setSize(386, 283);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
