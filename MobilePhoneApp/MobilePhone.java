import java.util.ArrayList;

public class MobilePhone {

	private String myNumber;
	private ArrayList<Contacts> cont ; 
	
	
	public MobilePhone(String myNumber) {
		
		this.myNumber = myNumber;
		cont = new ArrayList<Contacts>();
	}
	
	public boolean addNewContact (Contacts contact) {
		if (findContact (contact.getName()) >= 0) {
			System.out.println("Contact is already on file");
			return false;
		}else
			this.cont.add(contact);
			return true;
	}
	
	public boolean updateContact(Contacts oldContact, Contacts newContact) {
		int foundPosition = findContact(oldContact);
		if(foundPosition < 0) {
			System.out.println(oldContact.getName() + ", was not found");
			return false;
		}else if(findContact(newContact.getName()) != -1) {
			
			System.out.println("Contact with name " + newContact.getName() + "is already exists " +
			"update is not successful");
			return false;
		}
		
			 cont.set(foundPosition, newContact);
		System.out.println(oldContact.getName() + ", was replaced with " + newContact.getName());
		return true;
	}
	
	
	
	public void printContacts() {
		
		System.out.println("Contact List");
		for(int i = 0 ; i < cont.size();i++) {
			System.out.println((i+1) +"."+ cont.get(i).getName()+ "->"+
							cont.get(i).getphoneNumer());
			
		}
	}
	
	
	
	public boolean removeContact(Contacts contact) {
		if(findContact(contact) >= 0 ) {
			cont.remove(findContact(contact));
			System.out.println(contact.getName() + " was deleted");
			return true;
		}else
			System.out.println(contact.getName() + "was not found");
		return false;
	}
	
	
	
	private int findContact(Contacts contact) {
		return this.cont.indexOf(contact);
	}
	
	private int findContact(String contactName) {
		for (int i = 0; i < cont.size(); i++) {
			Contacts contact = cont.get(i);
			if(contact.getName().equals(contactName)) {
				return i;
			}
		}
		return -1;
	}
	
	public String queryContact(Contacts contact) {
		if(findContact(contact) >=0) {
			return contact .getName();
		}else
			return null;
	}
	

	
	
	public Contacts queryContact(String name) {
		int position = findContact(name);
		if(position >= 0) {
			return cont.get(position);
		}
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
