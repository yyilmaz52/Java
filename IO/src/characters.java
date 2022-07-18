import java.io.Serializable;

public class characters implements Serializable {

	private int power;
	private	String type;
	private	String[] weapons;
	characters(int power, String type, String[] weapons){
		this.power= power;
		this.type = type;
		this.weapons = weapons;
	}
	public int getPower() {
		return power;
	}
	
	public String getType() {
		return type;
	}
	
	public String getWeapons() {
		return weapons.toString();
	}
	
	
	
}
