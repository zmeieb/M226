package adressbuch;

public class Person {
	private String vorname;
	private String nachname;
	private String alter;
	private String telefonnummer;
	private String geschlecht;
	private String email;
	private String strasse;
	private String plz;
	private String Ort;
	
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
		return false;
	}
	public String getTelefonnummer() {
		return telefonnummer;
	}
	public void setTelefonnummer(String telefonnummer) {
		this.telefonnummer = telefonnummer;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getStrasse() {
		return strasse;
	}
	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}
	public String getPlz() {
		return plz;
	}
	public void setPlz(String plz) {
		this.plz = plz;
	}
	public String getGeschlecht() {
		return geschlecht;
	}
	public void setGeschlecht(String geschlecht) {
		this.geschlecht = geschlecht;
	}
	public String getOrt() {
		return Ort;
	}
	public void setOrt(String ort) {
		Ort = ort;
	}
}
