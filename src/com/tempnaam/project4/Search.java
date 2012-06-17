package com.tempnaam.project4;

import android.os.Bundle;
import android.project4.R;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.actionbarsherlock.app.SherlockActivity;

public class Search extends SherlockActivity {
//	private LayoutInflater inflater;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.mainpage_layout);
		
//		inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		this.initialisePaging();
	}

	private void initialisePaging() {
		EditText query_textArea = (EditText) findViewById(R.id.seach_queryText);
		
		query_textArea.addTextChangedListener(new TextWatcher() {

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				getResults(s);
			}
			
		});
	}

	protected void getResults(CharSequence s) {
		ListView lv = (ListView) findViewById(R.id.seach_queryResults);
		
		String[] str = new String[] { s.toString(), "test", "test" };
		
		lv.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, str));
	}
}
