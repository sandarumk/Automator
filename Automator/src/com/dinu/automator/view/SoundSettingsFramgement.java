package com.dinu.automator.view;

import com.dinu.automator.Profile;
import com.dinu.automator.R;
import com.dinu.automator.SoundProfile;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.SeekBar;

public class SoundSettingsFramgement extends Fragment {
	private SoundProfile sound;
	private View view;

	private static SoundSettingsFramgement soundSettings;

	public static SoundSettingsFramgement getInstance() {
		if (soundSettings == null) {
			soundSettings = new SoundSettingsFramgement();
		}
		return soundSettings;
	}

	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		view = inflater.inflate(R.layout.sound_setting_fragment, null);
		System.out.println(sound);
		if(sound!=null){
		SeekBar seek = (SeekBar) view.findViewById(R.id.seekBar_volume);
		seek.setProgress(sound.getRingVolume());
		CheckBox chkSilent= (CheckBox)view.findViewById(R.id.check_silent);
		chkSilent.setChecked(sound.isSilentMode());
		 CheckBox chkvib=(CheckBox)view.findViewById(R.id.checkBox_vibration);
		 chkvib.setChecked(sound.isVibration());
		
		}
		/*
		 * 
		 * seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
		 * {
		 * 
		 * @Override public void onStopTrackingTouch(SeekBar seekBar) {
		 * 
		 * 
		 * }
		 * 
		 * @Override public void onStartTrackingTouch(SeekBar seekBar) {
		 * 
		 * 
		 * }
		 * 
		 * @Override public void onProgressChanged(SeekBar seekBar, int
		 * progress, boolean fromUser) { sound.setRing_volume(progress);
		 * 
		 * } });
		 * 
		 * 
		 * chkSilent.setOnCheckedChangeListener(new
		 * CompoundButton.OnCheckedChangeListener() {
		 * 
		 * @Override public void onCheckedChanged(CompoundButton buttonView,
		 * boolean isChecked) { sound.setSilent_mode(isChecked);
		 * 
		 * } });
		 * 
		 *
		 * chkvib.setOnCheckedChangeListener(new
		 * CompoundButton.OnCheckedChangeListener() {
		 * 
		 * @Override public void onCheckedChanged(CompoundButton buttonView,
		 * boolean isChecked) { sound.setVibration(isChecked);
		 * 
		 * } });
		 */
		return view;

	}

	public SoundProfile getSound() {
		return sound;
	}

	public void setSound(SoundProfile sound) {
		
		this.sound = sound;
	}

	public void updateData() {

		// saving in sound object
		
		if (view != null && sound !=null) {
			SeekBar seek = (SeekBar) view.findViewById(R.id.seekBar_volume);
			int volume = seek.getProgress();
			

			CheckBox chkSilent = (CheckBox) view.findViewById(R.id.check_silent);
			boolean silent = chkSilent.isChecked();
		
			CheckBox chkVibration = (CheckBox) view.findViewById(R.id.checkBox_vibration);
			boolean vibration = chkVibration.isChecked();
		
			
			sound.setRingVolume(volume);
			sound.setSilentMode(silent);
			sound.setVibration(vibration);
		}
		

	}

}
