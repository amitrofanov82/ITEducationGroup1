package l88;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.Priority;

public class MainLoggerTester {
	
	public static void main(String[] args) {
		Logger.getLogger("Vasya")
			.log(Level.INFO, "hello from Vasya Logger");
		Logger.getLogger("Vasya")
			.log(Level.DEBUG, "hello from Vasya Logger");
		Logger.getLogger("Vasya")
			.log(Level.ERROR, "hello from Vasya Logger");
		Logger.getLogger(MainLoggerTester.class)
			.log(Level.INFO, "hello from Class Logger");
	}
	
}
