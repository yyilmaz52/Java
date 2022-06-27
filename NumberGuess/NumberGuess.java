import java.util.Scanner;
import javax.swing.*;

public class NumberGuess {

	
		public static Scanner scan = new Scanner(System.in);
 	
	public static void main (String[] args) {
		
		
		int number = (int)(Math.random()  * 100) + 1 ;
		
		System.out.println(number);
		boolean tr  = true;
		
		while(tr) {
			
			 String value = JOptionPane.showInputDialog("Enter Your Guess");
		     int i = Integer.parseInt(value);
			
			
			if(i > number) {
			JOptionPane.showMessageDialog(null, "Your Guess is higher than the number" );
				
			}else if(i < number) {
			JOptionPane.showMessageDialog(null, "Your Guess is lower than the number" );	
				
			}else {
			JOptionPane.showMessageDialog(null, "You Guessed it right" );	
				tr = false;
		}
			
		}
		
	}
	
	
}
