package ControlFlow;
//eklenebilir
public class sumodd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(sumOdd(100,1000));
	}

	
	public static boolean isOdd (int number) {
		
		if(number > 0 && number%2 != 0) {
			return true;
		}else if(number > 0 && number%2 == 0 ) {
			return false;
		}else {
		
			return false;
		}
	}
	public static int sumOdd (int start , int end) {
		int sum = 0;
		if (end >= start && end > 0 && start>0) {
			for(int i = start ; i <=end ; i++) {
				if(isOdd(i)) {
					sum += i;	
				}
			}
			return sum;
		}else
			return -1;
		
	}
}
