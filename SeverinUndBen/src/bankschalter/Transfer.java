package bankschalter;

public class Transfer {

	public static void TransferMoney(Konto payKonto, Konto recKonto, double amount) {
		if(payKonto.withdraw(amount)) {
			recKonto.deposit(amount);
			System.out.println("Betrag: "+ amount + " erfolgreich überwiesen");
		}else {
			System.out.println("Konto: " + payKonto.getKontoNr() + " verfügt über zu wenig Saldo");
		}
	}
}
