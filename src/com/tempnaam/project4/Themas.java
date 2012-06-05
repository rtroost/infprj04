package com.tempnaam.project4;

import android.app.Activity;
import android.os.Bundle;
import android.project4.R;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;

public class Themas extends Fragment {
	private ScrollView ll;
	private Activity act;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		if (container == null) {
			return null;
		}

		ll = (ScrollView) inflater.inflate(R.layout.themas, container,
				false);

		return ll;
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		this.act = activity;
	}
}
