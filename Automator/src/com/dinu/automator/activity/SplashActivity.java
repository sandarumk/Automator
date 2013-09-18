package com.dinu.automator.activity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.app.Activity;
import android.content.Intent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.dinu.automator.R;

public class SplashActivity extends Activity {

	protected static final int splashTimeOut = 3000;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_splash);
		TextView logo = (TextView) findViewById(R.id.TextView_Logo);
		
		// start fade in animation
		Animation fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);
		logo.startAnimation(fadeIn);
		
		// start count down timer
		CountDownTimer countDownTimer = new CountDownTimer(splashTimeOut, 1) {
			ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar_Splash);

			@Override
			public void onTick(long millisUntilFinished) {
				progressBar.setProgress((int) (splashTimeOut - millisUntilFinished) * 100 / splashTimeOut);

			}

			@Override
			public void onFinish() {
				startActivity(new Intent(SplashActivity.this, MainActivity.class));
				SplashActivity.this.finish();

			}
		};
		countDownTimer.start();
	}

	protected void onPause() {
		super.onPause();
		TextView logo_name = (TextView) findViewById(R.id.TextView_Logo);
		logo_name.clearAnimation();
	}

}
