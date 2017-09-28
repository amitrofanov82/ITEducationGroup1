package examples37.exception;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionExamples {
	
	public static void main(String[] args) throws Exception{
		try {
			zagadka();
		} catch (StackOverflowError e) {
			System.out.println("Bye-Bye");
			zagadka();
		}

		/*try {
			throw new Exception("U nas prednamerennoe iskl.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			System.out.println(e.getStackTrace());
			e.printStackTrace(System.out);
			try {
				throw new Exception("Iskl. pri obrabotke isklucheniya", e);
			} catch (Exception e2) {
				System.out.println("=================================");
				System.out.println(e2.getMessage());
				System.out.println(e2.getCause());
				System.out.println(e2.getStackTrace());
				e2.printStackTrace(System.out);
			} finally {
				System.out.println("V lyubom sluchae vypolintsya");
			}
			
			
			try {
				noFile();
			} catch (FileNotFoundException e1) {
				System.out.println("Fajla net, rabotat nevozmozhno");
				//new NotepadInternalException(
						//"obratites w podderzhku... i rasskazhite im ob etoj prichine", e1);
				new NotepadInternalException(e1.getMessage(), e1);
			}
		}*/
		

		
	}
	
	public static void noFile() throws FileNotFoundException{
			throw new FileNotFoundException("Net fajla");
	}
	
	
	
	
	
	
	
	
	public static void zagadka() throws Exception{
		
		try{
			if (true)  {
				throw new FileNotFoundException("in try");
			} else {
				throw new NotepadInternalException("in try");
			}
		} catch (IOException e1) {
			System.out.println(e1.getMessage());
			throw new Exception("in e1 catch");
		} catch (NotepadInternalException e2) {
			System.out.println(e2.getMessage());
			throw new Exception("in e1 catch");
		} catch (Exception e3) {
			System.out.println(e3.getMessage());
			throw new Exception("in e1 catch");
		} finally {
			//throw new RuntimeException("in finally");
			zagadka();
		}
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
