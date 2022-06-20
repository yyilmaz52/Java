package ControlFlow;

import java.util.Scanner;

public class InputCalculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		inputThenPrintSumAndAverage();
		
	}

	public static void inputThenPrintSumAndAverage () {
		
		Scanner scan = new Scanner (System.in);
		
		
		int sum = 0;
		int count = 0;
		long avg = 0 ;

	
		while(true){
			boolean smt = scan.hasNextInt();
		
		
				if(smt) {
					int number = scan.nextInt();
					count ++;
					sum += number;
					
				}else if(count == 0) {
					
					System.out.println("SUM = " + sum + " " + "AVG " + avg);
				}
				
				
				else {
					avg = sum / count;
					 
					System.out.println("SUM = " + sum + " " + "AVG " + avg);
					break;
				}
			
				scan.nextLine();
				
		}
		
		scan.close();
	}
	
		
}
