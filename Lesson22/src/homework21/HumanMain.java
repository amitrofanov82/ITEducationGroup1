package homework21;

public class HumanMain {
    public static void main(String[] args) {
	Human[] people = new Human[10];
	boolean diffrentSex = false;
	for (int i = 0; i < people.length; i++) {
	    people[i] = new Human();
	    if (i != 0 && people[i].getSex() != people[i - 1].getSex()) {
		diffrentSex = true;
	    }

	    if (i == people.length - 1 && !diffrentSex) {
		i--;
	    }
	}
	print(people);

	for (int i = 0; i < people.length; i++) {
	    int random = (int) (Math.random() * people.length);
	    if (people[i].getSex() == people[random].getSex()) {
		i--;
		continue;
	    }
	    people[i].setWhoHeLikes(people[random]);
	}
	print(people);

	ListHuman assembly = new ListHuman();

	for (int i = 0; i < people.length - 1; i++) {
	    for (int j = i + 1; j < people.length; j++) {
			if (people[i] == people[j].getWhoHeLikes()
					&& people[j] == people[i].getWhoHeLikes()) {
		    assembly.add(people[i]);
		    assembly.add(people[j]);
		    Children child = new Children();
		    child.setFather((people[i].getSex()) ? people[i] : people[j]);
		    child.setMother((!people[j].getSex()) ? people[j] : people[i]);
		    assembly.add(child);
		}
	    }
	}

	System.out.println(assembly/*.toString()*/);
    }

    private static void print(Human[] people) {
	System.out.println("-----------------------");
	for (int i = 0; i < people.length; i++) {
	    System.out.println(people[i]);
	}
    }
}
