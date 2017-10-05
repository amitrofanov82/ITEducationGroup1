 package examples39.files;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class FilesEx {
	public static void main(String[] args) {
		File f = new File ("d:/Mitrofanov/primer.txt");
		OutputStream out = null;
		try {
			out = new FileOutputStream(f, true);
			for (int i = 0; i<26; i++){
				out.write(65+i);
			}
			//out.close();
		} catch (FileNotFoundException e) {
			/*try {
				out.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}*/
		} catch (IOException e) {
			/*try {
				out.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}*/
		} finally {
			closeQuetly(out);
		}
		

	}

	private static void closeQuetly(OutputStream out) {
		if (out != null) {
			try {
				out.close();
			} catch (IOException e1) {
				//System.err.println("Молчу");
			}
			System.out.println();
			System.out.println(Math.PI);
		}
	}
}




























