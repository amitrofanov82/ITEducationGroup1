package tetris;

public class Game {
	private Field field;

	public Game() {
		field = new Field();
	}

	public void start() {

		while (field.stackIsNtFull) {
			//UserCommand command = ui.getCommandFromUser();
			//field.performAction(UserCommand command);
			//ui.update(field);
			
			
			// текущая фигура
			Figure current = new Figure(field);
			field.figureInGame = true;
			// ввод фигуры в игру вверху поля
			field.appearFig(current);

			while (field.figureInGame) {
				// отрисовка поля
				System.out.println(field);
				System.out.println("Possible move:\n1. Left\n2. Right\n3. Rotate" + "\n4. Down\n5. Completly down");

				move(current);
			}
		}
		System.out.println(field);
		System.out.println("Game is over");
	}

	// выбор хода пользователем
	private void move(Figure currentPiece) {
		switch (GetInt.get()) {
		// перемещение влево
		case (1): {
			field.move(currentPiece, -1);
			field.move(currentPiece, 0);
			break;
		}
		// перемещение вправо
		case (2): {
			field.move(currentPiece, 1);
			field.move(currentPiece, 0);
			break;
		}
		// поворот
		case (3): {
			field.rotate(currentPiece);
			field.move(currentPiece, 0);
			break;
		}
		// перемещение вниз
		case (4): {
			field.move(currentPiece, 0);
			break;
		}
		// перемещение вниз до упора
		case (5): {
			while (field.figureInGame) {
				field.move(currentPiece, 0);
			}
			break;
		}
		case (0): {
			field.stackIsNtFull = false;
			field.figureInGame = false;
			break;
		}
		default: {
			break;
		}
		}
	}
}