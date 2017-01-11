package com.saijie.youka.fn;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.saijie.youka.R;
import com.saijie.youka.adapter.JshipaiAdapter;
import com.saijie.youka.bean.GoodsInfo;
import com.saijie.youka.pop.CustomPopupWindow;
import com.saijie.youka.util.BeanUtil;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class JshipaiActivity extends Activity {
	private TextView ivShow;

	ListView goodsLv;
	private List<TextView> timeViewList;
	private String[] timeArr;
	private int screenWidth, widthDP;//像素值，DP值
	private LinearLayout timeLayout;
	private List<GoodsInfo> list;
	private JshipaiAdapter adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_jshipai);

//		Covers c = new Covers(this, "ab51d5a3cb4d45bbae9e8de9e43a432e");

		ivShow = (TextView) findViewById(R.id.ivShow);
		ivShow.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				CustomPopupWindow popupWindow = new CustomPopupWindow(JshipaiActivity.this);
				popupWindow.showAtDropDownCenter(ivShow);
			}
		});

		findById();
		initData();

	}
	private void initData() {
		list = new ArrayList<>();
		adapter = new JshipaiAdapter(this,list);
		goodsLv.setAdapter(adapter);
		for(int i =0;i<10;i++){
			GoodsInfo goodsinfo = new GoodsInfo();
			goodsinfo.setAddress("地址:临西五路与聚财路交汇..");
//			goodsinfo.setCoordinate("102.1022");
			goodsinfo.setCoordinate("0.5km");
			goodsinfo.setGoods_name("豪华标准间"+i);
			goodsinfo.setGoods_num_0("已抢"+(i)+"套");
			goodsinfo.setGoods_num_1("剩"+(10-i)+"套");
			goodsinfo.setSeller_name("金谷大酒店"+i);
			goodsinfo.setGoods_price_first(188);
			goodsinfo.setGoods_price_now(59);
			goodsinfo.setGoods_img("");
			list.add(goodsinfo);
		}
		adapter.notifyDataSetChanged();

	}

	private void findById() {
		goodsLv= (ListView) findViewById(R.id.goods_lv);
		String current_time = new SimpleDateFormat("HH").format(System.currentTimeMillis());
		//获取手机屏幕宽度
		DisplayMetrics metrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metrics);
		screenWidth = metrics.widthPixels;
//		widthDP = BeanUtil.px2dp(this, screenWidth);
		widthDP = BeanUtil.dp2px(this,screenWidth);
		Log.i("宽度DP：", widthDP + "");
		timeLayout = (LinearLayout) findViewById(R.id.timeLayout);
		timeArr = new String[]{"10:00", "13:00", "16:00", "20:00", "22:00"};
		LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(widthDP / 10, ViewGroup.LayoutParams.MATCH_PARENT);
		layoutParams.setMargins(1, 0, 1, 0);
		for (int i = 0; i < timeArr.length; i++) {
			TextView textView = new TextView(this);
			textView.setText(timeArr[i]);
			int a = current_time.compareTo(timeArr[i]);
			int b = 0;
			if (i < timeArr.length - 1) {
				b = current_time.compareTo(timeArr[i + 1]);
			}
			if (a > 0 && b < 0) {
				textView.setBackgroundColor(Color.parseColor("#fe6013"));
			} else {
				textView.setBackgroundColor(Color.parseColor("#333333"));
			}
			textView.setTextColor(this.getResources().getColor(R.color.white));
			textView.setLayoutParams(layoutParams);
			textView.setGravity(Gravity.CENTER);

			timeLayout.addView(textView);
		}
	}



	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
