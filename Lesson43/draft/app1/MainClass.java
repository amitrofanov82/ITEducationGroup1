package by.shipalex.day9.app1;

import by.shipalex.day9.app1.viewconsole.ConsoleView;
import by.shipalex.day9.app1.viewswing.NotepadFrame;

import java.io.IOException;

public class MainClass {
    public static void main(String[] args) throws IOException {
//        ConsoleView m=new ConsoleView();
        NotepadFrame fr= new NotepadFrame();
        fr.setVisible(true);
        fr.setDefaultCloseOperation(fr.EXIT_ON_CLOSE);
        fr.repaint();
    }
}
