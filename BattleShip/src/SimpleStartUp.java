

		class SimpleStartup {
			private String[][] locationCells;
			private int numberOfHits = 0;
			int randomNumber = (int)(Math.random()*5);
			int number = randomNumber;
			int a = (int)(Math.random()*7);
			public void setLocationCells(String[][] locations) {
				locationCells = locations;
				
				char b = 'A';
				for(int i = 0; i < 7; i++) {		
					
					for(int j = 0; j < 7; j++) {		
						
						locationCells[i][j] = String.valueOf(b) + (j+1);
					}
					b++;
				}
				for(int i = 0; i < 3; i++) {		
				
					locationCells[a][randomNumber] = String.valueOf(randomNumber+1);
					randomNumber++;
				
				}
			}
			
			public String checkYourself(String[] guess) {
				
				int aNumber = number;
				String result = "miss";
					for(int j = 0; j < 3; j++) {		
						
					if(guess[1].equals(locationCells[a][aNumber]) && ((locationCells[a][0].contains(guess[0])) || locationCells[a][6].contains(guess[0]))) {	
							numberOfHits++;
							
							if(numberOfHits == 3) {
								return "Killed";
							}
							return "You hit the mark";
						}
					
					aNumber++;
					}	
				return result;
				
		}
			
			public void ShowBoard() {
				//PRINT OUT THE PLAY BOARD
				for(int i = 0; i < 7; i++) {		
					
					for(int j = 0; j < 7; j++) {		
						
						System.out.print(locationCells[i][j]+ " ");
					}
					System.out.println("\n");
				}
			}
		} // close class
		
		