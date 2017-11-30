package l53;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Draft {

	public static void main(String[] args) {
		InputStream in = null;
		try {
			in = new FileInputStream("Mars");
			//...
		} catch (IOException | NullPointerException e) {
			System.out.println("marsohod propal");
		} finally{
			if (in !=null){
				try {
					in.close();
				} catch (IOException e) {
					System.out.println("marsohod propal pri proschanii");
				}
			}
		}
		//=========
		try (InputStream in2 = new FileInputStream("Mars");
			 InputStream in3 = new FileInputStream("Venera")){
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
