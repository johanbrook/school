class Gravity {
	private double dropHeight;
	private double time;
	private double counter;
	
	private final double GRAVITY = 9.81;
	
	public Gravity(double dropHeight, double time){
		this.counter = 0;
		this.dropHeight = dropHeight;
		this.time = time;
	}	
		
		public void tick(){
			this.counter = this.counter + this.time;
		}
		
		public String toString(){
			return "Time: " + getTime() + "s\tHeight: " + getHeight() + "m\tVelocity: " + getVelocity() + " m/s";
		}
		
		public double getTime(){
			return this.counter;
		}
		
		public double getHeight(){
			return dropHeight - (4.9 * counter*counter);
		}
		
		public double getVelocity(){
			return GRAVITY * counter;
		}
		
	public static void main(String[] args) {
		double m = 180.0;
		
		Gravity p = new Gravity(m, 1.0);
		
		while(p.getHeight() >= 0){
			System.out.println(p);
			p.tick();
		}
	}
}