package geometri;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends Shape {

	private int width;
	private int height;
	
	public Rectangle(int x, int y, int width, int height, Color color) 
			throws IllegalPositionException, IllegalArgumentException {
		
		super(x, y, color);
		
		if(width < 0 || height < 0){
			throw new IllegalArgumentException("Measures can't be negative!");
		}
		
		this.width = width;
		this.height = height;
	}

	public Rectangle(GeometricalForm f, int width, int height, Color c) {
		super(f, c);
		
		this.width = width;
		this.height = height;
	}

	@Override
	public int area() {
		return this.width * this.height;
	}

	@Override
	public int compareTo(GeometricalForm f) {
		return (this.area() < f.area()) ? -1 : 
			(this.area() > f.area()) ? 1 : 0;
	}

	@Override
	public void fill(Graphics g) {
		g.setColor(getColor());
		g.fillRect(getX(), getY(), this.width, this.height);
	}

	@Override
	public int perimeter() {
		return (this.width*2) + (this.height*2);
	}

}
