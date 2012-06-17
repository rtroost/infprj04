package com.tempnaam.project4;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.project4.R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.actionbarsherlock.app.SherlockFragment;

public class Algemeen extends SherlockFragment {
	private ScrollView ll;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		if (container == null) {
			return null;
		}

		ll = (ScrollView) inflater.inflate(R.layout.algemeen, container, false);

		instantiateFragment();

		return ll;
	}

	public void instantiateFragment() {

		LinearLayout menuitems = (LinearLayout) ll.findViewById(R.id.menuitems);

		try {
			@SuppressWarnings("unused")
			ApplicationInfo info = getActivity().getPackageManager().getApplicationInfo(
					"com.tempname.project4", 0);

			Button button = new Button(getActivity());
			//button.setText("Klik hier om de Amnesty Wallpaper app te openen.");
			button.setTextSize(12);
			button.setBackgroundResource(R.drawable.openwallpaper);
			button.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {

					Intent LaunchIntent = getActivity().getPackageManager()
							.getLaunchIntentForPackage("com.tempname.project4");
					startActivity(LaunchIntent);

				}
			});

			GridLayout.LayoutParams buttonpar = new GridLayout.LayoutParams();
			buttonpar.width = -1;
			buttonpar.height = 100;

			menuitems.addView(button, buttonpar);

		} catch (PackageManager.NameNotFoundException e) {
			Button button = new Button(getActivity());
			//button.setText("Doneer en Download de Amnesty Wallpaper app.");
			button.setTextSize(12);
			button.setBackgroundResource(R.drawable.downloadwallpaper);
			button.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {

					Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri
							.parse("https://play.google.com/store?hl=nl"));
					startActivity(browserIntent);

				}
			});

			GridLayout.LayoutParams buttonpar = new GridLayout.LayoutParams();
			buttonpar.width = -1;
			buttonpar.height = 100;

			menuitems.addView(button, buttonpar);
		}

//		GridLayout line = new GridLayout(getActivity());
//		line.setBackgroundResource(R.color.gray);
//
//		GridLayout.LayoutParams first = new GridLayout.LayoutParams();
//		first.width = -1;
//		first.height = 2;
//		first.topMargin = 10;
//		first.bottomMargin = 10;
//
//		menuitems.addView(line, first);
	}
}