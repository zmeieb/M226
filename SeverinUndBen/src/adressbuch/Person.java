package adressbuch;

public class Person extends Kontakt{
	private String vorname;
	private String nachname;
	private String alter;
	
	public String getVorname() {
		return vorname;
	}
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	public String getNachname() {
		return nachname;
	}
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}
	public String getAlter() {
		return alter;
	}
	public void setAlter(String alter) {
		this.alter = alter;
	}
	public boolean matches(String string) {
		// TODO Auto-generated method stub
		return false;
	}
}
