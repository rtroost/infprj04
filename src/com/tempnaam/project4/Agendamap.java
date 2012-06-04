package com.tempnaam.project4;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.project4.R;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.google.android.maps.MapActivity;
import com.google.android.maps.MapView;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;



public class Agendamap extends MapActivity {

	private MapView mapView;
	private static final Point[] punten = {new Point(51695624, 5297320)};
	private static final String[] teksten = {"Film Justice for Sale - Den Bosch, Verkadefabriek"};
	private static final int latitudeE6 = 52501176;
	private static final int longitudeE6 = 4960327;
	private static GeoPoint zoompoint = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
         
        super.onCreate(savedInstanceState);
        setContentView(R.layout.agendamap);
        
        /*
         * Header bar
         */
        Button search = (Button)this.findViewById(R.id.search);
        search.setOnClickListener(new OnClickListener() {
          public void onClick(View view) {
           Intent search_i = new Intent(Agendamap.this, Search.class);
       	   startActivity(search_i);
          }
        });
        
        Button homebutton = (Button) findViewById(R.id.homebutton);
        homebutton.setOnClickListener(new View.OnClickListener() {
           public void onClick(View arg0) {
        	   Intent home_i = new Intent(Agendamap.this, Project4Activity.class);
        	   startActivity(home_i);
           }
        });
        
        Button overons = (Button) findViewById(R.id.overons);
        overons.setOnClickListener(new View.OnClickListener() {
           public void onClick(View arg0) {
        	   Intent overons_i = new Intent(Agendamap.this, Overons.class);
        	   startActivity(overons_i);
           }
        });
        /*
         * End Header bar
         */
        
        Button themas = (Button) findViewById(R.id.themas);
        themas.setOnClickListener(new View.OnClickListener() {
           public void onClick(View arg0) {
        	   Intent i = new Intent(Agendamap.this, Themas.class);
        	   startActivity(i);
           }
        });
        
        Button steunonsButton = (Button) findViewById(R.id.steunons);
        steunonsButton.setOnClickListener(new View.OnClickListener() {
           public void onClick(View arg0) {
        	   Intent i = new Intent(Agendamap.this, Steunons.class);
        	   startActivity(i);
           }
        });
        
        Button agendaButton = (Button) findViewById(R.id.agenda);
        agendaButton.setOnClickListener(new View.OnClickListener() {
           public void onClick(View arg0) {
        	   Intent i = new Intent(Agendamap.this, Agenda.class);
        	   startActivity(i);
           }
        });
        
         
        mapView = (MapView) findViewById(R.id.map_view);      
        mapView.setBuiltInZoomControls(true);
         
        List<Overlay> mapOverlays = mapView.getOverlays();
        Drawable drawable = this.getResources().getDrawable(R.drawable.logo);
        CustomItemizedOverlay itemizedOverlay =
        new CustomItemizedOverlay(drawable, this);
        
        for(int i = 0; i < punten.length; i++){
        	
        	GeoPoint point = new GeoPoint(punten[i].x, punten[i].y);
            OverlayItem overlayitem =
            new OverlayItem(point, "Amnesty Nederland", teksten[i]);
            
            itemizedOverlay.addOverlay(overlayitem);
            mapOverlays.add(itemizedOverlay);
            
            if(i == 0){
        		zoompoint = point;
        	}
        }
        
        
        
        
        
        MapController mapController = mapView.getController();
           
        mapController.animateTo(zoompoint);
        mapController.setZoom(9);

        
    }
 
    @Override
    protected boolean isRouteDisplayed() {
        return false;
    }

}
