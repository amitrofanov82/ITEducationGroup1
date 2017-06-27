package homework15;

import java.util.Scanner;

public class Casino {
	// для Блэкджэка
	private static boolean stay;
	private static int pointsUser, pointsDealer, nextCard;
	private static String[] userCards = new String[9];
	private static String[] dealerCards = new String[9];
	private final static String[] cardDeck = { "2♠", "3♠", "4♠", "5♠", "6♠", "7♠", "8♠", "9♠", "10♠", "2♣", "3♣", "4♣",
			"5♣", "6♣", "7♣", "8♣", "9♣", "10♣", "2♥", "3♥", "4♥", "5♥", "6♥", "7♥", "8♥", "9♥", "10♥", "2♦", "3♦",
			"4♦", "5♦", "6♦", "7♦", "8♦", "9♦", "10♦", "V♥", "D♥", "K♥", "V♣", "D♣", "K♣", "V♦", "D♦", "K♦", "V♠", "D♠",
			"K♠", "T♣", "T♦", "T♥", "T♠" };

	// для рулетки
	private static int score = 1000;
	private static int[] field = new int[37];
	private static int[] redNumbers = new int[18];
	private static int ball;

	public static void main(String[] args) {
		System.out.println("Welcome to The Casino!");
		System.out.println("Please choise your game:");
		System.out.println("1. Blackjack");
		System.out.println("2. Roulette");
		System.out.print(">>>>> ");
		boolean wrong;
		do {
			wrong = false;
			switch (get()) {
			case 1: {
				blackJack();
				break;
			}
			case 2: {
				roul();
				break;
			}
			default: {
				wrong = true;
			}
			}
		} while (wrong);
	}

	public static int get() {
		Scanner take = new Scanner(System.in);

		String input = take.nextLine();

		while (!check(input)) {
			System.out.println("Wrong Input. Retry >>");
			input = take.nextLine();
		}
		// take.close();

		return Integer.parseInt(input);
	}

	public static boolean check(String input) {
		if (input.length() < 1 || input.length() > 11) {
			return false;
		}

		for (int i = 0; i < input.length(); i++) {
			if (i == 0 && input.charAt(i) == '-') {
				if (input.length() > 1) {
					continue;
				} else {
					return false;
				}
			}
			boolean exist = false;
			for (char j = '0'; j <= '9'; j++) {
				if (j == input.charAt(i)) {
					exist = true;
					break;
				}
			}
			if (!exist) {
				return false;
			}
		}
		if (input.length() > 8) {
			Long one = Long.parseLong(input);
			if (one < -2147483648 || one > 2147483647) {
				return false;
			}
		}
		return true;
	}

	private static void roul() {
		boolean game = false;
		System.out.println("Welcome to Blackjack!");
		// обозначение какие ячейки относятся к красным, какие - к чёрным
		initRed();
		do {
			game = false;
			run();

			if (score > 0) {
				System.out.printf("\nNext? \n1: Yes \nOther: No ");
				if (get() == 1) {
					game = true;
				}
			} else {
				System.out.println("You are bankrupt");
			}
		}
		// играть, пока пользователь не передумает или не проиграет все деньги
		while (game && score > 0);

	}

