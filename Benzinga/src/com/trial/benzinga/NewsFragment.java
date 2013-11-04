package com.trial.benzinga;

import java.util.ArrayList;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class NewsFragment extends Fragment {
	public static String TAG="DirectionsFragment";
	private String[] list_items = new String[10];
	ArrayList<Story> list;
	ListView lView1;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, 
			Bundle savedInstanceState) {
	    View view = inflater.inflate(R.layout.news_layout, container, false);
	    addStories();
	    createListView(view);
	    return view;
	}
	
	private void createListView(View view) {
	    lView1 = (ListView) view.findViewById(R.id.news_list);
	    lView1.setAdapter(new MySimpleArrayAdapter(getActivity(), list));
	}

	public class MySimpleArrayAdapter extends ArrayAdapter<String> {
	  private final Context context;
	  private final ArrayList<Story> values;
	
	  public MySimpleArrayAdapter(Context context, ArrayList<Story> values) {
	    super(context, R.layout.story, list_items);
	    this.context = context;
	    this.values = values;
	  }
	
	  @Override
	  public View getView(int position, View convertView, ViewGroup parent) {
	    LayoutInflater inflater = (LayoutInflater) context
	        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	    View rowView = inflater.inflate(R.layout.story, parent, false);
	    TextView title = (TextView) rowView.findViewById(R.id.story_title);
	    TextView desc = (TextView) rowView.findViewById(R.id.story_desc);
//	    ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
	    title.setText(values.get(position).title);
	    desc.setText(values.get(position).snippet);
	    return rowView;
	  }
	} 
	
	private void addStories() {
		list = new ArrayList<Story>();
	    for (int i = 0; i < 10; ++i) {
	    	list.add(new Story(i));
	    }
	}
	
	public class Story { 
		public String title, author, text, snippet;
		
		Story(int i) {
			title = "Story " + Integer.toString(i);
			author = "Author Name";
			text = "Lorem ipsum dolor sit amet, consectetur adipisicing elit, " +
					"sed do eiusmod tempor incididunt ut labore et dolore magna " +
					"aliqua. Ut enim ad minim veniam, quis nostrud exercitation " +
					"ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis " +
					"aute irure dolor in reprehenderit in voluptate velit esse cillum " +
					"dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat " +
					"non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";
			snippet = text.substring(0, 245);
		}
	};
}