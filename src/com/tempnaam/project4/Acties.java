package com.tempnaam.project4;

import android.app.Activity;
import android.os.Bundle;
import android.project4.R;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.tidy.Tidy;

public class Acties extends Activity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.acties_layout);

		// Parse XML Content
		this.parseActieXml();
	}

	private void parseActieXml() {
		URL u = null;
		InputStream is = null;
		try {
			u = new URL("http://www.google.nl/");
			is = u.openStream();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Tidy tidy = new Tidy();
		Document tidyDOM = tidy.parseDOM(is, null);
		NodeList divTags = tidyDOM.getElementsByTagName("div");
		System.out.println(divTags);

//		try {
//			File file = new File("c:\\MyXMLFile.xml");
//			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
//			DocumentBuilder db = dbf.newDocumentBuilder();
//			Document doc = db.parse(file);
//			doc.getDocumentElement().normalize();
//			System.out.println("Root element "
//					+ doc.getDocumentElement().getNodeName());
//			NodeList nodeLst = doc.getElementsByTagName("employee");
//			System.out.println("Information of all employees");
//
//			for (int s = 0; s < nodeLst.getLength(); s++) {
//
//				Node fstNode = nodeLst.item(s);
//
//				if (fstNode.getNodeType() == Node.ELEMENT_NODE) {
//
//					Element fstElmnt = (Element) fstNode;
//					NodeList fstNmElmntLst = fstElmnt
//							.getElementsByTagName("firstname");
//					Element fstNmElmnt = (Element) fstNmElmntLst.item(0);
//					NodeList fstNm = fstNmElmnt.getChildNodes();
//					System.out.println("First Name : "
//							+ ((Node) fstNm.item(0)).getNodeValue());
//					NodeList lstNmElmntLst = fstElmnt
//							.getElementsByTagName("lastname");
//					Element lstNmElmnt = (Element) lstNmElmntLst.item(0);
//					NodeList lstNm = lstNmElmnt.getChildNodes();
//					System.out.println("Last Name : "
//							+ ((Node) lstNm.item(0)).getNodeValue());
//				}
//
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

	}

}