	private static void run() {
		// вывести поле для фишек
		ball = -1;
		print();
		int bet;
		do {
			System.out.printf("Please input your bet size (<= %d): ", score);
			bet = get();
		} while (bet > score);

		System.out.println("Possible bet:");
		System.out.printf("1. Odd\n2. Even\n3. Black\n4. Red\n5. Zero");
		System.out.printf("\n6. 1st 12\n7. 2nd 12\n8. 3rd 12\n9. 1 to 18\n10. 19 to 36");
		System.out.printf("\n11. 1st column\n12. 2nd column\n13. 3rd column\n14. To number\n>>>> ");

		// "запуск" шарика
		ball = (int) (Math.random() * 37);

		switch (get()) {
		case 1: {
			// нечётные, выигрыш 2 к 1
			if (ball % 2 != 0) {
				print();
				score += bet * 2;
				System.out.println("Congratulation! You won! Your score is " + score);
				return;
			}
			break;
		}
		case 2: {
			// чётные, выигрыш 2 к 1
			if (ball % 2 == 0 && ball != 0) {
				print();
				score += bet * 2;
				System.out.println("Congratulation! You won! Your score is " + score);
				return;
			}
			break;
		}
		case 3: {
			// чёрное, выигрыш 2 к 1
			if (!redChek(ball)) {
				print();
				score += bet * 2;
				System.out.println("Congratulation! You won! Your score is " + score);
				return;
			}
			break;
		}
		case 4: {
			// красное, выигрыш 2 к 1
			if (redChek(ball)) {
				print();
				score += bet * 2;
				System.out.println("Congratulation! You won! Your score is " + score);
				return;
			}
			break;
		}
		case 5: {
			// зеро, выигрыш 37 к 1
			if (ball == 0) {
				print();
				score += bet * 37;
				System.out.println("Congratulation! You won! Your score is " + score);
				return;
			}
			break;
		}
		case 6: {
			// первая 12-ка, выигрыш 3 к 1
			if (ball >= 1 && ball <= 12) {
				print();
				score += bet * 3;
				System.out.println("Congratulation! You won! Your score is " + score);
				return;
			}
			break;
		}
		case 7: {
			// вторая 12-ка, выигрыш 3 к 1
			if (ball > 12 && ball <= 24) {
				print();
				score += bet * 3;
				System.out.println("Congratulation! You won! Your score is " + score);
				return;
			}
			break;
		}
		case 8: {
			// третья 12-ка, выигрыш 3 к 1
			if (ball > 24 && ball <= 36) {
				print();
				score += bet * 3;
				System.out.println("Congratulation! You won! Your score is " + score);
				return;
			}
			break;
		}
		case 9: {
			// первая половина, выигрыш 2 к 1
			if (ball >= 1 && ball <= 18) {
				print();
				score += bet * 2;
				System.out.println("Congratulation! You won! Your score is " + score);
				return;
			}
			break;
		}
		case 10: {
			// вторая половина, выигрыш 2 к 1
			if (ball > 18 && ball <= 36) {
				print();
				score += bet * 2;
				System.out.println("Congratulation! You won! Your score is " + score);
				return;
			}
			break;
		}
		case 11: {
			// первый столбец, выигрыш 3 к 1
			if (ball % 3 == 1) {
				print();
				score += bet * 3;
				System.out.println("Congratulation! You won! Your score is " + score);
				return;
			}
			break;
		}
		case 12: {
			// второй столбец, выигрыш 3 к 1
			if (ball % 3 == 2) {
				print();
				score += bet * 3;
				System.out.println("Congratulation! You won! Your score is " + score);
				return;
			}
			break;
		}
		case 13: {
			// третий столбец, выигрыш 3 к 1
			if (ball % 3 == 0) {
				print();
				score += bet * 3;
				System.out.println("Congratulation! You won! Your score is " + score);
				return;
			}
			break;
		}
		case 14: {
			// конкретное число, выигрыш 37 к 1
			System.out.print("What number? ");
			if (ball == get()) {
				print();
				score += bet * 37;
				System.out.println("Congratulation! You won! Your score is " + score);
				return;
			}
			break;
		}
		default: {
			System.out.println("Wrong choise!");
		}
		}
		print();
		score -= bet;
		System.out.println("You lose! Your score is " + score);
	}

	private static void initRed() {
		int red = 1;
		for (int i = 0; i < redNumbers.length; i++) {
			redNumbers[i] = red;
			if (red % 9 == 0) {
				if (red / 9 == 2) {
					red -= 1;
				} else {
					red += 1;
				}
			}
			red += 2;
		}
	}

	private static boolean redChek(int number) {
		for (int i = 0; i < redNumbers.length; i++) {
			if (number == redNumbers[i]) {
				return true;
			}
		}
		return false;
	}

	private static void print() {
		if (field[0] == ball) {
			System.out.printf("\t\t|\t\u20DD\t|");
		} else {
			System.out.printf("\t\t|\t%d\t|", field[0]);
		}
		System.out.printf("\n-------------------------------------------------\n");
		for (int i = 1; i < field.length; i++) {
			field[i] = i;
			// вывод "шарика" вместо цифры
			if (field[i] == ball) {
				if (!redChek(field[i])) {
					// вывод чёрных ячеек
					System.out.printf("||||||||\u20DD||||||");
				} else {
					// вывод красных ячеек
					System.out.printf("|\t\u20DD\t");
				}
			} else {
				if (!redChek(field[i])) {
					// вывод чёрных ячеек
					System.out.printf("||||||||%d||||||", field[i]);
				} else {
					// вывод красных ячеек
					System.out.printf("|\t%d\t", field[i]);
				}
			}
			if (i % 3 == 0) {
				System.out.printf("|\n-------------------------------------------------\n");
			}
		}
	}

