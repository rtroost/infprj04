package com.tempnaam.project4;

import java.util.List;
import java.util.Vector;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.project4.R;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.actionbarsherlock.view.MenuItem.OnMenuItemClickListener;
import com.viewpagerindicator.TitlePageIndicator;

public class Project4Activity extends SherlockFragmentActivity {
	
	MyPagerAdapter mAdapter;
	ViewPager mPager;
	TitlePageIndicator mIndicator;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {

		if (android.os.Build.VERSION.SDK_INT > 9) {
			StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
					.permitAll().build();
			StrictMode.setThreadPolicy(policy);
		}
		
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.mainpage_layout);
		
		this.initialisePaging();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add("Back")
				.setOnMenuItemClickListener(new OnMenuItemClickListener() {

					@Override
					public boolean onMenuItemClick(MenuItem item) {
						Intent home_i = new Intent(Project4Activity.this,
								Project4Activity.class);
						startActivity(home_i);
						return false;
					}
				}).setIcon(android.R.drawable.ic_menu_revert)
				.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
		menu.add("Info")
				.setOnMenuItemClickListener(new OnMenuItemClickListener() {

					@Override
					public boolean onMenuItemClick(MenuItem item) {
						Intent overons_i = new Intent(Project4Activity.this,
								Overons.class);
						startActivity(overons_i);
						return false;
					}
				}).setIcon(android.R.drawable.ic_menu_info_details)
				.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
		menu.add("Search")
				.setIcon(android.R.drawable.ic_menu_search)
				.setActionView(R.layout.collapsible_edittext)
				.setShowAsAction(
						MenuItem.SHOW_AS_ACTION_ALWAYS
								| MenuItem.SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW);

		return true;
	}
	
	private void initialisePaging() {

		List<Fragment> fragments = new Vector<Fragment>();
		fragments.add(Fragment.instantiate(this,
				Algemeen.class.getName()));
		fragments.add(Fragment.instantiate(this,
				Themas.class.getName()));
		fragments.add(Fragment.instantiate(this,
				Acties.class.getName()));
		fragments.add(Fragment.instantiate(this,
				Agenda.class.getName()));
		fragments.add(Fragment.instantiate(this,
				Steunons.class.getName()));
		
		MyPagerAdapter mAdapter = new MyPagerAdapter(getSupportFragmentManager(),
				fragments);

		mPager = (ViewPager)findViewById(R.id.pager);
        mPager.setAdapter(mAdapter);

        mIndicator = (TitlePageIndicator)findViewById(R.id.titles);
        mIndicator.setViewPager(mPager);
        
	}

	class MyPagerAdapter extends FragmentPagerAdapter {
		private final List<Fragment> fragments;
		protected final String[] CONTENT = new String[] { "Algemeen", "Thema's", "Acties", "Agenda", "Steun Ons", };

		public MyPagerAdapter(FragmentManager fm, List<Fragment> fragments) {
			super(fm);
			this.fragments = fragments;
		}
		
	    @Override
	    public Fragment getItem(int position) {
	    	return this.fragments.get(position);
	    }

	    @Override
	    public int getCount() {
	        return this.fragments.size();
	    }
	    
	    @Override
	    public CharSequence getPageTitle(int position) {
	        return this.CONTENT[position % CONTENT.length];
	    }
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