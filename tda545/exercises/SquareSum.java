class SquareSum {
	
	public static int sumOfSquares(int m, int n){
		int sum = 0;
		int mid = (m + n) / 2;
		
		if(m > n){
			return -1;
		}
		else{
			
		}
	}
	
	
	static int sumOfSquares1(int m, int n) {
		int sum = 0;
		for (int i=m; i<=n; i++) {
			sum = sum + i*i;
		}
		return sum;
	}
	
	public static void main(String[] args) {
		System.out.println(sumOfSquares1(2, 5));
		System.out.println("*******************");
		System.out.println(sumOfSquares(2, 5));
	}
}