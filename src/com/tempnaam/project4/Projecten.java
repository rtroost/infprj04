package com.tempnaam.project4;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.project4.R;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Projecten extends Activity {

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.projecten);
        
        /*
         * Header bar
         */
        Button closeButton = (Button)this.findViewById(R.id.search);
        closeButton.setOnClickListener(new OnClickListener() {
          public void onClick(View view) {
        	System.out.println("hallo");
            finish(); //finish sluit de app;
          }
        });
        
        Button overons = (Button) findViewById(R.id.overons);
        overons.setOnClickListener(new View.OnClickListener() {
           public void onClick(View arg0) {
        	   Intent overons_i = new Intent(Projecten.this, Overons.class);
        	   startActivity(overons_i);
           }
        });
        /*
         * End Header bar
         */
       
    }
	
}