	public static void blackJack() {
		boolean game = false;
		System.out.println("Welcome to Blackjack!");
		do {
			game = false;
			System.out.println();
			run2();
			System.out.printf("\n\nAgain? \n1: Yes \nOther: No ");
			if (get() == 1) {
				game = true;
			}
		} while (game);
	}

	public static void run2() {
		init();

		if (pointsUser == 21) {
			printCurrent();
			System.out.println("Congratulation! You have a Blackjack!");
			return;
		}
		do {
			printCurrent();

			System.out.println("Your move:");
			System.out.println("1. Hit me");
			System.out.println("2. Stay");
			System.out.print(">>>>> ");
			userChoise();
			if (pointsUser > 20) {
				printCurrent();
				break;
			}
		} while (!stay);

		System.out.println("Dealer move");
		dealerMove();
	}

	private static void init() {
		stay = false;
		pointsUser = 0;
		pointsDealer = 0;
		nextCard = 2;
		for (int i = 0; i < userCards.length; i++) {
			userCards[i] = null;
			dealerCards[i] = null;
		}
		userCards[0] = cardDeck[scoring(0)];
		userCards[1] = cardDeck[scoring(0)];
		dealerCards[0] = cardDeck[scoring(1)];
	}

	private static void userChoise() {
		switch (get()) {
		case 1: {
			userCards[nextCard] = cardDeck[scoring(0)];
			nextCard++;
			break;
		}
		case 2: {
			stay = true;
			break;
		}
		default: {
			System.out.println("Wrong choise!");
		}
		}
	}

	private static void printCurrent() {
		System.out.print("User hand: ");
		for (int i = 0; i < userCards.length && userCards[i] != null; i++) {
			System.out.print(userCards[i] + " ");
		}
		System.out.printf("\t");
		System.out.print("Dealer hand: ");
		for (int i = 0; i < dealerCards.length && dealerCards[i] != null; i++) {
			System.out.print(dealerCards[i] + " ");
		}
		System.out.println();
		System.out.print("User's points is " + pointsUser);
		System.out.printf("\t");
		System.out.print("Dealer's points is " + pointsDealer);
		System.out.println();
	}

	private static int scoring(int i) {
		int correct = 0, random;
		do {
			random = (int) (Math.random() * cardDeck.length);
		} while (!repeat(random));

		if (random < 9) {
			correct = -2;
		} else if (random > 8 && random < 18) {
			correct = 7;
		} else if (random > 17 && random < 27) {
			correct = 16;
		} else if (random > 26 && random < 36) {
			correct = 25;
		} else if (random > 35 && random < 48) {
			correct = random % 10 + ((random / 10) - 1) * 10;
		} else {
			correct = (random % 10 + ((random / 10) - 1) * 10) - 1;
		}

		if (i == 0) {
			pointsUser += random - correct;
		} else {
			pointsDealer += random - correct;
		}
		return random;
	}

	private static boolean repeat(int random) {
		for (int i = 0; i < userCards.length; i++) {
			if (cardDeck[random] == userCards[i] || cardDeck[random] == dealerCards[i]) {
				return false;
			}
		}
		return true;
	}

	private static void dealerMove() {
		dealerCards[1] = cardDeck[scoring(1)];
		printCurrent();
		if (pointsUser > 21) {
			if (userCards[2] != null) {
				System.out.print("You lose!");
				if (pointsDealer == 22) {
					System.out.print(" Dealer has golden point");
				}
			} else {
				if (pointsDealer != 22) {
					System.out.println("You lose!");
				} else {
					System.out.println("Draw");
				}
			}
			return;
		} else {
			stay = false;
			nextCard = 2;
			do {
				if (pointsDealer >= 17 || pointsDealer > pointsUser) {
					stay = true;
				} else {
					dealerCards[nextCard] = cardDeck[scoring(1)];
					printCurrent();
				}
				nextCard++;
			} while (!stay);

			if (pointsDealer == pointsUser) {
				System.out.println("Draw");
			} else if (pointsDealer > 21 || pointsDealer < pointsUser) {
				if (pointsDealer == 22 && dealerCards[2] == null) {
					System.out.print("You lose! Dealer has golden point");
				} else {
					System.out.println("You win!");
				}
			} else {
				System.out.println("You lose!");
			}
		}
	}

}