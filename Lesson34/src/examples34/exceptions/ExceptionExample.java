package examples34.exceptions;

public class ExceptionExample {
	private static final int DEFAULT_VALUE = 120;

	public static void main(String[] args) {
		int[] massivExample = new int[10];
		int[] massivExample2 = null;
		int element;
		try {
			element = get(massivExample, 4);
			element = get(massivExample2, 4);
		} catch (Exception e) {
			System.out.println("Some exception happened");
			System.out.println("Exception is: " + e.getClass());
			element = DEFAULT_VALUE; 
		}
		System.out.println(element);
	}
	
	public static int get(int[] massiv, int index) throws Exception{
		try {
			return massiv[index];
		} catch (ArrayIndexOutOfBoundsException e) {
			//System.out.println("Вы не правы, сударь. Держите поседний элемент.");
			throw new Exception("Вы не правы, сударь. Держите поседний элемент.");
			//return massiv[massiv.length-1];
		}
	}
}

















