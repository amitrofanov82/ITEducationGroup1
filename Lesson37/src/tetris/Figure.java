package tetris;

public class Figure {
	// координаты фигуры на поле
	protected boolean[][] map = new boolean[4][4];

	public Figure(Field field) {
		field.setCurFigPl(0, 4);

		// выбор случайной фигуры
		switch ((int) (Math.random() * 5)) {
		case 0:
			// фигура в виде L
			if (Math.random() > 0.5) {
				// левосторонная
				map[1][0] = map[2][0] = map[2][1] = map[2][2] = true;
			} else {
				// правосторонная
				map[1][2] = map[2][0] = map[2][1] = map[2][2] = true;
			}
			break;
		case 1:
			// фигура в виде линии
			map[1][0] = map[1][1] = map[1][2] = map[1][3] = true;
			break;
		case 2:
			// фигура в виде квадрата
			map[1][1] = map[1][2] = map[2][1] = map[2][2] = true;
			break;
		case 3:
			// фигура в виде T
			map[1][1] = map[2][0] = map[2][1] = map[2][2] = true;
			break;
		case 4:
			// фигура в виде Z
			if (Math.random() > 0.5) {
				// левосторонная
				map[1][0] = map[1][1] = map[2][1] = map[2][2] = true;
			} else {
				// правосторонная
				map[1][1] = map[1][2] = map[2][0] = map[2][1] = true;
			}
			break;
		default:
			break;
		}
	}

	// вернуть карту фигуры
	public boolean[][] getMap() {
		return map;
	}

	// поворот
	public void rotate(Field field) {
		boolean[][] temp = new boolean[map.length][map[0].length];

		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp[i].length; j++) {
				temp[j][temp.length - 1 - i] = map[i][j];
			}
		}

		// проверка, возможен ли поворот
		int[] curFigPl = field.getCurFigPl();
		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp[i].length; j++) {
				if (temp[i][j]) {
					if (curFigPl[0] + i >= field.field.length || curFigPl[1] + j >= field.field[0].length
							|| curFigPl[1] + j < 0 || field.field[curFigPl[0] + i][curFigPl[1] + j]) {
						return;
					}
				}
			}
		}
		map = temp;
	}
}