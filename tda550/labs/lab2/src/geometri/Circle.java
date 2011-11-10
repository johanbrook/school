package geometri;

import java.awt.Color;
import java.awt.Graphics;

public class Circle extends Shape {

	private int radius;
	
	public Circle(int x, int y, int radius, Color color) throws IllegalPositionException {
		super(x, y, color);
		
		this.radius = radius;
	}

	public Circle(GeometricalForm f, int radius, Color c) {
		super(f, c);
		
		this.radius = radius;
	}

	@Override
	public int area() {
		return (int) Math.PI * (radius*radius);
	}

	@Override
	public int compareTo(GeometricalForm f) {
		return (this.area() < f.area()) ? -1 : 
				(this.area() > f.area()) ? 1 : 0;
	}

	@Override
	public void fill(Graphics g) {
		g.setColor(getColor());
		g.fillOval(getX(), getY(), radius*2, radius*2);
	}

	@Override
	public int perimeter() {
		return (int) Math.PI * (radius*2);
	}

}
