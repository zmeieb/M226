package notenverwaltung;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddNote extends JFrame {

	private JPanel contentPane;
	private JTextField gewichtungField;

	/**
	 * Launch the application.
	 */
	public static void InitWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddNote frame = new AddNote();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddNote() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JComboBox<String> choice = new JComboBox<String>();
		for(Fach fach : SqlManager.LoadFaecher()) {
			choice.addItem(fach.getFachname());
		}
		contentPane.add(choice);
		choice.setBounds(10,20,200,20);
		JLabel gewichtungLabel = new JLabel("Gewichtung:");
		gewichtungLabel.setBounds(10,84,100,20);
		contentPane.add(gewichtungLabel);
		gewichtungField= new JTextField();
		gewichtungField.setBounds(96, 84, 100, 20);
		contentPane.add(gewichtungField);
		JLabel notenLabel = new JLabel("Note:");
		notenLabel.setBounds(10,50,50,20);
		contentPane.add(notenLabel);
		JTextField NotenField = new JTextField();
		NotenField.setBounds(96, 50, 100, 20);
		contentPane.add(NotenField);
		
		
		JButton btnNewButton = new JButton("Hinzufügen");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int gewichtung = Integer.parseInt(gewichtungField.getText());
					float note = Float.parseFloat(NotenField.getText());
					SqlManager.AddNote(Fach.getFachIDFromFachname(choice.getSelectedItem().toString()),
							gewichtung, note);
					JOptionPane.showMessageDialog(contentPane,
						    "Erfolgreich abgespeichert",
						    "Erfolgreich", JOptionPane.OK_CANCEL_OPTION);
				}catch(NumberFormatException ex) {
					JOptionPane.showMessageDialog(contentPane,
						    "ungültige Eingabe",
						    "Fehler", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton.setBounds(171, 143, 89, 23);
		contentPane.add(btnNewButton);
		
	}
}
