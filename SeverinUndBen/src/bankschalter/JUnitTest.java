package bankschalter;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class JUnitTest {

	@Test
	void InitXMLFile() {
		ArrayList<Konto> kontoList = new ArrayList<Konto>();
		Konto newKonto = new Konto("Severin","Nauer");
		kontoList.add(newKonto);
		XmlManager manager = new XmlManager();
		manager.setKontoList(kontoList);
		manager.CreateXml();
	}

}
