package bankschalter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XmlManager {
	
	private ArrayList<Konto> kontoList;

	public void setKontoList(ArrayList<Konto> kontoList) {
		this.kontoList = kontoList;
	}

	public ArrayList<Konto> getKontoList() {
		return kontoList;
	}

	public void AddKontoToKontoList(Konto konto) {
		kontoList.add(konto);
	}

	public void LoadKontos() {
		ArrayList<Konto> tempkontoList = new ArrayList<Konto>();
		try {
		File fXmlFile = new File("D:\\github\\M226\\SeverinUndBen\\src\\bankschalter\\xml\\Kontos.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;
		dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fXmlFile);
		NodeList nList = doc.getElementsByTagName("Konto");
		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);	
			NodeList childList = nNode.getChildNodes();
			ArrayList<String> childListString = new ArrayList<String>();
			for (int i = 0; i < childList.getLength(); i++) {
				childListString.add(childList.item(i).getFirstChild().getNodeValue());
			}
			Konto tempKonto = new Konto(childList.item(0).getFirstChild().getNodeValue(),childList.item(1).getFirstChild().getNodeValue()
					,childList.item(2).getFirstChild().getNodeValue(),Double.parseDouble(childList.item(3).getFirstChild().getNodeValue()),
					childList.item(4).getFirstChild().getNodeValue(),childList.item(5).getFirstChild().getNodeValue());	
			tempkontoList.add(tempKonto);
		}
		}catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setKontoList(tempkontoList);
	}
	
	public void CreateXml() {
		try {
			DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder;
			documentBuilder = documentFactory.newDocumentBuilder();
			Document document = documentBuilder.newDocument();
	
			Element root = document.createElement("Kontos");
			document.appendChild(root);
			
			for(Konto konto:kontoList) {
				Element kontoElement = document.createElement("Konto");
				root.appendChild(kontoElement); 
				
				Element kontoNrElement = document.createElement("KontoNr");
				kontoNrElement.appendChild(document.createTextNode(konto.getKontoNr()));
				kontoElement.appendChild(kontoNrElement);
				
				Element firstname = document.createElement("Firstname");
				firstname.appendChild(document.createTextNode(konto.getOwnerFirstname()));
				kontoElement.appendChild(firstname);
				
				Element lastname = document.createElement("Lastname");
				lastname.appendChild(document.createTextNode(konto.getOwnerLastname()));
				kontoElement.appendChild(lastname);
				
				Element saldo = document.createElement("Saldo");
				saldo.appendChild(document.createTextNode(String.valueOf(konto.getSaldo())));
				kontoElement.appendChild(saldo);
				
				Element username = document.createElement("Username");
				username.appendChild(document.createTextNode(String.valueOf(konto.getLoginName())));
				kontoElement.appendChild(username);
				Element password = document.createElement("Password");
				password.appendChild(document.createTextNode(String.valueOf(konto.getPassword())));
				kontoElement.appendChild(password);
			}
			
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource domSource = new DOMSource(document);
			StreamResult streamResult = new StreamResult(new File("D:\\github\\M226\\SeverinUndBen\\src\\bankschalter\\xml\\Kontos.xml"));
            transformer.transform(domSource, streamResult);
		} catch (ParserConfigurationException e) {
			System.out.println(e.getMessage());
		}
		catch (TransformerException tfe) {
			System.out.println(tfe.getMessage());
		}
	}
}
