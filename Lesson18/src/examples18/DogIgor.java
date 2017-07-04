package examples18;

import java.util.Scanner;

public class DogIgor {
	static final String porodi[] = { "haski", "erk", "buldog", "mops" };
	String poroda;
	String name;
	int age;
	int weight;
	String mood;
	char sex;
	static final String moods[] = { "cheerful", "evil", "hungry", "sleepy", "tired", "playful" };

	public DogIgor() {
		System.out.println("Viberite porodu 1)Haski 2)erk 3)buldog 4)mops");
		Scanner sc = new Scanner(System.in);
		int choise;
		choise = sc.nextInt();
		System.out.println("you enter " + choise);
		if (choise == 1) {
			poroda = porodi[0];
		}
		if (choise == 2) {
			poroda = porodi[1];
		}
		if (choise == 3) {
			poroda = porodi[2];
		}
		if (choise == 4) {
			poroda = porodi[3];
		}
		System.out.println("Nazovite sobaku");
		Scanner sc2 = new Scanner(System.in); ///По хорошему сканнер тот же, что и раньше должен быть.
      										  ///но есть косяк с использованием nextLine после nextInt. 
      										  ///который мы ыкратце обговаривали, но его полное понимание пока преждевременно.
		String givename;
		givename = sc2.nextLine();
		System.out.println("name " + givename);
		name = givename;
		age = 1;
		if ((int) Math.random() > 0.5) {
			sex = 'M';
		} else {
			sex = 'F';
		}
		weight=(int) (Math.random()*5);
	}
	public void voice(){
		System.out.println("GAV GAV GAV");
	}
}
