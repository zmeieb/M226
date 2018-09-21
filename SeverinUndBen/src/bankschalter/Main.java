package bankschalter;

public class Main {

	public static void main(String[] args) {
		Konto BenKonto = new Konto("Meier", "Ben");
		Konto SeverinKonto = new Konto("Mauer", "Stephan");
		Konto MusterKonto = new Konto("Muster", "Hans");
		Konto TimKonto	= new Konto("Mazhari", "Tim");
		Konto LucaKonto = new Konto("Schweizer", "Luca");
		
		BenKonto.deposit(1500.75);
		MusterKonto.deposit(465.75);
		LucaKonto.deposit(566.45);
		
		Transfer.TransferMoney(BenKonto, SeverinKonto, 845.25);
		Transfer.TransferMoney(MusterKonto, TimKonto, 2.50);
		Transfer.TransferMoney(LucaKonto, MusterKonto, 20);
		Transfer.TransferMoney(SeverinKonto, TimKonto, 13.25);
		
		BenKonto.printStatus();
		SeverinKonto.printStatus();
		MusterKonto.printStatus();
		LucaKonto.printStatus();
		TimKonto.printStatus();
	}

}
