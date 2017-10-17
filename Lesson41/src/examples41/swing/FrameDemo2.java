package examples41.swing;



import java.awt.Color;
import java.awt.Graphics;

import java.awt.Graphics2D;

import java.awt.Shape;

import java.awt.geom.Ellipse2D;

import javax.swing.JFrame;

public class FrameDemo2 extends JFrame {
    private String msg = "My Windows-Application";

    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        setBackground(Color.LIGHT_GRAY);
        g2.rotate(Math.PI / 6);
        drawChessBoard(g);
        g2.rotate(-Math.PI / 6);
        g.setXORMode(new Color(200, 255, 250));
        Shape e = new Ellipse2D.Float(70, 75, 70, 50);
        g2.fill(e);
    }

    public void drawChessBoard(Graphics g) {
        int size = 16;
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                if ((x + y) % 2 == 0)
                    g.setColor(Color.BLUE);
                else
                    g.setColor(Color.WHITE);
                g.fillRect(75 + x * size, y * size - 25, size, size);
            }
            g.setColor(Color.BLACK);

            g.drawString(new Character((char)('8' - y)).toString(), 66,
                         y * size - 13);
            g.drawString(new Character((char)(y + 'a')).toString(),
                         79 + y * size, 8 * size - 14);
        }
    }
}
