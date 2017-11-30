package l53;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serialization {
	
	public static void main(String[] args) throws Exception {
		FileOutputStream fileOut = new FileOutputStream("objFile");
		ObjectOutputStream serialOut = new ObjectOutputStream(fileOut);
		
		FileInputStream fileIn = new FileInputStream("objFile");
		ObjectInputStream serialIn = new ObjectInputStream(fileIn);
		
		Product p = new Product();
		serialOut.writeObject(p);
		Object o = serialIn.readObject();
		Product p2 = null;
		if (o instanceof Product){
			System.out.println("Product has been read");
			p2 = (Product) o;
		}
		System.out.println(p2); 
		
	}
	
	
	
}
