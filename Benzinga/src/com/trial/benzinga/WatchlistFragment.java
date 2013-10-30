package com.trial.benzinga;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class WatchlistFragment extends Fragment {
	public static String TAG="DirectionsFragment";
	private String[] list_items = {"Watchlist Fragment"};
	ListView lView1;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, 
			Bundle savedInstanceState) {
	    View view = inflater.inflate(R.layout.watchlist_layout, container, false);
	    createListView(view);
	    return view;
	}
	
	private void createListView(View view)
	{
	    lView1 = (ListView) view.findViewById(R.id.watchlist_list);
	    lView1.setAdapter(new ArrayAdapter<String>(getActivity(),
	    android.R.layout.simple_list_item_1, list_items));
	}
}
