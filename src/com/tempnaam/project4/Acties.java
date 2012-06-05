package com.tempnaam.project4;

import java.util.ArrayList;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.project4.R;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class Acties extends Fragment {
	private LinearLayout ll;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		if (container == null) {
			return null;
		}

		ll = (LinearLayout) inflater.inflate(R.layout.acties, container, false);

		populateListViews();

		return ll;
	}

	private void populateListViews() {
		ArrayList<Article> articles = new ArrayList<Article>();
		articles.addAll(parseActieXml(R.raw.schrijfacties));
		articles.addAll(parseActieXml(R.raw.petities));
		articles.addAll(parseActieXml(R.raw.specialeacties));

		ListView lv = (ListView) ll.findViewById(R.id.listView_Acties);

		lv.setAdapter(new MyArrayAdapter(getActivity(), toStringArray(articles)));

		Acties_ListView_onItemClickListener listener = new Acties_ListView_onItemClickListener();

		listener.setArticles(articles);

		lv.setOnItemClickListener(listener);
	}

	private String[] toStringArray(ArrayList<Article> list) {
		String[] str = new String[list.size()];

		for (int i = 0; i < list.size(); i++) {
			str[i] = list.get(i).getTitle();
		}

		return str;
	}

	class MyArrayAdapter extends ArrayAdapter<String> {
		private final Context context;
		private final String[] values;

		public MyArrayAdapter(Context context, String[] values) {
			super(context, R.layout.listviewlayout, values);
			this.context = context;
			this.values = values;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			
			View rowView = inflater.inflate(R.layout.listviewlayout, parent, false);
			
			TextView label = (TextView) rowView.findViewById(R.id.label);
			TextView type = (TextView) rowView.findViewById(R.id.type);
			
			label.setText(values[position]);
			
			
			type.setText("Schrijfactie");

			return rowView;			
		}
	}

	class Acties_ListView_onItemClickListener implements OnItemClickListener {

		private ArrayList<Article> articles;

		public void setArticles(ArrayList<Article> articles) {
			this.articles = articles;
		}

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			final Article article = articles.get(position);

			final Dialog dialog = new Dialog(getActivity());
			dialog.setContentView(R.layout.actiepager_actiedialog);
			dialog.setTitle(article.getTitle());
			dialog.setCancelable(true);

			TextView description = (TextView) dialog
					.findViewById(R.id.actie_description);
			description.setText(article.getDescription());

			Button browserpopout_button = (Button) dialog
					.findViewById(R.id.actie_browserpopout);

			browserpopout_button.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri
							.parse(article.getUrl()));
					startActivity(browserIntent);
				}

			});

			Button close_button = (Button) dialog
					.findViewById(R.id.actie_close);

			close_button.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					dialog.dismiss();
				}

			});

			dialog.show();
		}
	}

	private ArrayList<Article> parseActieXml(int rawXML) {
		try {
			/** Handling XML */
			SAXParserFactory spf = SAXParserFactory.newInstance();
			SAXParser sp = spf.newSAXParser();

			XmlParser_acties handler = new XmlParser_acties();

			sp.parse(getResources().openRawResource(rawXML), handler);

			ArrayList<Article> articles = handler.getArticles();

			return articles;

		} catch (Exception e) {
			System.out.println("XML Error " + e);
		}
		return null;
	}
}
