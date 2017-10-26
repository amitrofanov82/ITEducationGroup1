package app1;

import app1.viewconsole.ConsoleView;
import app1.viewswing.NotepadFrame;

import java.io.IOException;

public class MainClass {
    public static void main(String[] args) throws IOException {
        /*ConsoleView m=new ConsoleView();
        NotepadFrame fr= new NotepadFrame();
        fr.setVisible(true);
        fr.setDefaultCloseOperation(fr.EXIT_ON_CLOSE);
        fr.repaint();*/
    	
        PaintEditor fr= new PaintEditor();
        fr.setVisible(true);
        fr.setDefaultCloseOperation(fr.EXIT_ON_CLOSE);
    }
}
