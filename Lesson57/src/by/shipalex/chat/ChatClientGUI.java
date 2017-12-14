package by.shipalex.chat;

import java.awt.Color;

import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.IOException;

import java.io.PrintWriter;

import java.net.Socket;

import java.net.UnknownHostException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

public class ChatClientGUI {
    private static ChatClient chatClient;
    public static String userName="anonim";
    
    //Main window
    public static JFrame mainWindow=new JFrame();
    private static JButton bAbout=new JButton();
    private static JButton bConnect=new JButton();
    private static JButton bDisconnect=new JButton();
    private static JButton bHelp=new JButton();
    private static JButton bSend=new JButton();
    private static JLabel lMessage=new JLabel("Message: ");
    public static JTextField TFMessage=new JTextField(20);
    private static JLabel LConversation=new JLabel();
    public static JTextArea TAConversation=new JTextArea();
    private static JScrollPane SPConversation=new JScrollPane();
    private static JLabel LOnline=new JLabel();
    public static JList JLOnline=new JList();
    private static JScrollPane SPOnline=new JScrollPane();
    private static JLabel LLoggedInAs=new JLabel();
    private static JLabel LLoggedInAsBox=new JLabel();
    
    public static JFrame logInWindow=new JFrame();
    public static JTextField TFUserNameBox=new JTextField(20);
    public static JButton bEnter=new JButton("Enter");
    public static JLabel LEnterUserName=new JLabel("Enter username: ");
    public static JPanel PLogin=new JPanel();
    
    
    public static void main(String[] args) {
        System.out.println();
        buildMainWindow();
        initialize();
    }
    
    public static void connect() {
        try{
                
            final int port=444;
            final String host="127.0.0.1";
            Socket sock=new Socket(host,port);
            System.out.println("You connected to "+host);
            
            chatClient =new ChatClient(sock);
            PrintWriter out= new PrintWriter(sock.getOutputStream());
            out.println(userName);
            out.flush();
            System.out.println(11);
            
            Thread t=new Thread(chatClient);
            t.start();
            
        } catch (Exception e){
            e.getMessage();
            JOptionPane.showMessageDialog(null, "Server not responding.");
            System.exit(0);
        }
    }
    
    public static void initialize(){
        bSend.setEnabled(false);
        bDisconnect.setEnabled(false);
        bConnect.setEnabled(true);
    }
    
    public static void buildLogInWindow(){
        logInWindow.setTitle("What's your name?");
        logInWindow.setSize(400, 100);
        logInWindow.setLocation(250, 200);
        logInWindow.setResizable(false);
        PLogin=new JPanel();
        PLogin.add(LEnterUserName);
        PLogin.add(TFUserNameBox);
        PLogin.add(bEnter);
        logInWindow.add(PLogin);
        loginAction();
        logInWindow.setVisible(true);
    }
    
    public static void buildMainWindow(){
        mainWindow.setTitle(userName+"'s chat box");
        mainWindow.setSize(450, 500);
        mainWindow.setLocation(220, 160);
        mainWindow.setResizable(false);
        configureMainWindow();
        mainWindowAction();
        mainWindow.setVisible(true);
    }
    
