package notenverwaltung;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddFach extends JFrame {

	private JPanel contentPane;
	private JTextField Fachfield;

	/**
	 * Launch the application.
	 */
	public static void InitWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddFach frame = new AddFach();
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
	public AddFach() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Hinzufügen");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!Fachfield.getText().equals("")) {
					SqlManager.AddFach(Fachfield.getText());
					JOptionPane.showMessageDialog(contentPane,
						    "Erfolgreich abgespeichert",
						    "Erfolgreich", JOptionPane.OK_CANCEL_OPTION);
				}
			}
		});
		btnNewButton.setBounds(171, 143, 150, 23);
		contentPane.add(btnNewButton);
		JLabel fachlabel = new JLabel("Fachname:");
		fachlabel.setBounds(10, 84, 100, 20);
		contentPane.add(fachlabel);
		Fachfield = new JTextField();
		Fachfield.setBounds(120, 84, 240, 20);
		contentPane.add(Fachfield);
		Fachfield.setColumns(10);
	}
}
