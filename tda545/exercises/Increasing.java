public class Increasing {

	public static boolean increasing(int[] f){
		if(f == null || f.length == 0){
			return false;
		}
		for(int i = 0; i < f.length-1; i++){

			if(f[i] >= f[i+1]){
				return false;
			}
			
		}
		
		return true;
	}
	
	
	public static boolean increasing2(int[] f, int n){
		if(f == null || f.length == 0)
			return false;
		
		if(n == 0 || n == 1)
			return true;
			
		if(f[n] >= f[n-1]){
			return increasing2(f, n-1);
		}
		else{
			return false;
		}
	}
	
	
	public static void main(String[] args) {
		int[] temp = new int[args.length];
		try{
			for(int i = 0; i < temp.length; i++){
				temp[i] = Integer.parseInt(args[i]);
			}
			
			System.out.println(increasing(temp));
			System.out.println(increasing2(temp, temp.length-1));
		}
		catch(NumberFormatException e){
			System.out.println("Fel i indata");
		}
		
	}
}