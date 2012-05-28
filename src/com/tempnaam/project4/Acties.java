package com.tempnaam.project4;

import java.util.ArrayList;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import android.app.ListActivity;
import android.os.Bundle;
import android.project4.R;
import android.widget.ArrayAdapter;

public class Acties extends ListActivity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.acties_layout);

		ArrayList<Article> returnList = parseActieXml();

		 System.out.println(returnList.get(0).getTitle());
		
		 String[] str = new String[returnList.size()];
		
		 for(int i = 0; i < returnList.size(); i++) {
		 str[i] = returnList.get(i).getTitle();
		 }

//		String[] str = new String[] { "Blub", "Blaat" };

		setListAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, str));
	}

	private ArrayList<Article> parseActieXml() {
		try {
			/** Handling XML */
            SAXParserFactory spf = SAXParserFactory.newInstance();
            SAXParser sp = spf.newSAXParser();
            
            XmlParser_Acties handler = new XmlParser_Acties();
            
            sp.parse(getResources().openRawResource(R.raw.acties), handler);

			return handler.getArticles();
		} catch(Exception e) {
            System.out.println("XML Error " + e);
        }
		return null;		
	}

	class XmlParser_Acties extends DefaultHandler {
		private ArrayList<Article> articles;
		private Article currentArticle;
		private StringBuilder builder;

		public ArrayList<Article> getArticles() {
			return this.articles;
		}
		
		@Override
		public void characters(char[] ch, int start, int length)
				throws SAXException {
			super.characters(ch, start, length);
			builder.append(ch, start, length);
		}
		
		public String trimSubstring(StringBuilder sb) {
		    int first, last;

		    for (first=0; first<sb.length(); first++)
		        if (!Character.isWhitespace(sb.charAt(first)))
		            break;

		    for (last=sb.length(); last>first; last--)
		        if (!Character.isWhitespace(sb.charAt(last-1)))
		            break;

		    return sb.substring(first, last);
		}

		@Override
		public void endElement(String uri, String localName, String qName)
				throws SAXException {
			super.endElement(uri, localName, qName);

			System.out.println("endElement! : " + qName);

			if (this.currentArticle != null) {
				if (qName.equalsIgnoreCase("title")) {
					currentArticle.setTitle(trimSubstring(builder));
				} else if (qName.equalsIgnoreCase("description")) {
					currentArticle.setDescription(trimSubstring(builder));
				} else if (qName.equalsIgnoreCase("startdate")) {
					currentArticle.setStartdate(trimSubstring(builder));
				} else if (qName.equalsIgnoreCase("enddate")) {
					currentArticle.setEnddate(trimSubstring(builder));
				} else if (qName.equalsIgnoreCase("url")) {
					currentArticle.setUrl(trimSubstring(builder));
				} else if (qName.equalsIgnoreCase("geopoint")) {
					currentArticle.setGeopoint(trimSubstring(builder));
				} else if (qName.equalsIgnoreCase("article")) {
					articles.add(currentArticle);
				}
				builder.setLength(0);
			}
		}

		@Override
		public void startDocument() throws SAXException {
			super.startDocument();

			articles = new ArrayList<Article>();
			builder = new StringBuilder();
		}

		@Override
		public void startElement(String uri, String localName, String qName,
				Attributes attributes) throws SAXException {
			super.startElement(uri, localName, qName, attributes);

			System.out.println("startElement!");

			if (qName.equalsIgnoreCase("article")) {
				this.currentArticle = new Article();
			}
		}
	}

	class Article {
		private String title, description, startdate, enddate, url, geopoint;

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

		public String getStartdate() {
			return startdate;
		}

		public void setStartdate(String startdate) {
			this.startdate = startdate;
		}

		public String getEnddate() {
			return enddate;
		}

		public void setEnddate(String enddate) {
			this.enddate = enddate;
		}

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		public String getGeopoint() {
			return geopoint;
		}

		public void setGeopoint(String geopoint) {
			this.geopoint = geopoint;
		}

	}

}
