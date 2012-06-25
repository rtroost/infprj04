package com.tempnaam.project4;

import java.util.List;
import java.util.Vector;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.project4.R;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.actionbarsherlock.view.MenuItem.OnMenuItemClickListener;
import com.viewpagerindicator.TitlePageIndicator;

public class Project4Activity extends SherlockFragmentActivity {

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

		this.initialisePaging();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add("Back")
				.setOnMenuItemClickListener(new OnMenuItemClickListener() {

					@Override
					public boolean onMenuItemClick(MenuItem item) {
						mPager.setCurrentItem(0);
						return true;
					}
				}).setIcon(android.R.drawable.ic_media_previous)
				.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);

		menu.add("Info")
				.setOnMenuItemClickListener(new OnMenuItemClickListener() {

					@Override
					public boolean onMenuItemClick(MenuItem item) {
						Intent overons_i = new Intent(Project4Activity.this,
								Overons.class);
						startActivity(overons_i);
						return true;
					}
				}).setIcon(android.R.drawable.ic_menu_info_details)
				.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);

		menu.add("Search")
				.setOnMenuItemClickListener(new OnMenuItemClickListener() {

					@Override
					public boolean onMenuItemClick(MenuItem item) {
						Intent search_intent = new Intent(
								Project4Activity.this, Search.class);
						startActivity(search_intent);
						return true;
					}
				}).setIcon(android.R.drawable.ic_menu_search)
				.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);

		return true;
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

		mAdapter = new MyPagerAdapter(
				getSupportFragmentManager(), fragments);

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