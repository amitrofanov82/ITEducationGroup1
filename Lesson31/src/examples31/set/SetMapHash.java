package examples31.set;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class SetMapHash {
	
	public static void main(String[] args) {
		Object o = new Object() {
			

			@Override
			public String toString() {
				try {
					this.finalize();
				} catch (Throwable e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return "result";
			}

			@Override
			protected void finalize() throws Throwable {
				System.out.println("bye");
			}
		}; 
		
		
		Map<String, String> m = System.getenv();
		Set<String> s = m.keySet();
		Iterator<String> i = s.iterator();
		//String key;
		while (i.hasNext()) {
			//System.out.println((key = i.next()) + " : " + m.get(key));
			
			String currentKey = i.next();
			String currentValue = m.get(currentKey);
			System.out.println(currentKey + " : " + currentValue);
			
		}
		
		
		
		
	}
	
	


	
}
