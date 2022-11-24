package hu.domparse.f58kq8;

import java.io.File;
import java.io.IOException;

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

public class DomReadF58KQ8 {

	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException, TransformerException {
		//xml f�jl megnyit�sa ahonnan beolvassuk az adatokat
		File xmlFile = new File("XMLF58KQ8.xml");
		
		//dokumentum l�trehoz�sa
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = factory.newDocumentBuilder();
		
		//dokumentum l�trehoz�sa a beolvasott f�jlb�l, majd annak a normaliz�l�s�a
		Document document = dBuilder.parse(xmlFile);		
		document.getDocumentElement().normalize();
		
		System.out.println("Root element: " + document.getDocumentElement().getNodeName());
		
		//beolvas� met�dusok megh�v�sa
		getRendl�s(document);
		
		getMegrendel�(document);
		
		getFizet�s(document);
		
		getKapcsolo(document);
		
		get�telek(document);
		
		getAkci�(document);
		
		 //a m�dos�tott adatok ki�r�sa txt f�jlba f�jlba
        File modFile = new File("XMLF58KQ8.txt");
        
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();

        DOMSource source = new DOMSource(document);   
        
        StreamResult resultModFile = new StreamResult(modFile);        
        transformer.transform(source, resultModFile );
		
		
	}
	
	public static void getRendl�s(Document doc) {
		NodeList nList = doc.getElementsByTagName("rendel�s");
		
		System.out.println("\nMegrendel�sek:\n---------------------");
		
		for (int i = 0; i < nList.getLength(); i++) {
			
			Node nNode = nList.item(i);
			
			System.out.println("\nCurrent Element: " + nNode.getNodeName());
			
			if (nNode.getNodeType()==Node.ELEMENT_NODE) {
				
				Element elem = (Element) nNode;
				String rid = elem.getAttribute("RID");
				String mid = elem.getAttribute("MID");
				String fid = elem.getAttribute("FID");
				
				Node node1 = elem.getElementsByTagName("d�tum").item(0);
				String node1Text = node1.getTextContent();
				
				Node node2 = elem.getElementsByTagName("kisz�ll�t�si_c�m").item(0);
				String node2Text = node2.getTextContent();
				
				Node node3 = elem.getElementsByTagName("�sszeg").item(0);
				String node3Text = node3.getTextContent();	
				
				System.out.println("Rendel�s id: " + rid);
				System.out.println("Megrendel� id: " + mid);
				System.out.println("Fizet�s id: " + fid);
				System.out.println("D�tum: " + node1Text);
				System.out.println("Kisz�ll�t�si c�m: " + node2Text);
				System.out.println("�sszeg: " + node3Text);
			}
			
		}
	}	
	
	public static void getMegrendel�(Document doc) {
		NodeList nList = doc.getElementsByTagName("megrendel�");
		
		System.out.println("\nMegrendel�k:\n---------------------");
		
		for (int i = 0; i < nList.getLength(); i++) {
			
			Node nNode = nList.item(i);
			
			System.out.println("\nCurrent Element: " + nNode.getNodeName());
			
			if (nNode.getNodeType()==Node.ELEMENT_NODE) {
				
				Element elem = (Element) nNode;
				String mid = elem.getAttribute("MID");
				
				Node node1 = elem.getElementsByTagName("visszat�r�_vend�g").item(0);
				String node1Text = node1.getTextContent();
				
				Node node2 = elem.getElementsByTagName("telefonsz�m").item(0);
				String node2Text = node2.getTextContent();
				
				Node node3 = elem.getElementsByTagName("n�v").item(0);
				String node3Text = node3.getTextContent();	
				
				System.out.println("Megrendel� id: " + mid);
				System.out.println("Visszat�r� vend�g: " + node1Text);
				System.out.println("Telefonsz�m: " + node2Text);
				System.out.println("N�v: " + node3Text);
			}
			
		}
	}	
	
