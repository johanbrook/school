package se.chalmers.hajo.debug.ctrl;

import java.awt.Color;
import java.util.Random;

public class OtherCtrl {
	
	public Color execute(){ 
		Random rand = new Random();
		int r = rand.nextInt(256); 
		int g = rand.nextInt(256); 
		int b = rand.nextInt(256); 
		return new Color(r,g,b);
	}
}
