import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;

public class BallPanel extends JPanel implements ChangeListener {
	
	private BallShape ball;
	
	public BallPanel(){
		ball = new BallShape(30, 30, 30);
		setPreferredSize(new Dimension(300, 300));
		setVisible(true);
	}
	
	public void stateChanged(ChangeEvent e){
		
		if(e.getSource() instanceof JSlider){
			JSlider slider = (JSlider) e.getSource();
			
			ball.setRadius(slider.getValue());
			repaint();
		}
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		ball.draw(g);
	}
}