	public static void getFizet�s(Document doc) {
		NodeList nList = doc.getElementsByTagName("fizet�s");
		
		System.out.println("\nFizet�sek:\n---------------------");
		
		for (int i = 0; i < nList.getLength(); i++) {
			
			Node nNode = nList.item(i);
			
			System.out.println("\nCurrent Element: " + nNode.getNodeName());
			
			if (nNode.getNodeType()==Node.ELEMENT_NODE) {
				
				Element elem = (Element) nNode;
				String fid = elem.getAttribute("FID");
				
				Node node1 = elem.getElementsByTagName("�tvitel_ideje").item(0);
				String node1Text = node1.getTextContent();
				
				Node node2 = elem.getElementsByTagName("kupon").item(0);
				String node2Text = node2.getTextContent();
				
				Node node3 = elem.getElementsByTagName("fizet�s_m�dja").item(0);
				String node3Text = node3.getTextContent();	
				
				System.out.println("Fizet�s id: " + fid);
				System.out.println("�tvitel ideje: " + node1Text);
				System.out.println("Kupon: " + node2Text);
				System.out.println("Fizet�s m�dja: " + node3Text);
			}
			
		}
	}
	
	public static void getKapcsolo(Document doc) {
		NodeList nList = doc.getElementsByTagName("rendelt");
		
		System.out.println("\nMegrendelt �telek kapcsol�i:\n---------------------");
		
		for (int i = 0; i < nList.getLength(); i++) {
			
			Node nNode = nList.item(i);
			
			System.out.println("\nCurrent Element: " + nNode.getNodeName());
			
			if (nNode.getNodeType()==Node.ELEMENT_NODE) {
				
				Element elem = (Element) nNode;
				String rid = elem.getAttribute("RID");
				String eid = elem.getAttribute("EID");
				
				Node node1 = elem.getElementsByTagName("mennyis�g").item(0);
				String node1Text = node1.getTextContent();
				
				System.out.println("Rendel�s id: " + rid);
				System.out.println("�tel id: " + eid);
				System.out.println("Mennyis�g: " + node1Text);
			}
			
		}
	}
	
	public static void get�telek(Document doc) {
		NodeList nList = doc.getElementsByTagName("�tel");
		
		System.out.println("\n�telek:\n---------------------");
		
		for (int i = 0; i < nList.getLength(); i++) {
			
			Node nNode = nList.item(i);
			
			System.out.println("\nCurrent Element: " + nNode.getNodeName());
			
			if (nNode.getNodeType()==Node.ELEMENT_NODE) {
				
				Element elem = (Element) nNode;
				String eid = elem.getAttribute("EID");
				
				Node node1 = elem.getElementsByTagName("n�v").item(0);
				String node1Text = node1.getTextContent();
				
				Node node2 = elem.getElementsByTagName("�r").item(0);
				String node2Text = node2.getTextContent();
				
				
				
				
				
				System.out.println("�telek id: " + eid);
				System.out.println("N�v: " + node1Text);
				System.out.println("�r: " + node2Text);
				
				int counter = 0;
				
				while (elem.getElementsByTagName("allerg�n").item(counter)!=null) {
					Node node3 = elem.getElementsByTagName("allerg�n").item(counter);
					String node3Text = node3.getTextContent();	
					System.out.println("Allerg�n: " + node3Text);
					counter++;
				}
				
				
				Node node4 = elem.getElementsByTagName("t�pus").item(0);
				String node4Text = node4.getTextContent();	
				
				System.out.println("T�pus: " + node4Text);
			}
			
		}
	}
	
	public static void getAkci�(Document doc) {
		NodeList nList = doc.getElementsByTagName("akci�");
		
		System.out.println("\nAkci�k:\n---------------------");
		
		for (int i = 0; i < nList.getLength(); i++) {
			
			Node nNode = nList.item(i);
			
			System.out.println("\nCurrent Element: " + nNode.getNodeName());
			
			if (nNode.getNodeType()==Node.ELEMENT_NODE) {
				
				Element elem = (Element) nNode;
				String aid = elem.getAttribute("AID");
				String eid = elem.getAttribute("EID");
				
				Node node1 = elem.getElementsByTagName("kezdete").item(0);
				String node1Text = node1.getTextContent();
				
				Node node2 = elem.getElementsByTagName("v�ge").item(0);
				String node2Text = node2.getTextContent();
								
				Node node3 = elem.getElementsByTagName("le�raz�s").item(0);
				String node3Text = node3.getTextContent();	
				
				System.out.println("Akci� id: " + aid);
				System.out.println("�tel id: " + eid);
				System.out.println("Kezdete: " + node1Text);
				System.out.println("V�ge: " + node2Text);
				System.out.println("Le�raz�s: " + node3Text);
			}
			
		}
	}
}
