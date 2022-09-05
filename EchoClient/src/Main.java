
import java.io.*;

import java.net.*;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		try(Socket socket = new Socket("localhost",5000)){
			
			socket.setSoTimeout(5000);
			
			BufferedReader echoes = new BufferedReader(
					new InputStreamReader(socket.getInputStream()));
			PrintWriter stringToEcho = new PrintWriter(socket.getOutputStream(),true);
			
			Scanner scan = new Scanner(System.in);
			String echoString;
			String response;
			
			do {
				System.out.println("Enter string to be echoed");
				echoString = scan.nextLine();
				
				stringToEcho.println(echoString);
				if(!echoString.equals("Exit")) {
					response = echoes.readLine();
					System.out.println(response);
				}
			} while(!echoString.equals("exit"));
			
		}catch(SocketTimeoutException e) {	
			
			System.out.println("the socket timed out");
		
		}catch(IOException e) {
		
			System.out.println("Client error: " + e.getMessage());
		
		}

	}

}
