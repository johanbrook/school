import javax.swing.*;
import java.awt.*;

public class Rectangle extends JPanel {
	private final int OFFSET = 10;
	
	public Rectangle(){
		setPreferredSize(new Dimension(340, 340));
		setVisible(true);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		int xOffset = getSize().width - OFFSET*2;
		int yOffset = getSize().height - OFFSET*2;
		
		g.drawRect(OFFSET, OFFSET, xOffset, yOffset);
		g.drawRect(OFFSET*2, OFFSET*2, xOffset - OFFSET*2, yOffset - OFFSET*2);
	}
	
	
	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setContentPane(new Rectangle());
		
		f.setLocation(300, 300);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.pack();
		f.setVisible(true);
	}
}