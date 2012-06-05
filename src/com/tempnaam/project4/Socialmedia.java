package com.tempnaam.project4;


import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.w3c.dom.CharacterData;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.project4.R;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;
import android.view.MenuItem;

public class Socialmedia extends Activity {

	private int ADD_NEW_TAB = Menu.FIRST;
	private WebView facebook;
	private WebView twitter;
	private JSONObject json;
	
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		ArrayList<Item> rssItems = parseRssXml();
		
		Rss rssclass = new Rss();
		
		rssclass.writeNews();
		String[] rssTitle = rssclass.getTitle();
		String[] rssPubDate = rssclass.getPubDate();
		String[] rssDescription = rssclass.getDescription();
		String[] rssLink = rssclass.getLink();
		
		LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View v = inflater.inflate(R.layout.socialmedia, null);

        LinearLayout rss = (LinearLayout) v.findViewById(R.id.rssll);
        
        for (int i = 0; i < rssTitle.length; i++) {
        	
        	TextView title = new TextView(this);
        	title.setText(rssTitle[i]);
        	title.setTextColor(R.color.amnastyyellow);
        	
        	String pubDateText = rssPubDate[i];
        	String[] pubDatetokens = pubDateText.split("[+]");
        	TextView pubDate = new TextView(this);
        	pubDate.setText(pubDatetokens[0]);
        	pubDate.setTextSize(8);
        	pubDate.setTextColor(R.color.gray);
        	
        	String descriptionText = rssDescription[i];
        	String[] destokens = descriptionText.split("<");
        	TextView description = new TextView(this);
        	description.setText(destokens[1].substring(2));
        	description.setTextSize(10);
        	
			rss.addView(title);
			rss.addView(description);
			rss.addView(pubDate);

			GridLayout line = new GridLayout(this);
			line.setBackgroundResource(R.color.gray);
			line.setPadding(0, 10, 0, 10);
			
			GridLayout.LayoutParams first = new GridLayout.LayoutParams();
			first.width = -1;
			first.height = 2;
			first.topMargin = 10;
			first.bottomMargin = 10;

			rss.addView(line, first);		
			
		}
        
       setContentView(v);
            
        facebook = (WebView) findViewById(R.id.facebook);
        facebook.getSettings().setJavaScriptEnabled(true);
        facebook.loadUrl("http://m.facebook.com/amnestynl?v=feed");
		
        twitter = (WebView) findViewById(R.id.twitter);
        twitter.getSettings().setJavaScriptEnabled(true);
        twitter.getSettings().setUserAgentString("Mozilla/5.0 (Linux; U; Android 2.0; en-us; Droid Build/ESD20) AppleWebKit/530.17 (KHTML, like Gecko) Version/4.0 Mobile Safari/530.17");
        twitter.loadUrl("http://mobile.twitter.com/amnesty");

        TabHost tabs = (TabHost) this.findViewById(R.id.my_tabhost);
        tabs.setup();
        TabSpec tspec1 = tabs.newTabSpec("First Tab");
        tspec1.setIndicator("Facebook");
        tspec1.setContent(R.id.facebook);
        tabs.addTab(tspec1);
        
        TabSpec tspec2 = tabs.newTabSpec("Second Tab");
        tspec2.setIndicator("Twitter");
        tspec2.setContent(R.id.twitter);
        tabs.addTab(tspec2);
        
        TabSpec tspec3 = tabs.newTabSpec("Third Tab");
        tspec3.setIndicator("Rss Feed");
        tspec3.setContent(R.id.rss);
        tabs.addTab(tspec3);
        
    }

	private ArrayList<Item> parseRssXml() {
		try {
			/** Handling XML */
			SAXParserFactory spf = SAXParserFactory.newInstance();
			SAXParser sp = spf.newSAXParser();

			XmlParser_rss handler = new XmlParser_rss();
			
			HttpURLConnection con = null;
			URL url;
			InputStream is=null;
			
			url = new URL("http://www.amnestybookings.nl/rss/nieuws");
			con = (HttpURLConnection) url.openConnection();
			con.connect();
			is = con.getInputStream();
			
			sp.parse(is, handler);

			ArrayList<Item> items = handler.getItems();
			
			return items;

		} catch (Exception e) {
			System.out.println("XML Error " + e);
		}
		return null;
	}
	
	 @Override
	    public boolean onCreateOptionsMenu(Menu menu) {
		 return false;

     }

     @Override
	    public boolean onOptionsItemSelected(MenuItem item) {
    	 return false;

     }
	
     public class ourViewClinet extends WebViewClient {

    	 @Override
    	 public boolean shouldOverrideUrlLoading(WebView v, String url){
    		 v.loadUrl(url);
    		 return true;
    	 }
    	 
     }

}


