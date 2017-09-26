import java.util.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.*;
import java.nio.channels.ReadPendingException;
import java.text.*;

public class MainMenu {
    private Notebook notepad;
    private Scanner scr = new Scanner(System.in);
    private String input;
    private boolean itsTrue = true;

    public MainMenu(){
        notepad = new Notebook();
    }

    public MainMenu(Notebook notepad){
        this.notepad = notepad;
    }

    public void start() throws FileNotFoundException, IOException, NeudachnikException{
    	if (Math.random() <0.03) {
    		throw new IOException();
    	}
    	if (Math.random() <0.98) {
    		throw new NeudachnikException();
    		//throw new RuntimeException("RandomUsualException occured");
    	}

    	this.Menu();
    }

    private void Menu(){
        while(true){
            if (notepad.getNotes().isEmpty() && notepad.getReminders().isEmpty()){
                System.out.println("=============================");
                System.out.println("|        ГЛАВНОЕ МЕНЮ       |");
                System.out.println("=============================");
                System.out.println("|1. Меню заметок            |");
                System.out.println("|2. Меню напоминаний        |");
                System.out.println("|3. Выход                   |");
                System.out.println("=============================");
                System.out.println("Сделай свой выбор же наконец: ");
                subMenu();
            }else {
                System.out.println("=============================");
                System.out.println("|        ГЛАВНОЕ МЕНЮ       |");
                System.out.println("=============================");
                System.out.println("|1. Меню заметок            |");
                System.out.println("|2. Меню напоминаний        |");
                System.out.println("|3. Заметки и напоминания   |");
                System.out.println("|4. Выход                   |");
                System.out.println("=============================");
                subMenu();
            }
        }
    }

    private void subMenu(){
        if (notepad.getNotes().isEmpty() && notepad.getReminders().isEmpty()){
            input = scr.nextLine();
            while(!"1".equals(input) && !"2".equals(input) && !"3".equals(input)){
                System.err.println("Попробуй нормально ввести!");
                input = scr.nextLine();
            }
            switch (input){
                case "1":{
                    subNote();
                    break;
                }
                case "2":{
                    subReminder();
                    break;
                }
                case "3" : {
                    System.err.println("=============================");
                    System.err.println("|>>>>>>>>>>Bye-Bye<<<<<<<<<<|");
                    System.err.println("=============================");
                    System.exit(0);}
            }
        }else {
            input = scr.nextLine();
            while(input.isEmpty() || (!(input.equals("1")) && !(input.equals("2")) && !(input.equals("3")) && !(input.equals("4")))){
                System.err.println("Попробуй нормально ввести!");
                input = scr.nextLine();
            }
            switch (input){
                case "1":{
                    subNote();
                    break;
                }
                case "2":{
                    subReminder();
                    break;
                }
                case "3": {
                    System.out.println("                                ЗАМЕТКИ");
                    printAllNotes();
                    System.out.println("                              НАПОМИНАНИЯ");
                    printAllReminders();
                    subNoteRemind();
                    break;
                }
                case "4": {
                    System.err.println("=============================");
                    System.err.println("|>>>>>>>>>>Bye-Bye<<<<<<<<<<|");
                    System.err.println("=============================");
                    System.exit(0);}
            }
        }
    }

