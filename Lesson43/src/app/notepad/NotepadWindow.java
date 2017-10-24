package app.notepad;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import app.notepad.model.Notepad;

public class NotepadWindow extends JFrame {
	
	//NotepadWindowModel model;
	Notepad notepadModel;
	
	JButton showRemindersBt;
	JButton showNotesBt;
	JButton addReminderBt;
	JButton addNoteBt;
	
	JTextField inputField;
	JTextArea outputArea;
	
	private NotepadWindow(){
		//1. Задать параметры создаваемого окна
		     //1.1 Размер, чтобы закрывалось по крестику.
		     //заголовок. Задать режим расположение по координатам
			 //установить запрет изменения размера
		System.out.println(this.getSize().getHeight());
		this.setSize(850, 650);
		System.out.println(this.getSize().getHeight());
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setTitle("Крутой блокнот");
		this.setResizable(false);
		this.setLayout(null);
		
		//2. Задать параметры кнопок (размер, надпись, 
		//   расположение в контейнере) по одной.
		showNotesBt = new JButton();
		showNotesBt.setSize(80, 40);
		showNotesBt.setLocation(800-80, 600-40);
		showNotesBt.setText("Покажи записи");
		//showNotesBt.getFont(). кури интсрукцию
		
		addNoteBt = new JButton();
		addNoteBt.setSize(80, 40);
		addNoteBt.setLocation(800-80, 600-40-40-10);
		addNoteBt.setText("Добавь запись");

		//3. инпут филд задать размеры, положение
		inputField = new JTextField();
		inputField.setSize(700, 40);
		inputField.setLocation(50, 600-40);
		
		//4. Область вывода задать размеры, положение, запрет ввода
		outputArea = new JTextArea();
		outputArea.setSize(700, 500);
		outputArea.setLocation(50, 10);
		
		//5. добавить их в окно методом адд у фрэйма
		this.add(showNotesBt);
		this.add(addNoteBt);
		this.add(inputField);
		this.add(outputArea);
		
		//6. Привязать листенеры к кнопкам
		addNoteBt.addMouseListener( new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				notepadModel.addNewNote(inputField.getText());
				new JFrame("Win2").setVisible(true);;
			}
		});
		
		showNotesBt.addMouseListener( new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String notes = notepadModel.showAllNotes();
				outputArea.setText(notes);
			}
		});
	}
	
	public NotepadWindow(Notepad model) {
		this();
		this.notepadModel = model;
	}
	
	public void startNotepadUI() {
		this.setVisible(true);
	}
	
	
	
}
