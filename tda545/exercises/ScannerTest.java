import java.util.*;
import java.io.*;

public class ScannerTest {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		System.out.println("Skriv: ");
		int hej = 0;
		
		if(s.hasNextInt()){
			hej = s.nextInt();
		}
		
		System.out.println("Du skrev " + hej);
	}
	
}