package adressbuch;

import java.util.ArrayList;
import java.util.Scanner;

public class Erstellen implements KontaktMethoden {
	private ArrayList<Person> ListPerson = new ArrayList<>();

	private Scanner scan;

	@Override
	public Person erstelleKontakt() {

		Person person = new Person();
		scan = new Scanner(System.in);
		System.out.println("Geben sie den Vornamen des neuen Kontakts ein: ");
		String vorname = scan.nextLine();
		person.setVorname(vorname);

		scan = new Scanner(System.in);
		System.out.println("Geben sie den Nachnamen des neuen Kontakts ein: ");
		String nachname = scan.nextLine();
		person.setNachname(nachname);

		scan = new Scanner(System.in);
		System.out.println("Geben sie das Alter des neuen Kontakts ein: ");
		String alter = scan.nextLine();
		person.setAlter(alter);

		scan = new Scanner(System.in);
		System.out.println("Geben sie die Telefonnummer des neuen Kontakts ein: ");
		String telefonnummer = scan.nextLine();
		person.setTelefonnummer(telefonnummer);

		scan = new Scanner(System.in);
		System.out.println("Geben sie das Geschlecht des neuen Kontakts ein: ");
		String geschlecht = scan.nextLine();
		person.setGeschlecht(geschlecht);

		scan = new Scanner(System.in);
		System.out.println("Geben sie die Email des neuen Kontakts ein: ");
		String email = scan.nextLine();
		person.setEmail(email);

		scan = new Scanner(System.in);
		System.out.println("Geben sie die Strasse mit Hausnummer des neuen Kontakts ein: ");
		String strasse = scan.nextLine();
		person.setStrasse(strasse);

		scan = new Scanner(System.in);
		System.out.println("Geben sie die Postleitzahl des neuen Kontakts ein: ");
		String plz = scan.nextLine();
		person.setPlz(plz);

		scan = new Scanner(System.in);
		System.out.println("Geben sie den Ort des neuen Kontakts ein: ");
		String ort = scan.nextLine();
		person.setOrt(ort);

		return person;
	}

	@Override
	public void löscheKontakt(String vorname, ArrayList<Person> listPerson) {
		for (Person person : listPerson) {
			if (person.getVorname().equals(vorname)) {
				listPerson.remove(person);
				System.out.println("Kontakt wurde erfolgreich gelöscht. ");
			} else {
				System.out.println("Es wurde kein Kontakt mit diesem Vornamen gefunden. ");
			}
		}
	}

	@Override
	public void zeigeKontaktDetails(String vorname, ArrayList<Person> listPerson) {
		for (Person person : listPerson) {
			if (person.getVorname().equals(vorname)) {
				System.out.println("Vorname: " + person.getVorname());
				System.out.println("Nachname: " + person.getNachname());
				System.out.println("Alter: " + person.getAlter());
				System.out.println("Email: " + person.getEmail());
				System.out.println("Telefon Nr.: " + person.getTelefonnummer());
				System.out.println("Geschlecht: " + person.getGeschlecht());
				System.out.println("Strasse: " + person.getStrasse());
				System.out.println("Ort: " + person.getPlz() +" "+ person.getOrt());
			}
		}
	}

	@Override
	public void showAllContacts(ArrayList<Person> listPerson) {
		for (Person person : listPerson) {
			System.out.println(person.getVorname() + " " + person.getNachname());
		}
	}

	@Override
	public Person bearbeiteKontakt(String vorname, ArrayList<Person> listPerson) {
		for (Person person : listPerson) {
			if (person.getVorname().equals(vorname)) {
				listPerson.remove(person);
				System.out.println("Bearbeite Kontakt!");
				return erstelleKontakt();
			} else {
				System.out.println("Es wurde kein Kontakt mit diesem Vornamen gefunden. ");
			}
		}
		return null;
	}

}
