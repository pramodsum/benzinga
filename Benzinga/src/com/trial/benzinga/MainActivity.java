package com.trial.benzinga;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.TabHost;

public class MainActivity extends Activity {
	public static TabHost tabHost;
	public static ActionBar actionBar;
	public static Context context;

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		actionBar = getActionBar();
	    actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
	    actionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(
	    		R.color.DarkBlue)));
	    actionBar.setStackedBackgroundDrawable(new ColorDrawable(getResources().getColor(
	    		R.color.LightBlue)));
	    actionBar.setDisplayShowTitleEnabled(false);
		addTabs();
		actionBar.show(); 
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.main, menu);
	    return super.onCreateOptionsMenu(menu);
	}
	
	private void addTabs() {
	    Tab tab = actionBar.newTab()
	                       .setText("Watchlist")
	                       .setTabListener(new TabListener<WatchlistFragment>(
	                               this, "Watchlist", WatchlistFragment.class));
	    actionBar.addTab(tab);
	    
	    tab = actionBar.newTab()
                .setText("News")
                .setTabListener(new TabListener<NewsFragment>(
                        this, "News", NewsFragment.class));
	    actionBar.addTab(tab);
	    
	    tab = actionBar.newTab()
                .setText("Trending")
                .setTabListener(new TabListener<TrendingFragment>(
                        this, "Trending", TrendingFragment.class));
	    actionBar.addTab(tab);
    }
}
