package com.tempnaam.project4;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.project4.R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ScrollView;

import com.actionbarsherlock.app.SherlockFragment;

public class Steunons extends SherlockFragment {

	private ScrollView ll;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		if (container == null) {
			return null;
		}

		ll = (ScrollView) inflater.inflate(R.layout.steunons, container,
				false);

		setButtonActions();

		return ll;
	}
	
	private void setButtonActions() {
		Button doneerWordtLid = (Button) ll.findViewById(R.id.buttonWordLid);
		doneerWordtLid.setOnClickListener(new View.OnClickListener() {
			public void onClick(View arg0) {
				Intent browse = new Intent(Intent.ACTION_VIEW, Uri
						.parse("http://www.amnesty.nl/steun-amnesty/word-lid"));
				startActivity(browse);
			}
		});

		Button doneerEenmalig = (Button) ll.findViewById(R.id.buttonEenmaligDoneren);
		doneerEenmalig.setOnClickListener(new View.OnClickListener() {
			public void onClick(View arg0) {
				Intent browse = new Intent(
						Intent.ACTION_VIEW,
						Uri.parse("http://www.amnesty.nl/steun-amnesty/geef/eenmalige-gift"));
				startActivity(browse);
			}
		});

	}

}
