package app1.viewswing;

import app1.model.NoteEnum;
import app1.model.Notepad;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.File;

import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;

public class NotepadFrame extends JFrame {
//------------------------------------
    private Notepad n;
    
    private JButton buttonSaveZametka = new JButton("Сохранить зам.");
    private JButton buttonShowZametka = new JButton("ШоуЗам");
    private JButton buttonSaveZadacha = new JButton("SAVe zad");
    private JButton buttonShowZadacha = new JButton("show zadacha");
    private JTextField textToSave = new JTextField();
    private JTextArea outputArea = new JTextArea();
//-----------------------------------    
    private BorderLayout layoutMain = new BorderLayout();
    private JPanel panelCenter = new JPanel();
    private JMenuBar menuBar = new JMenuBar();
    private JMenu menuFile = new JMenu();
    private JMenuItem menuFileExit = new JMenuItem();
    private JMenu menuHelp = new JMenu();
    private JMenuItem menuHelpAbout = new JMenuItem();
    private JLabel statusBar = new JLabel();
    private JToolBar toolBar = new JToolBar();
    private JButton buttonOpen = new JButton();
    private JButton buttonClose = new JButton();
    private JButton buttonHelp = new JButton();
    private ImageIcon imageOpen =
        new ImageIcon(NotepadFrame.class.getResource("openfile.gif"));
    private ImageIcon imageClose =
        new ImageIcon(NotepadFrame.class.getResource("closefile.gif"));
    private ImageIcon imageHelp =
        new ImageIcon(NotepadFrame.class.getResource("help.gif"));
    

    public NotepadFrame() {
        try {
            jbInit();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.setJMenuBar(menuBar);
        this.getContentPane().setLayout(layoutMain);
        panelCenter.setLayout(new FlowLayout());
        this.setSize(new Dimension(400, 600));
        this.setResizable(false);
        this.setTitle("Notepad");
        //------------
        buttonSaveZametka.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    buttonSaveZametka_actionPerformed(e);
                }
            });
        buttonShowZametka.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    buttonShowZametka_actionPerformed(e);
                }
            });
        buttonSaveZadacha.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    buttonSaveZadacha_actionPerformed(e);
                }
            });
        buttonShowZadacha.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    buttonShowZadacha_actionPerformed(e);
                }
            });
        //-=--------
        menuFile.setText("File");
        menuFileExit.setText("Exit");
        menuFileExit.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    fileExit_ActionPerformed(ae);
                }
            });
        menuHelp.setText("Help");
        menuHelpAbout.setText("About");
        menuHelpAbout.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    helpAbout_ActionPerformed(ae);
                }
            });
        statusBar.setText("NACHALIO");
        buttonOpen.setToolTipText("Open File");
        buttonOpen.setIcon(imageOpen);
        buttonOpen.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    buttonOpen_actionPerformed(e);
                }
            });
        buttonClose.setToolTipText("Close File");
        buttonClose.setIcon(imageClose);
        buttonHelp.setToolTipText("About");
        buttonHelp.setIcon(imageHelp);
        buttonHelp.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    buttonHelp_actionPerformed(e);
                }
            });
        textToSave.setSize(new Dimension(300, 19));
        textToSave.setPreferredSize(new Dimension(333, 19));
        outputArea.setPreferredSize(new Dimension(333, 333));
        outputArea.setEditable(false);
        outputArea.setAutoscrolls(true);
        outputArea.setLineWrap(true);
        //-------------
        
        menuFile.add(menuFileExit);
        menuBar.add(menuFile);
        menuHelp.add(menuHelpAbout);
        menuBar.add(menuHelp);
        this.getContentPane().add(statusBar, BorderLayout.SOUTH);
        toolBar.add(buttonOpen);
        toolBar.add(buttonClose);
        toolBar.add(buttonHelp);
        
        panelCenter.add(buttonSaveZadacha);
        panelCenter.add(buttonSaveZametka);
        panelCenter.add(buttonShowZadacha);
        panelCenter.add(buttonShowZametka);
        panelCenter.add(textToSave, null);
        panelCenter.add(outputArea, null);
        this.getContentPane().add(toolBar, BorderLayout.NORTH);
        this.getContentPane().add(panelCenter, BorderLayout.CENTER);
    }

    void fileExit_ActionPerformed(ActionEvent e) {
        System.exit(0);
    }

    void helpAbout_ActionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(this, new NotepadFrame_AboutBoxPanel1(),
                                      "About", JOptionPane.PLAIN_MESSAGE);
    }

    private void buttonHelp_actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(this, new NotepadFrame_AboutBoxPanel1(),
                                      "About", JOptionPane.PLAIN_MESSAGE);
    }

    private void buttonOpen_actionPerformed(ActionEvent e) {
        JFileChooser fileopen = new JFileChooser();
        int ret = fileopen.showDialog(null, "������� ����");
        if (ret == JFileChooser.APPROVE_OPTION) {
            n = new Notepad(fileopen.getSelectedFile());
        }
        statusBar.setText("���� ��� ������ ������");
    }


    

    private void buttonSaveZadacha_actionPerformed(ActionEvent e) {
        try {
            n.add(textToSave.getText(), NoteEnum.ZADACHA);
        } catch (Exception f) {
            statusBar.setText("�� ����������� ������-��");
        }
    }

    private void buttonSaveZametka_actionPerformed(ActionEvent e) {
        try {
            n.add(textToSave.getText(), NoteEnum.ZAMETKA);
        } catch (Exception f) {
            statusBar.setText("�� ����������� ������-��");
        }
    }

    private void buttonShowZametka_actionPerformed(ActionEvent e) {
        List<String> list;
        outputArea.removeAll();
        try {
            list = n.read(NoteEnum.ZAMETKA);
            for (String s: list) outputArea.append(s+"\r\n");
        } catch (Exception f) {
            statusBar.setText("������ ���������� ������");
        }
        
    }

    private void buttonShowZadacha_actionPerformed(ActionEvent e) {
        List<String> list;
        outputArea.removeAll();
        try {
            list = n.read(NoteEnum.ZADACHA);
            for (String s: list) outputArea.append(s+"\r\n");
        } catch (Exception f) {
            statusBar.setText("������ ���������� ������");
        }
    }
}
