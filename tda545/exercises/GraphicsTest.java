import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GraphicsTest extends JPanel implements ActionListener {
	
	private Color cl;
	private int x;
	private int y;
	
	public GraphicsTest(){
		JButton red = new JButton("RED");
		JButton blue = new JButton("BLUE");
		JButton move = new JButton("Move");
		
		x = 40;
		y = 40;
		
		red.setActionCommand("red");
		blue.setActionCommand("blue");
		move.setActionCommand("move");
		
		red.addActionListener(this);
		blue.addActionListener(this);
		move.addActionListener(this);
		
		add(red);
		add(blue);
		add(move);
	}
	
	public void setBallColor(Color c){
		this.cl = c;
		repaint();
	}
	
	public void moveBall(int dx, int dy){
		x = x + dx;
		y = y + dy;
		
		repaint();
	}
	
	public void actionPerformed(ActionEvent e){
		JButton temp = (JButton) e.getSource();
		if(temp.getActionCommand().equals("red")){
			setBallColor(Color.RED);
		}
		else if(temp.getActionCommand().equals("blue")){
			setBallColor(Color.BLUE);
		}
		else{
			moveBall(10, 10);
		}
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		g.setColor(cl);
		g.fillOval(x, y, x*2, y*2);
	}
	
	public static void main(String[] args) {
		JFrame f = new JFrame();
		GraphicsTest t = new GraphicsTest();
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(t);
		f.setPreferredSize(new Dimension(400, 400));
		f.pack();
		
		f.setVisible(true);
	}
}