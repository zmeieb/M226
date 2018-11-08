package bankschalter;


import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class JUnitTest {

	@Test
	void InitXMLFile() {
		ArrayList<Konto> kontoList = new ArrayList<Konto>();
		Konto newKonto = new Konto("123456","Severin", "Nauer", 0.0, "sevenaue2", "Password123");
		kontoList.add(newKonto);
		XmlManager manager = new XmlManager();
		manager.setKontoList(kontoList);
		manager.CreateXml();
	}
	
	@Test
	void ReadXmlFile() {
		XmlManager manager = new XmlManager();
		manager.LoadKontos();
	}

}
