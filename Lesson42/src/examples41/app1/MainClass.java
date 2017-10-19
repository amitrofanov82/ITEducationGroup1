package examples41.app1;

import java.io.IOException;

import examples41.app1.viewswing.NotepadFrame;

public class MainClass {
    public static void main(String[] args) throws IOException {
//        ConsoleView m=new ConsoleView();
        NotepadFrame fr= new NotepadFrame();
        fr.setVisible(true);
        fr.setDefaultCloseOperation(fr.EXIT_ON_CLOSE);
        fr.repaint();
    }
}
