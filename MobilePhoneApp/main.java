import java.util.Scanner;

public class main {

	private static Scanner scan = new Scanner(System.in);
	private static MobilePhone mobilePhone = new MobilePhone("0507 555 55 55");
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		boolean quit = false;
		startPhone();
		printActions();
		
		while(!quit) {
			
			System.out.println("\nEnter action: (6 to show available actions");
			int action = scan.nextInt();
			scan.nextLine();
			
			switch(action) {
			case 0 :
				System.out.println("\nShutting down...");
				quit = true;
				break;
			case 1 :
				mobilePhone.printContacts();
				break;
			case 2 :
				addNewContact();
				break;
			case 3 :
				updateContact();
				break;
			case 4 :
				removeContact();
				break;
			case 5 : 
				queryContact();
				break;
			case 6 :
				printActions();
				break;
			}
			
		}
		
		
	}
	
	public static void addNewContact() {
		
		System.out.println("Enter new contact name : ");
		String name = scan.nextLine();
		System.out.println("Enter phone number: ");
		String pnumber = scan.nextLine();
		Contacts contact = Contacts.createContacts(name, pnumber); 
		if(mobilePhone.addNewContact(contact)) {
			System.out.println("New contact added :" + name +  ", phone =" + pnumber);
		}else
			System.out.println("Cannot add, " + name + "already exist");
	}
	
	private static void updateContact() {
		System.out.println("Enter existing contact name: " );
		String name = scan.nextLine();
		
		Contacts existingContactRecord = mobilePhone.queryContact(name);
		if(existingContactRecord == null) {
			System.out.println("Contact not found.");
		}
		System.out.println("Enter new contact name: " );
		String newName = scan.nextLine();
		System.out.println("Enter new contact phone number: " );
		String pnumber = scan.nextLine();
		Contacts newContact = Contacts.createContacts(newName, pnumber);
		if(mobilePhone.updateContact(existingContactRecord, newContact)) {
			System.out.println("Succesfully updated record");
		}else
			System.out.println("Error updating record");
		
	}
	
	

	private static void removeContact() {
		System.out.println("Enter existing contact name: " );
		String name = scan.nextLine();
		
		Contacts existingContactRecord = mobilePhone.queryContact(name);
		if(existingContactRecord == null) {
			System.out.println("Contact not found.");
		}
		
		if(mobilePhone.removeContact(existingContactRecord)) {
			System.out.println("Succesfully deleted");
		}else {
			System.out.println("Error deleting contact");
		}
			
		
	
	}
	
	
	private static void queryContact() {
		System.out.println("Enter existing contact name: " );
		String name = scan.nextLine();
		
		Contacts existingContactRecord = mobilePhone.queryContact(name);
		if(existingContactRecord == null) {
			System.out.println("Contact not found.");
			return;
		}
		
		System.out.println("Name : " + existingContactRecord.getName()+ 
				"phone number is " + existingContactRecord.getphoneNumer());		
	
	}
	
	
	public static void startPhone() {
		System.out.println("Phone starting...");
	}
	
	
	
	private static void printActions() {
		System.out.println("\nAvailable actions:press");
		System.out.println(	"0 - to shutdown\n" +
						   	"1 - to print contacts\n" +
						   	"2 - to add a new contact\n" +
						   	"3 - to update an existing contact\n"+
						   	"4 - to remove an existing contact\n" +
						   	"5 - to query if an existing contact exists\n"+
						   	"6 - to print a list of available actions.");
		System.out.println("Choose your action : ");
	}

}
