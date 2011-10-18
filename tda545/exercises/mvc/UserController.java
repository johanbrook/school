import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UserController extends JPanel {
	
	private User user;
	private UserView view;
	private JTextField text;
	
	public UserController(User model){
		this.user = model;
		this.view = new UserView(user);
		
		text = new JTextField(10);
		JButton button = new JButton("Change name");
		
		button.addActionListener(new ButtonListener());
		text.addKeyListener(new EnterListener());
		
		setLayout(new BorderLayout());
		add(view, BorderLayout.NORTH);
		add(text, BorderLayout.CENTER);
		add(button, BorderLayout.SOUTH);
	}
	
	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e){
			user.name(text.getText());
			view.repaint();
		}
	}
	
	private class EnterListener implements KeyListener {
		
		public void keyPressed(KeyEvent e){
			if(e.getKeyCode() == KeyEvent.VK_ENTER){
				user.name(text.getText());
				view.repaint();
			}
		}
		
		public void keyReleased(KeyEvent e){}
		public void keyTyped(KeyEvent e){}
	}
	
	
}