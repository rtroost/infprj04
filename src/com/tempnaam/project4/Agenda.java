package com.tempnaam.project4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.project4.R;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ScrollView;

public class Agenda extends Fragment {

	private ScrollView ll;
	private Activity act;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		if (container == null) {
			return null;
		}

		ll = (ScrollView) inflater.inflate(R.layout.agenda, container, false);

		setButtonActions();

		return ll;
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		this.act = activity;
	}

	private void setButtonActions() {
		Button agendaButton = (Button) ll.findViewById(R.id.agendamap);
		agendaButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View arg0) {
				Intent i = new Intent(act, Agendamap.class);
				startActivity(i);
			}
		});
	}
}
