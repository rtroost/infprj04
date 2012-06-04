package com.tempnaam.project4;

import java.util.List;

import android.app.Activity;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.project4.R;

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
