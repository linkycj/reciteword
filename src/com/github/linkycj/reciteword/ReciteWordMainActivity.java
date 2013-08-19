package com.github.linkycj.reciteword;

import java.util.Locale;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;

public class ReciteWordMainActivity extends FragmentActivity {

	private final int DICTIONARY = 0;
	private final int SKIM = 1;
	private final int REVIEW = 2;
	private final int TOTAL_SIZE = 3;
	
	/**
	 * The {@link android.support.v4.view.PagerAdapter} that will provide
	 * fragments for each of the sections. We use a
	 * {@link android.support.v4.app.FragmentPagerAdapter} derivative, which
	 * will keep every loaded fragment in memory. If this becomes too memory
	 * intensive, it may be best to switch to a
	 * {@link android.support.v4.app.FragmentStatePagerAdapter}.
	 */
	SectionsPagerAdapter mSectionsPagerAdapter;

	/**
	 * The {@link ViewPager} that will host the section contents.
	 */
	ViewPager mViewPager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_recite_word_main);

		// Create the adapter that will return a fragment for each of the three
		// primary sections of the app.
		mSectionsPagerAdapter = new SectionsPagerAdapter(
				getSupportFragmentManager());

		// Set up the ViewPager with the sections adapter.
		mViewPager = (ViewPager) findViewById(R.id.pager);
		mViewPager.setAdapter(mSectionsPagerAdapter);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.recite_word_main, menu);
		return true;
	}

	/**
	 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
	 * one of the sections/tabs/pages.
	 */
	public class SectionsPagerAdapter extends FragmentPagerAdapter {

		public SectionsPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			// getItem is called to instantiate the fragment for the given page.
			// Return a DummySectionFragment (defined as a static inner class
			// below) with the page number as its lone argument.
			Fragment fragment = null;
			switch (position) {
			case DICTIONARY:
				fragment = new DictionaryFragment();
				break;
			case SKIM:
				fragment = new SkimFragment();
				break;
			case REVIEW:
				fragment = new ReviewFragment();
				break;
			}
			return fragment;
		}

		@Override
		public int getCount() {
			return TOTAL_SIZE;
		}

		@Override
		public CharSequence getPageTitle(int position) {
			Locale loc = Locale.getDefault();
			switch (position) {
			case DICTIONARY:
				return getString(R.string.title_dictionary).toUpperCase(loc);
			case SKIM:
				return getString(R.string.title_skim).toUpperCase(loc);
			case REVIEW:
				return getString(R.string.title_review).toUpperCase(loc);
			}
			return null;
		}
	}

}
