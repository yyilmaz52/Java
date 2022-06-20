package ControlFlow;

public class NumberPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(isPalindrome(11212));
		
	}

	public static boolean isPalindrome (int number) {
		int reverse = 0;
		int compare = number;
		while(number != 0){
		int lastDigit=number%10;
		reverse *= 10;
		reverse += lastDigit;
		number /= 10;
		System.out.println(reverse);
	}
		
		if(reverse == compare) {
			return true;
		}else 
			return false;
			
}
}