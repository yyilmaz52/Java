package ControlFlow;
//eklenebilir
public class sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int sum = 0;
		int num = 0;
		for(int i = 1 ; i<1000 ; i++) {
			
			if ( i%3 == 0 && i%5==0 ) {
				sum += i;
				num ++;
				System.out.println(num);
				
			}
			if(num == 5) {
				break;
			}
			
		}
		System.out.println(sum);
	}

}
