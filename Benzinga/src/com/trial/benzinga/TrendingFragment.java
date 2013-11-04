package com.trial.benzinga;

import java.util.ArrayList;

import com.trial.benzinga.NewsFragment.MySimpleArrayAdapter;
import com.trial.benzinga.NewsFragment.Story;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class TrendingFragment extends Fragment {
	public static String TAG="DirectionsFragment";
	private String[] list_items = new String[11];
	ArrayList<Tweet> list;
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
	
	public class Tweet { 
		public String author, username, text, time, url;
		
		Tweet(int i) {
			author = "Sumedha Pramod";
			username = "@" + "pramodsum";
			text = "Lorem ipsum dolor sit amet, consectetur adipisicing elit, " +
					"sed do eiusmod tempor incididunt ut labore et dolore magna " +
					"aliqua. Ut enim ad minim veniam, quis nostrud exercitation " +
					"ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis " +
					"aute irure dolor in reprehenderit in voluptate velit esse cillum " +
					"dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat " +
					"non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";
			time = 0 + "m ago";
			url = "www.twitter.com";
		}
	};
}
