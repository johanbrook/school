public class Polymorphism {
	public static void main(String[] args) {
		Parent p = new Parent();
		Parent pc = new Child();
		
		Child c = new Child();
		
		mehod(p);
		mehod(pc);
		mehod(c);
	
		
	}
	
	public static void mehod(Parent obj){
		System.out.println(obj.hello());
	}
	
	
	private static class Parent {
		
		public String hello(){
			return "I'm in parent!";
		}
	}
	
	private static class Child extends Parent {
		
		public String hello(){
			return "I'm in child!";
		}
	}
}