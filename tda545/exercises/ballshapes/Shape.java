import java.awt.*;

public interface Shape {
	// drawing color
	public void setColor(Color c);
	
	// width and height of the component
	// i.e. size of smallest enclosing rectangle
	public int getWidth();
	public int getHeight();
	
	// position of upper left corner
	public int getX();
	public int getY();
	
	public void draw(Graphics g);
}
