import javax.swing.*;
import java.awt.*;

public class Snowstar extends JPanel {
	
	Graphics gr;
	
	public Snowstar(){
		
	}
	
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		gr = g;
		gr.setColor(Color.BLUE);
		
		int width = getSize().width;
		int height = getSize().height;
		int min;
		
		if(height > width)
			min = height;
		else
			min = width;
			
		draw(width / 2, height / 2, min / 4);
	}
	
	private void draw(int x, int y, int size){
		int endX;
		int endY;
		
		if(size <= 2)
			return;
		
		for(int i = 0; i <= 6; i++){
			endX = x + (int) (size*Math.cos( (2*Math.PI/6)*i ));
			endY = y - (int) (size*Math.sin( (2*Math.PI/6)*i ));
			gr.drawLine(x, y, endX, endY);
			
			draw(endX, endY, size / 3);
		}
	}
	
	
	
	public static void main(String[] args) {
		JFrame f = new JFrame("Snowstar");
		Snowstar s = new Snowstar();
		
		f.setPreferredSize(new Dimension(300, 300));
		f.setLocation(300, 300);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(s);
		f.pack();
		f.setVisible(true);
	}
	
}