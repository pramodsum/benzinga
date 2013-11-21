package com.trial.benzinga;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

@SuppressLint("ValidFragment")
public class StoryDialogFragment extends DialogFragment {
	int pos;
	public interface NoticeDialogListener {
		public void onDialogNegativeClick(DialogFragment dialog);
	}
	
	public StoryDialogFragment() { pos = 0; }
	public StoryDialogFragment(int position) { pos = position; }

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
		final View view = inflater.inflate(R.layout.story_detail, null);
		
		TextView title = (TextView) view.findViewById(R.id.story_detail_title);
		TextView author = (TextView) view.findViewById(R.id.story_detail_author);
	    TextView text = (TextView) view.findViewById(R.id.story_detail_text);
	    TextView date = (TextView) view.findViewById(R.id.story_detail_date);
//	    ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
	    title.setText(NewsFragment.list.get(pos).title);
	    author.setText(NewsFragment.list.get(pos).author);
	    text.setText(NewsFragment.list.get(pos).text);
	    date.setText(NewsFragment.list.get(pos).date);

		builder.setView(view);
		return builder.show();
	}
}
