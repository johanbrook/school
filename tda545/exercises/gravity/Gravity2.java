class Gravity2 {
	private final double GRAVITY = 9.81;
	
	private double dropHeight;
	private double timeResolution;
	private double time;
	
	public Gravity2(double dropHeight, double timeResolution){
		this.dropHeight = dropHeight;
		this.timeResolution = timeResolution;
		this.time = 0;
	}
	
	public void tick(){
		time = time + timeResolution;
	}
	
	public String toString(){
		return "Time: " + getTime() + "\tHeight: " + getHeight() + "m\tVelocity: " + getVelocity() + "m/s";
	}
	
	public double getHeight(){
		double h = dropHeight - (4.9 * (time * time) );

		if(h <= 0)
			return 0.0;
		else
			return  h;
	}
	
	public double getTime(){
		return time;
	}
	
	public double getVelocity(){
		return GRAVITY * time;
	}
	
	public static void main(String[] args) {
		
		Gravity2 g = new Gravity2(180.0, 1.0);
		
		while(g.getHeight() > 0){
			g.tick();
			System.out.println(g);
		}
	}
}