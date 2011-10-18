public class User {
	
	private String name;
	private int age;
	
	public User(String name, int age){
		this.name = name;
		this.age = age;
	}
	
	public String name(){
		return this.name;
	}
	public int age(){
		return this.age;
	}
	public void name(String name){
		this.name = name;
	}
	public void age(int age){
		this.age = age;
	}
	
}