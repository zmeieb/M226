package bankschalter;

public class Konto {
	private String kontoNr = "";
	
	public String getKontoNr() {
		return kontoNr;
	}

	private double saldo = 0.0;
	private String ownerLastname = "";
	private String ownerFirstname = "";
	
	public Konto (String lastname, String firstname) {
		ownerLastname= lastname;
		ownerFirstname = firstname;
		kontoNr = initKontoNr();
	}
	
	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public String getOwnerLastname() {
		return ownerLastname;
	}

	public void setOwnerLastname(String ownerLastname) {
		this.ownerLastname = ownerLastname;
	}

	public String getOwnerFirstname() {
		return ownerFirstname;
	}

	public void setOwnerFirstname(String ownerFirstname) {
		this.ownerFirstname = ownerFirstname;
	}

	public void setKontoNr(String kontoNr) {
		this.kontoNr = kontoNr;
	}

	public boolean withdraw(double amount) {
		boolean hasEnoughSaldo = true;
		
		if(saldo-amount>0) {
			saldo -=amount;
		}else {
			System.out.println("nicht genug Saldo um " + amount + "abheben") ;
			hasEnoughSaldo = false;
		}
		
		
		return hasEnoughSaldo;
	}
	
	public void deposit(double amount) {
		
		saldo += amount;
		
	}
	
	public void printStatus() {
		System.out.println("Aktueller Status:");
		System.out.println("Kontonummer: " + kontoNr);
		System.out.println("Inhaber Vorname: " + ownerFirstname);
		System.out.println("Inhaber Nachname: " + ownerLastname);
		System.out.println("Saldo: " + saldo);
	}
	
	private String initKontoNr() {
		int random;
		String tempKontoNr = "CH";
		for(int i = 0; i<19; i++) {
			random = (int)(Math.random()*10);
			tempKontoNr += random;
		}
		return tempKontoNr;
	}
}
