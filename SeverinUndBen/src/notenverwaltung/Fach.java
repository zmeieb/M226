package notenverwaltung;

import java.util.ArrayList;

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
	
	public static int getFachIDFromFachname(String fachname) {
		ArrayList<Fach> faecher = SqlManager.LoadFaecher();
		for (Fach fach : faecher) {
			if(fach.getFachname().equals(fachname)) {
				return fach.getFachID();
			}
		}
		return 0;
	}
}
