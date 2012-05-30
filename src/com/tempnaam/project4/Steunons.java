package com.tempnaam.project4;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.project4.R;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Steunons extends Activity {
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.steunons);
        
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
        	   Intent overons_i = new Intent(Steunons.this, Overons.class);
        	   startActivity(overons_i);
           }
        });
        
        
        /*
         * End Header bar
         */
        
        
      
        
        
        Button doneerWordtLid = (Button) findViewById(R.id.buttonWordLid);
        doneerWordtLid.setOnClickListener(new View.OnClickListener() {
           public void onClick(View arg0) {
        	   Intent browse = new Intent( Intent.ACTION_VIEW , Uri.parse( "http://www.amnesty.nl/steun-amnesty/word-lid" ) );
               startActivity( browse );
           }
        });
        
        
        Button doneerEenmalig = (Button) findViewById(R.id.buttonEenmaligDoneren);
        doneerEenmalig.setOnClickListener(new View.OnClickListener() {
           public void onClick(View arg0) {
        	   Intent browse = new Intent( Intent.ACTION_VIEW , Uri.parse( "http://www.amnesty.nl/steun-amnesty/geef/eenmalige-gift" ) );
               startActivity( browse );
           }
        });
       
        
    }
	
	
}
