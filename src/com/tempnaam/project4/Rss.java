package com.tempnaam.project4;

import java.net.URL;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.CharacterData;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Rss {

	private String[] title;
	private String[] pubDate;
	private String[] description;
	private String[] link;

	public void writeNews() {
		try {
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			URL u = new URL("http://www.amnestybookings.nl/rss/nieuws"); // your feed
			Document doc = builder.parse(u.openStream());
			NodeList nodes = doc.getElementsByTagName("item");

			this.title = new String[nodes.getLength()];
			this.pubDate = new String[nodes.getLength()];
			this.description = new String[nodes.getLength()];
			this.link = new String[nodes.getLength()];
			
			for (int i = 0; i < nodes.getLength(); i++) {
				Element element = (Element) nodes.item(i);
				
				this.title[i] = getElementValue(element, "title");
				this.pubDate[i] = getElementValue(element, "pubDate");
				this.description[i] = getElementValue(element, "description");
				this.link[i] = getElementValue(element, "link");
				
//				System.out.println("Title: "+ getElementValue(element, "title"));
//				System.out.println("Link: " + getElementValue(element, "link"));
//				System.out.println("Publish Date: "+ getElementValue(element, "pubDate"));
//				System.out.println("Author: "+ getElementValue(element, "dc:creator"));
//				System.out.println("Description: "+ getElementValue(element, "description"));
//				System.out.println();
			}// for
			
		}// try
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public String[] getTitle() {
		return title;
	}

	public void setTitle(String[] title) {
		this.title = title;
	}
	
	public String[] getPubDate() {
		return pubDate;
	}

	public void setPubDate(String[] pubDate) {
		this.pubDate = pubDate;
	}

	public String[] getDescription() {
		return description;
	}

	public void setDescription(String[] description) {
		this.description = description;
	}

	public String[] getLink() {
		return link;
	}

	public void setLink(String[] link) {
		this.link = link;
	}

	private String getCharacterDataFromElement(Element e) {
		try {
			Node child = e.getFirstChild();
			if (child instanceof CharacterData) {
				CharacterData cd = (CharacterData) child;
				return cd.getData();
			}
		} catch (Exception ex) {

		}
		return "";
	} // private String getCharacterDataFromElement

	protected float getFloat(String value) {
		if (value != null && !value.equals(""))
			return Float.parseFloat(value);
		else
			return 0;
	}

	protected String getElementValue(Element parent, String label) {
		return getCharacterDataFromElement((Element) parent
				.getElementsByTagName(label).item(0));
	}

//	public static void main(String[] args) {
//		Rss reader = Rss.getInstance();
//		reader.writeNews();
//	}
}