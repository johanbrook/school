/** 
*	Util class.
*
*	@author Johan Brook (900720-0216), Robin Andersson (900122-0574)
*	@group 0
*	@assignment Lab 4
*	@date 2011-10-11
*/
public class Verktyg {
	
	/**
	*	Shuffles the order of the elements in an array.
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
}