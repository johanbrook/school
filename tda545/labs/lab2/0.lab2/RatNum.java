/** 
*	Rational number class
*
*	Simple class for working with rational numbers. Supports common
*	aritmethic operations, such as addition, subtraction, and more.
*
*	Contents:
*	
*	- Instance variables
*	- Constructors
*	- Public methods
*	- Overrides
*	- Class methods
*
*	@author Johan Brook (900720-0216), Robin Andersson (900122-0574)
*	@group 0
*	@assignment Lab 2, del 1
*	@date 2011-09-13
*/


public class RatNum {
	
	// Instance variables
	
	private int numerator;
	private int denominator;
	
	
	// Constructors
	
	public RatNum(){
		this.numerator = 0;
		this.denominator = 1;
	}
	
	public RatNum(int a){
		this.numerator = a;
		this.denominator = 1;
	}
	
	/**
	*	Build a rational number with a numerator and denominator.
	*
	*	@param a The numerator.
	*	@param b The denominator.
	*	@throws NumberFormatException if b (the denominator) is 0.
	*/
	public RatNum(int a, int b){
		
		// The denominator can't be 0:
		if(b == 0){
			throw new NumberFormatException("Denominator = 0");
		}
		
		// The numerator and denominator shouldn't be negative:
		if(a < 0 && b < 0){
			a = Math.abs(a);
			b = Math.abs(b);
		}
		else if(b < 0){
			a = -a;
			b = Math.abs(b);
		}
		
		/* 
			If "a" is 0, no common divisor can be found, and numerator and denominator is
			set to a and b 
		*/
		
		this.numerator = (a == 0)	? a : a / sgd(a, b);
		this.denominator = (a == 0) ? b : b / sgd(a, b);
		
		/*
			Below you see a longer form of the 'if' conditionals above. 
			We prefer the compact form when dealing with these
			simple tasks though.
			
			if(a == 0){
				this.numerator = a;
				this.denominator = b;
			}
			else{
				int divisor = sgd(a, b);
				this.numerator = a / divisor;
				this.denominator = b / divisor;
		}
		*/

	}
	
	/**
	*	"Clone" constructor: creates a new RatNum based on the properties
	*	of an existing RatNum.
	*
	*	@param r A RatNum.
	*/
	public RatNum(RatNum r){
		this.numerator = r.getNumerator();
		this.denominator = r.getDenominator();
	}
	
	
	/**
	*	Build a new RatNum based on the information in a well formated string.
	*
	*	@param text A string with a rational number, such as "2/3". 
	*	@throws NumberFormatException if the parameter is not well formatted.
	*/
	public RatNum(String text){		
		RatNum parsedRatNum;
		
		try{
			parsedRatNum = parse(text);
			this.numerator = parsedRatNum.getNumerator();
			this.denominator = parsedRatNum.getDenominator();
		}
		catch(NumberFormatException e){
			throw e;
		}
	}

	
	
	// Public methods
	
	
	/**
	*	Returns the numerator.
	*/
	public int getNumerator(){
		return this.numerator;
	}
	
	/**
	*	Returns the denominator.
	*/
	public int getDenominator(){
		return this.denominator;
	}
	
	/**
	*	Returns the rational number as a double.
	*/
	public double toDouble(){
		return (double) this.numerator / this.denominator;
	}
	
	
	/**
	*	Check if "our" instance of RatNum is less than a RatNum r.
	*
	*	@param r A RatNum.
	*/
	public boolean lessThan(RatNum r){
		// To compare the RatNums, they need common denominators.
		int ourNumerator = this.numerator * r.getDenominator();
		int foreignNumerator = r.getNumerator() * this.denominator;
		
		return (ourNumerator < foreignNumerator);
	}
	
	
	/**
	*	Add another RatNum.
	*
	*	@param r A RatNum.
	*/
	public RatNum add(RatNum r){
		int numerator = (this.denominator * r.getNumerator()) + (this.numerator * r.getDenominator());
		int denominator = this.denominator * r.getDenominator();

		return new RatNum(numerator, denominator);
	}
	
	
	/**
	*	Subtract another RatNum from our instance.
	*
	*	@param r A RatNum.
	*/
	public RatNum sub(RatNum r){
		int numerator = (this.numerator * r.getDenominator()) - (this.denominator * r.getNumerator());
		int denominator = this.denominator * r.getDenominator();
		
		return new RatNum(numerator, denominator);
	}
	
	/**
	*	Multiply with another RatNum.
	*
	*	@param r A RatNum.	
	*/
	public RatNum mul(RatNum r){
		return new RatNum(this.numerator * r.getNumerator(), this.denominator * r.getDenominator());
	}
	
	
	/**
	*	Divide with another RatNum.
	*
	*	@param r A RatNum.
	*/
	public RatNum div(RatNum r){		
		/* 	A new RatNum is created from the parameter r, where a/b is inversed to b/a.
			It's used with the multiplication method above. */
		return this.mul(new RatNum(r.getDenominator(), r.getNumerator()));
		
		/*
			We could have created a reusable method for inverting RatNums, but felt
			it wasn't justified for the trivial task above.
			
			We could have written something like this instead of the return line above:
			
				return this.mul(r.invertRational());
			
			Where 'invertRational()' is a (perhaps private) method where the numerator and
			denominator have switched positions.

		*/
	
		
	}
	
	
	// Overrides
	
	public String toString(){
		int integerPart = this.numerator / this.denominator;
		int remainder = this.numerator % this.denominator;
		
		// If both parts are zero, return 0:
		if(integerPart == 0 && remainder == 0){
			return "0";
		
		// If there's no integer part, return on regular form: 'a/b'
		}else if(integerPart == 0 && remainder != 0){
			return this.numerator + "/" + this.denominator;
		}
		else if(remainder == 0){
			// Return the integer part as a String:
			return integerPart + "";
			
		}
		else{
			// Return on mixed form: 'A b/c'
			return integerPart + " " + Math.abs(this.numerator % this.denominator) + "/" + this.denominator;
		}
	}
	
	
	public boolean equals(RatNum r){
		return (
			this.numerator == r.getNumerator() && 
			this.denominator == r.getDenominator()
		);
	}
	
	
	
	
	// Class methods
	
	
	/**
	*	Parse a well-formatted string and build a new RatNum.
	*
	*	@param s A well-formatted string, such as "2/3".
	*	@throws NumberFormatException if the string is not well-formatted.
	*/
	public static RatNum parse(String s){
		int a;
		int b;
		
		// Append "/1" if the string doesn't contain a slash,
		// i.e. is a single numerator:
		
		s += (s.indexOf("/") == -1) ? "/1" : "";
		
		try{
			a = Integer.parseInt( s.substring(0, s.indexOf("/")) );
			b = Integer.parseInt( s.substring(s.indexOf("/") + 1) );
		}
		catch(NumberFormatException e){
			throw e;
		}
		
		return new RatNum(a, b);
		
	}
	
	
	/**
	*	Calculate the greatest common divisor of two integers.
	*
	*	Using Euclid's algorithm (http://en.wikipedia.org/wiki/Euclidean_algorithm)
	*
	*	@param m The first integer.
	*	@param n The second integer.
	*	@throws IllegalArgumentException if any of the parameters are zero.
	*/
	public static int sgd(int m, int n){
		if(m == 0 || n == 0){
			throw new IllegalArgumentException();
		}
		
		// We only want positive integers:
		m = Math.abs(m);
		n = Math.abs(n);
		
		int r = m % n;
		
		while(r != 0){
			m = n;
			n = r;
			r = m % n;
		}
		
		return n;
		
	}
}