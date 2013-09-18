package com.dinu.automator;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;

public class DataStore {

	//file names
	private static final String FILENAME_PROFILE = "profile_data";
	private static final String FILENAME_ALARM = "alarm_data";
	private static final String FILENAME_SMS = "sms_data";
	// lists of objects
	private static List<Profile> profiles;
	private static List<Alarm> alarms;
	private static List<Sms> sms;
	// state of functionalities
	private static boolean profileEnabled;
	private static boolean alarmEnabled;
	private static boolean smsEnabled;
	
	

	public static boolean isProfileEnabled() {
		return profileEnabled;
	}

	public static void setProfileEnabled(boolean profileEnabled) {
		DataStore.profileEnabled = profileEnabled;
	}

	public static boolean isAlarmEnabled() {
		return alarmEnabled;
	}

	public static void setAlarmEnabled(boolean alarmEnabled) {
		DataStore.alarmEnabled = alarmEnabled;
	}

	public static boolean isSmsEnabled() {
		return smsEnabled;
	}

	public static void setSmsEnabled(boolean smsEnabled) {
		DataStore.smsEnabled = smsEnabled;
	}

	public static void saveData(Context context) {
		saveAlarms(context);
		saveProfiles(context);
		saveSmS(context);
	}

	public static void saveObject(Context context, String filename, List data) {
		FileOutputStream fos;
		try {
			fos = context.openFileOutput(filename, Context.MODE_PRIVATE);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(data);
			oos.flush();
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void saveProfiles(Context context) {
		saveObject(context, FILENAME_PROFILE, profiles);
	}

	public static void saveSmS(Context context) {
		saveObject(context, FILENAME_SMS, sms);
	}

	public static void saveAlarms(Context context) {
		saveObject(context, FILENAME_ALARM, alarms);
	}

	public static void retrieveData(Context context) {
		retreiveAlarm(context);
		retreiveSms(context);
		retreiveProfiles(context);
	}

	public static void retreiveProfiles(Context context) {
		FileInputStream fis;

		String filename = FILENAME_PROFILE;
		try {
			fis = context.openFileInput(filename);
			ObjectInputStream ois = new ObjectInputStream(fis);
			profiles = (ArrayList<Profile>) ois.readObject();
			ois.close();
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (StreamCorruptedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (profiles == null) {
				profiles = new ArrayList<Profile>();
			}
		}

	}

	public static void retreiveSms(Context context) {
		FileInputStream fis;

		String filename = FILENAME_SMS;
		try {
			fis = context.openFileInput(filename);
			ObjectInputStream ois = new ObjectInputStream(fis);
			sms = (ArrayList<Sms>) ois.readObject();
			ois.close();
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (StreamCorruptedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (sms == null) {
				sms = new ArrayList<Sms>();
			}
		}

	}

	public static void retreiveAlarm(Context context) {
		FileInputStream fis;

		String filename = FILENAME_ALARM;
		try {
			fis = context.openFileInput(filename);
			ObjectInputStream ois = new ObjectInputStream(fis);
			alarms = (ArrayList<Alarm>) ois.readObject();
			ois.close();
			fis.close();
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (StreamCorruptedException e) {
		
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} finally {
			if (alarms == null) {
				alarms = new ArrayList<Alarm>();
			}

		}

	}

	public static List<Profile> getProfileList() {
		if (profiles == null) {
			profiles = new ArrayList<Profile>();
		}

		return profiles;
	}

	public static void addProfile(Profile profile) {
		profiles.add(profile);

	}

	public static void deleteProfile(Profile profile) {
		profiles.remove(profile);
	}
	
	public static List<Sms> getsmsList() {
		if (sms == null) {
			sms = new ArrayList<Sms>();
		}

		return sms;
	}

	public static void addSms(Sms smsInstance) {
		sms.add(smsInstance);
		

	}

	public static void deleteSms(Sms smsInstance) {
		sms.remove(smsInstance);
	}

}
