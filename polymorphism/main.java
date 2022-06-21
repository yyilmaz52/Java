class Car {
	
	
	private boolean engine;
	private int cylinders;
	private String name;
	private int wheels;
	
	public Car (int cylinders , String name) {
		
		this.engine = true;
		this.wheels = 4;
		this.cylinders=cylinders;
		this.name = name;
		
	}
	
	public String startEngine() {
		return "Car -> startEngine()";
	}
	public String accelerate() {
		return "Car -> accelerate()";
	}
	public String brake() {
		return "Car -> brake()";
	}

	public int getCylinders() {
		return cylinders;
	}
	public String getName() {
		return name;
	}
}


class Mitsubishi extends Car{
	
	public Mitsubishi(int cylinders , String name) {
		super(cylinders,name);
	}
	
	public String startEngine() {
		return  "Mitsubishi -> start engine()";
	}
	public String accelerate() {
		return "Mitsubishi -> accelerate()";
	}
	public String brake() {
		return "Mitsubishi -> brake()";
	}
}

class Ford extends Car{
	
	public Ford (int cylinders , String name) {
		super(cylinders,name);
	}
	
	public String startEngine() {
		return  "Ford -> start engine()";
	}
	public String accelerate() {
		return "Ford -> accelerate()";
	}
	public String brake() {
		return "Ford -> brake()";
	}
}
class Holden extends Car{
	
	public Holden(int cylinders , String name) {
		super(cylinders,name);
	}
	
	public String startEngine() {
		return  "Holden -> start engine()";
	}
	public String accelerate() {
		return "Holden -> accelerate()";
	}
	public String brake() {
		return "Holden -> brake()";
	}
}

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Car car = new Car(8, "Base car");
		System.out.println(car.startEngine());
		System.out.println(car.accelerate());
		System.out.println(car.brake());
		
		Mitsubishi mit = new Mitsubishi(6,"Outlander VRX 4WD");
		System.out.println(mit.startEngine());
		System.out.println(mit.accelerate());
		System.out.println(mit.brake());
		
		Ford ford = new Ford(6, "Ford Falcon");
		System.out.println(ford.startEngine());
		System.out.println(ford.accelerate());
		System.out.println(ford.brake());
		
		Holden hold = new Holden (4,"Holden Commodore");
		System.out.println(hold.startEngine());
		System.out.println(hold.accelerate());
		System.out.println(hold.brake());
	}

}


 