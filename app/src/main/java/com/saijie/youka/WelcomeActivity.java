package com.saijie.youka;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

public class WelcomeActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_welcome);

		new Thread(new Runnable() {
			@Override
			public void run() {
				//此处运行耗时任务
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
						startActivity(intent);
						WelcomeActivity.this.finish();
					}
				});
			}
		}).start();


//		Handler handler = new Handler();
//		//当计时结束,跳转至主界面
//		handler.postDelayed(new Runnable() {
//			@Override
//			public void run() {
//				Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
//				startActivity(intent);
//				WelcomeActivity.this.finish();
//			}
//		}, 3000);
//	}


	}


}

