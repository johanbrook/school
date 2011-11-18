import java.util.*;

public final class Car implements Comparable<Car> {

	private final String manufacturer;
	private final String modelName;
	private final int modelYear;
	private final String serialNumber;
	
	// Accessors go here.
	
	public String toString() {
		
		return getClass().toString() + " manufacturer: " + this.manufacturer+
			" | modelName: " + this.modelName +
			" | modelYear: " + this.modelYear +
			" | serialNumber: " + this.serialNumber;
	}
	
	public Car(String manufacturer, String modelName, int modelYear, String serialNumber) {
		this.manufacturer = manufacturer;
		this.modelName = modelName;
		this.modelYear = modelYear;
		this.serialNumber = serialNumber;
	}
	
	
	public static void main(String[] args) {
		Car a = new Car("bmw", "Z3", 1990, "AXA");
		Car b = new Car("bmw", "D000", 1990, "Lol");
		Car c = new Car("Volvo", "240", 1988, "wad1");
		
		
		
	}
	
	public String getManufacturer(){
		return this.manufacturer;
	}
	
	public String getModelName(){
		return this.modelName;
	}
	
	public int getModelYear(){
		return this.modelYear;
	}
	
	public String getSerial(){
		return this.serialNumber;
	}
	
	public int compareTo(Car c) {
		
		if(this.modelYear != c.modelYear){
			return this.modelYear - c.modelYear;
		}
		else{
			
			if(this.manufacturer.compareTo(c.manufacturer) == 0){
				return this.modelName.compareTo(c.modelName);
			}
			
			return this.manufacturer.compareTo(c.manufacturer);
			
		}
		
	}
	
	public boolean equals(Object o) {
		// Your code here.
		throw new UnsupportedOperationException("equals missing! Help!");
	}
}
