package ControlFlow;

public class DiagonalStar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		printSquareStar(2);
	}

	public static void printSquareStar(int number) {
		
		if(number < 5 ) {
			System.out.println("Invalid Value");
		}else {
			for(int i = 0 ; i<number ; i++) {
				
				
				for(int j = 0; j<number ; j++) {
					
					if(j ==0 || i == 0) {
						System.out.print("*");
					}else if( j == number-1 || i == number-1) {
						
						System.out.print("*");
					}else if(j == i) {
						
						System.out.print("*");
					}else if(number == (i+j+1)) {
						System.out.print("*");
					}
					
					else
						System.out.print(" ");
				
				}
				System.out.println();
				
			}
		}
		
	}
	
}
