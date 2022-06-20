package ControlFlow;

public class GreatestCommonDivisor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getGreatestCommonDivisor(81,153));
	}

	public static int getGreatestCommonDivisor(int first , int second) {
		
		if (first <10 || second <10) {
			return -1;
		}else {
			int ret = 0;
			int divider = 1;
			boolean smt = true;
			while(smt) {
				
			if(first % divider == 0 && second % divider == 0) {
				 ret = divider ;
				divider++;
				continue;
			}
				if ((second > first && divider == second) || (second < first && divider == first) ) {
					smt = false;
				}
				divider++;
			}
			return ret  ;
			
		}
			
	}
}
