package examples33.zoopark;

import examples33.zoopark.domain.Slon;

public class Zoopark {
	
	private BeastSet<Slon> elephants = new SlonoSet();
	
	public void kupiSlona(Slon slon){
		elephants.add(slon);
	}
	
	public void nakormiSlonov() {
		int size = elephants.getSize();
		for (int i = 0; i<size; i++){
			Slon slon = elephants.next();
			System.out.println(slon.getName() + " кушает");
		}
	}

}
