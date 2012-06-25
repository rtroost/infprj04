package com.tempnaam.project4;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.project4.R;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class Overons extends Activity {
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.overons);
        
        ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
    }
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu_layout, menu);

		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			Intent intent_home = new Intent(this, Project4Activity.class);
			intent_home.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent_home);
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

}
