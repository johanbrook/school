import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class RandomLines extends JPanel {
	
	private final int LINES = 20;
	
	public RandomLines(){
		setPreferredSize(new Dimension(300, 300));
	}
	
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Random rand = new Random();
		
		int x, y;
		
		for(int i = 0; i < LINES; i++){
			x = rand.nextInt(getWidth());
			y = rand.nextInt(getHeight());
			
			g.drawLine(100, 100, x, y);
		}
		
	}
	
	
	public static void main(String[] args) {
		JFrame f = new JFrame("Random");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(new RandomLines());
		
		f.pack();
		f.setVisible(true);
	}
	
}