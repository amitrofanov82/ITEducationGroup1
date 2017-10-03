package lesson38.examples.files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Example {
	
	public static void main(String[] args)throws Exception {
		//File f = new File ("u:/Mitrofanov/ТЕСТ.txt");
		//InputStream in = new FileInputStream(f);
		URL tutBy = new URL("https://tut.by");
		InputStream in = tutBy.openConnection().getInputStream();
		
		
		byte[] tekstBuffer = new byte[1000000]; 
		int i=0;
		//while (in.available()>0) {
		//for (int i =0; i<(int) f.length(); i++){
		while (true){
			int readByte = in.read();
			tekstBuffer[i] = (byte) readByte;
			i++;
			if (readByte == -1){
				System.out.println("!!!!!!" + in.read());
				break;
			}
		}
		Map<String, Charset> encodingsMap = Charset.availableCharsets();
		Set<String> encodingNames = encodingsMap.keySet();
		Iterator it = encodingNames.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		
		
		String text = new String(tekstBuffer, Charset.forName("windows-1251"));
		System.out.println(text);
	}

}
