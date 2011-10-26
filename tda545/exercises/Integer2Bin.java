class Integer2Bin {
	
	public static String int2base(int i, int base){
		
		if(base != 2){
			throw new NumberFormatException("Otillåtet");
		}
		
		int bit = i % base;
		int newI = (int) Math.floor(i / base);

		if(newI == 0){
			return Integer.toString(bit);
		}
		
		return int2base(newI, base) + bit;
	}
	
	public static void main(String[] args) {
		System.out.println( int2base(23, 2) );
	}
}