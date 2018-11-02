package adressbuch;

import java.util.ArrayList;
import java.util.Scanner;

public class Main extends Erstellen{
	public static void main(String [] args) {
		ArrayList<Person> listPerson = new ArrayList<>();
		boolean fertig = true;
		Scanner scan = new Scanner(System.in);
		Erstellen erstelle = new Erstellen();
		erstelle.erstelleKontakt();
		erstelle.showAllContacts(listPerson);
		while(fertig) {
			System.out.println("\n\n Was möchten sie als nächstes tun?\n"
					+ "1. Alle Kontakte anzeigen lassen.\n "
					+ "2. Einen Kontakt mit seinen Details anzeigen.\n"
					+ "3. Einen neuen Kontakt erstellen.\n"
					+ "4. Einen Kontakt bearbeiten.\n"
					+ "5. Einen Kontakt löschen.\n"
					+ "6. Das Programm beenden.\n");
			String nextStep = scan.nextLine();
			
			if (nextStep.equals("1")) {
				erstelle.showAllContacts(listPerson);
			}
			else if (nextStep.equals("2")) {
				System.out.println("Geben sie den Vornamen des Kontaktes ein: ");
				String namen = scan.nextLine();
				erstelle.zeigeKontaktDetails(namen, listPerson);
			}
			else if (nextStep.equals("3")) {
				erstelle.erstelleKontakt();
			}
			else if (nextStep.equals("4")) {
				System.out.println("Geben sie den Vornamen des Kontaktes ein, den sie bearbeiten möchten: ");
				String namen = scan.nextLine();
				erstelle.bearbeiteKontakt(namen, listPerson);
			}
			else if (nextStep.equals("5")) {
				System.out.println("Geben sie den Vornamen des Kontaktes ein, den sie löschen möchten: ");
				String namen = scan.nextLine();
				erstelle.löscheKontakt(namen, listPerson);
			}
			else if (nextStep.equals("6")) {
				System.out.println("Ok, Good Bye");
				System.exit(1);
			}
			scan.close();
			
		}
	}
}
