package examples41.swing;



import java.awt.Color;

import java.awt.Dimension;

import java.awt.Graphics;

import javax.swing.JFrame;

public class FrameDemo extends JFrame {

    private String msg = "My Windows-Application";

    @Override
    public void paint(Graphics g) {
        int diam = 230;
        drawSphere(g, diam);
        g.drawString(msg, 59, diam + 52);
        g.drawLine(59, diam + 56, 190, diam + 56);
    }

    public void drawSphere(Graphics g, int diam) {
        int r = diam / 2;
        int alpha = 0;
        int k = 20;
        for (int i = 0; i < 4; i++) {
            int width = (int)(r * Math.cos(Math.PI / 180 * alpha));
            int height = (int)(r * Math.sin(Math.PI / 180 * alpha));
            g.setColor(Color.MAGENTA);
            g.drawArc(10 + r - width, r + height + i * 10, 2 * width,
                      80 - i * 20, 0, 180);
            g.drawArc(10 + r - width, r - height + i * 10, 2 * width,
                      80 - i * 20, 0, 180);
            g.setColor(Color.BLACK);
            g.drawArc(10 + r - width, r + height + i * 10, 2 * width,
                      80 - i * 20, 0, -180);
            g.drawArc(10 + r - width, r - height + i * 10, 2 * width,
                      80 - i * 20, 0, -180);
            alpha += k;
            k -= 1;
        }
        for (int i = 0; i < 4; i++) {
            k = (i * i * 17);
            g.drawOval(10 + k / 2, 40, diam - k, diam);
        }
    }

}
