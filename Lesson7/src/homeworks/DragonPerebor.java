package homeworks;

public class DragonPerebor {

    public static void main(String[] args) {
	int sum = 100;

	if (sum < 3) {
	    System.out.println("Max for three dragons: " + sum);
	    System.exit(0);
	}

	int dr1, dr2, dr3, comp, max = 1;
	dr2 = dr3 = 1;
	dr1 = sum - 2;

	for (; dr1 > 0; dr1--) {
	    dr2 = sum - 1 - dr1;
	    for (; dr2 > 0; dr2--) {
			dr3 = sum - dr1 - dr2;
			comp = dr1 * dr2 * dr3;
		if (comp > max) {
		    max = comp;
		}
	    }
	}
	System.out.println("Max for three dragons: " + max);
    }
}
