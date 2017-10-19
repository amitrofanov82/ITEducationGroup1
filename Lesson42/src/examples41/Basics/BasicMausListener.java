package examples41.Basics;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BasicMausListener implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("click");
	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("press");
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println("release");
	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

}
