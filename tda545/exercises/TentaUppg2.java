class TentaUppg2 {
	
	static int sumOfSquares(int m, int n) {
		int sum = 0;
		for (int i=m; i<=n; i++) {
			sum = sum + i*i;
		}
		
		return sum;
	}
	
	static int sumOfSquares2(int m, int n){
		int middle = (m + n) / 2;
		
		if(m == n){
			return m*m;
		}else if(m > n){
			return 0;
		}
		else{
			return sumOfSquares2(m, middle) + sumOfSquares2(middle + 1, n);
		}
		
	}
	
	
	public static void main(String[] args) {
		System.out.println(sumOfSquares(2, 10));
		System.out.println(sumOfSquares2(2, 10));
	}
	
	
}