package notenverwaltung;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Faecher extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void InitWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Faecher frame = new Faecher();
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
	public Faecher() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnFachHinzufgen = new JButton("Fach hinzuf\u00FCgen");
		btnFachHinzufgen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddFach addfach = new AddFach();
				addfach.InitWindow();
			}
		});
		btnFachHinzufgen.setBounds(311, 44, 113, 23);
		contentPane.add(btnFachHinzufgen);
		ArrayList<Fach> faecher = SqlManager.LoadFaecher();
		ArrayList<String> faecherStr = new ArrayList<String>();
		for(Fach fach :faecher){
			faecherStr.add(fach.getFachID() + " - " + fach.getFachname());
		}
		JList<String> list = new JList<String>(faecherStr.toArray(new String[faecherStr.size()]));
		list.setBounds(30, 35, 291, 132);
		contentPane.add(list);
	}
}
