import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class BallWindow extends JPanel {
	
	private Gravity2 gr;
	private double dropHeight;
	private int height;
	private final int SIZE = 30;
	
	public BallWindow(double dropHeight, double resolution, double delay){
		setPreferredSize(new Dimension(400, 600));
		gr = new Gravity2(dropHeight, resolution);
		
		this.dropHeight = dropHeight;
		
		while(gr.getHeight() > 0){
			gr.tick();
			height = (int) (600 - ((gr.getHeight() / dropHeight) * 600));
			repaint();
		}
		
		setOpaque(true);
		setBackground(Color.WHITE);
		repaint();
		setVisible(true);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		System.out.println(height);
		g.fillOval(10, 10, SIZE, SIZE);
		//g.drawString(gr.toString(), 10+SIZE+10, height);
		
		
	}
	
}