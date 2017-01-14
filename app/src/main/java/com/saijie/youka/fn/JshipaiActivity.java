package com.saijie.youka.fn;

import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
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
import com.saijie.youka.base.BaseActivity;
import com.saijie.youka.bean.GoodsInfo;
import com.saijie.youka.pop.CustomPopupWindow;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class JshipaiActivity extends BaseActivity {
	private TextView ivShow;

	ListView goodsLv;
	private List<TextView> timeViewList;
	private String[] timeArr;
	private int screenWidth;//像素值
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
	}

	/**
	 * 根据时间段模拟数据,自定义酒店名字
	 *
	 * @param time
	 */
	private void initData(String time, String hotel_name, int normal) {
		list.clear();
		for (int i = 0; i < 10; i++) {
			GoodsInfo goodsinfo = new GoodsInfo();
			goodsinfo.setAddress("地址:临西五路与聚财路交汇..");
			goodsinfo.setCoordinate("0.5km");
			goodsinfo.setGoods_name(time + "豪华标准间" + i);
			goodsinfo.setGoods_num_0("已抢" + (i) + "套");
			goodsinfo.setGoods_num_1("剩" + (10 - i) + "套");
			goodsinfo.setSeller_name(hotel_name + i);
			goodsinfo.setGoods_price_first(188);
			goodsinfo.setGoods_price_now(59);
			goodsinfo.setGoods_img("");
			goodsinfo.setNormal(normal);
			list.add(goodsinfo);
		}
		adapter.notifyDataSetChanged();
		goodsLv.setSelection(0);

	}

	private void findById() {
		goodsLv = (ListView) findViewById(R.id.goods_lv);
		list = new ArrayList<>();
		adapter = new JshipaiAdapter(this, list);
		goodsLv.setAdapter(adapter);
		String current_time = new SimpleDateFormat("HH").format(System.currentTimeMillis());
		//获取手机屏幕宽度
		DisplayMetrics metrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metrics);
		screenWidth = metrics.widthPixels;
		timeLayout = (LinearLayout) findViewById(R.id.timeLayout);
		timeArr = new String[]{"10:00", "13:00", "16:00", "20:00", "22:00"};
		LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(screenWidth / 4, ViewGroup.LayoutParams.MATCH_PARENT);
		layoutParams.setMargins(1, 0, 1, 0);
		int b = 0;
		final String[] hotels = new String[]{"金谷大酒店", "那家院子", "临沂饭店", "蓝海大饭店", "如家酒店"};
		//根据当前时间加载时间选择页面的内容
		int normal = 0;
		for (int i = 0; i < timeArr.length; i++) {
			TextView textView = new TextView(this);
			textView.setSingleLine(false);
			int a = current_time.compareTo(timeArr[i].split(":")[0]);
			if (i != timeArr.length - 1) {
				b = current_time.compareTo(timeArr[i + 1]);
			}

			if (!(a < 0) && b < 0) {
				textView.setBackgroundColor(Color.parseColor("#fe6013"));
				textView.setText(timeArr[i] + "\n" + "正在抢购中");
				initData(timeArr[i], hotels[i], 0);
				normal = 0;
			} else if (a > 0) {
				textView.setBackgroundColor(Color.parseColor("#333333"));
				textView.setText(timeArr[i] + "\n" + "已结束");
				normal = -1;
			} else {
				textView.setBackgroundColor(Color.parseColor("#333333"));
				textView.setText(timeArr[i] + "\n" + "即将开抢");
				normal = 1;
			}
			if (i == 0 && a < 0) {
				initData(timeArr[i], hotels[i], 1);
			}

			textView.setTextColor(this.getResources().getColor(R.color.white));
			textView.setLayoutParams(layoutParams);
			textView.setGravity(Gravity.CENTER);
			final int finalI = i;
			final int finalNormal = normal;
			textView.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View view) {
					initData(timeArr[finalI], hotels[finalI], finalNormal);
				}
			});
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
