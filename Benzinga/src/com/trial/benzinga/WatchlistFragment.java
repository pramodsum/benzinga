package com.trial.benzinga;

import java.util.ArrayList;

import com.trial.benzinga.TrendingFragment.MySimpleArrayAdapter;
import com.trial.benzinga.TrendingFragment.Tweet;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class WatchlistFragment extends Fragment {
	public static String TAG="DirectionsFragment";
	private String[] list_items = new String[11];
	ArrayList<Stock> list;
	ListView lView1;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, 
			Bundle savedInstanceState) {
	    View view = inflater.inflate(R.layout.watchlist_layout, container, false);
	    addStocks();
	    createListView(view);
	    return view;
	}
	
	private void createListView(View view) {
	    lView1 = (ListView) view.findViewById(R.id.watchlist);
	    lView1.setAdapter(new MySimpleArrayAdapter(getActivity(), list));
	}

	public class MySimpleArrayAdapter extends ArrayAdapter<String> {
	  private final Context context;
	  private final ArrayList<Stock> values;
	
	  public MySimpleArrayAdapter(Context context, ArrayList<Stock> list) {
	    super(context, R.layout.stock, list_items);
	    this.context = context;
	    this.values = list;
	  }
	
	  @Override
	  public View getView(int position, View convertView, ViewGroup parent) {
	    LayoutInflater inflater = (LayoutInflater) context
	        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	    View rowView = inflater.inflate(R.layout.stock, parent, false);
	    TextView stock = (TextView) rowView.findViewById(R.id.stock);
	    TextView company = (TextView) rowView.findViewById(R.id.company);
	    TextView price = (TextView) rowView.findViewById(R.id.price);
	    TextView dollar_change = (TextView) rowView.findViewById(R.id.dollar_change);
	    TextView percent_change = (TextView) rowView.findViewById(R.id.percent_change);
//	    ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
	    stock.setText(values.get(position).stock_name);
	    company.setText(values.get(position).company);
	    price.setText(values.get(position).price);
	    dollar_change.setText(values.get(position).dollar_change);
	    percent_change.setText(values.get(position).percent_change);
	    return rowView;
	  }
	} 
	
	private void addStocks() {
		list = new ArrayList<Stock>();
	    for (int i = 0; i < list_items.length; ++i) {
	    	list.add(new Stock(i));
	    }
	}
	
	public class Stock { 
		public String stock_name, company, price, dollar_change, percent_change;
		
		Stock(int i) {
			stock_name = "AAPL";
			company = "Apple Inc.";
			price = "$523.39";
			dollar_change = "+2.15";
			percent_change = "(+0.41%)";
		}
	};
}
