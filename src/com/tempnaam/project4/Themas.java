package com.tempnaam.project4;


import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.project4.R;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Themas extends Activity {

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.themas);
        
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
        	   Intent overons_i = new Intent(Themas.this, Overons.class);
        	   startActivity(overons_i);
           }
        });
        /*
         * End Header bar
         */
       
        
        
        
//        TextView thema1 = (TextView)this.findViewById(R.id.thema1);
//        thema1.setOnClickListener(new OnClickListener() {
//          public void onClick(View view) {
//        	System.out.println("hallo");
//            finish(); //finish sluit de app;
//          }
//        });

    }
	
	public void thema1(View view){
    	Intent browse = new Intent( Intent.ACTION_VIEW , Uri.parse( "http://www.amnesty.nl/mensenrechten/themas/bedrijven-en-mensenrechten" ) );
        startActivity( browse );
    }
	public void thema2(View view){
    	Intent browse = new Intent( Intent.ACTION_VIEW , Uri.parse( "http://www.amnesty.nl/mensenrechten/themas/doodstraf" ) );
        startActivity( browse );
    }
	public void thema3(View view){
    	Intent browse = new Intent( Intent.ACTION_VIEW , Uri.parse( "http://www.amnesty.nl/mensenrechten/themas/economische-sociale-en-culturele-rechten" ) );
        startActivity( browse );
    }
	public void thema4(View view){
    	Intent browse = new Intent( Intent.ACTION_VIEW , Uri.parse( "http://www.amnesty.nl/mensenrechten/themas/gevangenen-marteling-moorden-en-verdwijningen" ) );
        startActivity( browse );
    }
	public void thema5(View view){
    	Intent browse = new Intent( Intent.ACTION_VIEW , Uri.parse( "http://www.amnesty.nl/mensenrechten/themas/internationaal-recht-en-berechting" ) );
        startActivity( browse );
    }
	public void thema6(View view){
    	Intent browse = new Intent( Intent.ACTION_VIEW , Uri.parse( "http://www.amnesty.nl/mensenrechten/themas/lgbt" ) );
        startActivity( browse );
    }
	public void thema7(View view){
    	Intent browse = new Intent( Intent.ACTION_VIEW , Uri.parse( "http://www.amnesty.nl/mensenrechten/themas/mensenrechten-in-nederland" ) );
        startActivity( browse );
    }
	public void thema8(View view){
    	Intent browse = new Intent( Intent.ACTION_VIEW , Uri.parse( "http://www.amnesty.nl/mensenrechten/themas/mensenrechteneducatie" ) );
        startActivity( browse );
    }
	public void thema9(View view){
    	Intent browse = new Intent( Intent.ACTION_VIEW , Uri.parse( "http://www.amnesty.nl/mensenrechten/themas/mensenrechtenverdedigers" ) );
        startActivity( browse );
    }
	public void thema10(View view){
    	Intent browse = new Intent( Intent.ACTION_VIEW , Uri.parse( "http://www.amnesty.nl/mensenrechten/themas/vrijheid-meningsuiting" ) );
        startActivity( browse );
    }
	public void thema11(View view){
    	Intent browse = new Intent( Intent.ACTION_VIEW , Uri.parse( "http://www.amnesty.nl/mensenrechten/themas/vrouwen" ) );
        startActivity( browse );
    }
	
}
