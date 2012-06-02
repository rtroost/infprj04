package com.tempnaam.project4;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class XmlParser_rss extends DefaultHandler {
	private ArrayList<Item> items;
	private Item currentItem;
	private StringBuilder builder;

	public ArrayList<Item> getItems() {
		return this.items;
	}
	
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		super.characters(ch, start, length);
		builder.append(ch, start, length);
	}

	public String trimSubstring(StringBuilder sb) {
		int first, last;

		for (first = 0; first < sb.length(); first++)
			if (!Character.isWhitespace(sb.charAt(first)))
				break;

		for (last = sb.length(); last > first; last--)
			if (!Character.isWhitespace(sb.charAt(last - 1)))
				break;

		return sb.substring(first, last);
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		super.endElement(uri, localName, qName);

		System.out.println("endElement! : " + qName);
		//<item
		//<title>
		// <description>
		// <pubDate>
		if (this.currentItem != null) {
			if (qName.equalsIgnoreCase("title")) {
				currentItem.setTitle(trimSubstring(builder));
			} else if (qName.equalsIgnoreCase("description")) {
				currentItem.setDescription(trimSubstring(builder));
			} else if (qName.equalsIgnoreCase("link")) {
				currentItem.setLink(trimSubstring(builder));
			} else if (qName.equalsIgnoreCase("pubDate")) {
				currentItem.setPubDate(trimSubstring(builder));
			} else if (qName.equalsIgnoreCase("item")) {
				items.add(currentItem);
			}
			builder.setLength(0);
		}
	}

	@Override
	public void startDocument() throws SAXException {
		super.startDocument();

		items = new ArrayList<Item>();
		builder = new StringBuilder();
	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		super.startElement(uri, localName, qName, attributes);

		System.out.println("startElement!");

		if (qName.equalsIgnoreCase("item")) {
			this.currentItem = new Item();
		}
	}
}

class Item {
	private String title, description, link, pubDate;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getPubDate() {
		return pubDate;
	}

	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}

}
