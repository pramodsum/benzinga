package com.trial.benzinga;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class NewsFragment extends Fragment {
	public static String TAG="DirectionsFragment";
	private Story[] list_items;
	ListView lView1;
	public static List<Story> news;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, 
			Bundle savedInstanceState) {
	    View view = inflater.inflate(R.layout.news_layout, container, false);
	    createListView(view);
	    return view;
	}
	
	private void createListView(View view) {
	    news = new ArrayList<Story>(3);
	    lView1 = (ListView) view.findViewById(R.id.newslist);
	    lView1.setAdapter(new ArrayAdapter<Story>(getActivity(), android.R.layout.simple_list_item_1, list_items));
	    final ArrayList<Story> list = new ArrayList<Story>();
	    final MySimpleArrayAdapter adapter = new MySimpleArrayAdapter(MainActivity.context, list);
	    lView1.setAdapter(adapter);

	    lView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@SuppressLint("NewApi")
			public void onItemClick(AdapterView<?> parent, final View view, int position, long id) {
				final String item = (String) parent.getItemAtPosition(position);
				view.animate().setDuration(2000).alpha(0)
					.withEndAction(new Runnable() {
						public void run() {
			            list.remove(item);
			            adapter.notifyDataSetChanged();
			            view.setAlpha(1);
			          }
					});
			  	}
		    }
	    );
	}

	public class Story { public String title, author, text; };
	
	public class MySimpleArrayAdapter extends ArrayAdapter<String> {
	  private final Context context;
	  private final ArrayList<Story> values;
	
	  public MySimpleArrayAdapter(Context context, ArrayList<Story> list) {
	    super(context, R.layout.story);
	    this.context = context;
	    this.values = list;
	  }

	@Override
	  public View getView(int position, View convertView, ViewGroup parent) {
	    LayoutInflater inflater = (LayoutInflater) context
	        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	    View rowView = inflater.inflate(R.layout.story, parent, false);
	    TextView title = (TextView) rowView.findViewById(R.id.story_title);
	    TextView text = (TextView) rowView.findViewById(R.id.story_text);
	    title.setText(values.get(position).title);
	    text.setText(values.get(position).text);
	    return rowView;
	  }
	}; 
}