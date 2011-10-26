import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DragnDrop extends JFrame implements MouseListener, MouseMotionListener {
	
	JPanel obj;
	
	private int x, y;
	
	public DragnDrop(){
		super("Drag N Drop");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(400,400));
		setLayout(new FlowLayout());
		
		obj = new JPanel();
		obj.setPreferredSize(new Dimension(60,60));
		obj.setOpaque(true);
		obj.setBackground(Color.RED);
		obj.addMouseListener(this);
		obj.addMouseMotionListener(this);
		
		update(100, 100);
		add(obj);
		
		pack();
		setVisible(true);
	}
	
	private void update(int x, int y){
		obj.setLocation(x, y);
	}
	
	
	public void mouseClicked(MouseEvent e){}
	
	public void mouseEntered(MouseEvent e){}
	public void mouseExited(MouseEvent e){}
	
	public void mousePressed(MouseEvent e){
		
	}
	
	public void mouseDragged(MouseEvent e){
		update(e.getX(), e.getY());
	}
	
	public void mouseMoved(MouseEvent e){}
	
	public void mouseReleased(MouseEvent e){}
	
	
	public static void main(String[] args) {
		new DragnDrop();
	}
	
}