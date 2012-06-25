package com.tempnaam.project4;

import java.util.List;
import java.util.Vector;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.project4.R;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.SearchView;

import com.viewpagerindicator.TitlePageIndicator;

public class Project4Activity extends FragmentActivity {

	private MyPagerAdapter mAdapter;
	private ViewPager mPager;
	private TitlePageIndicator mIndicator;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		if (android.os.Build.VERSION.SDK_INT > 9) {
			StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
					.permitAll().build();
			StrictMode.setThreadPolicy(policy);
		}

		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.mainpage_layout);

		ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);

		this.initialisePaging();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menu_layout, menu);
		SearchView searchView = (SearchView) menu.findItem(R.id.menu_search).getActionView();
		
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			mPager.setCurrentItem(0);
			return true;
		case R.id.about:
			Intent intent_about = new Intent(this,
					Overons.class);
			startActivity(intent_about);
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	private void initialisePaging() {

		List<Fragment> fragments = new Vector<Fragment>();
		fragments.add(Fragment.instantiate(this, Algemeen.class.getName()));
		fragments.add(Fragment.instantiate(this, Themas.class.getName()));
		fragments.add(Fragment.instantiate(this, Acties.class.getName()));
		fragments.add(Fragment.instantiate(this, Agenda.class.getName()));
		fragments.add(Fragment.instantiate(this, Socialmedia.class.getName()));
		fragments.add(Fragment.instantiate(this, Steunons.class.getName()));
		fragments.add(Fragment.instantiate(this, Nieuwsbrief.class.getName()));

		mAdapter = new MyPagerAdapter(getSupportFragmentManager(), fragments);

		mPager = (ViewPager) findViewById(R.id.pager);
		mPager.setAdapter(mAdapter);

		mIndicator = (TitlePageIndicator) findViewById(R.id.titles);
		mIndicator.setViewPager(mPager);
	}

	class MyPagerAdapter extends FragmentPagerAdapter {
		private final List<Fragment> fragments;
		protected final String[] CONTENT = new String[] { "Algemeen",
				"Thema's", "Acties", "Agenda", "Social Media", "Steun Ons",
				"Nieuwsbrief", };

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
}