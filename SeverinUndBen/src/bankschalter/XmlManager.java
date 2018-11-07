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

	public ArrayList<Konto> getKontoList() {
		return kontoList;
	}

	public void setKontoList(ArrayList<Konto> kontoList) {
		this.kontoList = kontoList;
	}

	/*public ArrayList<Konto> GetKontos() {
		try {
		File fXmlFile = new File("Kontos.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;
		dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fXmlFile);
		NodeList nList = doc.getElementsByTagName("staff");
		for (int temp = 0; temp < nList.getLength(); temp++) {
			
			Node nNode = nList.item(temp);
					
			System.out.println("\nCurrent Element :" + nNode.getNodeName());
					
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {

				Element eElement = (Element) nNode;


			}
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
	}*/
	
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
				
			}
			
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource domSource = new DOMSource(document);
			StreamResult streamResult = new StreamResult(new File("C:\\Users\\Severin\\Desktop\\files\\Konto.xml"));
            transformer.transform(domSource, streamResult);
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (TransformerException tfe) {
            tfe.printStackTrace();
		}
	}
}
