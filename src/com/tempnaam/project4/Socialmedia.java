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
		
		//String[] rssTitles = parseRssXml();
		
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
    	
        //TextView tv = new TextView(this);
        
//        for (int i = 0; i < rssItems.size(); i++) {
//        	TextView tv = new TextView(this);
//			tv.setText(rssItems.get(i).getTitle());
//			rss.addView(tv);
//		}
        
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
        	//pubDate.setBackgroundResource(R.color.gray);
        	
        	String descriptionText = rssDescription[i];
        	String[] destokens = descriptionText.split("<");
        	TextView description = new TextView(this);
        	description.setText(destokens[1].substring(2));
        	description.setTextSize(10);
        	
//        	TextView link = new TextView(this);
//        	link.setText(rssLink[i]);
//        	link.setTextColor(1);
        	
			//link.setTextColor(colors);
        	
			rss.addView(title);
			rss.addView(description);
			rss.addView(pubDate);
			//rss.addView(link);

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
        

		
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.socialmedia);
        
        facebook = (WebView) findViewById(R.id.facebook);
        //facebook.setWebViewClient(new ourViewClinet());
        facebook.getSettings().setJavaScriptEnabled(true);
        facebook.loadUrl("http://m.facebook.com/amnestynl?v=feed");
		
        twitter = (WebView) findViewById(R.id.twitter);
        twitter.getSettings().setJavaScriptEnabled(true);
        //twitter.setWebViewClient(new ourViewClinet());
        twitter.getSettings().setUserAgentString("Mozilla/5.0 (Linux; U; Android 2.0; en-us; Droid Build/ESD20) AppleWebKit/530.17 (KHTML, like Gecko) Version/4.0 Mobile Safari/530.17");
        twitter.loadUrl("http://mobile.twitter.com/amnesty");

        //System.out.println(this.getInputStreamFromUrl("http://www.amnestybookings.nl/rss/nieuws"));
        
        
		
        //http://mobile.twitter.com/amnesty
		
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
        	   Intent overons_i = new Intent(Socialmedia.this, Overons.class);
        	   startActivity(overons_i);
           }
        });
        /*
         * End Header bar
         */


        
    	
        
    }
	
	
	private ArrayList<Item> parseRssXml() {
		try {
			/** Handling XML */
			SAXParserFactory spf = SAXParserFactory.newInstance();
			SAXParser sp = spf.newSAXParser();

			XmlParser_rss handler = new XmlParser_rss();
			//sp.parse(getResources().openRawResource(R.raw.schrijfacties), handler);
			//sp.parse(getResources().openRawResource(R.raw.rss), handler);
			
			HttpURLConnection con = null;
			URL url;
			InputStream is=null;
			
			url = new URL("http://www.amnestybookings.nl/rss/nieuws");
			con = (HttpURLConnection) url.openConnection();
			con.connect();
			is = con.getInputStream();
			
			
			sp.parse(is, handler);
			//sp.parse(("http://www.amnestybookings.nl/rss/nieuws"), handler);
			//"http://www.amnestybookings.nl/rss/nieuws"
			ArrayList<Item> items = handler.getItems();
//			String[] title = new String[items.size()];
//			String[] description = new String[items.size()];
//			String[] link = new String[items.size()];
//			String[] pubDate = new String[items.size()];
//
//			for (int i = 0; i < items.size(); i++) {
//				title[i] = items.get(i).getTitle();
//				description[i] = items.get(i).getDescription();
//				description[i] = items.get(i).getDescription();
//				description[i] = items.get(i).getDescription();
//			}

			return items;

		} catch (Exception e) {
			System.out.println("XML Error " + e);
		}
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	public static InputStream getInputStreamFromUrl(String url) {
//		InputStream content = null;
//		try {
//          		HttpClient httpclient = new DefaultHttpClient();
//			HttpPost httpPost = new HttpPost(url);
//			List nameValuePairs = new ArrayList(1);
//                        //this is where you add your data to the post method
//                        nameValuePairs.add(new BasicNameValuePair(
//			"name", "anthony"));
//			httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
//			// Execute HTTP Post Request
//			HttpResponse response = httpclient.execute(httpPost);
//			content = response.getEntity().getContent();
//		        return content;
//	        }
//}
//	
	
//	public InputStream getInputStreamFromUrl(String url) {
//		InputStream content = null;
//		try {
//			HttpGet httpGet = new HttpGet(url);
//			HttpClient httpclient = new DefaultHttpClient();
//			// Execute HTTP Get Request
//			HttpResponse response = httpclient.execute(httpGet);
//			content = response.getEntity().getContent();
//                } catch (Exception e) {
//			//handle the exception !
//		}
//		return content;
//}
	
	
	
	
//	public void saveUrl(String filename, String urlString) throws MalformedURLException, IOException
//    {
//        BufferedInputStream in = null;
//        FileOutputStream fout = null;
//        try
//        {
//                in = new BufferedInputStream(new URL(urlString).openStream());
//                fout = new FileOutputStream(filename);
//
//                byte data[] = new byte[1024];
//                int count;
//                while ((count = in.read(data, 0, 1024)) != -1)
//                {
//                        fout.write(data, 0, count);
//                }
//        }
//        finally
//        {
//                if (in != null)
//                        in.close();
//                if (fout != null)
//                        fout.close();
//        }
//    }

	
	

//	
//	private InputStream downloadUrl(String urlstring) {
//		HttpURLConnection con = null;
//		URL url;
//		InputStream is=null;
//		try {
//			url = new URL(urlstring);
//			con = (HttpURLConnection) url.openConnection();
//			con.setReadTimeout(10000 /* milliseconds */);
//			con.setConnectTimeout(15000 /* milliseconds */);
//			con.setRequestMethod("GET");
//			con.setDoInput(true);
//			con.addRequestProperty("Referer", "http://blog.dahanne.net");
//			// Start the query
//			con.connect();
//			is = con.getInputStream();
//		}catch (IOException e) {
//                        //handle the exception !
//			e.printStackTrace();
//		}
//		return is;
// 
//	}
	
//	private InputStream downloadUrl(String urlstring) {
//		InputStream myInputStream = null;
//		StringBuilder sb = new StringBuilder();
//		// adding some data to send along with the request to the server
//		sb.append("name=Anthony");
//		URL url;
//		try {
//			url = new URL(urlstring);
//			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//			conn.setDoOutput(true);
//			conn.setRequestMethod("POST");
//			OutputStreamWriter wr = new OutputStreamWriter(
//					conn.getOutputStream());
//			// this is were we're adding post data to the request
//			wr.write(sb.toString());
//			wr.flush();
//			myInputStream = conn.getInputStream();
//			wr.close();
//		} catch (Exception e) {
//			// handle the exception !
//			//Log.d(TAG, e.getMessage());
//		}
//		return myInputStream;
//	}
	
	
//	public static void writeContents(File file, String content){
//        BufferedWriter out = null;
//        try {
//            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
//            // Write:
//            out.write(content);
//            /*
//Normally, you don't need to call this manually, because it is called when
//the "close()"-method is called. I like to do it anyhow...
//*/
//            out.flush();
//        } catch (FileNotFoundException e) {
//            // The given file could not be found
//            e.printStackTrace();
//        } catch (IOException e) {
//            // There was a problem writing to the File
//            e.printStackTrace();
//        } finally {
//            // Close the Streams to prevent memory-leaks:
//            if (out != null) try {
//                out.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    /**
//* Reads the raw-data from a given {@code URL}.</p>
//* This method has undefined behaviour for reading binary-
//* files. It is intended for plain-text files only.</p>
//* All possible exceptions are handled internally, this should
//* be changed when in real-use-scenarios...
//* @param url the {@code URL} to read from.
//* @return the raw-content of the document at the given {@code URL}.
//*/
//    public static String readContents(URL url){
//        BufferedReader in = null;
//        try {
//            URLConnection con = url.openConnection();
//            in = new BufferedReader(new InputStreamReader(con.getInputStream()));
//            // Load the contents:
//            String line = in.readLine();
//            /*
//You should use a StringBuilder when appending multiple times
//because it's faster then using normal concation (+=) with Strings.
//*/
//            StringBuilder builder = new StringBuilder();
//            do {
//                builder.append(line+"\n"); // Keep the line-endings (pretty print)
//            } while ( (line = in.readLine()) != null);
//            // Return the contents:
//            return builder.toString();
//        } catch (IOException e) {
//            // Problem reading from the URL
//            e.printStackTrace();
//        } finally {
//            // Close the Streams to prevent memory-leaks:
//            if (in != null) try {
//                in.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        return ""; // Better way to do that...
//    }
	
	
	 @Override
	    public boolean onCreateOptionsMenu(Menu menu) {
		 return false;
//	        super.onCreateOptionsMenu(menu);
//	
//	        menu.add(0, ADD_NEW_TAB, 0, "New Tabs");
//	        return true;
     }

     //Dynamically delete tabs, then add one again
     //Problem with SDK 1.1 returns null pointer exception
     @Override
	    public boolean onOptionsItemSelected(MenuItem item) {
    	 return false;
//	        TabHost tabs = (TabHost) this.findViewById(R.id.my_tabhost);
//	        tabs.clearAllTabs();
//	        tabs.setup();
//	        TabSpec tspec1 = tabs.newTabSpec("New Tab");
//	        tspec1.setIndicator("NEWTAB", this.getResources().getDrawable(R.drawable.logo));
//	        tspec1.setContent(R.id.content);
//	        tabs.addTab(tspec1);
//	
//	        return super.onOptionsItemSelected(item);
     }
     
     
     
     
	
     public class ourViewClinet extends WebViewClient {

    	 @Override
    	 public boolean shouldOverrideUrlLoading(WebView v, String url){
    		 v.loadUrl(url);
    		 return true;
    	 }
    	 
     }
     
//     public class Rss {
//    	 
//    	 	private String url;
//    	 	
//    	 	private ArrayList<String> rssLijst;
//    	 
////    		private static Rss instance = null;
////    		
////    		// een array list maken met in elk deel een arraylist met titel, link, publish, author en description
////
//    		private Rss(String url) {
//    			this.url = url;
//    		}
////
////    		public static Rss getInstance() {
////    			if (instance == null)
////    				instance = new Rss();
////    			return instance;
////    		}
//
//    		public void writeNews() {
//    			try {
//    				DocumentBuilder builder = DocumentBuilderFactory.newInstance()
//    						.newDocumentBuilder();
//    				System.out.println("url wordt geopend:    " + url);
//    				URL u = new URL(url); // your feed
//    				System.out.println("url wordt geopend:    " + 1);
//    				Document doc = builder.parse(u.openStream());
//    				System.out.println("url wordt geopend:    " + 2);
//    				NodeList nodes = doc.getElementsByTagName("item");
//    				System.out.println("url wordt geopend:    " + 3);
//    				for (int i = 0; i < nodes.getLength(); i++) {
//    					Element element = (Element) nodes.item(i);
//    					System.out.println("Title: "
//    							+ getElementValue(element, "title"));
//    					System.out.println("Link: " + getElementValue(element, "link"));
//    					System.out.println("Publish Date: "
//    							+ getElementValue(element, "pubDate"));
//    					System.out.println("Author: "
//    							+ getElementValue(element, "dc:creator"));
//    					System.out.println("Description: "
//    							+ getElementValue(element, "description"));
//    					System.out.println();
//    				}// for
//    			}// try
//    			catch (Exception ex) {
//    				ex.printStackTrace();
//    			}
//    		}
//
//    		private String getCharacterDataFromElement(Element e) {
//    			try {
//    				Node child = e.getFirstChild();
//    				if (child instanceof CharacterData) {
//    					CharacterData cd = (CharacterData) child;
//    					return cd.getData();
//    				}
//    			} catch (Exception ex) {
//
//    			}
//    			return "";
//    		} // private String getCharacterDataFromElement
//
//    		protected float getFloat(String value) {
//    			if (value != null && !value.equals(""))
//    				return Float.parseFloat(value);
//    			else
//    				return 0;
//    		}
//
//    		protected String getElementValue(Element parent, String label) {
//    			return getCharacterDataFromElement((Element) parent
//    					.getElementsByTagName(label).item(0));
//    		}
//
//
//    			
//    		
//    	}
	

}


