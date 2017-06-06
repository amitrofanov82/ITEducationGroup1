
public class Loshadi {
	
	public static void main(String[] args) {
		int N = 5;
		int D = 1000;
		double[] speeds = { 20, 30, 10, 11,12};
		double[] positions = {200, 250, 310, 500,550};
		
		double maxTime = 0;
		
		for (int i = 0; i <= N-1; i++){
			if ((D-positions[i])/speeds[i] > maxTime){
				maxTime = (D-positions[i])/speeds[i];
			}
		}
		System.out.println("Скорость девушки должна быть " + D/maxTime);
		
		
	}
	
	

}
