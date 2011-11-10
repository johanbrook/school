package geometri;

import java.awt.Color;
import java.awt.Graphics;

public class Square extends Shape {

	private int side;
	
	public Square(int x, int y, int side, Color color) throws IllegalPositionException {
		super(x, y, color);
		this.side = side;
	}

	public Square(GeometricalForm f, int side, Color c) {
		super(f, c);
		this.side = side;
	}

	@Override
	public int area() {
		return side*side;
	}

	@Override
	public int compareTo(GeometricalForm f) {
		return (this.area() < f.area()) ? -1 :
				(this.area() > f.area()) ? 1 : 0;
	}

	@Override
	public void fill(Graphics g) {
		g.setColor(getColor());
		g.fillRect(getX(), getY(), this.side, this.side);
	}

	@Override
	public int perimeter() {
		return (side*4);
	}

}
