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

public class TrendingFragment extends Fragment implements View.OnClickListener  {
	public static String TAG="DirectionsFragment";
	private String[] list_items = new String[11];
	public static ArrayList<Tweet> list;
	ListView lView1;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, 
			Bundle savedInstanceState) {
	    View view = inflater.inflate(R.layout.trending_layout, container, false);
	    addTweets();
	    createListView(view);
	    return view;
	}
	
	private void createListView(View view) {
	    lView1 = (ListView) view.findViewById(R.id.trendinglist);
	    lView1.setAdapter(new MySimpleArrayAdapter(getActivity(), list));
	    lView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
				@Override
				public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
	            	final DialogFragment dialog = new TweetDialogFragment(position);
	    			dialog.show(getFragmentManager(), "TweetDialogFragment");
				}
			});
	}

	public class MySimpleArrayAdapter extends ArrayAdapter<String> {
	  private final Context context;
	  private final ArrayList<Tweet> values;
	
	  public MySimpleArrayAdapter(Context context, ArrayList<Tweet> list) {
	    super(context, R.layout.tweet, list_items);
	    this.context = context;
	    this.values = list;
	  }
	
	  @Override
	  public View getView(int position, View convertView, ViewGroup parent) {
	    LayoutInflater inflater = (LayoutInflater) context
	        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	    View rowView = inflater.inflate(R.layout.tweet, parent, false);
	    TextView author = (TextView) rowView.findViewById(R.id.tweet_name);
	    TextView username = (TextView) rowView.findViewById(R.id.twitter_username);
	    TextView time = (TextView) rowView.findViewById(R.id.time_since_tweet);
	    TextView text = (TextView) rowView.findViewById(R.id.tweet_text);
//	    ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
	    author.setText(values.get(position).author);
	    username.setText(values.get(position).username);
	    time.setText(values.get(position).time);
	    text.setText(values.get(position).text);
	    return rowView;
	  }
	} 
	
	private void addTweets() {
		list = new ArrayList<Tweet>();
	    for (int i = 0; i < list_items.length; ++i) {
	    	list.add(new Tweet(i));
	    }
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	};
}
