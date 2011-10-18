/** 
*	Util class
*
*	@author Johan Brook (900720-0216), Robin Andersson (900122-0574)
*	@group 0
*	@assignment Lab 4
*	@date 2011-10-03
*/

import javax.swing.ImageIcon;
import java.io.File;

public class Verktyg {
	
	/**
	*	Shuffles an array
	*
	*	@param field The array
	*/
	public static void slumpOrdning(Object[] field){
		int rand;
		Object oldObj;

		for(int i = 0; i < field.length; i++){
			rand = (int) (field.length * Math.random());
			oldObj = field[i];
			
			field[i] = field[rand];
			field[rand] = oldObj;
		}
		
		
	}
	
	/**
	*	Loads image icons from a specified folder and returns
	*	an array with created Kort objects.
	*
	*	@param required The amount of cards which should be returned
	*	@param path The path (a directory) to load images from
	*	@return An array with Kort objects (with icons)
	*/
	public static Kort[] loadIcons(int required, String path){
		File resources = new File(path);
		Kort[] temp = new Kort[required];
		
		// 	Just in case something went wrong .. 
		if(resources == null){
			throw new NullPointerException();
		}
		
		File[] icons = resources.listFiles();
		
		if(icons.length < required ){
			throw new ArrayIndexOutOfBoundsException();
		}
		
		//	Randomize the order of the images, so we don't play
		// 	with the same ones on every app launch.
		slumpOrdning(icons);
		
		// Finally, create new cards with icons, and fill an array:
		for(int i = 0; i < required; i++){
			temp[i] = new Kort( new ImageIcon(icons[i].getPath() ));
		}
		
		return temp;
	}
	
}