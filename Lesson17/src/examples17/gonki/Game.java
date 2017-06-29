package examples17.gonki;

public class Game {
	
	public static void main(String[] args) {
		Auto auto1 = new Auto(1000, 250, 220/3.6, "Player1");
		Auto auto2 = new Auto(1500, 350, 240 /3.6, "Player2");
		
		while (auto1.distanceM < 10000 || auto2.distanceM < 10000) {
			auto1.updateStatusPerSecond((int) (Math.random()*121) - 20);
			auto2.updateStatusPerSecond((int) (Math.random()*121) - 20);
			System.out.println(auto1.distanceM + " " +auto2.distanceM  );
		}
		
	}
	
}
