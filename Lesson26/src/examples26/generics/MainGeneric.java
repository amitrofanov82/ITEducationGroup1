package examples26.generics;

import java.util.Collection;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class MainGeneric{
	
	public static void main(String[] args) {
		Integer a = 2;
		Integer b = 2;
		Integer s = min(a,b);
		
		Collection c;// = new Collection();
		Set set;
		List list;
		Queue que;
		
		
		
	}

	static <T extends Number> T min(T a, T b) {
		return a;
	}
	
	

}
