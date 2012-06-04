package com.tempnaam.project4;

import java.util.Timer;
import java.util.TimerTask;



import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.project4.R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class Project4Activity extends Activity {
	
	//private Button closeButton;
	public int currentimageindex=0;
    Timer timer;
    TimerTask task;
    ImageView slidingimage;
 
    private int[] IMAGE_IDS = {
            R.drawable.foto1, R.drawable.foto2, R.drawable.foto3,
            R.drawable.foto4
        };
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	
    	if (android.os.Build.VERSION.SDK_INT > 9) {
    	      StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
    	      StrictMode.setThreadPolicy(policy);
    	    }

    	
        super.onCreate(savedInstanceState);
        
        
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        
        View v = inflater.inflate(R.layout.main, null);
        
        LinearLayout menuitems = (LinearLayout) v.findViewById(R.id.menuitems);
        
        try{
            ApplicationInfo info = getPackageManager().getApplicationInfo("com.tempname.project4", 0 );
            
            Button button = new Button(Project4Activity.this);
            button.setText("Klik hier om de Amnesty Wallpaper app te openen.");
            button.setTextSize(12);
            button.setBackgroundResource(R.drawable.buttonview);
            button.setOnClickListener(new OnClickListener(){
            	public void onClick(View arg0) {
            		
            		Intent LaunchIntent = getPackageManager().getLaunchIntentForPackage("com.tempname.project4");
            		startActivity( LaunchIntent );

                 }
            });
            
            GridLayout.LayoutParams buttonpar = new GridLayout.LayoutParams();
            buttonpar.width = -1;
            buttonpar.height = 100;

            menuitems.addView(button, buttonpar);
            
        } catch( PackageManager.NameNotFoundException e ){
        	Button button = new Button(Project4Activity.this);
            button.setText("Doneer en Download de Amnesty Wallpaper app.");
            button.setTextSize(12);
            button.setBackgroundResource(R.drawable.buttonview);
            button.setOnClickListener(new OnClickListener(){
            	public void onClick(View arg0) {
            		
            		Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store?hl=nl"));
            		startActivity(browserIntent);

                 }
            });
            
            GridLayout.LayoutParams buttonpar = new GridLayout.LayoutParams();
            buttonpar.width = -1;
            buttonpar.height = 100;


            menuitems.addView(button, buttonpar);
        }
        
        
        
        
		GridLayout line = new GridLayout(this);
		line.setBackgroundResource(R.color.gray);
		
		GridLayout.LayoutParams first = new GridLayout.LayoutParams();
		first.width = -1;
		first.height = 2;
		first.topMargin = 10;
		first.bottomMargin = 10;

		menuitems.addView(line, first);	
        
        setContentView(v);

        
        /*
         * Header bar
         */
        Button searchButton = (Button)this.findViewById(R.id.search);
        searchButton.setOnClickListener(new OnClickListener() {
          public void onClick(View view) {
        	Intent search = new Intent(Project4Activity.this, Search.class);
       	    startActivity(search);
          }
        });
        
        Button homebutton = (Button) findViewById(R.id.homebutton);
        homebutton.setOnClickListener(new View.OnClickListener() {
           public void onClick(View arg0) {
        	   Intent home_i = new Intent(Project4Activity.this, Project4Activity.class);
        	   startActivity(home_i);
           }
        });
        
        Button overons = (Button) findViewById(R.id.overons);
        overons.setOnClickListener(new View.OnClickListener() {
           public void onClick(View arg0) {
        	   Intent overons_i = new Intent(Project4Activity.this, Overons.class);
        	   startActivity(overons_i);
           }
        });
        
        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
           public void onClick(View arg0) {
        	   Intent button3_i = new Intent(Project4Activity.this, Actiepager.class);
        	   startActivity(button3_i);
           }
        });
        
        /*
         * End Header bar
         */
        
        // begin slider
        final Handler mHandler = new Handler();
        // Create runnable for posting
        final Runnable mUpdateResults = new Runnable() {
            public void run() {
 
                AnimateandSlideShow();
 
            }
        };
        int delay = 1000; // delay for 1 sec.
        int period = 8000; // repeat every 4 sec.
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
        public void run() {
             mHandler.post(mUpdateResults);
        }
        }, delay, period);
        // end slider
        
        Button themas = (Button) findViewById(R.id.themas);
        themas.setOnClickListener(new View.OnClickListener() {
           public void onClick(View arg0) {
        	   Intent i = new Intent(Project4Activity.this, Themas.class);
        	   startActivity(i);
           }
        });
        
        Button steunonsButton = (Button) findViewById(R.id.steunons);
        steunonsButton.setOnClickListener(new View.OnClickListener() {
           public void onClick(View arg0) {
        	   Intent i = new Intent(Project4Activity.this, Steunons.class);
        	   startActivity(i);
           }
        });
        
        Button agendaButton = (Button) findViewById(R.id.agenda);
        agendaButton.setOnClickListener(new View.OnClickListener() {
           public void onClick(View arg0) {
        	   Intent i = new Intent(Project4Activity.this, Agenda.class);
        	   startActivity(i);
           }
        });
        
        Button socialmediaButton = (Button) findViewById(R.id.socialmedia);
        socialmediaButton.setOnClickListener(new View.OnClickListener() {
           public void onClick(View arg0) {
        	   Intent i = new Intent(Project4Activity.this, Socialmedia.class);
        	   startActivity(i);
           }
        });
        
       
    }
    
    /**
     * Helper method to start the animation on the splash screen
     */
    private void AnimateandSlideShow() {
 
        slidingimage = (ImageView)findViewById(R.id.ImageSlider);
        slidingimage.setImageResource(IMAGE_IDS[currentimageindex%IMAGE_IDS.length]);
 
        currentimageindex++;
 
        Animation rotateimage = AnimationUtils.loadAnimation(this, R.anim.custom_anim);
 
          slidingimage.startAnimation(rotateimage);
 
    }

}