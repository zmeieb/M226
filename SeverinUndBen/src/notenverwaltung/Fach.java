package notenverwaltung;

public class Fach {
	public int getFachID() {
		return FachID;
	}
	public String getFachname() {
		return Fachname;
	}
	private int FachID;
	private String Fachname;
	
	public Fach(int FachID, String Fachname) {
		this.FachID = FachID;
		this.Fachname = Fachname;
	}
	
}
