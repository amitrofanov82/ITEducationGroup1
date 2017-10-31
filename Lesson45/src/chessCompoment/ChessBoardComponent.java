package chessCompoment;

import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;;

public class ChessBoardComponent extends JComponent {
	public static final int WHITE_DOWN = 0;
	public static final int BLACK_DOWN = 1;
	
	private int direction = WHITE_DOWN;
	private Color lightColor = Color.WHITE;
	private Color darkColor = Color.BLACK;
	
	public void setDirection(int directionEnum) {
		direction = directionEnum;
	}

	public void setColors(Color light, Color dark) {
		lightColor = light;
		darkColor = dark;
	}
	
	@Override
	public void paint(Graphics g) {
		Graphics2D graphics = (Graphics2D) g;
		graphics.setColor(Color.BLACK);
		graphics.fillRect(0, 0, this.getWidth(), this.getHeight());
		graphics.setColor(this.getBackground());
		graphics.fillRect(0, 0, this.getWidth()-200, this.getHeight()-200);
		
		
	}

	
	
	
	
	
	
	

}
