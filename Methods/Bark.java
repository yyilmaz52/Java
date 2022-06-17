
public class Bark {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(shouldWakeUp (true,23));
	}

	public static boolean shouldWakeUp(boolean barking, int hourOfDay) {
		if ( barking && (hourOfDay < 8 || hourOfDay > 22)&& hourOfDay != -1 && hourOfDay <= 23) { 
			return true ;
		}else if(hourOfDay < 0 || hourOfDay > 23) {
			return false;	
		}else
		return false;
}

}