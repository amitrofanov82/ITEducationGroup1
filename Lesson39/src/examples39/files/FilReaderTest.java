package examples39.files;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.net.URL;

public class FilReaderTest {
	public static void main(String[] args) throws Exception {
		/*FileReader reader = 
				new FileReader("d:/Mitrofanov/Вопросы.txt");
		LineNumberReader lreader = 
				new LineNumberReader(reader);
		lreader.setLineNumber(3);
		while (Math.random()<0.95){
			String result = lreader.readLine();
			System.out.println(result);
		}*/
		
		URL tutBy = new URL("https://tut.by");
		InputStream in = tutBy.openConnection().getInputStream();
		BufferedReader br = 
			new BufferedReader(new InputStreamReader(in));
		while (Math.random()<0.95){
			System.out.println(br.readLine());
		}
		

		
	}
}
