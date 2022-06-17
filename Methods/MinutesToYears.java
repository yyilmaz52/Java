
public class MinutesToYears {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
 
		printYearsAndDays (-561600);
	}

	public static void printYearsAndDays (long minutes) {
		if (minutes < 0 ) {
			System.out.println("Invalid Value");
		}else {
			long DAY = minutes / 1440 ;
			long remainingDay = DAY % 365;
			long year = DAY / 365 ;
			System.out.println(minutes + " min = " + year + " y " + "and " + remainingDay + " d" );
	}
	}	
}
