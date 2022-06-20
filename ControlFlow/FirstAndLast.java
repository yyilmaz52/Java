package ControlFlow;

public class FirstAndLast {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(sumFirstAndLastDigit(252));
	}

	public static int sumFirstAndLastDigit(int number) {
		
		int lastDigit=number%10;
		int FirstDigit = 0;
		while((number != 0 || number / 10 == 0 ) && number > 0){
			
			FirstDigit = number;
			number /= 10;
			if (number != 0) {
				FirstDigit = number;
			}else if(number == 0 ) {
				break;
			}
		}
		if (number <0 ) {
			return -1;
		}else
			return lastDigit + FirstDigit ;
	}
}