    private void subNoteRemind(){
        System.out.println("=============================");
        System.out.println("|1.Открыть запись по ID     |");
        System.out.println("|2.Удалить запись по ID     |");
        System.out.println("|3.Вернуться в главное меню |");
        System.out.println("=============================");
        input = scr.nextLine();
        while(input.isEmpty() || (!(input.equals("1")) && !(input.equals("2")) && !(input.equals("3")))){
            System.err.println("Попробуй нормально ввести!");
            input = scr.nextLine();
        }
        switch (input){
            case "1":{
                itsTrue = true;
                while(itsTrue){
                    System.out.println("=============================");
                    System.out.println("| Введите ID записи:         |");
                    String idString = scr.nextLine();
                    long id = 0;
                    try {
                        id = Long.parseLong(idString);
                    } catch (NumberFormatException e) {
                    	System.err.println("Incorrect format");
                    	continue;
                    }
                    if ((id>100000 && id<120999)||(id>120100 && id<120999)){
                        if(notepad.getRecordById(id)!=null){
                            System.out.println(notepad.getIdMessage(id).getMessage());
                            System.out.println();
                            System.out.println("                                ЗАМЕТКИ");
                            printAllNotes();
                            System.out.println("                              НАПОМИНАНИЯ");
                            printAllReminders();
                            subNoteRemind();
                            itsTrue = false;
                            return;
                        }
                    }
                    System.err.println("Нет такого ID!");
                    itsTrue = true;
                }
            }
            case "2": {
                if (notepad.getNotes().isEmpty() && notepad.getReminders().isEmpty()){
                    System.out.println("ЗАПИСЕЙ НЕТ!");
                    return;
                }else{
                    itsTrue = true;
                    while (itsTrue){
                        System.out.println("=============================");
                        System.out.println("| Введите ID для удаления:  |");
                        String idString = scr.nextLine();
                        long id = 0;
                        try {
                            id = Long.parseLong(idString);
                        } catch (NumberFormatException e) {
                        }
                        if ((id>100000 && id<110999)||(id>120100 && id<120999)){
                            if(notepad.getRecordById(id)!=null){
                                notepad.removeRecords(id);
                                System.out.println("                                ЗАМЕТКИ");
                                printAllNotes();
                                System.out.println("                              НАПОМИНАНИЯ");
                                printAllReminders();
                                System.out.println("=============================");
                                System.out.println("|  Запись успешно удалена!  |");
                                System.out.println("=============================");
                                System.out.println();
                                subNoteRemind();
                                itsTrue = false;
                                return;
                            }else if(notepad.getRecordById(id)==null){
                                System.err.println("Нет такого ID!");
                                itsTrue = true;
                            }
                        }else if(idString.length()!=5){
                            System.err.println("Попробуй нормально ввести!");
                            itsTrue = true;
                        }else if(idString.isEmpty()){
                            System.err.println("Попробуй нормально ввести!");
                            itsTrue = true;
                        }else if(idString.equals(" ")){
                            System.err.println("Попробуй нормально ввести!");
                            itsTrue = true;
                        }
                        itsTrue = true;
                    }
                }
            }
            case "3":{return;}
        }
    }

    private void subNote(){
        while(true){
            System.out.println("=============================");
            System.out.println("|       МЕНЮ \"ЗАМЕТКИ\"      |");
            System.out.println("=============================");
            System.out.println("|1.Создать заметку          |");
            if (notepad.getNotes().isEmpty()){
                System.out.println("|2.Вернуться в главное меню |");
                System.out.println("=============================");
                input = scr.nextLine();
                while(input.isEmpty() || (!(input.equals("1")) && !(input.equals("2")))){
                    System.err.println("Попробуй нормально ввести!");
                    input = scr.nextLine();
                }
                switch (input){
                    case "1":{
                              addNote();
                              break;
                              }
                    case "2":{return;}
                }
            }else {
                System.out.println("|2.Удалить заметку          |");
                System.out.println("|3.Посмотреть все заметки   |");
                System.out.println("|4.Вернуться в главное меню |");
                System.out.println("=============================");
                input = scr.nextLine();
                while(input.isEmpty() || (!(input.equals("1")) && !(input.equals("2")) && !(input.equals("3")) && !(input.equals("4")))){
                    System.err.println("Попробуй нормально ввести!");
                    input = scr.nextLine();
                }
                switch (input){
                    case "1":{
                        addNote();
                        break;}
                    case "2": {
                        removeNote();
                        break;}
                    case "3": {
                        printAllNotes();
                        break;}
                    case "4": {return;}
                }
            }
        }
    }

    private void subReminder(){
        while(true){
            System.out.println("=============================");
            System.out.println("|     МЕНЮ \"НАПОМИНАНИЯ\"    |");
            System.out.println("=============================");
            System.out.println("|1.Создать напоминание      |");
            if (notepad.getReminders().isEmpty()){
                System.out.println("|2.Вернуться в главное меню |");
                System.out.println("=============================");
                input = scr.nextLine();
                while(input.isEmpty() || (!(input.equals("1")) && !(input.equals("2")))){
                    System.err.println("Попробуй нормально ввести!");
                    input = scr.nextLine();
                }
                switch (input){
                    case "1":{
                        addReminder();
                        break;
                    }
                    case "2":{return;}
                }
            }else {
                System.out.println("|2.Удалить напоминание      |");
                System.out.println("|3.Посмотреть напоминания   |");
                System.out.println("|4.Вернуться в главное меню |");
                System.out.println("=============================");
                input = scr.nextLine();
                while(input.isEmpty() || (!(input.equals("1")) && !(input.equals("2")) && !(input.equals("3")) && !(input.equals("4")))){
                    System.err.println("Попробуй нормально ввести!");
                    input = scr.nextLine();
                }
                switch (input){
                    case "1":{
                        addReminder();
                        break;}
                    case "2": {
                        removeReminder();
                        break;}
                    case "3": {
                        printAllReminders();
                        break;}
                    case "4": {return;}
                }
            }
        }
    }

