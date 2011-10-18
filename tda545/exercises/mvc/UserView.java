import javax.swing.*;
import java.awt.*;

public class UserView extends JPanel {
	
	private User user;
	private JLabel label;
	private Font heading;
	private final int MAX_LENGTH = 7;
	
	public UserView(User model){
		user = model;
		label = new JLabel();
		heading = new Font("Helvetica", Font.BOLD, 120);
		label.setFont(heading);
		label.setForeground(Color.BLACK);
		
		add(label);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		String userName = user.name();
		
		if(userName.length() >= MAX_LENGTH){
			Font oldFont = label.getFont();
			userName = userName.substring(0, MAX_LENGTH) + " ...";
			label.setFont( oldFont.deriveFont(new Float(90)) );
		}

		label.setText(userName);
		
	}
	
}