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
		System.out.println("Geben sie das Email des neuen Kontakts ein: ");
		String email = scan.nextLine();
		person.setEmail(email);

		scan = new Scanner(System.in);
		System.out.println("Geben sie das Adresse des neuen Kontakts ein: ");
		String adresse = scan.nextLine();
		person.setAdresse(adresse);

		scan = new Scanner(System.in);
		System.out.println("Geben sie das Postleitzahl des neuen Kontakts ein: ");
		String plz = scan.nextLine();
		person.setPlz(plz);

		scan = new Scanner(System.in);
		System.out.println("Geben sie den Ort des neuen Kontakts ein: ");
		String ort = scan.nextLine();
		person.setOrt(ort);

		return person;
	}

	@Override
	public void l�scheKontakt(String vorname, ArrayList<Person> listPersonen) {
		for (Person person : listPersonen) {
			if (person.getVorname().equals(vorname)) {
				listPersonen.remove(person);
				System.out.println("Kontakt wurde erfolgreich gel�scht. ");
			} else {
				System.out.println("Es wurde kein Kontakt mit diesem Vornamen gefunden. ");
			}
		}
	}

	@Override
	public void zeigeKontaktDetails(String vorname, ArrayList<Person> listPersonen) {
		for (Person person : ListPerson) {
			if (person.getVorname().equals(vorname)) {
				System.out.println(person.getVorname());
				System.out.println(person.getNachname());
				System.out.println(person.getAlter());
				System.out.println(person.getEmail());
				System.out.println(person.getTelefonnummer());
				System.out.println(person.getGeschlecht());
				System.out.println(person.getPlz() + person.getOrt());
			}
		}
	}

	@Override
	public void showAllContacts(ArrayList<Person> listPerson) {
		for (Person person : ListPerson) {
			System.out.println(person.getVorname() + person.getNachname());
		}
	}

	@Override
	public Person bearbeiteKontakt(String vorname, ArrayList<Person> listPersonen) {
		zeigeKontaktDetails(vorname, listPersonen);
		l�scheKontakt(vorname, listPersonen);
		return erstelleKontakt();
	}

}
