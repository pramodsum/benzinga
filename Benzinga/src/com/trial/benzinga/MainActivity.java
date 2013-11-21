package com.trial.benzinga;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.app.DialogFragment;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.ColorDrawable;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.TabHost;
/**
 * @author: Sumedha Pramod
 * @version: 0.1
 */
public class MainActivity extends Activity implements 
		StoryDialogFragment.NoticeDialogListener,
		TweetDialogFragment.NoticeDialogListener {
	public static TabHost tabHost;
	public static ActionBar actionBar;
	public static Context context;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if(savedInstanceState == null) {
			setContentView(R.layout.activity_main);
		}
	    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
	    create_actionbar();
	}
	
	/**
	 * Create action bar at top of screen and set color scheme
	 */
	private void create_actionbar() {
		actionBar = getActionBar();
	    actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
	    actionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(
	    		R.color.DarkBlue)));
	    actionBar.setStackedBackgroundDrawable(new ColorDrawable(getResources().getColor(
	    		R.color.LightBlue)));
	    actionBar.setDisplayShowTitleEnabled(true);
		addTabs();
		actionBar.show(); 
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.main, menu);
	    return super.onCreateOptionsMenu(menu);
	}
	
	/**
	 * Create Watchlist, News, and Trending tabs
	 */
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

	public void onDialogNegativeClick(DialogFragment dialog) {}
}
