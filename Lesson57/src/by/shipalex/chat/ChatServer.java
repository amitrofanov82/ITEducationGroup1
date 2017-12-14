package by.shipalex.chat;

import java.io.IOException;

import java.io.PrintWriter;

import java.net.ServerSocket;
import java.net.Socket;

import java.util.ArrayList;
import java.util.Scanner;

public class ChatServer {
    public static ArrayList<Socket> connectionArray = new ArrayList<Socket>();
    public static ArrayList<String> currentUsers=new ArrayList<String>();
    
    public static void main(String[] args) throws IOException{
        try {
            final int port=444;
            ServerSocket server=new ServerSocket(port);
            System.out.println("Waiting for clients...");
            
            while(true){
                Socket sock=server.accept();
                connectionArray.add(sock);
                
                System.out.println("Client connection from "+sock.getLocalAddress().getHostName());
                
                addUserName(sock);
                
                ChatServerReturn chat=new ChatServerReturn(sock);
                
                Thread t=new Thread(chat);
                t.start();
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void addUserName(Socket s) throws IOException {
        Scanner input=new Scanner(s.getInputStream());
        String userName=input.nextLine();
        currentUsers.add(userName);
        
        for (int i = 1; i <= connectionArray.size(); i++) {
            Socket temp=(Socket) ChatServer.connectionArray.get(i-1);
            PrintWriter out=new PrintWriter(temp.getOutputStream());
            out.println("###"+currentUsers);
            out.flush();
        }

    }
}



















