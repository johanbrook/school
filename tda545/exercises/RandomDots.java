import javax.swing.*;
import java.awt.*;
import java.util.*;

public class RandomDots extends JPanel {
	
	public RandomDots(){
		setPreferredSize(new Dimension(200, 200));
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Random rand = new Random();
		int x, y;
		
		for(int i = 0; i < 10000; i++){
			x = rand.nextInt(getWidth());
			y = rand.nextInt(getHeight());
			
			g.drawOval(x, y, 1,1);
		}
	}
	
	
	public static void main(String[] args) {
		JFrame f = new JFrame("Random");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setResizable(false);
		
		f.add(new RandomDots());
		f.pack();
		f.setVisible(true);
	}
}