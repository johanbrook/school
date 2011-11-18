import java.util.*;

/**
* A comparator that can provide all total orderings for a Car-object.
* @inv Describe reasonable class invariants.
*/
class CarComparator implements Comparator<Car> {

	private final Field[] f;
	private final Order[] o;
	
	public enum Field{
		MANUFACTURER, MODELNAME, MODELYEAR, SERIAL
	}
	
	public enum Order{
		ASCENDING, DESCENDING
	}
	
	/**
		* @pre Describe reasonable preconditions.
	*/
	
	public static void main(String[] args) {
		Field[] f = {Field.MODELYEAR, Field.MANUFACTURER, Field.MODELNAME, Field.SERIAL};
		Order[] o = {Order.ASCENDING, Order.DESCENDING, Order.DESCENDING, Order.ASCENDING};
		
		Car a = new Car("bmw", "Z3", 1990, "AXA");
		Car b = new Car("bmw", "D000", 1990, "Lol");
		Car c = new Car("Volvo", "240", 1988, "wad1");
		
		Car[] arr = {a, b, c};
		
		Arrays.sort(arr, new CarComparator(f, o));
		
		for(Car q : arr){
			System.out.println(a);
		}
	}

	public CarComparator(Field[] f, Order[] o) {
		this.f = f.clone();
		this.o = o.clone();
		
	}
	
	private int attrCompare(Field f, Car c1, Car c2){
		switch(f){
			case MANUFACTURER: 
				return c1.getManufacturer().compareTo(c2.getManufacturer());
			
			case MODELYEAR:
				return c1.getModelYear() - c2.getModelYear();
			
			case MODELNAME:
				return c1.getModelName().compareTo(c2.getModelName());
			
			case SERIAL:
				return c1.getSerial().compareTo(c2.getSerial());
				
			default: return 0;
		}
	}
	
	public int compare(Car c1, Car c2) {
		// Your implementation.
		
		for(int i = 0; i < f.length; i++){
			int diff = attrCompare(f[i], c1, c2);
			
			if(diff != 0){
				return o[i] == Order.ASCENDING ? diff : -diff;
			}
		}
		
		return 0;
		
	}
}
