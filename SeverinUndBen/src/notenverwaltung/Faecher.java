package notenverwaltung;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Faecher extends JFrame {
	private ArrayList<Fach> faecher;
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
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 600, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		faecher = SqlManager.LoadFaecher();
		JButton btnFachHinzufgen = new JButton("Fach hinzuf\u00FCgen");
		btnFachHinzufgen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddFach.InitWindow();
			}
		});
		Object [][] content = new Object[faecher.size()][2];
		for(int i = 0; i<faecher.size();i++) {
			content[i][0] = faecher.get(i).getFachID();
			content[i][1] = faecher.get(i).getFachname();
		}
		Object[] columns = { "ID", "Fachname"};
		btnFachHinzufgen.setBounds(350, 44, 200, 23);
		contentPane.add(btnFachHinzufgen);
		ArrayList<String> faecherStr = new ArrayList<String>();
		for(Fach fach :faecher){
			faecherStr.add(fach.getFachID() + " - " + fach.getFachname());
		}
		JTable table = new JTable(content, columns);
		table.setBounds(30, 35, 291, 132);
		contentPane.add(table);
	}
}
