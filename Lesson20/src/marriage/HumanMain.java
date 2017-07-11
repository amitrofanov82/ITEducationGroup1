package marriage;

public class HumanMain {
	
	public static void main(String[] args) {
		Human[] people = new Human[4];
		for (int i = 0; i< people.length; i++){
			people[i] = new Human();
		}
		for (int i = 0; i< people.length; i++){
			people[i].print();
		}
		for (int i = 0; i< people.length; i++){
			int randomRelation = (int)(Math.random()*people.length);
			if (people[i].getSex() == people[randomRelation].getSex()) {
				i--;
				continue;
			}
			people[i].setWhoHeLikes(people[randomRelation]);
		}
		System.out.println("-------------------------------");
		for (int i = 0; i< people.length; i++){
			people[i].print();
		}
		
		
	}

}
