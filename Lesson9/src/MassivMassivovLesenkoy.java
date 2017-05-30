
public class MassivMassivovLesenkoy {
	//создать массив массивов вот такой:
	//[0, 1, 2, 3]
	//[6, 8, 9]
	
	public static void main(String[] args) {
		int[] pervyjMassiv = {0, 1, 2, 3};
		int[][] massiv;
		massiv = new int[2][];
		massiv[0] = pervyjMassiv;
		massiv[1] = new int[3];
		massiv[1][0] = 6;
		massiv[1][1] = 8;
		massiv[1][2] = 9;
	}
	

	
}
