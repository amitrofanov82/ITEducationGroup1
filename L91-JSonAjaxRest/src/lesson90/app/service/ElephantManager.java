package lesson90.app.service;

import lesson90.app.model.Elephant;

public class ElephantManager {

	private Elephant singleElephant;
	
	public ElephantManager() {
		singleElephant = new Elephant();
	}
	
	public Elephant findBestElephant(){
		return singleElephant;
	}
	
	public void updateElephant(Elephant elephant) {
		singleElephant = elephant;
	}
	
	public void updateElephantsWeightWithName(Elephant elephant) {
		if (singleElephant.getName().equals(elephant.getName())) {
			singleElephant.setWeightKg(elephant.getWeightKg());
		}
	}

	public void deleteElephantWithName(Elephant elephant) {
		// not implemented
	}
	
}
