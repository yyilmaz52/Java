
public class EqualityPrinter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		printEqual(1,3,2);
		
	}
	public static void printEqual(int num1,int num2,int num3) {
		if(num1 < 0 || num2 < 0 || num3 < 0) {
			System.out.println("Invalid Value");
		}else if(num1 == num2 && num1 == num3){
			System.out.println("All numbers are equal");
		}else if(num1 != num2 && num1 != num3 && num2 != num3) {
			System.out.println("All numbers are different");
		}else
			System.out.println("Neither all are qual or different");
	}
}
