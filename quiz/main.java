package quiz;
//BASİC WRITING AND READING EXAMPLE
import java.io.*;
import java.util.*;
public class main {
		static Scanner scan = new Scanner(System.in);
		static ArrayList<String> questions = new ArrayList<String>();
		static ArrayList<String> answers = new ArrayList<String>();
		static int i = 0;
	public static void main(String[] args) {
		
		
		
		System.out.println("Type Start to start the game...");
		QuizCard card1 = new QuizCard("Garen kac rp ?", ",1350");
		QuizCard card2 = new QuizCard("Annie kac rp ?", ",6300");
		QuizCard card3 = new QuizCard("Kayle kac rp ?", ",450");
		
		QuizCard[] cards = {card1,card2,card3};
		
		
//			try (BufferedWriter writer = new BufferedWriter(new FileWriter("SoruVeCevap.txt"))){
//			
//			
//				for(QuizCard card : cards) {
//					writer.write(card.getQuestion() + card.getAnswer() + "\n");
//				}
//				
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
			
		
			try (BufferedReader fr = new BufferedReader(new FileReader("SoruVeCevap.txt"))) {
				String line;
				
				while((line = fr.readLine()) != null) {
					String[] qa = line.split(",");
					
					questions.add(qa[0]);
					answers.add(qa[1]);
				}
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			
		while(true) {
			String answer = scan.nextLine();
		if(answer.equalsIgnoreCase("start")) {
			while(true) {
			System.out.println("Which question u want to start --- Available(Q1-Q2-Q3)");
			answer = scan.nextLine();
					
			if(answer.equalsIgnoreCase("Q1")) {
				question(0);
			}else if(answer.equalsIgnoreCase("Q2")) {
				question(1);
			}else if(answer.equalsIgnoreCase("Q3")) {
				question(2);
			}else
				System.out.println("Wrong input");
			}		
		}else
			System.out.println("Wrong input");
	
		}
		
	}
	
	
	
//	public static void question (QuizCard card) {
//		
//		
//		
//		try (BufferedReader fr = new BufferedReader(new FileReader("SoruVeCevap.txt"))) {
//			
//			
//			System.out.println(fr.readLine() );
//			
//			
//			while(true) {
//				if(scan.nextLine().equalsIgnoreCase(card.getAnswer())) {
//					System.out.println("Bildin");
//					fr.reset();
//					break;
//				
//				}else
//					System.out.println("wrong answer, try again");
//				
//			}
//			
//			
//		} catch (IOException e) {
//			
//			e.printStackTrace();
//		}
//	}
	public static void question(int i) {
		
		
		
		String a;
		while((a = questions.get(i) ) != null ) {
			
			System.out.println(questions.get(i));
			System.out.println("SHOW ANSWER - ANSWER - previous - NEXT - EXIT");
			String answer = scan.nextLine();
			
			if(answer.equalsIgnoreCase("Answer")) {
				System.out.println("Your Answer");
				while(true) {
					answer = scan.nextLine();
					if(answer.equalsIgnoreCase(answers.get(i))) {
						System.out.println("Bildiniz");
						break;
					}else
						System.out.println("Wrong input");
				}
				
			}else if(answer.equalsIgnoreCase("Next")) {
				if(i == 2) {
					i--;
				}
					
					
			}else if(answer.equalsIgnoreCase("Show Answer")) {
				System.out.println(answers.get(i));
			}else if (answer.equalsIgnoreCase("Exit")) {
				System.exit(0);
			}else if(answer.equalsIgnoreCase("Previous")) {
				if(i != 0) {
					i--;
					continue;
				}else
					i--;
			}
			
			
			else {
				System.out.println("Wrong input");
				continue;
			}
			
			i++;
			if(i == 3) {
				System.out.println("--------------------");
				break;
			}
		}
		
	}
}
