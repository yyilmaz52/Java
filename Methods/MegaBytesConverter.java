
public class MegaBytesConverter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		printMegaBytesAndKiloBytes(5000);
	}
	
	public static void printMegaBytesAndKiloBytes (int kiloBytes) {
		int mb = kiloBytes / 1024 ;
		int remain = kiloBytes % 1024 ;
		if(kiloBytes < 0) {
			System.out.println("Invalid Value");
		}else
		System.out.println(kiloBytes + " KB = " + mb +" MB " + "and " + remain + " KB");
	//	
	}
}
