package com.tempnaam.project4;

import java.util.ArrayList;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import android.app.Activity;
import android.app.Dialog;
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

public class Actiepager_petities extends Fragment {
	private LinearLayout ll;
	private Activity act;

	/** Called when the activity is first created. */

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		if (container == null) {
			return null;
		}

		ll = (LinearLayout) inflater.inflate(R.layout.actiepager_listview,
				container, false);

		instantiateList();

		return ll;
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		this.act = activity;
	}

	private void instantiateList() {
		/** Bind string array to ListView via Adapter */
		final ListView lv = (ListView) ll.findViewById(R.id.listView_Acties);
		final ArrayList<Article> articles = parseActieXml();

		String[] str = new String[articles.size()];

		for (int i = 0; i < articles.size(); i++) {
			str[i] = articles.get(i).getTitle();
		}

		lv.setAdapter(new ArrayAdapter<String>(getActivity(),
				R.layout.listviewlayout, str));

		lv.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				final Article article = articles.get(position);
				
				final Dialog dialog = new Dialog(act);
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
						Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(article.getUrl()));
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
		});
	}

	private ArrayList<Article> parseActieXml() {
		try {
			/** Handling XML */
			SAXParserFactory spf = SAXParserFactory.newInstance();
			SAXParser sp = spf.newSAXParser();

			XmlParser_acties handler = new XmlParser_acties();

			sp.parse(getResources().openRawResource(R.raw.petities), handler);

			return handler.getArticles();

		} catch (Exception e) {
			System.out.println("XML Error " + e);
		}
		return null;
	}
}
