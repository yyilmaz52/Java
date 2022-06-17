public class SpeedConverter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		System.out.println(toMilesPerHour(-5.6));
		printConversion(0.0);
	}
	
	public static long toMilesPerHour (double kilometersPerHour) {
		
		
		if(kilometersPerHour > 0 ) {
			double milesPerHour = kilometersPerHour/1.609 ;
			long rounded = Math.round(milesPerHour);
			return rounded;
		}else
			return -1;
	}
	public static void printConversion (double kilometersPerHour) {
		long milesPerHour = Math.round(kilometersPerHour/1.609);
		if(kilometersPerHour < 0) {
			System.out.println("Invalid Value");
		}else
		System.out.println(kilometersPerHour + " km/h = " + milesPerHour + " mi/h" );
	}
}
