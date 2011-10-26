import java.util.*;

public class Slask {
	
	
	static int sum(int n, int m){
		int mid = (n + m) / 2;
		
		if(n > m)
			return -1;
		else if(m == n)
			return n*n;
			
		else
			return sum(n, mid) + sum(mid+1, m);
	}


	static String int2base(int i, int base){
		if(base != 2)
			throw new NumberFormatException("Otillåten bas");
		
		if(i < base)
			return Integer.toString(i);
		else
			return int2base(i / base, base) + Integer.toString(i % base);
	}

	public static void main(String[] args) {
		
		System.out.println(sum(2, 3));
		
		System.out.println("**********************");
		
		for(int i = 0; i < 20; i++){
			try{
				System.out.println(int2base(i, 2));
			}
			catch(NumberFormatException e){
				System.out.println(e.getMessage());
			}
		}
		
	}
	
}