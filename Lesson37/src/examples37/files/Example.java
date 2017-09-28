package examples37.files;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Example {
	
	public static void main(String[] args) throws IOException {
		File f = new File ("d:/Mitrofanov/primer.exe");
		OutputStream out = new FileOutputStream(f, true);
		out.write(65);
	}

}
