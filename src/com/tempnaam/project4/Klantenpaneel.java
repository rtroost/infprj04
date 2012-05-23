package com.tempnaam.project4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.project4.R;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Klantenpaneel extends Activity {
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.klantenpaneel);
        
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
        
        Button klantenpaneel = (Button) findViewById(R.id.klantenpaneel);
        klantenpaneel.setOnClickListener(new View.OnClickListener() {
           public void onClick(View arg0) {
        	   Intent i = new Intent(Klantenpaneel.this, Klantenpaneel.class);
        	   startActivity(i);
           }
        });
        /*
         * End Header bar
         */
       
    }

}
