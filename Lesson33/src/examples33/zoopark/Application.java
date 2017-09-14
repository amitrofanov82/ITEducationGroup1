package examples33.zoopark;

import examples33.zoopark.domain.Slon;

public class Application {

	public static void main(String[] args) {
		Zoopark zoo = new Zoopark();
		for (int i = 0; i<20; i++) {
			zoo.kupiSlona(new Slon("Слон" + i%10));
		}
		zoo.kupiSlona(new Slon("Слон Вася"));
		zoo.nakormiSlonov();
	}

}























