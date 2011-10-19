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
	
	
	static String int2bin(int dec){

		if(dec <= 1){
			return Integer.toString(dec);
		}
		else{
			return int2bin(dec / 2) + Integer.toString(dec % 2);
		}
	}
	
	
	static int bin2int(String bin){
		int factor;
		
		if(bin.length() == 1){
			return Integer.parseInt(bin);
		}
		else{
			factor = Character.getNumericValue(bin.charAt(0));
			
			return factor * (int) Math.pow(2, bin.length()-1) + bin2int( bin.substring(1) );
		}
	}
	
	
	static String strreverse(String str){
		if(str.length() == 1){
			return str;
		}
		else{
			return strreverse(str.substring(1)) + str.charAt(0);
		}
	}
	
	
	static int countChar(String s, char c){
		
		if (s.isEmpty())
			return 0;
			
		else if (s.charAt(0) == c)
			return 1 + countChar(s.substring(1), c);
		else
			return countChar(s.substring(1), c);
	}
	
	
	static String removeVowels(String s){
		if(s.isEmpty()){
			return s;
		
		}else{
			if("aouåeiyäö".indexOf(Character.toLowerCase( s.charAt(0) )) != -1){
				s = s.replace(s.charAt(0), '\0');
			}
			
			return s.charAt(0) + removeVowels(s.substring(1));
		}	
	}
	
	
	static boolean match(String s, String r){
		System.out.println(s.charAt(0));
		System.out.println(r.charAt(0));
		
		if(s.length() != r.length())
			return false;
		if(s.isEmpty() && r.isEmpty())
			return true;
		else if(s.isEmpty() || r.isEmpty())
			return false;
			
		if(s.charAt(0) != r.charAt(0) && (s.charAt(0) != '\u003F' && r.charAt(0) != '\u003F') ){
			return false;
		}
		else{
			return match(s.substring(1), r.substring(1));
		}
	}
	
	
	static boolean palindrome(String s){
		int last = s.length() - 1;
		
		if(s.isEmpty())
			return true;
		else if(s.length() == 1)
			return true;
		
		if(s.charAt(0) != s.charAt(last)){
			return false;
		}
		else{
			return palindrome(s.substring(1, last));
		}
	}
	
	
	public static void main(String[] args) {
		
		System.out.println(palindrome("abba"));
	}
}