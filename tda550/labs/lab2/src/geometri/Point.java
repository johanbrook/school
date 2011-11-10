package geometri;

import java.awt.*;

public class Point extends Shape {
	
	private final int WIDTH = 1;
	private final int HEIGHT = 1;
	
	public Point(int x, int y, Color c) throws IllegalPositionException {
		super(x, y, c);
	}
	
	public Point(GeometricalForm f, Color c) {
		super(f, c);
	}
	
	
	
	@Override
	public int area() {
		return 0;
	}

	@Override
	public int compareTo(GeometricalForm f) {
		return 0;
	}

	@Override
	public void fill(Graphics g) {
		g.setColor(getColor());
		g.fillOval(getX(), getY(), WIDTH, HEIGHT);
	}

	@Override
	public int perimeter() {
		return 0;
	}

}
