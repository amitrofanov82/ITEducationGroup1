package examples41.swing;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;

public class App1 {
    public static void main(String[] args) {
        JFrame fr = new FrameDemo();
        fr.setBackground(Color.LIGHT_GRAY);
        fr.setSize(new Dimension(250, 300));
        fr.setTitle("Windows-Application");
        fr.setVisible(true);
        fr.repaint();
        
        JFrame fr2 = new FrameDemo();
        fr2.setBackground(Color.LIGHT_GRAY);
        fr2.setSize(new Dimension(250, 300));
        fr2.setTitle("Windows-Application");
        fr2.setVisible(true);
        fr2.repaint();
        
        JFrame fr3 = new FrameDemo2();
        fr3.setBackground(Color.LIGHT_GRAY);
        fr3.setSize(new Dimension(250, 300));
        fr3.setTitle("Windows-Application");
        fr3.setVisible(true);
        fr3.repaint();
    }
    
}



























