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
        
        Button homebutton = (Button) findViewById(R.id.homebutton);
        homebutton.setOnClickListener(new View.OnClickListener() {
           public void onClick(View arg0) {
        	   Intent home_i = new Intent(Steunons.this, Project4Activity.class);
        	   startActivity(home_i);
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
        
        Button themas = (Button) findViewById(R.id.themas);
        themas.setOnClickListener(new View.OnClickListener() {
           public void onClick(View arg0) {
        	   Intent i = new Intent(Steunons.this, Themas.class);
        	   startActivity(i);
           }
        });
        
        Button steunonsButton = (Button) findViewById(R.id.steunons);
        steunonsButton.setOnClickListener(new View.OnClickListener() {
           public void onClick(View arg0) {
        	   Intent i = new Intent(Steunons.this, Steunons.class);
        	   startActivity(i);
           }
        });
        
        Button agendaButton = (Button) findViewById(R.id.agenda);
        agendaButton.setOnClickListener(new View.OnClickListener() {
           public void onClick(View arg0) {
        	   Intent i = new Intent(Steunons.this, Agenda.class);
        	   startActivity(i);
           }
        });
        
        
      
        
        
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
