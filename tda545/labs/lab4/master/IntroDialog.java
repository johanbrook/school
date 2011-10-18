import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.beans.*;

/** 
*	A customized dialog, asking for rows, columns, and player
*	names on startup instead of handling it in several option panes.
*
*	@author Johan Brook (900720-0216), Robin Andersson (900122-0574)
*	@group 0
*	@assignment Lab 4
*	@date 2011-10-11
*/
class IntroDialog extends JDialog implements PropertyChangeListener {
	
	// Constants (UI element labels)
	
	private final String ROWS_LABEL = "Hur många rader vill du spela med?";
	private final String COLS_LABEL = "Hur många kolumner vill du spela med?";
	private final String NAME_LABEL = "Skriv in spelarens namn:";
	
	private final String EXIT_BTN_STRING = "Avsluta";
	private final String START_BTN_STRING = "Starta spel";
	
	// Instance variables
	
	private JTextField text1;
	private JTextField text2;
	private JTextField name1;
	private JTextField name2;
	
	private String cols = null;
	private String rows = null;
	private String player1 = null;
	private String player2 = null;
	
	// The panel
	
	private JOptionPane panel;
	
	
	// Constructor
	
	/**
	*	Creates a new intro dialog.
	*
	*	@param frame The parent frame
	*	@param title The window title
	*/
	public IntroDialog(JFrame frame, String title){
		super(frame, title, true);
		setResizable(false);
		
		// Center on screen
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

		int x = (int)(screen.getWidth() - getSize().getWidth()) / 3;
		int y = (int)(screen.getHeight() - getSize().getHeight()) / 3;

		setLocation(x, y);
		
		// Create text fields
		
		text1 = new JTextField(20);
		text2 = new JTextField(20);
		name1 = new JTextField(20);
		name2 = new JTextField(20);
		
		Object[] objects = {ROWS_LABEL, text1, COLS_LABEL, text2,
							NAME_LABEL, name1, NAME_LABEL, name2};
							
		Object[] options = {START_BTN_STRING, EXIT_BTN_STRING};
		
		// Build an option pane with the labels and text fields:
		
		panel = new JOptionPane(objects, 
										JOptionPane.QUESTION_MESSAGE,
        								JOptionPane.YES_NO_OPTION,
        								null,
        								options,
        								options[0]
									);
									
		// Set the panel to the content pane of this JDialog, and 
		// add a listener to changes:
		setContentPane(panel);
		panel.addPropertyChangeListener(this);
		
		// Close the panel properly. We need to catch the CLOSED_OPTION
		// outside of this class (with 'getValue') when the panel is closed.
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				panel.setValue(new Integer(JOptionPane.CLOSED_OPTION));
			}
		});
 
		pack();
	}	

	
	public void propertyChange(PropertyChangeEvent e) {
		String property = e.getPropertyName();
		
		if(isVisible() && e.getSource() == panel &&
			(JOptionPane.VALUE_PROPERTY.equals(property) ||
			JOptionPane.INPUT_VALUE_PROPERTY.equals(property)) ){
			
			Object value = panel.getValue();
			
			// Don't continue if the panel was closed
			if(value.equals(new Integer(JOptionPane.CLOSED_OPTION))){
				return;
			}
			
			// Reset the panel's value!
			panel.setValue(JOptionPane.UNINITIALIZED_VALUE);
		
			// If it's the 'start game' button:
			if(START_BTN_STRING.equals(value)){
				
				boolean correctInput = true;
				String error = "Något blev fel!\n\nTänk på att:";
				
				// Get input text:
				rows = text1.getText();
				cols = text2.getText();
				player1 = name1.getText();
				player2 = name2.getText();
				
			
				if(player1.isEmpty() || player2.isEmpty()){
					error = error + "\nDu måste skriva in namn på båda spelarna!";
					correctInput = false;
				}
			
				try{
					int iRows = Integer.parseInt(rows);
					int iCols = Integer.parseInt(cols);
					
					if(iRows <= 0 || iCols <= 0 || iRows*iCols <= 2){
						throw new NumberFormatException();
					}
				}
				catch(NumberFormatException ex){
					error = error + "\nDu måste skriva in tal större än noll som rader och kolumner." + 
									"\nSpelplanen måste även bestå av minst två rutor.";
					correctInput = false;
				}
				
				// If everything is ok, hide this dialog and go on:
				if(correctInput){
					setVisible(false);
				}
				else{
					// Instead of showing several error dialogs, we're showing a single 
					// dialog with all collected error messages:
					JOptionPane.showMessageDialog(this, error, "Fel", JOptionPane.ERROR_MESSAGE);
				}
			}
			
			// If the exit button was clicked:
			else if(value == null || EXIT_BTN_STRING.equals(value)){
				panel.setValue(new Integer(JOptionPane.CLOSED_OPTION));
				setVisible(false);
			}
		}
	}
	
	
	/**
	*	Get the panel value. May later be used for checking the action the user
	*	took in the IntroDialog, such as pressing the 'Quit' button.
	*
	*	@return The value of the panel
	*/
	public Object getValue(){
		return panel.getValue();
	}
	
	/**
	*	The actual input in the text fields from the user.
	*
	*	@return The user input as a string array
	*/
	public String[] getInput(){
		String[] results = {rows, cols, player1, player2};
		return results;
	}
	
}