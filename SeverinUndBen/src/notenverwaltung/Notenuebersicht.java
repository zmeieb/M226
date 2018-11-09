package notenverwaltung;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Notenuebersicht {

	private JFrame frame;
	private Object[][] content = null;
	JTable table = null;
	JTextField schnitt = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Notenuebersicht window = new Notenuebersicht();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Notenuebersicht() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		table = null;
		frame.setBounds(100, 100, 450, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JButton btnFaecher = new JButton("Faecher");
		btnFaecher.setBounds(10, 300, 189, 23);
		frame.getContentPane().add(btnFaecher);
		JComboBox<String> choice = new JComboBox<String>();
		for(Fach fach : SqlManager.LoadFaecher()) {
			choice.addItem(fach.getFachname());
		}
		content = initTable(choice.getSelectedItem().toString());
		Object[] columns = { "Erhaltene Note", "Gewichtung"};
		choice.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {		    	 
		    	content = initTable(choice.getSelectedItem().toString());
		    	 frame.getContentPane().remove(table);
		    	 frame.getContentPane().repaint();
		    	 table = new JTable(content,columns);
		 	     table.setBounds(10, 100, 233, 127);
		    	 frame.getContentPane().add(table);
		    	 frame.getContentPane().remove(schnitt);
		    	 schnitt = new JTextField("Durchschnitt: "+ getSchnitt(choice.getSelectedItem().toString()));
		    	 schnitt.setBounds(10, 250, 150, 20);
		    	 schnitt.setEnabled(false);
		    	 frame.getContentPane().add(schnitt);
		    }
		});
		choice.setBounds(10, 50, 189, 23);
		schnitt = new JTextField("Durchschnitt: "+ getSchnitt(choice.getSelectedItem().toString()));
		schnitt.setBounds(10, 250, 150, 20);
		schnitt.setEnabled(false);;
		table = new JTable(content,columns);
		table.setBounds(10, 100, 233, 127);
		frame.getContentPane().add(table);
		frame.getContentPane().add(choice);
		frame.getContentPane().add(schnitt);
		btnFaecher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			// open a new frame i.e window
			Faecher.InitWindow();
			}
		});
		JButton btnAddnote = new JButton("Note hinzufügen");
		btnAddnote.setBounds(220, 300, 189, 23);
		frame.getContentPane().add(btnAddnote);
		btnAddnote.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			// open a new frame i.e window
			AddNote.InitWindow();
			}
		});
		
	}
	
	private Object[][] initTable(String fachName){
		ArrayList<Note> selectedNoten = new ArrayList<Note>();

		ArrayList<Note> noten = SqlManager.LoadNoten();
		for(Note note : noten) {
			if(note.getFachName().equals(fachName)) {
				selectedNoten.add(note);
			}
		}
		Object[][] content = new Object[selectedNoten.size()][2];
		for(int i = 0; i<selectedNoten.size(); i++) {
			content[i][0] = selectedNoten.get(i).getErhalteneNote();
			content[i][1] = selectedNoten.get(i).getGewichtung();
		}
		return content;
	}
	
	private String getSchnitt(String fachName) {
		ArrayList<Note> selectedNoten = new ArrayList<Note>();

		ArrayList<Note> noten = SqlManager.LoadNoten();
		for(Note note : noten) {
			if(note.getFachName().equals(fachName)) {
				selectedNoten.add(note);
			}
		}
		
		float schnitt;
		int gesamtGewichtung = 0;
		float gesamtNote = 0;
		for(Note note : selectedNoten) {
			gesamtNote += note.getErhalteneNote()*note.getGewichtung();
			gesamtGewichtung += note.getGewichtung();
		}
		schnitt = gesamtNote / gesamtGewichtung;
		return String.valueOf(schnitt);
	}
}
