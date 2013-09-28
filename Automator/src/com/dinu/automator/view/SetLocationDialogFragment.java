package com.dinu.automator.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import com.dinu.automator.R;
import com.dinu.automator.activity.ProfileActivity;
import com.dinu.automator.activity.ProfileSettingsActivity;

@SuppressLint("ValidFragment")
public class SetLocationDialogFragment extends DialogFragment {
	
	private String latitude;
	private String longtitude;
	NoticeDialogListener mListener;
	
	
	
	
	public SetLocationDialogFragment(String latitude, String longtitude) {
		super();
		this.latitude = latitude;
		this.longtitude = longtitude;
	}
	

	
	public interface NoticeDialogListener {
        public void onDialogPositiveClick(DialogFragment dialog, double lattitude, double longitude, int radius, String name , boolean entering);
        public void onDialogNegativeClick(DialogFragment dialog);
        
    }



	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater= getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.set_location_dialog, null);
        final EditText textLatitude = (EditText) view.findViewById(R.id.editText_lttitude);
        if (textLatitude != null && this.latitude != null){
        	textLatitude.setText(latitude);
        }
        final EditText textLongitude =(EditText) view.findViewById(R.id.editText_longitude);
        if (textLongitude!=null  && this.longtitude != null){
        	textLongitude.setText(longtitude);
        }
        final EditText name=(EditText)view.findViewById(R.id.editText_name);
        final EditText radius=(EditText)view.findViewById(R.id.editText_radius);
        final RadioButton entering=(RadioButton)view.findViewById(R.id.radiobutton_entering);
        
        
        builder.setView(view);
        
        builder.setMessage(R.string.title_dialog_set_location)
               .setPositiveButton(R.string.dialog_button_save, new DialogInterface.OnClickListener() {
                   public void onClick(DialogInterface dialog, int id) {
                	   getActivity().finish();
                	   
                	   mListener.onDialogPositiveClick(SetLocationDialogFragment.this, Double.parseDouble(textLatitude.getText().toString()),Double.parseDouble(textLongitude.getText().toString()), Integer.parseInt(radius.getText().toString()), name.getText().toString(), entering.isChecked());
                   
                   
                   // save
                      
                   }
               })
               .setNegativeButton(R.string.dialog_button_cancel, new DialogInterface.OnClickListener() {
                   public void onClick(DialogInterface dialog, int id) {
                       
                	   
                   }
               });
        // Create the AlertDialog object and return it
        return builder.create();
    }
	
	@Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        // Verify that the host activity implements the callback interface
        try {
            // Instantiate the NoticeDialogListener so we can send events to the host
            mListener = (NoticeDialogListener) activity;
        } catch (ClassCastException e) {
            // The activity doesn't implement the interface, throw exception
            throw new ClassCastException(activity.toString()
                    + " must implement NoticeDialogListener");
        }
    }
}

