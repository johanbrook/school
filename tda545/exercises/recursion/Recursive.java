/**
	Various recursive exercises. Main method at the bottom.

*/
class Recursive {
	
	static int Triangle(int n){
		if(n == 1){
			return 1;
		}
		else{
			return n + Triangle(n - 1);
		}
	}
	
	static int Fib(int n){
		if(n <= 1){
			return n;
		}
		else{
			return Fib(n - 1) + Fib(n - 2);
		}
	}
	
	
	static boolean prime(int n, int m){
		if(m == 1){
			return true;
		}
		if(n % m == 0){
			return false;
		}
		else{
			return prime(n, m - 1);
		}
	}
	
	
	static int gcd(int n, int m){
		if(n == 0){
			return m;
		}
		else{
			return gcd(m % n, n);
		}
	}
	
	
	static int pyramid(int side){
		if(side == 1){
			return 1;
		}
		else{
			return side + pyramid(side - 1);
		}
		
	}
	
	
	static int sum(int n, int m){
		if(n == m)
			return m;
		else if(n > m)
			return -1;
		else
			return n + sum(n + 1, m);
	}
	
	
	static void sequence(int n){
		System.out.println(n);
		
		if(n == 1)
			return;

		if(n % 2 == 0)
			sequence(n / 2);
		else
			sequence(3*n + 1);
	}
	
	
	static int cube(int n){
		if(n == 1)
			return 1;
		else
			return cube(n-1) + (3 * square(n)) - 3*n + 1;
	}
	
	
	static int square(int n){
		if(n == 1)
			return 1;
		else
			return square(n-1) + 2*n - 1;
	}
	
	
	static int sum(int[] array, int index){
		if(array.length == index){
			return 0;
		}
		else if(index < array.length){
			return array[index] + sum(array, index + 1);
		}
		else{
			return -1;
		}
	}
	
	
	static int sum(int[] a){
		return sum(a, 0);
	}
	
	
	static int max(int[] a, int index){
		int max;
		
		if(a.length-1 == index)
			return a[index];
		
		if(a[index] > a[index+1])
			max = a[index];
		else
			max = a[index+1];
		
		
		int next = max(a, index+1);
		
		if(max > next)	
			return max;
		else
			return next;
	}
	
	
	static void perrin(int n){
		
		if(n == 0)
			System.out.println(3);
		else if(n == 1)
			System.out.println(0);
		else if(n == 2)
			System.out.println(2);
		else
			perrin(n-2);
	}
	
	
	static long comb(long m, long n){
		if(m < n)
			return 0;
		else if(n < 0)
			return 0;
			
		if(m == 0)
			return 1;
		
		return comb(m-1, n-1) + comb(m-1, n);
	}
	
	
	static int strlen(String s){
		if(s.isEmpty()){
			return 0;
		}
		
		return 1 + strlen(s.substring(1));
	}
	
	static boolean same(String s, String t){
		if(s.length() != t.length())
			return false;

		else if(s.isEmpty() && t.isEmpty())
			return true;
		else if(s.isEmpty() || t.isEmpty())
			return false;
		
		if(s.charAt(0) != t.charAt(0)){
			return false;
		}
		else{
			return same(s.substring(1), t.substring(1));
		}
	}
	
	
	public static void main(String[] args) {
		int n = 0;
		int[] a = {1,2,3,4,2,10,8, 20};
		
		System.out.println( same("lol1", "lol1") );
	}
}