package chessCompoment;

import javax.swing.JFrame;

import java.awt.Color;

public class main {
	public static void main(String[] d) {
		ChessBoardComponent boardComponent = new ChessBoardComponent();
		boardComponent.setDirection(ChessBoardComponent.WHITE_DOWN);
		//boardComponent.setPieceSet(PieceSet.HINDU_STYLE);
		boardComponent.setColors(Color.BLUE, Color.RED);
		boardComponent.setSize(800, 800);
		boardComponent.setLocation(100, 100);
		boardComponent.setBackground(Color.GREEN);
		boardComponent.enable(true);
		
		
		JFrame f = new JFrame("JustWindow");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(1100, 960);
		f.setLayout(null);
		f.add(boardComponent);
		f.setVisible(true);
	}
}
