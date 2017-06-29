package examples17;

public class BinatySearchV2 {
	
	public static void main(String[] args) {
		int[] A = {0, 2, 5, 34, 465, 568, 761, 998, 999};
		int L=0, R = A.length-1;
		int x = 761;
		int whereIsX = -1;
		while (L<R) {
			int i = (L+R)/2;
			if (A[i] == x) {
				whereIsX =i;
				break;
			}
			if (A[i] < x) {
				L = i;
			} else {
				R=i;
			}
		}
		System.out.println(whereIsX);
	}
	
}
