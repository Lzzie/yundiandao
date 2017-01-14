package com.saijie.youka.fn;

import android.os.Bundle;
import android.widget.ListView;

import com.saijie.youka.R;
import com.saijie.youka.adapter.MyaddressAdapter;
import com.saijie.youka.base.BaseActivity;
import com.saijie.youka.bean.MyaddressInfo;

import java.util.ArrayList;
import java.util.List;

public class MyaddressActivity extends BaseActivity {

	ListView myaddressLv;
	private List<MyaddressInfo> list;
	private MyaddressAdapter adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_myaddress);

		initView();
		initData();//myaddressLv



//
//		final Button un =(Button)findViewById(R.id.unselect);
//		final Button select =(Button)findViewById(R.id.select);
//		final ImageView un2 =(ImageView)findViewById(R.id.unselect2);
//		final ImageView select2 =(ImageView)findViewById(R.id.select2);
//		final ImageView un3 =(ImageView)findViewById(R.id.unselect3);
//		final ImageView select3 =(ImageView)findViewById(R.id.select3);
//
//		un.setOnClickListener(new View.OnClickListener(){
//			@Override
//			public void onClick(View view) {
//					un.setVisibility(View.GONE);
//					select.setVisibility(View.VISIBLE);
//					un2.setVisibility(View.VISIBLE);
//					select2.setVisibility(View.GONE);
//					un3.setVisibility(View.VISIBLE);
//					select3.setVisibility(View.GONE);
//
//			}
//		});
//
//		un2.setOnClickListener(new View.OnClickListener(){
//			@Override
//			public void onClick(View view) {
//				un2.setVisibility(View.GONE);
//				select2.setVisibility(View.VISIBLE);
//				un.setVisibility(View.VISIBLE);
//				select.setVisibility(View.GONE);
//				un3.setVisibility(View.VISIBLE);
//				select3.setVisibility(View.GONE);
//
//			}
//		});
//
//		un3.setOnClickListener(new View.OnClickListener(){
//			@Override
//			public void onClick(View view) {
//				un3.setVisibility(View.GONE);
//				select3.setVisibility(View.VISIBLE);
//				un.setVisibility(View.VISIBLE);
//				select.setVisibility(View.GONE);
//				un2.setVisibility(View.VISIBLE);
//				select2.setVisibility(View.GONE);
//
//
//			}
//		});

	}

	private void initData() {
		list = new ArrayList<>();
		adapter = new MyaddressAdapter(this,list);
		myaddressLv.setAdapter(adapter);

		for(int i =0;i<3;i++){
			MyaddressInfo myaddressInfo = new MyaddressInfo();
			myaddressInfo.setMyaddress_sjr("收件人：");
			myaddressInfo.setMyaddress_user("王员外 180*****125"+i);
			myaddressInfo.setMyaddress_dz("地址：");
			myaddressInfo.setMyaddress_useraddress("山东省 临沂市 兰山区 成才路与蒙山大道交汇处"+i);
			myaddressInfo.setChecked(false);//Button 初始化為False,類似設值
			list.add(myaddressInfo);
		}
		adapter.notifyDataSetChanged();
	}

	private void initView() {
		myaddressLv =(ListView)findViewById(R.id.myaddress_lv);//初始化
	}
}
