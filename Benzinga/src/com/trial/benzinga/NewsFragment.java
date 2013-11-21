package com.trial.benzinga;

import java.util.ArrayList;

import android.app.DialogFragment;
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

/** NewsFragment tab for displaying all the most current news articles pulled from the Benzinga API
 * @author: Sumedha Pramod
 * @version: 0.1
 */
public class NewsFragment extends Fragment implements View.OnClickListener {
	public static String TAG="DirectionsFragment";
	private String[] list_items = new String[10];
	public static ArrayList<Story> list;
	ListView lView1;
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container, 
			Bundle savedInstanceState) {
	    View view = inflater.inflate(R.layout.news_layout, container, false);
	    addStories();
	    createListView(view);
	    return view;
	}
	
	private void createListView(View view) {
	    lView1 = (ListView) view.findViewById(R.id.news_list);
	    final MySimpleArrayAdapter adapter = new MySimpleArrayAdapter(getActivity(), list);
	    lView1.setAdapter(adapter);
	    lView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
				@Override
				public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
	            	final DialogFragment dialog = new StoryDialogFragment(position);
	    			dialog.show(getFragmentManager(), "StoryDialogFragment");
				}
			});
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
	    TextView time = (TextView) rowView.findViewById(R.id.time_since_story);
//	    ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
	    title.setText(values.get(position).title);
	    desc.setText(values.get(position).snippet);
	    time.setText(values.get(position).time);
	    return rowView;
	  }
	} 
	
	private void addStories() {
		list = new ArrayList<Story>();
	    for (int i = 0; i < 10; ++i) {
	    	list.add(new Story(i));
	    }
	}
	
	public void onClick(View v) { };
}