package com.tempnaam.project4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.project4.R;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Agenda extends Activity {
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.agenda);
        
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
        	   Intent overons_i = new Intent(Agenda.this, Agenda.class);
        	   startActivity(overons_i);
           }
        });
        
        Button homebutton = (Button) findViewById(R.id.homebutton);
        homebutton.setOnClickListener(new View.OnClickListener() {
           public void onClick(View arg0) {
        	   Intent home_i = new Intent(Agenda.this, Project4Activity.class);
        	   startActivity(home_i);
           }
        });
        
        Button search = (Button) findViewById(R.id.search);
        overons.setOnClickListener(new View.OnClickListener() {
           public void onClick(View arg0) {
        	   Intent search = new Intent(Agenda.this, Search.class);
        	   startActivity(search);
           }
        });
        /*
         * End Header bar
         */
        
        Button themas = (Button) findViewById(R.id.themas);
        themas.setOnClickListener(new View.OnClickListener() {
           public void onClick(View arg0) {
        	   Intent i = new Intent(Agenda.this, Themas.class);
        	   startActivity(i);
           }
        });
        
        Button steunonsButton = (Button) findViewById(R.id.steunons);
        steunonsButton.setOnClickListener(new View.OnClickListener() {
           public void onClick(View arg0) {
        	   Intent i = new Intent(Agenda.this, Steunons.class);
        	   startActivity(i);
           }
        });
        
        Button agenda1Button = (Button) findViewById(R.id.agenda);
        agenda1Button.setOnClickListener(new View.OnClickListener() {
           public void onClick(View arg0) {
        	   Intent i = new Intent(Agenda.this, Agenda.class);
        	   startActivity(i);
           }
        });
        
        Button agendaButton = (Button) findViewById(R.id.agendamap);
        agendaButton.setOnClickListener(new View.OnClickListener() {
           public void onClick(View arg0) {
        	   Intent i = new Intent(Agenda.this, Agendamap.class);
        	   startActivity(i);
           }
        });
       
    }

}
