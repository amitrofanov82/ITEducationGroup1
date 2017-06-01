
public class Perestanovka {

	public static void main(String[] args) {
		int i = 0;
		int[] a = {1,2,3};
		swap(i,2,a);
		//System.out.println(a);
		print(a);
		System.out.println(i);
		
	}
	
    private static void swap(int i, int j, int[] array) {
		//int change = array[i];
		//array[i] = array[j];
		//array[j] = change;
    	
    	array[i] = array[i] + array[j];
    	array[j] = array[i] - array[j];
    	array[i] = array[i] - array[j];
    	

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
