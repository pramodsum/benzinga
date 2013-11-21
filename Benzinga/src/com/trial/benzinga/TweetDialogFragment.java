package com.trial.benzinga;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
/**
 * @author: Sumedha Pramod
 * @version: 0.1
 */
@SuppressLint("ValidFragment")
public class TweetDialogFragment extends DialogFragment {
	int pos;
	public interface NoticeDialogListener {
		public void onDialogNegativeClick(DialogFragment dialog);
	}
	
	public TweetDialogFragment() { pos = 0; }
	public TweetDialogFragment(int position) { pos = position; }

	// Use this instance of the interface to deliver action events
	NoticeDialogListener mListener;

	// Override the Fragment.onAttach() method to instantiate the
	// NoticeDialogListener
	@Override
	public void onAttach(final Activity activity) {
		super.onAttach(activity);
		// Verify that the host activity implements the callback interface
		try {
			// Instantiate the NoticeDialogListener so we can send events to the
			// host
			mListener = (NoticeDialogListener) activity;
		} catch (final ClassCastException e) {
			// The activity doesn't implement the interface, throw exception
			throw new ClassCastException(activity.toString()
					+ " must implement NoticeDialogListener");
		}
	}
	
	public Dialog onCreateDialog(final Bundle savedInstanceState) {
		final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		final LayoutInflater inflater = (getActivity()).getLayoutInflater();
		final View view = inflater.inflate(R.layout.tweet_detail, null);
		
		TextView username = (TextView) view.findViewById(R.id.tweet_detail_username);
		TextView author = (TextView) view.findViewById(R.id.tweet_detail_author);
	    TextView text = (TextView) view.findViewById(R.id.tweet_detail_text);
	    TextView time = (TextView) view.findViewById(R.id.tweet_detail_time);
//	    ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
	    username.setText(TrendingFragment.list.get(pos).username);
	    author.setText(TrendingFragment.list.get(pos).author);
	    text.setText(TrendingFragment.list.get(pos).text);
	    time.setText(TrendingFragment.list.get(pos).time);

		builder.setView(view);
		return builder.show();
	}
}
