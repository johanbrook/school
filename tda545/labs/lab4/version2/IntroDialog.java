import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.beans.*;

class IntroDialog extends JDialog implements PropertyChangeListener {
	
	private final String ROWS_LABEL = "Hur många rader vill du spela med?";
	private final String COLS_LABEL = "Hur många kolumner vill du spela med?";
	private final String NAME_LABEL = "Skriv in spelarens namn:";
	
	private final String EXIT_BTN_STRING = "Avsluta";
	private final String START_BTN_STRING = "Starta spel";
	
	private JTextField text1;
	private JTextField text2;
	private JTextField name1;
	private JTextField name2;
	
	private String cols = null;
	private String rows = null;
	private String player1 = null;
	private String player2 = null;
	
	JOptionPane panel;
	
	public IntroDialog(JFrame frame){
		super(frame, true);
		setTitle("Inställningar");
		setResizable(false);
		
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

		int x = (int)(screen.getWidth() - getSize().getWidth()) / 3;
		int y = (int)(screen.getHeight() - getSize().getHeight()) / 3;

		setLocation(x, y);
		
		
		text1 = new JTextField(20);
		text2 = new JTextField(20);
		name1 = new JTextField(20);
		name2 = new JTextField(20);
		
		Object[] objects = {ROWS_LABEL, text1, COLS_LABEL, text2,
							NAME_LABEL, name1, NAME_LABEL, name2};
							
		Object[] options = {START_BTN_STRING, EXIT_BTN_STRING};
		
		panel = new JOptionPane(objects, 
										JOptionPane.QUESTION_MESSAGE,
        								JOptionPane.YES_NO_OPTION,
        								null,
        								options,
        								options[0]
									);
		setContentPane(panel);
		panel.addPropertyChangeListener(this);
		
		
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
		
			if(value.equals(new Integer(JOptionPane.CLOSED_OPTION))){
				return;
			}
			
			// Reset value!
			panel.setValue(JOptionPane.UNINITIALIZED_VALUE);
		
			if(START_BTN_STRING.equals(value)){
				
				boolean correctInput = true;
				String error = "Något blev fel:";
				
				rows = text1.getText();
				cols = text2.getText();
				player1 = name1.getText();
				player2 = name2.getText();
				
			
				if(player1.isEmpty() || player2.isEmpty()){
					//JOptionPane.showMessageDialog(this, "Du måste skriva in namn på spelare!", "Error", JOptionPane.ERROR_MESSAGE);
					error = error + "\nDu måste skriva in namn på båda spelarna!";
					correctInput = false;
				}
			
				try{
					Integer.parseInt(rows);
					Integer.parseInt(cols);
				}
				catch(NumberFormatException ex){
					error = error + "\nDu måste skriva in siffror som rader och kolumner!";
					//JOptionPane.showMessageDialog(this, "Du måste skriva in siffror!", "Error", JOptionPane.ERROR_MESSAGE);
					correctInput = false;
				}
			
				if(correctInput){
					setVisible(false);
				}
				else{
					// Instead of showing several error dialogs, we're showing a single 
					// dialog with all error messages:
					
					JOptionPane.showMessageDialog(this, error, "Error", JOptionPane.ERROR_MESSAGE);
				}
			
			}
			else if(value == null || EXIT_BTN_STRING.equals(value)){
				panel.setValue(new Integer(JOptionPane.CLOSED_OPTION));
				setVisible(false);
			}
		
		}
		
	}
	
	
	
	public Object getValue(){
		return panel.getValue();
	}
	
	
	public String[] getInput(){
		String[] results = {rows, cols, player1, player2};
		return results;
	}
	
	
	
	public static void main(String[] args) {
		JFrame f = new JFrame();
		
		IntroDialog j = new IntroDialog(f);
		j.setVisible(true);
		
		if(j.getValue().equals(new Integer(JOptionPane.CLOSED_OPTION))){
			System.out.println("exiting ..");
			System.exit(0);
		}
		
		String[] input = j.getInput();
		
		if(input != null){
			for(String s : input){
				System.out.println(s);
			}
		}
	}
	
}