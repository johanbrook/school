public class Holiday extends Card {
	
	public Holiday(String r){
		setRecipient(r);
	}
	
	public void greeting(){
		System.out.println("Happy holidays, " + getRecipient() + "!");
	}
	
	public static void main(String[] args) {
		Card h = new Holiday("Johan");
		
		h.greeting();
	}
}