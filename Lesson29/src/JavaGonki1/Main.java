package JavaGonki1;

import javax.swing.*;  

public class Main {

	public static void main(String[] args) {
		
		JFrame f = new JFrame("Gonki");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(1100, 620);
		f.add(new Road());
		f.setVisible(true);
	}

}
