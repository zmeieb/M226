package adressbuch;

import java.util.ArrayList;
import java.util.Scanner;

public class Erstellen {
	private ArrayList<Person> ListPerson = new ArrayList<>();
	
	private Scanner scan;


	
	protected void erstelleKontakt() {
		String vorname;
		String nachname;
		String alter;
		
		Person person = new Person();
		scan = new Scanner(System.in);
		System.out.println("Geben sie den Vornamen des neuen Kontakts ein: ");
		vorname = scan.nextLine();
		person.setVorname(vorname);
		
		scan = new Scanner(System.in);
		System.out.println("Geben sie den Nachnamen des neuen Kontakts ein: ");
		nachname = scan.nextLine();
		person.setNachname(nachname);
		
		scan = new Scanner(System.in);
		System.out.println("Geben sie das Alter des neuen Kontakts ein: ");
		alter = scan.nextLine();
		person.setAlter(alter);	
		
		scan = new Scanner(System.in);
		System.out.println("Geben sie die Telefonnummer des neuen Kontakts ein: ");
		alter = scan.nextLine();
		person.setAlter(alter);	
		
		scan = new Scanner(System.in);
		System.out.println("Geben sie das Alter des neuen Kontakts ein: ");
		alter = scan.nextLine();
		person.setAlter(alter);	
		
		ListPerson.add(person);
	}
	
	protected void löscheKontakt(String vorname) {
		
	}
	
	protected void zeigeKontakte(String name) {
			
		}
	
	protected void zeigeVornameUndNachname() {
		for (Person person : ListPerson) {
			System.out.println(person.getVorname() + person.getNachname() + person.getAlter());
		}
	}
}
