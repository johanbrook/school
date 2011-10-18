import java.io.*;

public class IsVowel {
	
	private static final String VOWELS = "aouåeiyäö";
	
	public static boolean isVowel(char ch){
		// Pwn ultra light solution:
		return (VOWELS.indexOf(Character.toLowerCase(ch)) != -1);
	}
	
	public static int nbrOfVowels(String str){
		int vowels = 0;
		for(int i = 0; i < str.length(); i++){
			if( isVowel(str.charAt(i)) ){
				vowels++;
			}
		}
		
		return vowels;
	}
	
	
	public static void main(String[] args){
		String testString = "johan";
		BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
		
		try{
			System.out.println("Enter a character: ");
 			
 			char c = buff.readLine().charAt(0);
			System.out.println("Is it a vowel: " + isVowel(c));
			
			System.out.println("How many vowels in string '"+ testString +"': " + nbrOfVowels(testString));
			
		}catch(IOException e){
			System.out.println(e);
		}
		
	}
}