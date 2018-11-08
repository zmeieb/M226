package bankschalter;

public class Transfer {

	public static Boolean TransferMoney(Konto payKonto, Konto recKonto, double amount) {
		if(payKonto.withdraw(amount)) {
			recKonto.deposit(amount);
			return true;
		}else {
			return false;
		}
	}
}
