package examples25.singleton;

public class Singleton {

	private static Singleton instance = null;
	//private static int counter;

	private int value;

	private Singleton() {
		value = (int) Math.random() * 10;
		//counter++
		
	}
	
	public static Singleton getInstance(){
		if (instance == null) {
			instance = new Singleton();
		}
		return instance;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

}
