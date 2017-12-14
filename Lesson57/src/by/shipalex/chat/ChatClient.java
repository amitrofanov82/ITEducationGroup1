package by.shipalex.chat;

import java.io.IOException;
import java.io.PrintWriter;

import java.net.Socket;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class ChatClient implements Runnable{
    Socket sock;
    Scanner input;
    Scanner send=new Scanner(System.in);
    PrintWriter out;
    
    public ChatClient(Socket s){
        this.sock=s;
    }

    @Override
    public void run() {
        try {
            try {
                input=new Scanner(sock.getInputStream());
                out=new PrintWriter(sock.getOutputStream());
                out.flush();
                checkStream();
            } finally {
                sock.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void disconnect() throws IOException {
        out.println(ChatClientGUI.userName+" has disconnected");
        out.flush();
        sock.close();
        JOptionPane.showMessageDialog(null, "You disconnected");
        System.exit(0);
    }
    public void checkStream(){
        while(true){
            receive();
        }
    }
    public void receive(){
        if (input.hasNext()) {
            String message=input.nextLine();
            if (message.contains("###")) {
                String temp=message.substring(3);
                temp=temp.replace("(", "");
                temp=temp.replace(")", "");
                String[] currentUsers=temp.split(", ");
                
                ChatClientGUI.JLOnline.setListData(currentUsers);
            }
            else{
                ChatClientGUI.TAConversation.append(message+"\n");
            }
        }
    }
    
    public void send(String s){
        out.println(ChatClientGUI.userName+": "+s);
        out.flush();
        ChatClientGUI.TFMessage.setText("");
    }
}
