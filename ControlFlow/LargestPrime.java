package ControlFlow;

public class LargestPrime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(getLargestPrime(-1));
	}

	
	public static int getLargestPrime (int number){
		
		
		int divider = 2;
		int ret = 0;
		while (divider <= number) {
			int div = 1;
			int count = 0;
			if(number % divider == 0) {
				
				
				
				while (div <= divider) {
					
					
					if(divider % div == 0) {
						count ++;
						div++;
					}else {
						div++;
						
					}
						
				
					
				}
				
				if (count == 2) {
					System.out.println("Prime number is :" + divider);
					 ret = divider;
				}
				
			}
			
			divider++;
			
		}
		if(number <= 1 ) {
			return -1;
		}
		return ret;
	}
}
