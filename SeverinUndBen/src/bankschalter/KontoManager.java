package bankschalter;

public class KontoManager {
	public Konto Login(String username, String password) {
		XmlManager manager = new XmlManager();
		manager.LoadKontos();
		for(Konto xKonto : manager.getKontoList()) {
			if(username.equals(xKonto.getLoginName())&& password.equals(xKonto.getPassword())) {
				return xKonto;
			}
		}
		return null;
	}
	
	public Boolean createKonto(String firstname, String lastname, String username, String password) {
		XmlManager manager = new XmlManager();
		manager.LoadKontos();
		for(Konto xKonto : manager.getKontoList()) {
			if(username.equals(xKonto.getLoginName())) {
				return false;
			}
		}
		Konto newKonto = new Konto(firstname,lastname,username,password);
		manager.AddKontoToKontoList(newKonto);
		manager.CreateXml();
		return true;
	}
}
