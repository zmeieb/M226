package adressbuch;

import java.util.ArrayList;
import java.util.Scanner;

public class Main extends Erstellen{
	public static void main(String [] args) {
		ArrayList<Person> listPerson = new ArrayList<>();
		boolean fertig = true;
		Scanner scan = new Scanner(System.in);
		System.out.println("Erstellen wir zu Beginn einen Kontakt.\n");
		Erstellen erstelle = new Erstellen();
		listPerson.add(erstelle.erstelleKontakt());
		System.out.println("Erfolgreich erstellt! \n\n");
		while(fertig) {
			System.out.println("\n Was m�chten sie als n�chstes tun?\n"
					+ "1. Alle Kontakte anzeigen lassen.\n"
					+ "2. Einen Kontakt mit seinen Details anzeigen.\n"
					+ "3. Einen neuen Kontakt erstellen.\n"
					+ "4. Einen Kontakt bearbeiten.\n"
					+ "5. Einen Kontakt l�schen.\n"
					+ "6. Das Programm beenden.\n");
			String nextStep = scan.nextLine();
			
			if (nextStep.equals("1")) {
				System.out.println("\n\n");
				erstelle.showAllContacts(listPerson);
			}
			else if (nextStep.equals("2")) {
				System.out.println("\n\n");
				System.out.println("Geben sie den Vornamen des Kontaktes ein: ");
				String namen = scan.nextLine();
				erstelle.zeigeKontaktDetails(namen, listPerson);
			}
			else if (nextStep.equals("3")) {
				System.out.println("\n\n");
				Person p = new Person();
				p = erstelle.erstelleKontakt();
				listPerson.add(p);
				System.out.println("Kontakt erfolgreich erstellt! \n");
			}
			else if (nextStep.equals("4")) {
				System.out.println("\n\n");
				System.out.println("Geben sie den Vornamen des Kontaktes ein, den sie bearbeiten m�chten: ");
				String namen = scan.nextLine();
				listPerson.add(erstelle.bearbeiteKontakt(namen, listPerson));
				System.out.println("Kontakt erfolgreich bearbeitet! \n");
			}
			else if (nextStep.equals("5")) {
				System.out.println("\n\n");
				System.out.println("Geben sie den Vornamen des Kontaktes ein, den sie l�schen m�chten: ");
				String namen = scan.nextLine();
				erstelle.l�scheKontakt(namen, listPerson);
				System.out.println("Kontakt erfolgreich gel�scht! \n");
			}
			else if (nextStep.equals("6")) {
				System.out.println("\n\n");
				System.out.println("Ok, Good Bye");
				System.exit(1);
			}
			else {
				throw new RuntimeException("User war nicht in der Lage eine Zahl von 1-6 einzugeben!"
						+ " \n User gab stattdessen '" + nextStep + "' ein!");
			}
			
		}
	}
}
