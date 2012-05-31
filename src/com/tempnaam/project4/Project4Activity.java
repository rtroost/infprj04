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
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

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
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        /*
         * Header bar
         */
        Button closeButton = (Button)this.findViewById(R.id.search);
        closeButton.setOnClickListener(new OnClickListener() {
          public void onClick(View view) {
        	Intent search = new Intent(Project4Activity.this, Search.class);
       	    startActivity(search);
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