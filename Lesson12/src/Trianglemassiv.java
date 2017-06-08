public class Trianglemassiv {


	
	public static void main(String[] args) {
			int[][] a = new int[6][];
			for (int i = 0; i < a.length; i++) {
				a[i] = new int[i+1];
				/*for(int j=0;j<=i;j++){
					a[i][j] = 3;//(int) (Math.random() * 100);
				}*/
			
			}
			printmassiv(a);
		}

		
		private static void printmassiv(int[][] massiv) {
			int count = 0;
			for (int k = 0; k <massiv.length; k++) {
				for(int n=0;n<=k;n++){
				count++;
				System.out.printf(massiv[k][n] + " | ");
			}
				System.out.println();
				if (count % 30 == 0) {
					System.out.println();
				}
			}
			System.out.println();
		}

}
