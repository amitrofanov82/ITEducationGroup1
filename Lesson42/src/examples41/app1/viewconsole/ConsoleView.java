package examples41.app1.viewconsole;



import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

import java.io.InputStreamReader;
import java.io.Reader;

import java.util.List;
import java.util.Scanner;

import examples41.app1.model.NoteEnum;
import examples41.app1.model.Notepad;
import examples41.app1.viewswing.NotepadFrame;

public class ConsoleView {
    private Notepad notepad;
    private Scanner sc;
    
    public ConsoleView() throws IOException {
        File f = new File("notepad.txt");
        notepad=new Notepad(f);
        sc=new Scanner(System.in);
        String inputStr = null;
        try {
            boolean b = true;
            while (b) {
                this.dialog();
                inputStr = sc.next();
                b = this.choise(inputStr);
            }
        } finally {
            sc.close();
        }
    }
    

    public void dialog() {
        System.out.println("\n�������� �����:");
        System.out.println("1: �������� ������");
        System.out.println("2: ����������� ������:");
        System.out.println("3: �������� �������:");
        System.out.println("4: ����������� �������:");
        System.out.println("5: ������� � ����������� �����:");
        System.out.println("0: �����:");
    }

    public boolean choise(String sVybor) throws IOException {
        int c = 0;
        try {
            c=Integer.valueOf(sVybor);
        } catch (Exception e) {
            c=99;
        }
        String s = null;
        List list=null;
        switch (c) {
        case 1:
            System.out.println("���������� ������, ������� �����");
            s = (new BufferedReader(new InputStreamReader(System.in))).readLine();
            notepad.add(s, NoteEnum.ZAMETKA);
            return true;
        case 2:
            System.out.println("����������� ������");
            list = notepad.read(NoteEnum.ZAMETKA);
            print(list);
            return true;
        case 3:
            System.out.println("���������� �������, ������� �����");
            s = (new BufferedReader(new InputStreamReader(System.in))).readLine();;
            notepad.add(s, NoteEnum.ZADACHA);
            return true;
        case 4:
            System.out.println("����������� �������");
            list=notepad.read(NoteEnum.ZADACHA);
            print(list);
            return true;
        case 5:
            NotepadFrame fr= new NotepadFrame();
            fr.setVisible(true);
            fr.repaint();
            return true;
        case 0:
            System.out.println("�����");
            System.exit(0);
            return false;
        default:
            System.out.println("�� ������ �����");
            return true;
        }
    }

    public void print(List list){
        for (Object o:list) System.out.println(o);
    }
    
    
}
