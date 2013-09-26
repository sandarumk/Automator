package com.dinu.automator.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.CheckBox;
import android.widget.SeekBar;
import android.widget.ToggleButton;

import com.dinu.automator.R;
import com.dinu.automator.SoundProfile;

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
		CheckBox chkVolume= (CheckBox)view.findViewById(R.id.checkBox_volume_enable);
		chkVolume.setChecked(false);
		SeekBar seek = (SeekBar) view.findViewById(R.id.seekBar_volume);
		seek.setProgress(0);
		ToggleButton switchSilent= (ToggleButton)view.findViewById(R.id.switch_silent);
		switchSilent.setChecked(false);
		CheckBox chkSilent=(CheckBox)view.findViewById(R.id.checkBox_silent_enable);
		chkSilent.setChecked(false);
		ToggleButton switchVibration= (ToggleButton)view.findViewById(R.id.switch_vibration);
		switchVibration.setChecked(false);
		CheckBox chkVibration=(CheckBox)view.findViewById(R.id.checkBox_silent_enable);
		chkVibration.setChecked(false);
		
		
		if(sound!=null){
			
		
		chkVolume.setChecked(sound.getRingVolume().isEnable());
		seek.setProgress(sound.getRingVolume().getSetting());
		
		
		switchSilent.setChecked(sound.getSilentMode().getBooleanSetting());
		chkSilent.setChecked(sound.getSilentMode().isEnable());
		
		
		switchVibration.setChecked(sound.getVibration().getBooleanSetting());
		chkVibration.setChecked(sound.getVibration().isEnable());
		 
		
		}
		
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
			CheckBox chkVolume= (CheckBox)view.findViewById(R.id.checkBox_volume_enable);
			boolean volumeEnable=chkVolume.isChecked();
			sound.setRingVolume(volume,volumeEnable);
			
			ToggleButton switchSilent= (ToggleButton)view.findViewById(R.id.switch_silent);
			CheckBox chkSilent=(CheckBox)view.findViewById(R.id.checkBox_silent_enable);
			sound.setSilentMode(switchSilent.isChecked(),chkSilent.isChecked());
			
			ToggleButton switchVibration= (ToggleButton)view.findViewById(R.id.switch_vibration);
			CheckBox chkVibration=(CheckBox)view.findViewById(R.id.checkBox_vibration_enabled);
			sound.setVibration(switchVibration.isChecked(),chkVibration.isChecked());

		
		}
		

	}

}
