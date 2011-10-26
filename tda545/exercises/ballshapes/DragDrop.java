import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DragDrop extends BallFrame implements MouseListener {
	
	BallShape ball;
	
	public DragDrop(){
		super();
		
		ball = getPanel().getBall();
		getContentPane().addMouseListener(this);
		ball.addMouseListener(this);
	}
	
	public void mouseClicked(MouseEvent e){}
	
	public void mouseEntered(MouseEvent e){
		System.out.println(e.getSource());
	}
	public void mouseExited(MouseEvent e){}
	
	public void mousePressed(MouseEvent e){
		System.out.println(e.getSource());
		if(e.getSource() == ball){
			BallShape temp = (BallShape) e.getSource();
			
			System.out.println(temp);
		}
	}
	
	public void mouseReleased(MouseEvent e){}
	
	public static void main(String[] args) {
		DragDrop d = new DragDrop();
		d.setVisible(true);
	}
}