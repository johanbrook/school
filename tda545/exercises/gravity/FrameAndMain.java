import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class FrameAndMain extends JFrame {
	
	private BallWindow panel;
	
	public FrameAndMain(){
		super("Falling ball");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		panel = new BallWindow(180.0, 1.0, 1.0);
		add(panel, BorderLayout.WEST);
		pack();
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new FrameAndMain();
	}
}