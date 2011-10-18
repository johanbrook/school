class Pins {
	
	static int Triangle(int n){
		if(n == 1){
			return 1;
		}
		else{
			return n + Triangle(n - 1);
		}
	}
	
	public static void main(String[] args) {
		System.out.println( Triangle(7) );
	}
}