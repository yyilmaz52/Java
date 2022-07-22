import java.util.Scanner;
						//BASIC BATTLESHIPS
public class SimpleStartupTestDrive {
				
		
				static int guessCount = 0;
			
				public static void main(String[] args) {
				
				SimpleStartup dot = new SimpleStartup();
				String[][] locations = new String[7][7];
				dot.setLocationCells(locations);
				
				boolean isAlive = true;
				String userGuess;
				
				Scanner scan = new Scanner(System.in);
				while(isAlive) {
					
					System.out.println("Enter your guess(Example(A-7 , B-3 or type Show to see the board ): ");
					userGuess = scan.nextLine();
					 
						if(userGuess.equalsIgnoreCase("Show")) {
							dot.ShowBoard();
							continue;
						}
					
					
					String[] input = new String[2];
					input = userGuess.split("-");
					String result = dot.checkYourself(input);
					if (result.equalsIgnoreCase("You hit the mark" ) ) {
						
						System.out.println("You hit the mark");
						
					}else if (result.equalsIgnoreCase("killed")) {
						
						System.out.println("killed");
						guessCount++;
						System.out.println("You gussed " + guessCount + " times.");
						break;
						
					}else if(result.equalsIgnoreCase("wrong input")) {
						System.out.println("wrong input");
					}else {
						System.out.println(result);
						
					}
					guessCount++;
				}
			}
		}