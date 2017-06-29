package example17.program;

import examples17.utils.MyFavoriteUtils;

public class SomeProgram {

	public static void main(String[] args) {
		char[][] mass = MyFavoriteUtils
				.createRandomArray2d(new char[5][7]);
		
		char[][] mass2 = new char[4][5];
		MyFavoriteUtils
				.createRandomArray2d(mass2);
		
		MyFavoriteUtils.printChar(mass2);
	}
	
	

}
