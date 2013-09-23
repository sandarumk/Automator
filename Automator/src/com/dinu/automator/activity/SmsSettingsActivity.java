package com.dinu.automator.activity;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.MenuItem;
import com.dinu.automator.Constant;
import com.dinu.automator.DataStore;
import com.dinu.automator.Profile;
import com.dinu.automator.R;
import com.dinu.automator.Sms;
import com.dinu.automator.R.id;
import com.dinu.automator.R.layout;
import com.dinu.automator.R.menu;
import com.dinu.automator.R.string;
import com.dinu.automator.view.DisplaySettingsFragment;
import com.dinu.automator.view.LocationFragment;
import com.dinu.automator.view.SoundSettingsFramgement;

import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.Contacts;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.support.v4.app.ShareCompat.IntentBuilder;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class SmsSettingsActivity extends SherlockActivity {
	
	private Sms smsInstance;
	private int index;
	private static final int CONTACT_PICKER_RESULT = 1001;
	private EditText num;
	private EditText message;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sms_settings);
		

		if (getSupportActionBar() != null) {
			getSupportActionBar().show();
			getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		}
		
		index = getIntent().getIntExtra(Constant.INTENT_EXTRA_SMS_INDEX, 5);
		

		if (index < 0) {
			smsInstance = new Sms();
		} else {
		smsInstance = DataStore.getsmsList().get(index);
		}
		
		Button setLocation = (Button)findViewById(R.id.button_sms_set_location);
		setLocation.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivity(new Intent(SmsSettingsActivity.this,LocatorActivity.class));
				
			}
		});

		ImageButton setContact= (ImageButton)findViewById(R.id.imageButton_sms_contact_picker);
		setContact.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent contactPickerIntent= new Intent(Intent.ACTION_PICK,Contacts.CONTENT_URI);
				startActivityForResult(contactPickerIntent, CONTACT_PICKER_RESULT);
			}
		});
		
		num =(EditText)findViewById(R.id.edittext_sms_phone_number);
		message=(EditText)findViewById(R.id.editText_message);
		
		num.setText(smsInstance.getNumber());
		message.setText(smsInstance.getMessage());
		
		
	}


	
	@Override
	public boolean onCreateOptionsMenu(com.actionbarsherlock.view.Menu menu){
		getSupportMenuInflater().inflate(R.menu.sms_settings, menu);
		getSupportActionBar().setTitle(smsInstance.getName());
		return true;
	}
	

	@Override
	public void onBackPressed() {

		super.onBackPressed();
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			finish();
			return true;
		case R.id.action_save:
			updateData();

			if (index < 0) {
				
				DataStore.addSms(smsInstance);
				index = DataStore.getsmsList().size() - 1;
				showSaveDialog(this);

			} else {
				DataStore.saveSmS(this);

				finish();
			}

			return true;

		case R.id.action_delete:
			// delete the current selected sms
			showDeleteDialog(this);
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	private void showSaveDialog(final Context context) {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		LayoutInflater inflator = this.getLayoutInflater();
		View view = inflator.inflate(R.layout.save_dialog_fragment, null);

		final EditText text = (EditText) view.findViewById(R.id.save_dialog_save);
		text.setHint("Sms Name");
		builder.setView(view);
		builder.setPositiveButton(R.string.dialog_button_save, new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				// save the profile
				
				smsInstance.setName(text.getText().toString());
				
				DataStore.saveSmS(context);
				finish();

			}
		});

		builder.create().show();

	}

	private void showDeleteDialog(final Context context) {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setMessage(R.string.dialog_message_confirm_delete)
				.setPositiveButton(R.string.dialog_button_delete, new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int id) {
						if (index >= 0) {
							DataStore.deleteSms(smsInstance);
							DataStore.saveSmS(context);
						}
						finish();

					}
				}).setNegativeButton(R.string.dialog_button_cancel, new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int id) {

					}
				});
		builder.create().show();
	}
	
	protected void onActivityResult(int requestCode, int resultCode,Intent data) {
		 if (resultCode == RESULT_OK) {  
		        switch (requestCode) {  
		        case CONTACT_PICKER_RESULT:  
		            // handle contact results  
		        	Uri result= data.getData();
		        	String id = result.getLastPathSegment();
		        	Cursor cursor = getContentResolver().query(Phone.CONTENT_URI, null,  
		        	        Phone.CONTACT_ID + "=?",  
		        	        new String[]{id}, null);  
		        	if (cursor.moveToFirst()) {  
		        	    int phoneIdx = cursor.getColumnIndex(Phone.DATA);  
		        	    String number = cursor.getString(phoneIdx);
		        	    num.setText(number);
		        	} 
		            break;  
		        }  
		    }  
	}
	
	private void updateData(){
		if(smsInstance!=null){
			smsInstance.setNumber(num.getText().toString());
			smsInstance.setMessage(message.getText().toString());
			// set the location from the dialog box
		}
	}

}
