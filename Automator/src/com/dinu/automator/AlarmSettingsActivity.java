package com.dinu.automator;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.MenuItem;

import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class AlarmSettingsActivity extends SherlockActivity {
	
	private Alarm alarmInstance;
	private int index;
	private EditText label;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_alarm_settings);
		
		if (getSupportActionBar() != null) {
			getSupportActionBar().show();
			getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		}
		
		index = getIntent().getIntExtra(Constant.INTENT_EXTRA_ALARM_INDEX, 5);
		

		if (index < 0) {
			alarmInstance = new Alarm();
		} else {
		alarmInstance = DataStore.getAlarmList().get(index);
		}
		
		label=(EditText)findViewById(R.id.editText_alarm_set_label);
		label.setText(alarmInstance.getLabel());
	}

	@Override
	public boolean onCreateOptionsMenu(com.actionbarsherlock.view.Menu menu){
		getSupportMenuInflater().inflate(R.menu.alarm_settings, menu);
		getSupportActionBar().setTitle(alarmInstance.getName());
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
				
				DataStore.addAlarm(alarmInstance);
				index = DataStore.getAlarmList().size() - 1;
				showSaveDialog(this);

			} else {
				DataStore.saveAlarms(this);

				finish();
			}

			return true;

		case R.id.action_delete:
			// delete the current selected alarm
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
		text.setHint("Alarm Name");
		builder.setView(view);
		builder.setPositiveButton(R.string.dialog_button_save, new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				// save the alarm
				
				alarmInstance.setName(text.getText().toString());
				
				DataStore.saveAlarms(context);
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
							DataStore.deleteAlarm(alarmInstance);
							DataStore.saveAlarms(context);
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
	
	
	private void updateData(){
		if(alarmInstance!=null){
			alarmInstance.setLabel(label.getText().toString());
			// set the location from the dialog box
		}
	}

}
