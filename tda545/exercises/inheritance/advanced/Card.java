public abstract class Card {
	private String recipient;
	
	public abstract void greeting();
	
	
	public void setRecipient(String s){
		recipient = s;
	}
	
	public String getRecipient(){
		return recipient;
	}
}