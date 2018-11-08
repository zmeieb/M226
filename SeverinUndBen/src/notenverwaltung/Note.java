package notenverwaltung;

public class Note {
	public int getNotenID() {
		return notenID;
	}
	public int getFachID() {
		return fachID;
	}
	public int getGewichtung() {
		return gewichtung;
	}
	public float getErhalteneNote() {
		return erhalteneNote;
	}
	
	private float erhalteneNote;
	private int notenID;
	private int fachID;
	private int gewichtung;
	private float berechneteNote;
	
	public float getBerechneteNote() {
		return berechneteNote;
	}
	public Note(int notenID, int fachID,int gewichtung,float erhalteneNote) {
		this.notenID = notenID;
		this.fachID = fachID;
		this.gewichtung = gewichtung;
		this.erhalteneNote = erhalteneNote;
		this.berechneteNote = (erhalteneNote/100)*gewichtung;
	}
	
}
