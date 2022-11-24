package hu.domparse.f58kq8;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DomQueryF58KQ8 {

	public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {
		try {
			//xml f�jl megnyit�sa ahonnan beolvassuk az adatokat
            File file = new File("XMLF58KQ8.xml");

            //dokumentum l�trehoz�sa l�trehoz�sa a beolvasott f�jlb�l
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = documentBuilder.parse(file);
            
            //dokumentum normaliz�l�s�a
            document.getDocumentElement().normalize();           
            

            //1. lek�rdez�s: a 'H�s�tel' t�pus� �telek nev�nek �s �r�nak lek�rdez�se  
            System.out.println("\n1. a 'H�s�tel' t�pus� �telek nev�nek �s �r�nak lek�rdez�se:");
            NodeList nList1 = document.getElementsByTagName("�tel");
            
            for (int i = 0; i < nList1.getLength(); i++) {
    			
            	Node nNode = nList1.item(i);
            	
    			if (nNode.getNodeType()==Node.ELEMENT_NODE) {       				

    				Element elem = (Element) nNode;
    				NodeList childNodes = nNode.getChildNodes();
    				
    				for (int j = 0; j < childNodes.getLength(); j++) {
    					
    					Node childNode = childNodes.item(j);	
    					
    					if ("t�pus".equals(childNode.getNodeName())) {

    						if ("H�s�tel".equals(childNode.getTextContent())) {
    							System.out.println("");
    							
    							String eid = elem.getAttribute("EID");    		    				
    		    				Node node1 = elem.getElementsByTagName("n�v").item(0);
    		    				String node1Text = node1.getTextContent();    		    				
    		    				Node node2 = elem.getElementsByTagName("�r").item(0);
    		    				String node2Text = node2.getTextContent();    				
    		    				
    		    				System.out.println("�telek id: " + eid);
    		    				System.out.println("N�v: " + node1Text);
    		    				System.out.println("�r: " + node2Text);	
    		    				
    						}
    					}
    				}	
    			}
    			
	            }
	            System.out.println("---------------------------------------------------");
	            
	            
	            //2. lek�rdez�s: azoknak a rendel�seknek lek�rdez�se amelyek az 1. ID-j� rendel�t�l j�ttek, 10000ft alatti �sszeg �rt�kben  
	            System.out.println("\n2. lek�rdez�s: azoknak a rendel�seknek lek�rdez�se, amelyek az 1. ID-j� rendel�t�l j�ttek, 10000ft alatti �sszeg �rt�kben:");
	            NodeList nList2 = document.getElementsByTagName("rendel�s");
	            
	            for (int i = 0; i < nList2.getLength(); i++) {
	    			
	            	Node nNode = nList2.item(i);
	            	
	    			if (nNode.getNodeType()==Node.ELEMENT_NODE) {       				
	
	    				Element elem = (Element) nNode;
	    				NodeList childNodes = nNode.getChildNodes();
	    				
	    				NamedNodeMap attr = nNode.getAttributes();
	    				Node nodeAttrM = attr.getNamedItem("MID");
	    				
	    				if (nodeAttrM.getTextContent().equals("1")) {
		    				for (int j = 0; j < childNodes.getLength(); j++) {
		    					
		    					Node childNode = childNodes.item(j);	
		    					
		    					if ("�sszeg".equals(childNode.getNodeName())) {
		
		    						if (Integer.valueOf(childNode.getTextContent()) < 10000 ) {
		    							System.out.println("");
		    							
		    							String rid = elem.getAttribute("RID");    		    				
		    		    				Node node1 = elem.getElementsByTagName("d�tum").item(0);
		    		    				String node1Text = node1.getTextContent();    		    				
		    		    				Node node2 = elem.getElementsByTagName("kisz�ll�t�si_c�m").item(0);
		    		    				String node2Text = node2.getTextContent();
		    		    				Node node3 = elem.getElementsByTagName("�sszeg").item(0);
		    		    				String node3Text = node3.getTextContent();    				
		    		    				
		    		    				
		    		    				System.out.println("Rendel�s id: " + rid);
		    		    				System.out.println("D�tum: " + node1Text);
		    		    				System.out.println("Kisz�ll�t�si c�m: " + node2Text);	
		    		    				System.out.println("�sszeg: " + node3Text);
		    		    				
		    						}
		    					}
		    				}	
	    				}
	    			}
	    			
	    		}
	            System.out.println("---------------------------------------------------");
	            
	            
		        //3. lek�rdez�s: h�ny fizet�s t�rt�nt a k�l�nb�z� fizet�si m�dok haszn�lat�val
		        System.out.println("\n3. h�ny fizet�s t�rt�nt a k�l�nb�z� fizet�si m�dok haszn�lat�val:");
		        NodeList nList3 = document.getElementsByTagName("fizet�s");
		          
		        int bankSz�m = 0;
		    	int sz�pSz�m = 0;
		    	int p�nzSz�m = 0;
		            
		        for (int i = 0; i < nList3.getLength(); i++) {        	  
		        	  
		        	Node nNode = nList3.item(i);
		            	
		        	if (nNode.getNodeType()==Node.ELEMENT_NODE) {       				
		        		
		        		NodeList childNodes = nNode.getChildNodes();
		    				
		        		for (int j = 0; j < childNodes.getLength(); j++) {
		    					
		        			Node childNode = childNodes.item(j);	
		    					
		        			if ("fizet�s_m�dja".equals(childNode.getNodeName())) {
		
		        				if ("bankk�rtya".equals(childNode.getTextContent())) {
		        					bankSz�m++;	    				
		        				}
		        				else if ("sz�p-k�rtya".equals(childNode.getTextContent())) {
		        					sz�pSz�m++;
		        				}
		        				else if ("k�szp�nz".equals(childNode.getTextContent())) {
		        					p�nzSz�m++;
		        				}
		        				  
		        			}
		    			}	
		    		}    			
		    	}
		        System.out.println("\nBankk�rty�s fizet�sek sz�ma: " + bankSz�m);	
		        System.out.println("Sz�p-k�rty�s fizet�sek sz�ma: " + sz�pSz�m);	
		        System.out.println("K�szp�nzes fizet�sek sz�ma: " + p�nzSz�m);	
		        System.out.println("---------------------------------------------------");
		        
		        
		        //4. lek�rdez�s: a NEM visszat�r� vend�gek lek�rdez�se 
	            System.out.println("\n4. a NEM visszat�r� vend�gek lek�rdez�se:");
	            NodeList nList4 = document.getElementsByTagName("megrendel�");
	            
	            for (int i = 0; i < nList4.getLength(); i++) {
	    			
	            	Node nNode = nList4.item(i);
	            	
	    			if (nNode.getNodeType()==Node.ELEMENT_NODE) {       				
	
	    				Element elem = (Element) nNode;
	    				NodeList childNodes = nNode.getChildNodes();
	    				
	    				for (int j = 0; j < childNodes.getLength(); j++) {
	    					
	    					Node childNode = childNodes.item(j);	
	    					
	    					if ("visszat�r�_vend�g".equals(childNode.getNodeName())) {
	
	    						if ("nem".equals(childNode.getTextContent())) {
	    							System.out.println("");
	    							
	    							String mid = elem.getAttribute("MID");    		    				
	    		    				Node node1 = elem.getElementsByTagName("n�v").item(0);
	    		    				String node1Text = node1.getTextContent();    		    				
	
	    		    				System.out.println("Megrendel� id: " + mid);
	    		    				System.out.println("N�v: " + node1Text);
	    						}
	    					}
	    				}	
	    			}
	    			
	            }
	            System.out.println("---------------------------------------------------");
	            
	          //5. lek�rdez�s: a 6 ID-j� �telhez tartoz� akci�k lek�rdez�se 
	            System.out.println("\n5. a 6 ID-j� �telhez tartoz� akci�k lek�rdez�se:");
	            NodeList nList5 = document.getElementsByTagName("akci�");
	            
	            for (int i = 0; i < nList5.getLength(); i++) {
	    			
	            	Node nNode = nList5.item(i);
	            	
	            	if (nNode.getNodeType()==Node.ELEMENT_NODE) {       				
	
	    				Element elem = (Element) nNode;    				
	    				NamedNodeMap attr = nNode.getAttributes();
	    				Node nodeAttrM = attr.getNamedItem("EID");
	
	    				if (nodeAttrM.getTextContent().equals("6")) {	    				
	
		    					System.out.println("");
		    							
		    					String aid = elem.getAttribute("AID");    		    				
		    		    		Node node1 = elem.getElementsByTagName("kezdete").item(0);
		    		    		String node1Text = node1.getTextContent();    		    				
		    		    		Node node2 = elem.getElementsByTagName("v�ge").item(0);
		    		    		String node2Text = node2.getTextContent();
		    		    		Node node3 = elem.getElementsByTagName("le�raz�s").item(0);
		    		    		String node3Text = node3.getTextContent();    				
		    		    				
		    		    				
		    		    		System.out.println("Akci� id: " + aid);
		    		    		System.out.println("Akci� kezdete: " + node1Text);
		    		    		System.out.println("Akci� v�ge: " + node2Text);	
		    		    		System.out.println("Le�raz�s m�rt�ke: " + node3Text);
		    				}	
	    				
	            	}
	    			
	            }
	            System.out.println("---------------------------------------------------");
		
	            
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ParserConfigurationException e) {
				e.printStackTrace();
			} catch (SAXException e) {
				e.printStackTrace();
			}   
         
	}
}
