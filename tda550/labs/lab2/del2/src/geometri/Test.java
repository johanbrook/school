package geometri;

import java.awt.Color;

/**
 * A class testing the shapes, mostly their <code>equals</code>, 
 * <code>compareTo</code> and <code>hashCode</code> methods.
 * 
 * @author Johan Brook and Robin Andersson
 *
 */
public class Test {
	
	public static void main(String[] args) {
		
		boolean didCatchException = false;
		
		try{	
			
			// These two are equal:
			GeometricalForm s = new Rectangle(10, 10, 30, 20, Color.RED);
			GeometricalForm t = new Rectangle(10, 10, 30, 20, Color.RED);
			GeometricalForm u = new Rectangle(t, 30, 20, Color.RED);
			
			// This guy's the odd one:
			GeometricalForm r = new Rectangle(10, 10, 20, 30, Color.WHITE);
			
			// Two equal circles:
			GeometricalForm c = new Circle(10, 10, 20, Color.RED);
			GeometricalForm c2 = new Circle(c, 20, Color.RED);
			
			// A square and an equal rectangle
			GeometricalForm rc = new Rectangle(10, 10, 20, 20, Color.RED);
			GeometricalForm sq = new Square(10, 10, 20, Color.RED);
			
			
			
			/*
				General tests
			-------------------------------- */
			
			// Reflexivity
			test(s.equals(s), "s.equals(s)", true);
			
			// Symmetry
			test(s.equals(t), "s.equals(t)", true);
			test(t.equals(s), "t.equals(s)", true);
			
			// Transivity (s equals t && t equals u => s equals u)
			
			boolean precon = s.equals(t) && t.equals(u);
			test(precon && s.equals(u), "s.equals(u)", true);
			
			// Circle equality
			test(c.equals(c2), "c.equals(c2)", true);
			
			// Null references
			test(s.equals(null), "s.equals(null)", false);

			
			/*
				Non-equality tests
			-------------------------------- */
			
			test(s.equals(r), "s.equals(r)", false);
			
			// A rectangle isn't a circle
			test(s.equals(c), "s.equals(c)", false);
			
			// A rectangle isn't a square
			test(rc.equals(sq), "rc.equals(sq)", false);
			
			
			
			
			/*
				Comparison tests
			-------------------------------- */
			
			// Equal objects should be equal in comparison
			test(s.equals(t) && s.compareTo(t) == 0, "s.equals(t) && s.compareTo(t)", true);
			
			// S should be less than C
			compare(s.compareTo(c), "s.compareTo(c)", -1);
			
			// Reflexivity
			compare(s.compareTo(s), "s.compareTo(s)", 0);
			
			// Anti symmetry
			test(s.compareTo(c) <= 0 && c.compareTo(s) >= 0, "s.compareTo(c) && c.compareTo(s)", true);
			
			// Transivity
			boolean compCond = rc.compareTo(s) <= 0 && s.compareTo(c) <= 0;
			test(compCond && rc.compareTo(c) <= 0, "rc.compareTo(c)", true);
			
						
			/*
				Hashcode tests
			-------------------------------- */
			
			
			boolean cond = s.equals(t);
			
			// Equal objects should have equal hashcodes
			test(cond && s.hashCode() == t.hashCode(), "Equal objects' hashcodes ", true);
			
			// Non-equal objects' hashcodes should be false
			test(s.hashCode() == r.hashCode(), "Non-equal objects' hashcodes ", false);
		
			// Negative parameters
			GeometricalForm q = new Square(10, -10, 20, Color.RED);
			
		}catch(IllegalPositionException e){
			didCatchException = true;	
		}
		
		test(didCatchException, "Illegal positions were catched", true);
		
	}
	
	/**
	 * Compare case. Takes two integers and compares them.
	 * 
	 * @param result The result of an comparison operation
	 * @param message The description of this test
	 * @param expected The expected integer output (negative, positive, or zero)
	 */
	private static void compare(int result, String message, int expected){
		if((result > 0 && expected > 0) || 
			(result == 0 && expected == 0) ||
			(result < 0 && expected < 0)){
			
			System.out.print("Passed: ");
		}
		else{
			System.out.print("Failed: ");
		}
		
		String print = (expected < 0) ? "smaller" : (expected > 0) ? "larger" : "same";
		String was = (result < 0) ? "smaller" : (result > 0) ? "larger" : "same";
		
		System.out.println(message + " should be (" + print + "), was ("+ was +")\n");
	}
	
	
	/**
	 * Boolean test case. Takes two boolean expressions/values
	 * and compares them.
	 * 
	 * @param cond The result of a operation returning a boolean
	 * @param message The description of this test
	 * @param expected The expected boolean output of this test
	 */
	private static void test(boolean cond, String message, boolean expected){
		
		if(cond == expected){
			System.out.print("Passed: ");
		}
		else{
			System.out.print("Failed: ");
		}
		
		System.out.print(message + " should be (" + expected + "), was ("+ cond +")\n");
	}
	
}
