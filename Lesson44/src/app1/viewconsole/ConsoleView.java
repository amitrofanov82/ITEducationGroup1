package app1.viewconsole;

import app1.model.NoteEnum;
import app1.model.Notepad;

import app1.viewswing.NotepadFrame;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

import java.io.InputStreamReader;
import java.io.Reader;

import java.util.List;
import java.util.Scanner;

public class ConsoleView {
    private Notepad notepad;
    private Scanner sc;
    
    public ConsoleView() throws IOException {
        File f = new File("notepad.txt");
        notepad=new Notepad(f);
        sc=new Scanner(System.in);
        String inputStr = null;
        try {
            boolean continueInput = true;
            while (continueInput) {
                this.dialog();
                inputStr = sc.next();
                continueInput = this.choise(inputStr);
            }
        } finally {
            sc.close();
        }
    }
    

    public void dialog() {
        System.out.println("\nМЕНЮ:");
        System.out.println("1: добавь заметку");
        System.out.println("2: покажи заметки:");
        System.out.println("3: �������� �������:");
        System.out.println("4: ����������� �������:");
        System.out.println("5: 21й век на дворе, открывай окно и не мучайся:");
        System.out.println("0: до свидания�:");
    }

    public boolean choise(String sVybor) throws IOException {
        int c = 0;
        try {
            c=Integer.valueOf(sVybor);
        } catch (NumberFormatException e) {
            c=99;
        }
        String s = null;
        List<String> list=null;
        switch (c) {
        case 1:
            System.out.println("добавь заметку");
            s = (new BufferedReader(new InputStreamReader(System.in))).readLine();
            notepad.add(s, NoteEnum.ZAMETKA);
            return true;
        case 2:
            System.out.println("покажи заметки");
            list = notepad.read(NoteEnum.ZAMETKA);
            print(list);
            return true;
        case 3:
            System.out.println("добавь задачу");
            s = (new BufferedReader(new InputStreamReader(System.in))).readLine();;
            notepad.add(s, NoteEnum.ZADACHA);
            return true;
        case 4:
            System.out.println("покажи задачи");
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
