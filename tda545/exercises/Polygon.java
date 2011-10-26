import java.util.*;
import java.awt.*;

public class Polygon {
	
	private ArrayList<Point> points;
	
	public Polygon(){
		points = new ArrayList<Point>();
	}
	
	public void add(Point p){
		points.add(p);
	}
	
	public double perimeter(){
		double perimeter = 0.0;
		
		for(int i = 0; i < points.size()-1; i++){
			perimeter = perimeter = Math.sqrt( Math.pow((points.get(i).x - points.get(i+1).x), 2) + Math.pow((points.get(i).y - points.get(i+1).y), 2) );
		}
		
		return perimeter;
	}
	
	public String toString(){
		return points.toString();
	}
	
	
	public static void main(String[] args) {
		Polygon p = new Polygon();
		
		p.add(new Point(3,3));
		p.add(new Point(4,6));
		p.add(new Point(3,3));
		
		System.out.println(p.perimeter());
	}
	
}