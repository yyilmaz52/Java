package ControlFlow;

public class EvenDigitSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(getEvenDigitSum(0));
	}

	public static int getEvenDigitSum (int number) {
		if(number >= 0) {
			//122
			int sum = 0;
			while(number != 0){
			int lastDigit=number%10;
			number /= 10;
			
			if (lastDigit %2 == 0) {
				sum += lastDigit;
			}
		}
			return sum ;
			
		}else
			return -1;
	}
}