    private void removeNote() {
        printAllNotes();
        itsTrue = true;
        while(itsTrue){
            System.out.println("=============================");
            System.out.println("| Введите ID заметки:       |");
            String idString = scr.nextLine();
            long id = 0;
            try {
                id = Long.parseLong(idString);
            } catch (NumberFormatException e) {
            }
            if (id>100000 && id<110999){
                if(notepad.getRecordById(id)!=null){
                    notepad.removeRecords(id);
                    System.out.println("                                ЗАМЕТКИ");
                    printAllNotes();
                    System.out.println("=============================");
                    System.out.println("|  Запись успешно удалена!  |");
                    System.out.println("=============================");
                    System.out.println();
                    itsTrue = false;
                    return;
                }else if(notepad.getRecordById(id)==null){
                    System.err.println("Нет такого ID!");
                    itsTrue = true;
                }
            }else if(idString.length()!=5){
                System.err.println("Попробуй нормально ввести!");
                itsTrue = true;
            }else if(idString.isEmpty()){
                System.err.println("Попробуй нормально ввести!");
                itsTrue = true;
            }else if(idString.equals(" ")){
                System.err.println("Попробуй нормально ввести!");
                itsTrue = true;
            }
            itsTrue = true;
        }
    }

    private void addNote() {
        System.out.println("=============================");
        System.out.println("|       Новая заметка       |");
        System.out.println("=============================");
        System.out.println("|Введите текст заметки:     |");
        Note note = new Note(scr.nextLine(),1);
        notepad.addRecords(note);
        System.out.println("=============================");
        System.out.println("|  Заметка успешно создана  |");
        System.out.println("=============================");
        System.out.println();
    }

    private void addReminder(){
        System.out.println("=============================");
        System.out.println("|Введите дату напоминания:  |");
        System.out.println("|(Пример = 12.12.2012 12:12)|");
        String needDate = scr.nextLine();
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        Date date = new Date();
        try {
            date = format.parse(needDate);
            needDate = format.format(date);
        } catch (ParseException ex) {
            System.err.println("Вы ввели какую-то херь!");
            System.out.println("Ваше напоминание сработает изза ващей тупости");
            System.out.println("завтра в 04:00 (по МСК)");
            date = null;
            needDate = null;
        }
        System.out.println("=============================");
        System.out.println("|Введите теск напоминания:  |");
        Reminder remind = new Reminder(scr.nextLine(), needDate, 3);
        notepad.addRecords(remind);
        System.out.println("=============================");
        System.out.println("|Напоминание успешно создано|");
        System.out.println("=============================");
        System.out.println();
    }

    private void removeReminder() {
        printAllReminders();
        itsTrue = true;
        while(itsTrue){
            System.out.println("=============================");
            System.out.println("|Введите ID напоминания:    |");
            String idString = scr.nextLine();
            long id = 0;
            try {
                id = Long.parseLong(idString);
            } catch (NumberFormatException e) {
            }
            if (id>100000 && id<120999){
                if(notepad.getRecordById(id)!=null){
                    notepad.removeRecords(id);
                    System.out.println("                             НАПОМИНАНИЯ");
                    printAllReminders();
                    System.out.println("=============================");
                    System.out.println("|  Запись успешно удалена!  |");
                    System.out.println("=============================");
                    System.out.println();
                    itsTrue = false;
                    return;
                }else if(notepad.getRecordById(id)==null){
                    System.err.println("Нет такого ID!");
                    itsTrue = true;
                }
            }else if(idString.length()!=5){
                System.err.println("Попробуй нормально ввести!");
                itsTrue = true;
            }else if(idString.isEmpty()){
                System.err.println("Попробуй нормально ввести!");
                itsTrue = true;
            }else if(idString.equals(" ")){
                System.err.println("Попробуй нормально ввести!");
                itsTrue = true;
            }
            itsTrue = true;
        }
    }

    private void printAllNotes() {
        System.out.println("=====================================================================");
        System.out.println("|  id  | |      Data      | |                 Messege               |");
        System.out.println("=====================================================================");
        Set<Note> set = notepad.getNotes();
        if(notepad.getNotes().isEmpty()){
            System.out.println("                        ЗАМЕТОК НЕТ");
        }
        for (Note note : set){
            System.out.println(note);
        }
        System.out.println("=====================================================================");
        System.out.println();
    }

    private void printAllReminders() {
        System.out.println("=====================================================================");
        System.out.println("|  id  | |      Data      | |      Messege      | |  Reminder Data  |");
        System.out.println("=====================================================================");
        Set<Reminder> set = notepad.getReminders();
        if(notepad.getReminders().isEmpty()){
            System.out.println("                        НАПОМИНАНИЙ НЕТ");
        }
        for (Reminder reminder : set){
            System.out.println(reminder);
        }
        System.out.println("=====================================================================");
        System.out.println();
    }
}
