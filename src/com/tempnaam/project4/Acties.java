package com.tempnaam.project4;

import android.app.Activity;
import android.os.Bundle;
import android.project4.R;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class Acties extends Fragment {
	private LinearLayout ll;
	private Activity act;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		if (container == null) {
			return null;
		}

		ll = (LinearLayout) inflater.inflate(R.layout.acties, container,
				false);

		return ll;
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		this.act = activity;
	}
}
