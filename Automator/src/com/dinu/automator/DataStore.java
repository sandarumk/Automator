package com.dinu.automator;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.StreamCorruptedException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import android.R.string;
import android.content.Context;

public class DataStore {

	private static final String FILENAME_PROFILE = "profile_data";
	private static final String FILENAME_ALARM= "alarm_data";
	private static final String FILENAME_SMS = "sms_data";
	private static List<Profile> profiles;
	private static List<Alarm> alarms;
	private static List<Sms> sms;

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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void saveProfiles(Context context) {
		saveObject(context, FILENAME_PROFILE, profiles);
	}

	public static void saveSmS(Context context) {
		saveObject(context, FILENAME_SMS,sms);
	}

	public static void saveAlarms(Context context) {
		saveObject(context, FILENAME_ALARM, alarms);
	}

	public static void retrieveData(Context context) {
		retrieveData(context);
		retreiveSms(context);
		retreiveProfiles(context);
	}

	public static void retreiveProfiles(Context context){
		FileInputStream fis;
		
		String filename=FILENAME_PROFILE;
		try {
			fis = context.openFileInput(filename);
			ObjectInputStream ois = new ObjectInputStream(fis);
			profiles = (ArrayList<Profile>) ois.readObject();
			ois.close();
			fis.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (StreamCorruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e){
			profiles= new ArrayList<Profile>();
		}
		

	}
	public static void retreiveSms(Context context){
		FileInputStream fis;
		
		String filename=FILENAME_SMS;
		try {
			fis = context.openFileInput(filename);
			ObjectInputStream ois = new ObjectInputStream(fis);
			sms = (ArrayList<Sms>) ois.readObject();
			ois.close();
			fis.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (StreamCorruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e){
			sms= new ArrayList<Sms>();
		}
		

	}
	public static void retreiveAlarm(Context context){
		FileInputStream fis;
		
		String filename=FILENAME_ALARM;
		try {
			fis = context.openFileInput(filename);
			ObjectInputStream ois = new ObjectInputStream(fis);
			sms = (ArrayList<Sms>) ois.readObject();
			ois.close();
			fis.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (StreamCorruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e){
			sms= new ArrayList<Sms>();
		}
		

	}
	public static List<Profile> getProfileList(){
		return profiles;
	}
	
	public static void addProfile(Profile profile){
		profiles.add(profile);
		
	}
	
	public static void deleteProfile(Profile profile){
		profiles.remove(profile);
	}
	

}
