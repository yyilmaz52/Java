package ControlFlow;

public class PerfectNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPerfectNumber(-1));
	}

	
	public static boolean isPerfectNumber (int number) {
		
		
		if(number < 1) {
			return false;
		}else {
			int sum = 0 ;
			int divider = 1 ;
			while(divider <= number) {
				
				if(number % divider == 0 && divider != number) {
					sum += divider;
					
				}
				divider ++;
			}
			if(sum == number) {
				return true;
			}else
				return false;
			
		}		
	}	
}
