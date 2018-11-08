package notenverwaltung;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;

public class Notenuebersicht {

	private JFrame frame;

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
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JButton btnFaecher = new JButton("Faecher");
		btnFaecher.setBounds(309, 38, 89, 23);
		frame.getContentPane().add(btnFaecher);
		ArrayList<Note> notenArrList = SqlManager.LoadNoten();
		ArrayList<String> notenStrArr = new ArrayList<String>();
		for (Note note : notenArrList) {
			notenStrArr.add(note.getNotenID()+ " - "+ note.getFachID()+ " - "+ note.getGewichtung()+ " - " +note.getErhalteneNote() +" - " + note.getBerechneteNote());
		}
		JList<String> list = new JList<String>(notenStrArr.toArray(new String[notenStrArr.size()]));
		list.setBounds(36, 41, 233, 127);
		frame.getContentPane().add(list);
		btnFaecher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			// open a new frame i.e window
			Faecher faecher = new Faecher();
			faecher.InitWindow();
			}
		});
	}
}
