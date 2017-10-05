package examples37.files;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Example {
	
	public static void main(String[] args) throws IOException {
		File f = new File ("d:/Mitrofanov/primer.txt");
		OutputStream out = new FileOutputStream(f, true);
		for (int i = 0; i<26; i++){
			out.write(65+i);
		}

		//out.close();
		
		
	}

}
