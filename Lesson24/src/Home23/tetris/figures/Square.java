package Home23.tetris.figures;

import Home23.tetris.Field;
import Home23.tetris.Figure;

public class Square extends Figure {
    public Square() {
	//задание точек, в которых "присутствуют" элементы фигуры
	size[0][0] = size[0][1] = size[1][0] = size[1][1] = true;
    }

    @Override
    public void rotate(Field field) {
	//квадрату не осбо нужен поворот)
	return;
    }
}