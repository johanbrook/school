import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

public class BallPanel extends JPanel implements ChangeListener, MouseListener {
	
	private BallShape ball;
	
	public BallPanel(){
		ball = new BallShape(30, 30, 30);
		setPreferredSize(new Dimension(300, 300));
		setVisible(true);
		
		ball.addMouseListener(this);
		add(ball);
	}
	
	public BallShape getBall(){
		return this.ball;
	}
	
	public void mouseClicked(MouseEvent e){}
	
	public void mouseEntered(MouseEvent e){
		System.out.println(e.getSource());
	}
	public void mouseExited(MouseEvent e){}
	
	public void mousePressed(MouseEvent e){
		
	}
	
	public void mouseReleased(MouseEvent e){}
	
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