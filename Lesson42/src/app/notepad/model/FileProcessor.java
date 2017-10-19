package app.notepad.model;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

import app.notepad.model.records.Record;
import app.notepad.utilits.files.FilesUtilits;

public class FileProcessor {

	


	HashMap<Long, Record> np = new HashMap<Long, Record>();

	public static  boolean chekPathFile(String path) {
		if (new File(path, "notepad.ntpd").exists()) {
			return true;
		} else {
			return false;
		}
	}
	public static boolean fileIsEmpty (String path){
		if (new File(path, "notepad.ntpd").length()>0) {		
			return false;
		} else {
			return true;
		}
	}

	public static HashMap<Long,Record> fileRead(String path) throws IOException {
			FileReader fileReader = new FileReader(path);
			String bufferString = "";
			int intChar;
			while((intChar=fileReader.read())!=-1){
				bufferString +=(char)intChar;
			}
			fileReader.close();
			return FilesUtilits.parseStringInHashMap(bufferString);
	}

	public static void fileWrite(String path,String notepad) throws IOException {
		FileWriter fileWriter = new FileWriter(path, false);
		fileWriter.write(notepad);
		fileWriter.close();
	}
	public static void createFile(String path) throws IOException {
		new File(path,"notepad.ntpd").createNewFile();
	}
}
