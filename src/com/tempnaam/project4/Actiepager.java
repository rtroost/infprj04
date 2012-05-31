package com.tempnaam.project4;

import java.util.List;
import java.util.Vector;

import android.os.Bundle;
import android.project4.R;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

public class Actiepager extends FragmentActivity {

	private PagerAdapter mPagerAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.actiepager);

		// initialize the pager
		this.initialisePaging();
	}

	/**
	 * Initialize the fragments to be paged
	 */
	private void initialisePaging() {

		List<Fragment> fragments = new Vector<Fragment>();
		fragments.add(Fragment.instantiate(this, Actiepager_schrijfacties.class.getName()));
		fragments.add(Fragment.instantiate(this, Actiepager_petities.class.getName()));
		fragments.add(Fragment.instantiate(this, Actiepager_specialeacties.class.getName()));
		this.mPagerAdapter = new MyPagerAdapter(
				super.getSupportFragmentManager(), fragments);

		ViewPager pager = (ViewPager) super.findViewById(R.id.viewPager);
		pager.setAdapter(this.mPagerAdapter);
		
//		//Bind the title indicator to the adapter
//		TitlePageIndicator titleIndicator = (TitlePageIndicator)findViewById(R.id.titles);
//		titleIndicator.setViewPager(pager);
	}

	class MyPagerAdapter extends FragmentPagerAdapter {
		private final List<Fragment> fragments;

		/**
		 * @param fm
		 * @param fragments
		 */
		public MyPagerAdapter(FragmentManager fm, List<Fragment> fragments) {
			super(fm);
			this.fragments = fragments;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see android.support.v4.app.FragmentPagerAdapter#getItem(int)
		 */
		@Override
		public Fragment getItem(int position) {
			return this.fragments.get(position);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see android.support.v4.view.PagerAdapter#getCount()
		 */
		@Override
		public int getCount() {
			return this.fragments.size();
		}
	}
}
