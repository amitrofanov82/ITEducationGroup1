package by.shipalex.chat;

import java.io.IOException;
import java.io.PrintWriter;

import java.net.Socket;

import java.util.Scanner;


public class ChatServerReturn implements Runnable {
    Socket sock;
    private Scanner input;
    private PrintWriter out;
    String message = ""; 

    public ChatServerReturn(Socket s) {
        this.sock = s;
    }

    public void checkConnection() throws IOException {
        if (!sock.isConnected()) {
            for (int i = 1; i <= ChatServer.connectionArray.size(); i++) {
                if (ChatServer.connectionArray.get(i) == sock) {
                    ChatServer.connectionArray.remove(i);
                }
            }
            for (int i = 1; i <= ChatServer.connectionArray.size(); i++) {
                Socket temp = (Socket)ChatServer.connectionArray.get(i - 1);
                PrintWriter pr = new PrintWriter(temp.getOutputStream());
                pr.println(temp.getLocalAddress().getHostName() + " disconnected");
                pr.flush();
                System.out.println(temp.getLocalAddress().getHostName() + " disconnected");
            }
        }
    }

    @Override
    public void run() {
        try {
            try {
                input = new Scanner(sock.getInputStream());
                out = new PrintWriter(sock.getOutputStream());

                while (true) {
                    checkConnection();
                    if (!input.hasNext()) {
                        return;
                    }
                    message = input.nextLine();
                    System.out.println("Client said " + message);
                    for (int i = 0; i < ChatServer.connectionArray.size(); i++) {
                        Socket temp = (Socket)ChatServer.connectionArray.get(i);
                        PrintWriter pr = new PrintWriter(temp.getOutputStream());
                        pr.println(message);
                        pr.flush();
                        System.out.println("Sent to " + sock.getLocalAddress().getHostName());
                    }


                }
            } finally {
                sock.close();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
