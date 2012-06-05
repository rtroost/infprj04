package com.tempnaam.project4;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.project4.R;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
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

		ll = (ScrollView) inflater.inflate(R.layout.themas, container,
				false);
		
		Button thema1 = (Button) ll.findViewById(R.id.buttonthema1);
		thema1.setOnClickListener(new View.OnClickListener() {
			public void onClick(View arg0) {
				Intent browse = new Intent( Intent.ACTION_VIEW , Uri.parse( "http://www.amnesty.nl/mensenrechten/themas/bedrijven-en-mensenrechten" ) );
		        startActivity( browse );
			}
		});
		
		Button thema2 = (Button) ll.findViewById(R.id.buttonthema2);
		thema2.setOnClickListener(new View.OnClickListener() {
			public void onClick(View arg0) {
				Intent browse = new Intent( Intent.ACTION_VIEW , Uri.parse( "http://www.amnesty.nl/mensenrechten/themas/doodstraf" ) );
		        startActivity( browse );
			}
		});
		
		Button thema3 = (Button) ll.findViewById(R.id.buttonthema3);
		thema3.setOnClickListener(new View.OnClickListener() {
			public void onClick(View arg0) {
				Intent browse = new Intent( Intent.ACTION_VIEW , Uri.parse( "http://www.amnesty.nl/mensenrechten/themas/economische-sociale-en-culturele-rechten" ) );
		        startActivity( browse );
			}
		});
		
		Button thema4 = (Button) ll.findViewById(R.id.buttonthema4);
		thema4.setOnClickListener(new View.OnClickListener() {
			public void onClick(View arg0) {
				Intent browse = new Intent( Intent.ACTION_VIEW , Uri.parse( "http://www.amnesty.nl/mensenrechten/themas/gevangenen-marteling-moorden-en-verdwijningen" ) );
		        startActivity( browse );
			}
		});
		
		Button thema5 = (Button) ll.findViewById(R.id.buttonthema5);
		thema5.setOnClickListener(new View.OnClickListener() {
			public void onClick(View arg0) {
				Intent browse = new Intent( Intent.ACTION_VIEW , Uri.parse( "http://www.amnesty.nl/mensenrechten/themas/internationaal-recht-en-berechting" ) );
		        startActivity( browse );
			}
		});
		
		Button thema6 = (Button) ll.findViewById(R.id.buttonthema6);
		thema6.setOnClickListener(new View.OnClickListener() {
			public void onClick(View arg0) {
				Intent browse = new Intent( Intent.ACTION_VIEW , Uri.parse( "http://www.amnesty.nl/mensenrechten/themas/lgbt" ) );
		        startActivity( browse );
			}
		});
		
		Button thema7 = (Button) ll.findViewById(R.id.buttonthema7);
		thema7.setOnClickListener(new View.OnClickListener() {
			public void onClick(View arg0) {
				Intent browse = new Intent( Intent.ACTION_VIEW , Uri.parse( "http://www.amnesty.nl/mensenrechten/themas/mensenrechten-in-nederland" ) );
		        startActivity( browse );
			}
		});
		
		Button thema8 = (Button) ll.findViewById(R.id.buttonthema8);
		thema8.setOnClickListener(new View.OnClickListener() {
			public void onClick(View arg0) {
				Intent browse = new Intent( Intent.ACTION_VIEW , Uri.parse( "http://www.amnesty.nl/mensenrechten/themas/mensenrechteneducatie" ) );
		        startActivity( browse );
			}
		});
		
		Button thema9 = (Button) ll.findViewById(R.id.buttonthema9);
		thema9.setOnClickListener(new View.OnClickListener() {
			public void onClick(View arg0) {
				Intent browse = new Intent( Intent.ACTION_VIEW , Uri.parse( "http://www.amnesty.nl/mensenrechten/themas/mensenrechtenverdedigers" ) );
		        startActivity( browse );
			}
		});
		
		Button thema10 = (Button) ll.findViewById(R.id.buttonthema10);
		thema10.setOnClickListener(new View.OnClickListener() {
			public void onClick(View arg0) {
				Intent browse = new Intent( Intent.ACTION_VIEW , Uri.parse( "http://www.amnesty.nl/mensenrechten/themas/vrijheid-meningsuiting" ) );
		        startActivity( browse );
			}
		});
		
		Button thema11 = (Button) ll.findViewById(R.id.buttonthema11);
		thema11.setOnClickListener(new View.OnClickListener() {
			public void onClick(View arg0) {
				Intent browse = new Intent( Intent.ACTION_VIEW , Uri.parse( "http://www.amnesty.nl/mensenrechten/themas/vrouwen" ) );
		        startActivity( browse );
			}
		});
		

		return ll;
	}

}
