package examples41.Basics;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Components {
	
	public static void main(String[] args) throws InterruptedException {
		JFrame window = new JFrame();
		window.setSize(400, 400);
		//window.setSize(new Dimension((int)(Math.random()*300 +100),
			//	(int)(Math.random()*300)+100));
		window.setVisible(true);
		
		Button knopka = new Button("ТупаяКнопка");
		Button knopka2 = new Button("ТупаяКнопка2");

		knopka.setSize(80, 20); //контейнер игнорирует этот размер
		window.setLayout(null);
		window.add(knopka);
		
		knopka2.setSize(180, 50); //контейнер игнорирует этот размер
		window.add(knopka2);
		
		window.addMouseListener(new BasicMausListener());
		
		
		
		/*while (true){
			Thread.sleep(1L);
			window.setSize(new Dimension((int)(Math.random()*300 +100),
					(int)(Math.random()*300)+100));
			
		}*/
	}
}
