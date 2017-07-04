package examples18.composition;

public class Auto {
	
	public Wheel[] wheelOnThisCar = {new Wheel(), null, null, null};
	public String description = "Great car";
	

	public Auto(String description, boolean putTiresOn){
		this.description = description;
		for (int i = 0; i < wheelOnThisCar.length; i++) {
			wheelOnThisCar[i] = new Wheel("Wheel" + (i+1) + "for car " 
							+ description, putTiresOn);
			
		}
		
	}
	
}
