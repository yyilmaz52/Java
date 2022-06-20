package ControlFlow;

public class NumberToWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//numberToWords(1000);
		//System.out.println(getDigitCount(1010));
		System.out.println(reverse(123));
		//System.out.println(getDigitCount(5200));
		
	}

	public static void numberToWords(int number) {
		
		if(number < 0) {
			System.out.println("Invalid Number");
		}else {
			int rnumber = reverse(number);
			while(rnumber != 0){
				int lastDigit=rnumber%10;
				
				switch(lastDigit) {
				case 0:
					System.out.print("Zero" + " ");
					break;
				case 1:
					System.out.print("One" + " ");
					break;
				case 2:
					System.out.print("Two" + " ");
					break;
				case 3:
					System.out.print("Three" + " ");
					break;
				case 4:
					System.out.print("Four" + " ");
					break;
				case 5:
					System.out.print("Five" + " ");
					break;
				case 6:
					System.out.print("Six" + " ");
					break;
				case 7:
					System.out.print("Seven" + " ");
					break;
				case 8:
					System.out.print("Eight" + " ");
					break;
				case 9:
					System.out.print("Nine" + " ");
					break;
				}
				rnumber /= 10;
				
			}
			
			
		}
		
	}
	
	public static int reverse(int number) {
		//1010
		int reverse = 0;
		int compare = number;
		while(number != 0){
			
		int lastDigit=number%10;
		reverse *= 10;
		reverse += lastDigit;
		number /= 10;
		
		System.out.println(reverse);
		
	}
		if(compare % 10 == 0 ) {
			reverse *= 10;
		}
		
		number = compare;
		
		if(getDigitCount(number) == getDigitCount(reverse)) {
			
			return reverse;
		}else {
			reverse /= 10;
			System.out.println("smt");
			return reverse * (int)Math.pow(10, getDigitCount(number)-1);
			
		}
			
			
		
	}
	
	public static int getDigitCount (int number) {
		
		
		if(number <0) {
			return -1;
		}else if (number == 0){
			
			return  1;
			
		}
			else {
		}
			int digitcount = 0;
			while(number != 0){
				
				number /= 10;
				
				digitcount ++;
			}
			return digitcount--;
		}
		
	}
	

