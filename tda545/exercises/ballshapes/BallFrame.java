import javax.swing.*;
import java.awt.*;


public class BallFrame extends JFrame {
	
	private BallPanel panel;
	
	private JSlider slider;
	private JLabel label;
	
	public BallFrame(){
		setLocation(300, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		panel = new BallPanel();
		
		
		JPanel p = new JPanel();
		
		label = new JLabel("Set a radius: ");
		slider = new JSlider(10, 100);
		slider.addChangeListener(panel);
	
		p.add(label);
		p.add(slider);
		
		add(panel, BorderLayout.NORTH);
		add(p, BorderLayout.SOUTH);
		
		pack();
	}
	
	public static void main(String[] args) {
		BallFrame b = new BallFrame();
		b.setVisible(true);
	}
}