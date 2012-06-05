package com.tempnaam.project4;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.project4.R;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ScrollView;

public class Themas extends Fragment {
	private ScrollView ll;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		if (container == null) {
			return null;
		}

		ll = (ScrollView) inflater.inflate(R.layout.themas, container, false);

		instantiateButtons();

		return ll;
	}

	private void instantiateButtons() {
		Button b;

		b = (Button) ll.findViewById(R.id.buttonthema1);
		b.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri
						.parse("http://www.amnesty.nl/mensenrechten/themas/bedrijven-en-mensenrechten"));
				startActivity(browserIntent);
			}

		});
		
		b = (Button) ll.findViewById(R.id.buttonthema2);
		b.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri
						.parse("http://www.amnesty.nl/mensenrechten/themas/doodstraf"));
				startActivity(browserIntent);
			}

		});
		
		b = (Button) ll.findViewById(R.id.buttonthema3);
		b.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri
						.parse("http://www.amnesty.nl/mensenrechten/themas/economische-sociale-en-culturele-rechten"));
				startActivity(browserIntent);
			}

		});
		
		b = (Button) ll.findViewById(R.id.buttonthema4);
		b.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri
						.parse("http://www.amnesty.nl/mensenrechten/themas/gevangenen-marteling-moorden-en-verdwijningen"));
				startActivity(browserIntent);
			}

		});
		
		b = (Button) ll.findViewById(R.id.buttonthema5);
		b.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri
						.parse("http://www.amnesty.nl/mensenrechten/themas/internationaal-recht-en-berechting"));
				startActivity(browserIntent);
			}

		});
		
		b = (Button) ll.findViewById(R.id.buttonthema6);
		b.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri
						.parse("http://www.amnesty.nl/mensenrechten/themas/lgbt"));
				startActivity(browserIntent);
			}

		});
		
		b = (Button) ll.findViewById(R.id.buttonthema7);
		b.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri
						.parse("http://www.amnesty.nl/mensenrechten/themas/mensenrechten-in-nederland"));
				startActivity(browserIntent);
			}

		});
		
		b = (Button) ll.findViewById(R.id.buttonthema8);
		b.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri
						.parse("http://www.amnesty.nl/mensenrechten/themas/mensenrechteneducatie"));
				startActivity(browserIntent);
			}

		});
		
		b = (Button) ll.findViewById(R.id.buttonthema9);
		b.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri
						.parse("http://www.amnesty.nl/mensenrechten/themas/mensenrechtenverdedigers"));
				startActivity(browserIntent);
			}

		});
		
		b = (Button) ll.findViewById(R.id.buttonthema10);
		b.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri
						.parse("http://www.amnesty.nl/mensenrechten/themas/vrijheid-meningsuiting"));
				startActivity(browserIntent);
			}

		});
		
		b = (Button) ll.findViewById(R.id.buttonthema11);
		b.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri
						.parse("http://www.amnesty.nl/mensenrechten/themas/vrouwen"));
				startActivity(browserIntent);
			}

		});

	}
}
