package examples17.gonki;

public class Auto {
	static final int HORSE_TO_WATT = 735;
	
	double massaKg;
	double powerVt;
	double maxSpeedMS;
	double currentSpeed = 0;
	String driverName;
	double distanceM;
	
	public Auto(int massaKg, int powerHorse, double maxSpeed, String driverName){
		this.massaKg = massaKg;
		powerVt = powerHorse * HORSE_TO_WATT;
		this.maxSpeedMS = maxSpeed;
		this.driverName = driverName;
		distanceM = 0;
	}
	
	void updateStatusPerSecond(int powerUsePercent){
		distanceM = distanceM + currentSpeed * 1;
		double currentPower = powerVt * (powerUsePercent/100.0); 
		currentSpeed = currentSpeed + 
				currentPower / (massaKg * (distanceM - currentSpeed)) ;
		/*if (currentSpeed > maxSpeedMS) {
			currentSpeed = maxSpeedMS;
		}*/
		currentSpeed = (currentSpeed > maxSpeedMS) ? maxSpeedMS : currentSpeed;
	}

	
}
