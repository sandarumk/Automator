package com.dinu.automator.view;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.dinu.automator.R;
import com.dinu.automator.activity.ProfileActivity;
import com.dinu.automator.activity.ProfileSettingsActivity;

public class SetLocationDialogFragment extends DialogFragment{
	
	private String latitude;
	private String longtitude;
	
	
	
	
	public SetLocationDialogFragment(String latitude, String longtitude) {
		super();
		this.latitude = latitude;
		this.longtitude = longtitude;
	}
	



	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater= getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.set_location_dialog, null);
        EditText textLatitude = (EditText) view.findViewById(R.id.editText_lttitude);
        if (textLatitude != null && this.latitude != null){
        	textLatitude.setText(latitude);
        }
        EditText textLongitude =(EditText) view.findViewById(R.id.editText_longitude);
        if (textLongitude!=null  && this.longtitude != null){
        	textLongitude.setText(longtitude);
        }
        builder.setView(view);
        
        builder.setMessage(R.string.title_dialog_set_location)
               .setPositiveButton(R.string.dialog_button_save, new DialogInterface.OnClickListener() {
                   public void onClick(DialogInterface dialog, int id) {
                   
                   startActivity(new Intent(getActivity(), ProfileSettingsActivity.class)); 
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
}

