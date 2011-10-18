import javax.swing.*;
import java.util.*;

class RelPrim {
	
	static boolean relPrim(int a, int b){
		for(int i = 2; i <= a && i <= b; i++){
			if(a % i == 0 && b % i == 0){
				return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		String numbers = JOptionPane.showInputDialog("Numbers here");
		if(numbers == null){
			System.exit(0);
		}
		
		Scanner sc = new Scanner(numbers);
		int a = sc.nextInt();
		int b = sc.nextInt();
		String msg;
		
		if(relPrim(a, b))
			msg = "De var inte relativa primtal";
		else
			msg = "De var relativa primtal";
			
		JOptionPane.showMessageDialog(null, msg);
	}
}