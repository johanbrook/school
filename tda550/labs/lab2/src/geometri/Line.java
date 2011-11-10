package geometri;

import java.awt.Color;
import java.awt.Graphics;

public class Line extends Shape {

	private int x2;
	private int y2;
	private double k;
	
	public Line(int x, int y, int x2, int y2, Color color) throws IllegalPositionException {
		super(x, y, color);
		
		if(x2 < 0 || y2 < 0){
			throw new IllegalPositionException("The coordinates can't be negative!");
		}
		
		this.x2 = x2;
		this.y2 = y2;
		
		// TvŒpunktsformeln:
		this.k = (this.y2 - getY()) / (this.x2 - getX());
	}

	

	public Line(GeometricalForm f1, GeometricalForm f2, Color c) {
		// Avoid calling "this()" so we don't throw an exception here:
		super(f1, c);
		this.x2 = f2.getX();
		this.y2 = f2.getY();
		
		// TODO Bad design, DRY.
		this.k = (this.y2 - getY()) / (this.x2 - getX());
	}
	
	
	public double getAngle(){
		return this.k;
	}
	
	@Override
	public int area() {
		return 0;
	}

	@Override
	public int compareTo(GeometricalForm f) {
		Line temp =  (Line) f;
		return (this.k < temp.getAngle()) ? -1 :
				(this.k > temp.getAngle()) ? 1 : 0;
	}

	@Override
	public int perimeter() {
		int a = getY() - this.y2;
		int b = this.x2 - getX();
		return (int) Math.sqrt((a*a) + (b*b));
	}

	@Override
	public void fill(Graphics g) {
		g.setColor(getColor());
		g.drawLine(getX(), getY(), this.x2, this.y2);
	}
	
}
