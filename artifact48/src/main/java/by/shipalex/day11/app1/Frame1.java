package by.shipalex.day11.app1;

import java.awt.Dimension;

import java.awt.Rectangle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Frame1 extends JFrame {
	
    private JLabel jLabel1 = new JLabel();
    private JButton jButton1 = new JButton();
    private JButton jButton2 = new JButton();
    private JButton jButton3 = new JButton();
    private JLabel animLabel = new JLabel("A");

    public Frame1() {
        try {
            jbInit();
            animLabel.setBounds(0,0,20,20);
            add(animLabel);
            new animateThread().start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.getContentPane().setLayout( null );
        this.setSize(new Dimension(574, 465));
        jLabel1.setText("Otvet:");
        jLabel1.setBounds(new Rectangle(55, 15, 170, 30));
        jButton1.setText("1+1");
        jButton1.setBounds(new Rectangle(15, 85, 145, 80));
        jButton1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jButton1_actionPerformed(e);
                }
            });
        jButton2.setText("1+1 2 \u043c\u0438\u043b\u043b\u0438\u0430\u0440\u0434\u0430 \u0440\u0430\u0437");
        jButton2.setBounds(new Rectangle(180, 85, 160, 80));
        jButton2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jButton2_actionPerformed(e);
                }
            });
        jButton3.setText("1+1 3 \u043c\u0438\u043b\u043b\u0438\u0430\u0440\u0434\u0430 \u0440\u0430\u0437 \u0432 \u043f\u043e\u0442\u043e\u043a\u0435");
        jButton3.setBounds(new Rectangle(60, 170, 250, 75));
        jButton3.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jButton3_actionPerformed(e);
                }
            });
        this.getContentPane().add(jButton3, null);
        this.getContentPane().add(jButton2, null);
        this.getContentPane().add(jButton1, null);
        this.getContentPane().add(jLabel1, null);
    }
    
    public static void main(String[] s){
        Frame1 f = new Frame1();
        f.setVisible(true);
        f.repaint();
    }

    private void jButton1_actionPerformed(ActionEvent e) {
        jLabel1.setText("Otvet: 2");
    }

    private void jButton2_actionPerformed(ActionEvent e) {
        long result = 0;
        for (long i=0; i<20000000000L; i++){
            result=result+1;
        }
        jLabel1.setText("Otvet: "+ result);
    }

    private void jButton3_actionPerformed(ActionEvent e) {
        new Thread(){
            public void run(){
            	jLabel1.setText("please wait...");
                long result = 0;
                for (long i=0; i<30000000000L; i++){
                    result=result+1;
                }
                jLabel1.setText("Otvet: "+ result);
            }
        }.start();
    }


    
    private class animateThread extends Thread{
        
        public void run(){
            
            try {
            while(true){
                Thread.currentThread().sleep(100);
                animLabel.setLocation(animLabel.getLocation().x+1, animLabel.getLocation().x+1);
            }
            } catch (InterruptedException e) {}
        }
    }
}