    public static void configureMainWindow(){
        mainWindow.setBackground(new Color(255,255,255));
        mainWindow.setSize(500, 320);
        mainWindow.getContentPane().setLayout(null);
        
        bSend.setBackground(new Color(0,0,255));
        bSend.setForeground(new Color (255,255,255));
        bSend.setText("Send");
        mainWindow.getContentPane().add(bSend);
        bSend.setBounds(250, 40, 81, 25);
        
        bDisconnect.setBackground(new Color(0,0,255));
        bDisconnect.setForeground(new Color (255,255,255));
        bDisconnect.setText("Disconnect");
        mainWindow.getContentPane().add(bDisconnect);
        bDisconnect.setBounds(10, 40, 110, 25);
        
        bConnect.setBackground(new Color(0,0,255));
        bConnect.setForeground(new Color (255,255,255));
        bConnect.setText("Connect");
        mainWindow.getContentPane().add(bConnect);
        bConnect.setBounds(130, 40, 110, 25);
        
        bHelp.setBackground(new Color(0,0,255));
        bHelp.setForeground(new Color (255,255,255));
        bHelp.setText("Help");
        mainWindow.getContentPane().add(bHelp);
        bHelp.setBounds(420, 40, 70, 25);
        
        bAbout.setBackground(new Color(0,0,255));
        bAbout.setForeground(new Color (255,255,255));
        bAbout.setText("About");
        mainWindow.getContentPane().add(bAbout);
        bAbout.setBounds(320, 40, 75, 25);
        
        lMessage.setText("Message: ");
        mainWindow.getContentPane().add(lMessage);
        lMessage.setBounds(10, 10, 60, 20);
        
        TFMessage.setForeground(new Color(0,0,255));
        TFMessage.requestFocus();
        mainWindow.getContentPane().add(TFMessage);
        TFMessage.setBounds(70, 4, 260, 30);
        
        LConversation.setHorizontalAlignment(SwingConstants.CENTER);
        LConversation.setText("Conversation");
        mainWindow.getContentPane().add(LConversation);
        LConversation.setBounds(100, 70, 140, 16);
        
        TAConversation.setColumns(20);
        TAConversation.setFont(new Font("Tahoma",0,12));
        TAConversation.setForeground(new Color(0,0,255));
        TAConversation.setLineWrap(true);
        TAConversation.setRows(5);
        TAConversation.setEditable(false);
        
        SPConversation.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        SPConversation.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        SPConversation.setViewportView(TAConversation);
        mainWindow.getContentPane().add(SPConversation);
        SPConversation.setBounds(10, 90, 330, 180);
        
        LOnline.setHorizontalAlignment(SwingConstants.CENTER);
        LOnline.setText("Currently online");
        LOnline.setToolTipText("");
        mainWindow.getContentPane().add(LOnline);
        LOnline.setBounds(350, 70, 130, 16);
        
        JLOnline.setForeground(new Color(0,0,255));
        
        SPOnline.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        SPOnline.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        SPOnline.setViewportView(JLOnline);
        mainWindow.getContentPane().add(SPOnline);
        SPOnline.setBounds(350, 90, 130, 180);
        
        LLoggedInAs.setFont(new Font("Tahoma",0,12));
        LLoggedInAs.setText("Currently logged in as");
        mainWindow.getContentPane().add(LLoggedInAs);
        LLoggedInAs.setBounds(348, 0, 140, 15);
        
        LLoggedInAsBox.setHorizontalAlignment(SwingConstants.CENTER);
        LLoggedInAsBox.setFont(new Font("Tahoma",0,12));
        LLoggedInAsBox.setForeground(new Color(255,0,0));
        LLoggedInAsBox.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
        mainWindow.getContentPane().add(LLoggedInAsBox);
        LLoggedInAsBox.setBounds(340, 17, 150, 20);
    }
    
    public static void loginAction(){
        bEnter.addActionListener(new ActionListener(){

                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        actionBEnter();
                    } catch (UnknownHostException f) {
                    } catch (IOException f) {
                    }
                }
            });
    }
    public static void actionBEnter() throws UnknownHostException, IOException {
        if (!TFUserNameBox.getText().equals("")) {
            userName=TFUserNameBox.getText().trim();
            LLoggedInAsBox.setText(userName);
            ChatServer.currentUsers.add(userName);
            mainWindow.setTitle(userName+"'s chat box");
            logInWindow.setVisible(false);
            bSend.setEnabled(true);
            bDisconnect.setEnabled(true);
            bConnect.setEnabled(false);
            connect();
        }
        else{
            JOptionPane.showMessageDialog(null, "Please, enter a name.");
        }
    }
    
    public static void mainWindowAction(){
        bSend.addActionListener(new ActionListener(){

                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    actionBSend();
                }
            });
        
        bDisconnect.addActionListener(new ActionListener(){

                @Override
                public void actionPerformed(ActionEvent e) {
                    actionBDisconnect();
                }
            });
        
        bConnect.addActionListener(new ActionListener(){

                @Override
                public void actionPerformed(ActionEvent e) {
                    buildLogInWindow();
                }
            });
        
        bHelp.addActionListener(new ActionListener(){

                @Override
                public void actionPerformed(ActionEvent e) {
                    actionBHelp();
                }
            });
        
        bAbout.addActionListener(new ActionListener(){

                @Override
                public void actionPerformed(ActionEvent e) {
                    actionBHelp();
                }
            });
    }
    
    public static void actionBSend(){
        if (!TFMessage.getText().equals("")) {
            chatClient.send(TFMessage.getText());
            TFMessage.requestFocus();
        }
    }
    
    public static void actionBDisconnect(){
        try {
            chatClient.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void actionBHelp(){
        JOptionPane.showMessageDialog(null, "Multiclient chat programm.");
    }
}
