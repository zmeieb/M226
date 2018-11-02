package adressbuch;

import java.util.ArrayList;

public interface KontaktMethoden {
	
	public Kontakt erstelleKontakt();
	
	public Kontakt bearbeiteKontakt(String vorname, ArrayList<Person> listPersonen);
	
	public void löscheKontakt(String vorname, ArrayList<Person> listPersonen);
	
	public void zeigeKontaktDetails(String vorname, ArrayList<Person> listPersonen);
	
	public void showAllContacts(ArrayList<Person> listPerson);
}
