import javax.swing.*;
import java.awt.*;

public class BallShape extends JComponent implements Shape {
	
	private int xPos;
	private int yPos;
	private int width;
	private int height;
	
	private int radius;
	private Color color;
	
	public BallShape(int x, int y, int radius){
		this.xPos = x;
		this.yPos = y;
		setRadius(radius);
		this.color = Color.RED;
		
		setVisible(true);
	}
	
	public int getX(){
		return this.xPos;
	}
	
	public int getY(){
		return this.yPos;
	}
	
	public void setX(int x){
		this.xPos = x;
	}
	
	public void setY(int y){
		this.yPos = y;
	}
	
	public int getWidth(){
		return this.width;
	}
	
	public int getHeight(){
		return this.height;
	}
	
	public void setColor(Color c){
		this.color = c;
	}
	
	public int getRadius(){
		return this.radius;
	}
	
	public void setRadius(int radius){
		this.radius = radius;
		height = radius * 2;
		width = radius * 2;
		setSize(width, height);
	}
	
	public String toString(){
		return "[color: "+this.color+", Radius: "+this.radius+", X: "+this.xPos+", Y: "+this.yPos+", Width: "+getSize().width+"]";
	}
	
	public void draw(Graphics g){
		g.setColor(this.color);
		g.fillOval(xPos, yPos, getWidth(), getHeight());
	}
}