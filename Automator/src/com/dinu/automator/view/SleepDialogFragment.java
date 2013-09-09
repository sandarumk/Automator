package com.dinu.automator.view;


import com.dinu.automator.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

public class SleepDialogFragment extends DialogFragment{
	SleepDialogListener listner;
	
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
	  AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
	         builder .setItems(R.array.sleep, new DialogInterface.OnClickListener(){
	             public void onClick(DialogInterface dialog, int which) {
	               // The 'which' argument contains the index position
	               // of the selected item
	          }
	   });
	    return builder.create();
	}
	
	public interface SleepDialogListener {
        public void onDialogClick(DialogFragment dialog, int which);
        
    }
	
	@Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        // Verify that the host activity implements the callback interface
        try {
            // Instantiate the NoticeDialogListener so we can send events to the host
            listner = (SleepDialogListener) activity;
        } catch (ClassCastException e) {
            // The activity doesn't implement the interface, throw exception
            throw new ClassCastException(activity.toString()
                    + " must implement NoticeDialogListener");
        }
    }


}
