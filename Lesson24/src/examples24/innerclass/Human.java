package examples24.innerclass;

public class Human {
	private char sex;
	public String name;
	protected Human whoHeLikes;
	private static int someStaticInt = 4;
	
	public static class Soul {
		void anyMethod(){
			System.out.println(someStaticInt);
		}
	}
	
	private static class Body {
		
	}
	
	protected class Head {
		Head(){
			System.out.println(sex);
		}
	}
	
	
	
}
