package examples18;

import java.util.Scanner;
import examples18.playdog.model.Dog;

public class DogGame {
	
	public static void main(String[] args) {
		Dog d = new Dog();
		//Dog d2 = new Dog("Tuzik2");
		Scanner sc = new Scanner(System.in);
		//d.name = "Tuzik";
		//пропущу инициализацию...
		
		System.out.println("Kupi sobaku s imenem: ");
		d.name = sc.nextLine();
		System.out.println("poroda: ");
		d.breed = sc.nextLine();
		
		while (true) {
			System.out.println("Chto delat'?");
			System.out.println("1 kormit'");
			System.out.println("2 gladit'");
			System.out.println("3 ubit'");
			System.out.println("4 sprosit' kak dela");
			int choice = sc.nextInt();
			switch (choice){
			case 1:
				d.feed(Dog.SOUP, 10);
				break;
			case 2:
				//TODO:
				break;
			case 3:
				System.out.println("Ty svoloch");
				System.exit(0);
				break;
			case 4:
				System.out.println(d.howAreYou());
				d.printStatus();
			}
			
		}
		
	}
}
