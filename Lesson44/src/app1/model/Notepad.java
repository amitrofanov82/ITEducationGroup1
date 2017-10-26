package app1.model;

import java.io.BufferedReader;
import java.io.File;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Notepad {
    File notepadFile;
    List<String> noteList;
    
    public Notepad(File f) {
        notepadFile=f;
        noteList=new ArrayList<String>();
    }
    
    public void add(String s, NoteEnum noteType) throws IOException {
        PrintWriter wr=null;
        try {
            wr = new PrintWriter(new FileWriter(notepadFile, true));
            String toSave = null;
            toSave =
                    "" + noteType.getNoteType() + ":" + Calendar.getInstance().getTime() +
                    ":" + s;
            wr.println(toSave);
            wr.flush();
        } finally {
            wr.close();
        }
    }
    
    public List<String> read(NoteEnum noteType) throws FileNotFoundException,
                                                         IOException {
        BufferedReader reader=null;
        try {
            noteList.clear();
            reader = new BufferedReader(new FileReader(notepadFile));
            String tempString = null;
            while (reader.ready()){
                tempString=reader.readLine();
                if (tempString.substring(0, 3).equals(noteType.getNoteType()))
                    noteList.add(tempString);
            }
            return noteList;
        } finally {
            reader.close();
            
        }
    }
    
}
