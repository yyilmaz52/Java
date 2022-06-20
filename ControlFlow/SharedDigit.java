package ControlFlow;

public class SharedDigit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(hasSharedDigit(15,55));
	}

	public static boolean hasSharedDigit (int num1,int num2) {
		
		if(num1 >= 10 && num1 <= 99 && num2 >= 10 && num2 <= 99) {
			 // 12 23
			int compare = num2 ;
			while(num1 != 0){
				int lastDigit=num1%10;
				
				num2 = compare;
				while(num2 != 0) {
					int digit=num2%10;
					num2 /= 10;	
					if (lastDigit == digit) {
						return true;
					}
				}
			
				num1 /= 10;	
			}
			return false;
		}else
			return false;
		
	}
}
