package com.tempnaam.project4;

import com.actionbarsherlock.app.SherlockFragment;

import android.os.Bundle;
import android.project4.R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

public class Socialmedia extends SherlockFragment {
	private WebView facebook;
	private WebView twitter;

	private TabHost ll;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		if (container == null) {
			return null;
		}

		ll = (TabHost) inflater.inflate(R.layout.socialmedia, container,
				false);

		setUpFragments();

		return ll;
	}

	public void setUpFragments() {
		Rss rssclass = new Rss();

		rssclass.writeNews();
		String[] rssTitle = rssclass.getTitle();
		String[] rssPubDate = rssclass.getPubDate();
		String[] rssDescription = rssclass.getDescription();

		LinearLayout rss = (LinearLayout) ll.findViewById(R.id.rssll);

		for (int i = 0; i < rssTitle.length; i++) {

			TextView title = new TextView(getActivity());
			title.setText(rssTitle[i]);
			title.setTextColor(R.color.amnastyyellow);

			String pubDateText = rssPubDate[i];
			String[] pubDatetokens = pubDateText.split("[+]");
			TextView pubDate = new TextView(getActivity());
			pubDate.setText(pubDatetokens[0]);
			pubDate.setTextSize(8);
			pubDate.setTextColor(R.color.gray);

			String descriptionText = rssDescription[i];
			String[] destokens = descriptionText.split("<");
			TextView description = new TextView(getActivity());
			description.setText(destokens[1].substring(2));
			description.setTextSize(10);

			rss.addView(title);
			rss.addView(description);
			rss.addView(pubDate);

			GridLayout line = new GridLayout(getActivity());
			line.setBackgroundResource(R.color.gray);
			line.setPadding(0, 10, 0, 10);

			GridLayout.LayoutParams first = new GridLayout.LayoutParams();
			first.width = -1;
			first.height = 2;
			first.topMargin = 10;
			first.bottomMargin = 10;

			rss.addView(line, first);

		}

		facebook = (WebView) ll.findViewById(R.id.facebook);
		facebook.getSettings().setJavaScriptEnabled(true);
		facebook.loadUrl("http://m.facebook.com/amnestynl?v=feed");

		twitter = (WebView) ll.findViewById(R.id.twitter);
		twitter.getSettings().setJavaScriptEnabled(true);
		twitter.getSettings()
				.setUserAgentString(
						"Mozilla/5.0 (Linux; U; Android 2.0; en-us; Droid Build/ESD20) AppleWebKit/530.17 (KHTML, like Gecko) Version/4.0 Mobile Safari/530.17");
		twitter.loadUrl("http://mobile.twitter.com/amnesty");

		TabHost tabs = (TabHost) ll.findViewById(R.id.my_tabhost);
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

	public class ourViewClinet extends WebViewClient {

		@Override
		public boolean shouldOverrideUrlLoading(WebView v, String url) {
			v.loadUrl(url);
			return true;
		}

	}
}
