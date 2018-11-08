package bankschalter;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		String input = "";
		Konto ActKonto = null;
		Scanner inputScanner = new Scanner(System.in);
		Boolean isCreated = false;
		do{
			do{
				showMainMenu();
				input = inputScanner.nextLine();
			}while(!input.equals("1") && !input.equals("2"));
			if(input.equals("1")) {
				do {
					KontoManager kManager = new KontoManager();
					System.out.println("Benutzername eingeben:");
					String username = inputScanner.nextLine();
					System.out.println("Passwort eingeben:");
					String password = inputScanner.nextLine();
					ActKonto = kManager.Login(username, password);
					if(ActKonto == null) {
						System.out.println("Login ungültig");
					}else {
						System.out.println("Login Erfolgreich");
					}
				}while(ActKonto == null);
			}else if(input.equals("2")) {
				do {
					KontoManager kManager = new KontoManager();
					System.out.println("Vorname eingeben:");
					String firstname = inputScanner.nextLine();
					System.out.println("Nachname eingeben:");
					String lastname = inputScanner.nextLine();
					System.out.println("Loginname eingeben:");
					String username = inputScanner.nextLine();
					System.out.println("Passwort eingeben:");
					String password = inputScanner.nextLine();
					isCreated = kManager.createKonto(firstname, lastname, username, password);
				}while(!isCreated);
			}
		}while(isCreated);
		do {
			System.out.println("Konto "+ActKonto.getKontoNr());
			System.out.println("--------------------");
			System.out.println("(1)Abheben");
			System.out.println("(2)Überweisen");
			System.out.println("(3)Kontostatus anzeigen");
			System.out.println("(9)Logout");
			input = inputScanner.nextLine();
			if(input.equals("1")) {
				Boolean IsWithdrawn = false;
				String amountStr = "";
				do{
					System.out.println("Betrag eingeben:");
					System.out.println("(a)abbrechen");
					amountStr = inputScanner.nextLine();
					Double amount = null;
					try {
						amount = Double.parseDouble(amountStr);
					}catch(NumberFormatException e) {
						if(!amountStr.equals("a")) {
							System.out.println("ungültige Eingabe");
						}
					}
					if(amount != null) {
						 if(ActKonto.withdraw(amount)) {
							 IsWithdrawn = true;
							 System.out.println(amount + " abgehoben");
						 }else {
							 IsWithdrawn = false;
							 System.out.println("Nicht genügend Saldo");
						 }
					}
				}while(!IsWithdrawn && !amountStr.equals("a"));
			}else if(input.equals("2")) {
				Boolean IsTransfered = false;
				String chosenKontoStr = "";
				int chosenKonto = -1;
				String amountStr = "";
				Konto receiverKonto = null;
				do{
					System.out.println("Konto auswählen:");
					XmlManager manager = new XmlManager();
					manager.LoadKontos();
					ArrayList<Konto> kontoList = manager.getKontoList();
					int i = 1;
					for(Konto konto : kontoList) {
						System.out.println("("+i+") "+ konto.getKontoNr());
						i++;
					}
					chosenKontoStr = inputScanner.nextLine();
					try {
						chosenKonto = Integer.parseInt(chosenKontoStr);
					}catch(NumberFormatException e) {
						System.out.println("Ungültige Eingabe");
					}
					if(chosenKonto < 0 || chosenKonto > kontoList.size()) {
						System.out.println("Ungültiges Konto gewählt");
					}else {
						receiverKonto = kontoList.get(chosenKonto -1);
					}
					if(receiverKonto != null) {
						System.out.println("Betrag eingeben:");
						System.out.println("(a)abbrechen");
						amountStr = inputScanner.nextLine();
						Double amount = null;
						try {
							amount = Double.parseDouble(amountStr);
						}catch(NumberFormatException e) {
							if(!amountStr.equals("a")) {
								System.out.println("ungültige Eingabe");
							}
						}
						if(amount != null) {
							 if(Transfer.TransferMoney(ActKonto, receiverKonto, amount)) {
								 IsTransfered = true;
								 System.out.println(amount + " abgehoben");
							 }else {
								 IsTransfered = false;
								 System.out.println("Nicht genügend Saldo auf dem Konto");
							 }
						}
					}
				}while(!IsTransfered && !amountStr.equals("a"));
			}else if(input.equals("3")) {
				System.out.println("Kontostatus:");
				System.out.println("--------------------");
				System.out.println("KontoNr: "+ ActKonto.getKontoNr());
				System.out.println("Vorname: "+ ActKonto.getOwnerFirstname());
				System.out.println("Nachname: "+ ActKonto.getOwnerLastname());
				System.out.println("Loginname: "+ ActKonto.getLoginName());
				System.out.println("Saldo: "+ ActKonto.getSaldo());
			}
		}while(!input.equals("9"));
	}

	private static void showMainMenu() {
		System.out.println("Hauptmenü");
		System.out.println("--------------------");
		System.out.println("(1)Login");
		System.out.println("(2)Neues Konto");
	}
	
}
