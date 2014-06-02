package de.LittleRolf.BieberFieber;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class TellerBieberFactory {
	private List<Bieber> bieberz = new ArrayList<Bieber>();
	private List<Teller> tellerz = new ArrayList<Teller>();

	public TellerBieberFactory(String path) {
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(new File(path));
			doc.getDocumentElement().normalize();
			System.out.println("Root element "
					+ doc.getDocumentElement().getNodeName());

			NodeList bieberNodeLst = doc.getElementsByTagName("bieber");
			for (int s = 0; s < bieberNodeLst.getLength(); s++) {
				Node bieberNode = bieberNodeLst.item(s);

				if (bieberNode.getNodeType() == Node.ELEMENT_NODE) {
					Element fstElmnt = (Element) bieberNode;
					NodeList fstNmElmntLst = fstElmnt
							.getElementsByTagName("name");
					Element fstNmElmnt = (Element) fstNmElmntLst.item(0);
					NodeList fstNm = fstNmElmnt.getChildNodes();

					String name = ((Node) fstNm.item(0)).getNodeValue();

					NodeList lstNmElmntLst = fstElmnt
							.getElementsByTagName("size");
					Element lstNmElmnt = (Element) lstNmElmntLst.item(0);
					NodeList lstNm = lstNmElmnt.getChildNodes();
					int size = Integer.valueOf(((Node) lstNm.item(0))
							.getNodeValue());
					bieberz.add(new Bieber(name, size == 1 ? Bieber.Size.SMALL
							: Bieber.Size.BIG));
				}
			}

			NodeList tellerNodeLst = doc.getElementsByTagName("teller");
			for (int s = 0; s < tellerNodeLst.getLength(); s++) {
				Node tellerNode = tellerNodeLst.item(s);

				if (tellerNode.getNodeType() == Node.ELEMENT_NODE) {
					Element fstElmnt = (Element) tellerNode;

					NodeList lstNmElmntLst = fstElmnt
							.getElementsByTagName("size");
					Element lstNmElmnt = (Element) lstNmElmntLst.item(0);
					NodeList lstNm = lstNmElmnt.getChildNodes();
					int size = Integer.valueOf(((Node) lstNm.item(0))
							.getNodeValue());

					tellerz.add(new Teller(size == 1 ? Teller.Size.SMALL
							: Teller.Size.BIG));
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Queue<Bieber> getBieberz() {
		Queue<Bieber> q = new LinkedList<Bieber>();
		for (Bieber b : bieberz) {
			q.add(b);
		}
		// q.add(new Bieber("Ulf", Bieber.Size.BIG));
		// q.add(new Bieber("Klein-Peda", Bieber.Size.SMALL));
		return q;
	}

	public Stack<Teller> getTellerz() {
		Stack<Teller> t = new Stack<Teller>();
		for (Teller tell : tellerz)
			t.push(tell);
		// t.push(new Teller(Teller.Size.SMALL));
		// t.push(new Teller(Teller.Size.BIG));
		return t;
	}

	public static void main(String... args) {
		TellerBieberFactory f = new TellerBieberFactory("device.xml");
	}

}
