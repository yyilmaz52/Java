
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/* Calculator 
		SimpleCalculator cal = new SimpleCalculator();
		cal.setFirstNumber(5.0);				
		cal.setSecondNumber(4);
		System.out.println("add=" + cal.getAdditionResult());*/
		
		
	/*	Person person = new Person();
		person.setFirstName("");
		person.setLastName("");
		
		person.setAge(10);
		System.out.println("fullname=" + person.getFullName());
		System.out.println("teen= " + person.isTeen());
		person.setFirstName("John");
		person.setAge(18);
		System.out.println("fullName= " + person.getFullName());
		System.out.println("teen= " + person.isTeen());
		person.setLastName("Smith");
		System.out.println("fullName= " + person.getFullName());*/
		
		
		/*Wall wall = new Wall(-1.25,-1.25);
		System.out.println("area= " + wall.getArea());
		wall.setHeight(-1.5);
		System.out.println("width= " + wall.getWidth());
		System.out.println("height= " + wall.getHeight());
		System.out.println("area= " + wall.getArea());*/
		
		/*Carpet carpet = new Carpet(3.5);
		Floor floor = new Floor (2.75,4.0);
		System.out.println(floor.getArea());
		Calculator calculator = new Calculator (floor,carpet);
		System.out.println("total= " + calculator.getTotalCost());
		carpet = new Carpet(1.5);
		floor = new Floor(5.4,4.5);
		calculator = new Calculator(floor , carpet);
		System.out.println("total= " + calculator.getTotalCost());*/
		
		ComplexNumber one = new ComplexNumber (1.0, 1.0);
		ComplexNumber number = new ComplexNumber(2.5,-1.5);
		one.add(1,1);
		System.out.println("one.real= " + one.getReal());
		System.out.println("one.imaginary= " + one.getImaginary());
		one.substract(number);
		System.out.println("one.real= " + one.getReal());
		System.out.println("one.imaginary= " + one.getImaginary());
		number.substract(one);
		System.out.println("number.real= " + number.getReal());
		System.out.println("number.imaginary= " + number.getImaginary());
	}

}
