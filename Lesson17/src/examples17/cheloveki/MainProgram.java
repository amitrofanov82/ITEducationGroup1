package examples17.cheloveki;

import java.util.Arrays;
import java.util.Scanner;

public class MainProgram {
	static int sort = 0;
	static people[] herd = new people[10];
	static Scanner scanner = new Scanner(System.in);
	static boolean sortir = true;

	public static void main(String[] args) {

		for (int i = 0; i < herd.length; i++) {
			herd[i] = new people(); ///Мне бы больше понравилось new Human. Одного человека этот клас описывает. 
		}
		System.out.println("Tabun naroda:");
		printHerd(herd);
		while (sortir) {
			if (sort == 0) { 
				System.out.println("If you want sort this herd by:\n" + "1)Name\n" + "2)Age\n" + "3)Weight\n"
						+ "4)Sex\n" + "5)He went in the ass");
				//sort = scanner.nextInt();
				inValid();
			} else if (sort == 6) {
				System.out.println("Can we still sort the herd?\n" + "1)Name\n" + "2)Age\n" + "3)Weight\n" + "4)Sex\n"
						+ "5)He went in the ass");
				//sort = scanner.nextInt();
				inValid();
			}

			switch (sort) {
			case 1:
				nameSort();
				break;
			case 2:
				ageSort();
				break;
			case 3:
				weightSort();
				break;
			case 4:
				sexSort();
				break;
			case 5:
				assHerd();
				break;
			}
			if (sortir) { 
				printHerd(herd);
			}
		}
	}

	///гуд. Но можно проще. 
	private static void nameSort() {
		String[] tempArr = new String[herd.length];
		while (sort == 1) {
			System.out.println("Sort for NAME:");
			for (int i = 0; i < herd.length; i++) {
				tempArr[i] = herd[i].name;
			}
			sort = 6;
		}

		// сортируем созданный массив имен
		// впадлу писать сортировку, времени нету
		Arrays.sort(tempArr);
		/*
		 * for (int i = 0; i < tempArr.length; i++) {
		 * System.out.print(tempArr[i] + " | "); }
		 */

		// сортируем наш созданный массив табуна
		for (int i = 0; i < tempArr.length; i++) {
			for (int j = i; j < herd.length; j++) {
				if (tempArr[i] == herd[j].name) {
					people[] temp = new people[1];
					temp[0] = herd[i];
					herd[i] = herd[j];
					herd[j] = temp[0];
				}

			}
		}
	}

	private static void ageSort() {
		while (sort == 2) {
			System.out.println("First:\n" + "1)Old\n" + "2)Young\n");
			sort = scanner.nextInt();
			if (sort == 1) {
				System.out.println("Sort for old age:");
				for (int i = 0; i < herd.length; i++) {
					for (int j = i; j < herd.length; j++) {
						if (herd[i].age >= herd[j].age) {
						} else if (herd[i].age <= herd[j].age) {
							people[] temp = new people[1];
							temp[0] = herd[i];
							herd[i] = herd[j];
							herd[j] = temp[0];
						}
					}
				}
			}
			if (sort == 2) {
				System.out.println("Sort for young age:");
				for (int i = 0; i < herd.length; i++) {
					for (int j = i; j < herd.length; j++) {
						if (herd[i].age <= herd[j].age) {
						} else if (herd[i].age >= herd[j].age) {
							people[] temp = new people[1];
							temp[0] = herd[i];
							herd[i] = herd[j];
							herd[j] = temp[0];
						}
					}
				}
			}
			sort = 6;
		}
	}

	private static void weightSort() {
		while (sort == 3) {
			System.out.println("First:\n" + "1)Thick\n" + "2)Thin\n");
			sort = scanner.nextInt();
			if (sort == 1) {
				System.out.println("Sort for thick weight:");
				for (int i = 0; i < herd.length; i++) {
					for (int j = i; j < herd.length; j++) {
						if (herd[i].weight >= herd[j].weight) {
						} else if (herd[i].weight <= herd[j].weight) {
							people[] temp = new people[1];
							temp[0] = herd[i];
							herd[i] = herd[j];
							herd[j] = temp[0];
						}
					}
				}
			}
			if (sort == 2) {
				System.out.println("Sort for thin weight:");
				for (int i = 0; i < herd.length; i++) {
					for (int j = i; j < herd.length; j++) {
						if (herd[i].weight <= herd[j].weight) {
						} else if (herd[i].weight >= herd[j].weight) {
							people[] temp = new people[1];
							temp[0] = herd[i];
							herd[i] = herd[j];
							herd[j] = temp[0];
						}
					}
				}
			}
			sort = 6;
		}
	}

	private static void sexSort() {

		while (sort == 4) {
			System.out.println("First:\n" + "1)Man\n" + "2)Women\n");
			sort = scanner.nextInt();
			if (sort == 1) {
				System.out.println("Sort for sex man:");
				for (int i = 0; i < herd.length; i++) {
					for (int j = i; j < herd.length; j++) {
						if (herd[j].sex == "M ") {
							if (herd[i].sex == herd[j].sex) {
							} else if (herd[i].sex != herd[j].sex) {
								people[] temp = new people[1];
								temp[0] = herd[i];
								herd[i] = herd[j];
								herd[j] = temp[0];
							}
							break;
						}
					}
				}
			}
			if (sort == 2) {
				System.out.println("Sort for sex woman:");
				for (int i = 0; i < herd.length; i++) {
					for (int j = i; j < herd.length; j++) {
						if (herd[j].sex == "W ") {
							if (herd[i].sex == herd[j].sex) {
							} else if (herd[i].sex != herd[j].sex) {
								people[] temp = new people[1];
								temp[0] = herd[i];
								herd[i] = herd[j];
								herd[j] = temp[0];
							}
							break;
						}
					}
				}
			}
			sort = 6;
		}
	}

	private static void assHerd() {
		// суровая правда жизни :)
		while (sort == 5) {
			System.out.println("All herd -> (_._)\nBye-bye!");
			sortir = false;
			break;
		}
	}

	private static void printHerd(people[] herd) {
		System.out.println("Name\t|Age\t\t|Weight\t|Sex");
		for (int i = 0; i < herd.length; i++) {
			System.out.print(herd[i].name +"\t "+ herd[i].age + "y age\t " + herd[i].weight + "kg\t " + herd[i].sex);
			System.out.println();
		}
		System.out.println();
	}
    
	private static void inValid(){
		sort = (int)scanner.nextInt();
		while(sort<=0 || sort>5 ){
			System.out.println("You fool! Make correct input!");
			sort = scanner.nextInt();
		}
	}
}