package app1;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Rectangle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;

import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class PaintEditor extends JFrame {
    private int prevX, prevY;
    private Color color = Color.BLACK;
    private JButton jButton = new JButton("ColorChooser");

    public PaintEditor() {
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        c.add(jButton);

        jButton.addActionListener(new ButtonActionListener());
        addMouseListener(new PaintMouseAdapter());
        addMouseMotionListener(new PaintMouseMotionAdapter());
    }

    private class ButtonActionListener implements ActionListener {
    	@Override
        public void actionPerformed(ActionEvent e) {
            color =
                    JColorChooser.showDialog(((Component)e.getSource()).getParent(),
                                             "Demo", color);
        }
    }

    private class PaintMouseAdapter extends MouseAdapter {
        public void mousePressed(MouseEvent ev) {
            setPreviousCoordinates(ev.getX(), ev.getY());
        }
    }

    private class PaintMouseMotionAdapter extends MouseMotionAdapter {
        public void mouseDragged(MouseEvent ev) {
            Graphics g = getGraphics();
            g.setColor(color);
            g.drawLine(prevX, prevY, ev.getX(), ev.getY());
            setPreviousCoordinates(ev.getX(), ev.getY());
        }
    }

    public void setPreviousCoordinates(int aPrevX, int aPrevY) {
        prevX = aPrevX;
        prevY = aPrevY;
    }
    
    
    
    

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
