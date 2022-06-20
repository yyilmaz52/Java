package ControlFlow;

public class LastDigitChecker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(hasSameLastDigit(9,32,42));
		System.out.println(isValid(10));
	}

	public static boolean hasSameLastDigit (int num1 ,int num2 ,int num3 ) {
		
		
		if(num1 >= 10 && num1 <= 1000 && num2>= 10 && num2 <= 1000 && num3 >= 10 && num3 <= 1000) {
			 // 12 23

			if (num1 % 10 == num2 %10 || num1 % 10 == num3 %10 || num2 % 10 == num3 %10 ) {
				return true;
			}else
				return false;
			
		}else
			return false;
		
		
	}
	
	public static boolean isValid (int number) {
		if ( 10 <= number && number <= 1000 ) {
			return true;
		}else
			return false;
	}
}
