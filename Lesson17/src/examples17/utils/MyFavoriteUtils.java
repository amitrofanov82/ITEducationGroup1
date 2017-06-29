package examples17.utils;

public class MyFavoriteUtils {
	
	/**
	 * @param massiv array of chars to be filled with random A-Z
	 */
	public static char[][] createRandomArray2d(char[][] massiv) {
		for(int i = 0; i < massiv.length; i++) {
			for(int j = 0; j < massiv[0].length; j++) {
				massiv[i][j] = (char) (Math.random() * 32 + 65) ;
			}
		}
		return massiv;
	}
	
	/**
	 * @param massiv array of ints to be filled with random 0-99
	 */
	public static int[][] createRandomArray2d(int[][] massiv) {
		for(int i = 0; i < massiv.length; i++) {
			for(int j = 0; j < massiv[0].length; j++) {
				massiv[i][j] = (int) (Math.random() * 100) ;
			}
		}
		return massiv;
	}
	
	//Метод выводит таблицу char -ов на экран
	public static void printChar(char[][] massiv) {
		for(int i = 0; i < massiv.length; i++) {
			for(int j = 0; j < massiv[0].length; j++) {
				System.out.print("| " + massiv[i][j] + " |");
			}
			System.out.println();
		}
		System.out.println();
	}
	
}
