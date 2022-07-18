import java.io.*;

public class IO {
	// SERIALIZATION EXAMPLE
	public static void main (String[] args) {
			
			
			

			try(FileOutputStream fileStream = new FileOutputStream("MyGame.ser");
					ObjectOutputStream os = new ObjectOutputStream(fileStream);) {
				

				
				characters c1 = new characters(50,"Elf",new String[] {"BOW","SWORD","DUST"});
				characters c2 = new characters(200,"Troll",new String[] {"BARE HANDS","BIG AX"});
				characters c3 = new characters(120,"Magician",new String[] {"SPELLS","INVISIBILITY"});
				os.writeObject(c1);
				os.writeObject(c2);
				os.writeObject(c2);
				os.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
			try(ObjectInputStream oi = new ObjectInputStream(new FileInputStream("MyGame.ser"))){
				
				characters c1i = (characters) oi.readObject();
				characters c2i = (characters) oi.readObject();
				characters c3i = (characters) oi.readObject();
				
				System.out.println("character one type is: " + c1i.getType());
				System.out.println("character two type is: " + c2i.getType());
				System.out.println("character three type is: " + c3i.getType());
				
			}catch(Exception e){
				e.printStackTrace();
			}
			
		
		
	}
	
	
}
