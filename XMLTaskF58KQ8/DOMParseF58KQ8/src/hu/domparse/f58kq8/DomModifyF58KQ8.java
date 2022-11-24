package hu.domparse.f58kq8;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DomModifyF58KQ8 {

	public static void main(String[] args) {
		try {
			//xml f�jl megnyit�sa ahonnan beolvassuk az adatokat
			File file = new File("XMLF58KQ8.xml");
	
			//dokumentum l�trehoz�sa a beolvasott f�jlb�l
	        DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
	        Document document = documentBuilder.parse(file);
	        
	      //dokumentum normaliz�l�s�a
	        document.getDocumentElement().normalize();
	        
	        //1. m�dos�t�s - a 'sz�p-k�rty�val' t�rt�n� fizet�sek �t�r�sa 'bankk�rty�ra':
	        NodeList fizetesNList = document.getElementsByTagName("fizet�s");
	        for (int temp = 0; temp < fizetesNList.getLength(); temp++) {
				Node node = fizetesNList.item(temp);
				
				if (node.getNodeType() == Node.ELEMENT_NODE) {
	
					NodeList childNodes = node.getChildNodes();
					
					for (int j = 0; j < childNodes.getLength(); j++) {
						
						Node childNode = childNodes.item(j);	
						
						if ("fizet�s_m�dja".equals(childNode.getNodeName())) {
	
							if ("sz�p-k�rtya".equals(childNode.getTextContent())) {
								childNode.setTextContent("bankk�rtya");							
							}
						}
					}	
				}
			}
	        
	      //2. m�dos�t�s - a harmadik megrendel�s megrendel�j�t a harmadik megrendel�re v�ltoztatjuk, az els� megrendel� helyett:
	        NodeList rendelNList = document.getElementsByTagName("rendel�s");
	        for (int temp = 0; temp < rendelNList.getLength(); temp++) {
				Node node = rendelNList.item(temp);
				
				NamedNodeMap attr = node.getAttributes();
				Node nodeAttrM = attr.getNamedItem("MID");
				Node nodeAttrR = attr.getNamedItem("RID");
				
				if (nodeAttrR.getTextContent().equals("3")) {
					nodeAttrM.setTextContent("3");
				}
			}
	        
	        //3. m�dos�t�s - a 10% le�raz�s� akci�k n�vel�se 20-ra
	        NodeList akcioNList = document.getElementsByTagName("akci�");
	        for (int temp = 0; temp < akcioNList.getLength(); temp++) {
				Node node = akcioNList.item(temp);
				
				if (node.getNodeType() == Node.ELEMENT_NODE) {
	
					NodeList childNodes = node.getChildNodes();
					
					for (int j = 0; j < childNodes.getLength(); j++) {
						
						Node childNode = childNodes.item(j);	
						
						if ("le�raz�s".equals(childNode.getNodeName())) {
							
							if ("10".equals(childNode.getTextContent())) {
								
								childNode.setTextContent("20");							
							}
						}
					}	
				}
			}
	        
	        //4. m�dos�t�s - a Piedone nev� pizza �r�nak cs�kkent�se 500 forinttal
	        NodeList etelNList = document.getElementsByTagName("�tel");
	        for (int temp = 0; temp < etelNList.getLength(); temp++) {
				Node node = etelNList.item(temp);
				
				if (node.getNodeType() == Node.ELEMENT_NODE) {
	
					NodeList childNodes = node.getChildNodes();
					
					for (int j = 0; j < childNodes.getLength(); j++) {					
						Node childNode = childNodes.item(j);	
						
						if ("n�v".equals(childNode.getNodeName())) {						
							if ("Piedone".equals(childNode.getTextContent())) {
								
								for (int k = 0; k < childNodes.getLength(); k++) {
									childNode = childNodes.item(k);	
									if ("�r".equals(childNode.getNodeName())) {
										childNode.setTextContent("1750");		
									}
								}												
							}
						}
					}	
				}
			}
	        
	        //5. m�dos�t�s - azok a megrendel�k, akik eddig nem voltak visszat�r� vend�gek, azokat azz� m�dos�tani
	        NodeList megrendeloNList = document.getElementsByTagName("megrendel�");
	        for (int temp = 0; temp < megrendeloNList.getLength(); temp++) {
				Node node = megrendeloNList.item(temp);
				
				if (node.getNodeType() == Node.ELEMENT_NODE) {
	
					NodeList childNodes = node.getChildNodes();
					
					for (int j = 0; j < childNodes.getLength(); j++) {					
						Node childNode = childNodes.item(j);	
						
						if ("visszat�r�_vend�g".equals(childNode.getNodeName())) {											
								
							if ("nem".equals(childNode.getTextContent())) {
								childNode.setTextContent("igen");							
							}
								
						}
					}	
				}
			}
	        
	        //a m�dos�tott adatok ki�r�sa mind konzolra mind f�jlba
	        File modFile = new File("MOD_XMLF58KQ8.xml");
	        
	        TransformerFactory transformerFactory = TransformerFactory.newInstance();
	        Transformer transformer = transformerFactory.newTransformer();
	
	        DOMSource source = new DOMSource(document);
	
	        System.out.println("---- Modositott fajl -----");       
	        
	        StreamResult consoleResult = new StreamResult(System.out);
	        StreamResult resultModFile = new StreamResult(modFile);
	        
	        transformer.transform(source, consoleResult);
	        transformer.transform(source, resultModFile );
	        
		} catch (Exception e ) {
            e.printStackTrace();
        }
	}
}
