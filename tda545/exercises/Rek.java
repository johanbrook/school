public class rek {
	
	/**
	*	Calculate number of digits in integer n.
	*/
	static int numberOfDig(int n){
		n = n / 10;
		if(n == 0)
			return 1;
			
		return (numberOfDig(n) + 1);
	}
	
	
	/**
	*	Strip non-alpha characters from string s, with start on position n
	*/
	static String strip(String s, int n){
		if(s.length() <= n){
			return s;
		}
		else if(!Character.isLetter(s.charAt(n))){
			// Java's bulky process of removing a character from a string ..
			s = s.replace(Character.toString(s.charAt(n)), "");
		}
		
		return (strip(s, n + 1));
	}
	
	
	public static void main(String[] args){
		//System.out.println(numberOfDig(555));
		// => 3
		
		System.out.println(strip("this_is_a_string_with_stuff!.", 0));
		
	}
}