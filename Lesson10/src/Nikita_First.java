public class Nikita_First {
	public static void main(String[] args) {
		int mass1[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int mass2[] = new int[mass1.length];
		
		for(int i = 0; i < mass1.length; i++)
			mass2[mass1.length-1 - i] = mass1[i];
		
		for(int n = 0; n < mass1.length; n++)
			System.out.println(mass2[n]);
	}
}
