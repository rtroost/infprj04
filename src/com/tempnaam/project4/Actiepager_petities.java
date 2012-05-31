package com.tempnaam.project4;

import java.util.ArrayList;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import android.os.Bundle;
import android.project4.R;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

public class Actiepager_petities extends Fragment {
	private LinearLayout ll;

	/** Called when the activity is first created. */

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		if (container == null) {
			return null;
		}

		ll = (LinearLayout) inflater.inflate(R.layout.actiepager_listview,
				container, false);
		
		
		/** Bind string array to ListView via Adapter */
		ListView lv = (ListView) ll.findViewById(R.id.listView_Acties);
		String[] str = parseActieXml();
		lv.setAdapter(new ArrayAdapter<String>(getActivity(), R.layout.listviewlayout, str));

		return ll;
	}

	private String[] parseActieXml() {
		try {
			/** Handling XML */
			SAXParserFactory spf = SAXParserFactory.newInstance();
			SAXParser sp = spf.newSAXParser();

			XmlParser_acties handler = new XmlParser_acties();

			sp.parse(getResources().openRawResource(R.raw.petities), handler);

			ArrayList<Article> articles = handler.getArticles();
			String[] str = new String[articles.size()];

			for (int i = 0; i < articles.size(); i++) {
				str[i] = articles.get(i).getTitle();
			}
			
			return str;

		} catch (Exception e) {
			System.out.println("XML Error " + e);
		}
		return null;
	}

}
