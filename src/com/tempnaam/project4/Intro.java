package com.tempnaam.project4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.project4.R;

public class Intro extends Activity 
{
	private final int SPLASH_DISPLAY_LENGTH = 3000; // 3 seconds
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.introlayout);
	}
	
	protected void onResume()
	{
		super.onResume();
		
		new Handler().postDelayed(new Runnable()
        	{
            		public void run()
            		{
            			Intro.this.finish();
                		Intent mainIntent = new Intent(Intro.this, Project4Activity.class); // verwijzing van huidige klasse naar MainActivity klasse.
                		Intro.this.startActivity(mainIntent);
            		}
        	}, SPLASH_DISPLAY_LENGTH);
	}
}
