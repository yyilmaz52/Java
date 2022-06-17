
public class TeenNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		hasTeen(22,15,23);
		
	}

	public static boolean hasTeen (int number1,int number2,int number3) {
		if(number1 <= 19 && number1 >= 13 || number2 <= 19 && number2 >= 13 || number3 <= 19 && number3 >= 13 ) {
			System.out.println("teen");
			return true;
		}else
			return false;
	}
	public static boolean isTeen (int num) {
		if(num <= 19 && num >= 13) {
			
			return true;
		}else
			return false;
	}
}
