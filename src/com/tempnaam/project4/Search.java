package com.tempnaam.project4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.project4.R;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Search extends Activity {
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);
        
        /*
         * Header bar
         */

        Button homebutton = (Button) findViewById(R.id.homebutton);
        homebutton.setOnClickListener(new View.OnClickListener() {
           public void onClick(View arg0) {
        	   Intent home_i = new Intent(Search.this, Project4Activity.class);
        	   startActivity(home_i);
           }
        });
        
        Button overons = (Button) findViewById(R.id.overons);
        overons.setOnClickListener(new View.OnClickListener() {
           public void onClick(View arg0) {
        	   Intent overons_i = new Intent(Search.this, Overons.class);
        	   startActivity(overons_i);
           }
        });
        
        
        Button search = (Button) findViewById(R.id.search);
        search.setOnClickListener(new View.OnClickListener() {
           public void onClick(View arg0) {
      	   Intent overons_i = new Intent(Search.this, Search.class);
       	   startActivity(overons_i);

           }
        });
        
        /*
         * End Header bar
         */
        
        Button themas = (Button) findViewById(R.id.themas);
        themas.setOnClickListener(new View.OnClickListener() {
           public void onClick(View arg0) {
        	   Intent i = new Intent(Search.this, Themas.class);
        	   startActivity(i);
           }
        });
        
        Button steunonsButton = (Button) findViewById(R.id.steunons);
        steunonsButton.setOnClickListener(new View.OnClickListener() {
           public void onClick(View arg0) {
        	   Intent i = new Intent(Search.this, Steunons.class);
        	   startActivity(i);
           }
        });
        
        Button agendaButton = (Button) findViewById(R.id.agenda);
        agendaButton.setOnClickListener(new View.OnClickListener() {
           public void onClick(View arg0) {
        	   Intent i = new Intent(Search.this, Agenda.class);
        	   startActivity(i);
           }
        });
        
       
    }

}
