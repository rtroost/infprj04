package com.tempnaam.project4;

import android.content.Intent;
import android.os.Bundle;
import android.project4.R;
import android.view.View;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.actionbarsherlock.view.MenuItem.OnMenuItemClickListener;

public class Overons extends SherlockActivity {
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.overons);
    }
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add("Back")
		.setOnMenuItemClickListener(new OnMenuItemClickListener() {
			@Override
			public boolean onMenuItemClick(MenuItem item) {
//				Intent startMain = new Intent(Intent.ACTION_MAIN);
//				startMain.addCategory(Intent.CATEGORY_HOME);
//				startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//				startActivity(startMain);
				//finishActivity(RESULT_OK);
				Intent overons_i = new Intent(Overons.this,
						Project4Activity.class);
				startActivity(overons_i);
				return true;
				
			}
		}).setIcon(android.R.drawable.ic_media_previous)
		.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
		menu.add("Search")
				.setIcon(android.R.drawable.ic_menu_search)
				.setActionView(R.layout.collapsible_edittext)
				.setShowAsAction(
						MenuItem.SHOW_AS_ACTION_ALWAYS
								| MenuItem.SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW);

		return true;
	}

}
