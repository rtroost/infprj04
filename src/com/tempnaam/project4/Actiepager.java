package com.tempnaam.project4;

import java.util.List;
import java.util.Vector;

import android.os.Bundle;
import android.project4.R;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.viewpagerindicator.TitlePageIndicator;

public class Actiepager extends FragmentActivity {
	MyPagerAdapter mAdapter;
	ViewPager mPager;
	TitlePageIndicator mIndicator;

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
		fragments.add(Fragment.instantiate(this,
				Actiepager_schrijfacties.class.getName()));
		fragments.add(Fragment.instantiate(this,
				Actiepager_petities.class.getName()));
		fragments.add(Fragment.instantiate(this,
				Actiepager_specialeacties.class.getName()));
		
		MyPagerAdapter mAdapter = new MyPagerAdapter(getSupportFragmentManager(),
				fragments);

		mPager = (ViewPager)findViewById(R.id.pager);
        mPager.setAdapter(mAdapter);

        mIndicator = (TitlePageIndicator)findViewById(R.id.titles);
        mIndicator.setViewPager(mPager);
	}

	class MyPagerAdapter extends FragmentPagerAdapter {
		private final List<Fragment> fragments;
		protected final String[] CONTENT = new String[] { "Schrijfacties", "Petities", "Speciale Acties", };

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
