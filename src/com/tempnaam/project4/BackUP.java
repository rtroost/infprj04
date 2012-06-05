package com.tempnaam.project4;

import android.os.Bundle;
import android.project4.R;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class BackUP extends Fragment {
	private LinearLayout ll;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		if (container == null) {
			return null;
		}

		ll = (LinearLayout) inflater.inflate(R.layout.algemeen,
				container, false);

		return ll;
	}
}