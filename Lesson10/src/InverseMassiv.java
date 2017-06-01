
public class InverseMassiv {
	public static void main(String[] args) {
		int[] c = { (int) (Math.random() * 1000000), (int) (Math.random() * 1000000), (int) (Math.random() * 1000000)};
				/*(int) (Math.random() * 1000000), (int) (Math.random() * 1000000), (int) (Math.random() * 1000000),
				(int) (Math.random() * 1000000), (int) (Math.random() * 1000000), (int) (Math.random() * 1000000),
				(int) (Math.random() * 1000000), (int) (Math.random() * 1000000), (int) (Math.random() * 1000000),
				(int) (Math.random() * 1000000), (int) (Math.random() * 1000000), (int) (Math.random() * 1000000),
				(int) (Math.random() * 1000000), (int) (Math.random() * 1000000), (int) (Math.random() * 1000000)};*/
		print(c);
		for (int i=0; i<c.length/2; i++){
			int mobil;
			mobil=c[i];
			c[i]= c[(c.length-1)-i];
			c[(c.length-1)-i]=mobil;
		}
		print(c);
	}
	private static void print(int[] array) {
		int counter = 0;
		for (int k = 0; k < array.length; k++) {
		    System.out.print(array[k] + "|");
		    counter++;
		    if (counter % 25 == 0) {
			System.out.println();
		    }
		}
		System.out.println();
	    }
}
