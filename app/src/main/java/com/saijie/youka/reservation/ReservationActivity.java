package com.saijie.youka.reservation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.saijie.youka.R;
import com.saijie.youka.adapter.ReservationAdapter;
import com.saijie.youka.base.BaseActivity;
import com.saijie.youka.bean.GoodsInfoReser;
import com.saijie.youka.details.SellerActivity;

import java.util.ArrayList;
import java.util.List;

public class ReservationActivity extends BaseActivity {

	private ExpandTabView expandTabView;
	private ArrayList<View> mViewArray = new ArrayList<View>();
	private ViewLeft viewLeft;
	private ViewMiddle viewMiddle;
	private ViewRight viewRight;
	private ViewFilter viewFilter;


	ListView goodsLv;
	private List<GoodsInfoReser> list;
	private ReservationAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_reservation);

		initView();
		initVaule();
		initListener();

		initData();//goodsLv

	}
	private void initData() {
		list = new ArrayList<>();
		adapter = new ReservationAdapter(this,list);
		goodsLv.setAdapter(adapter);
		for(int i =0;i<8;i++){
			GoodsInfoReser goodsInfoReser = new GoodsInfoReser();
			goodsInfoReser.setReser_seller_name("金谷大酒店兰亭序主题餐厅"+i);
			goodsInfoReser.setReser_seller_type("鲁菜");
			goodsInfoReser.setReser_seller_addres("[涑河街]188元 超值4-6人..");
			goodsInfoReser.setReser_seller_jl("71m");
			list.add(goodsInfoReser);
		}
		adapter.notifyDataSetChanged();
	}

	private void initView() {

		goodsLv =(ListView)findViewById(R.id.reservation_goods_lv);//初始化
		expandTabView = (ExpandTabView) findViewById(R.id.expandtab_view);
		viewLeft = new ViewLeft(this);
		viewMiddle = new ViewMiddle(this);
		viewRight = new ViewRight(this);
		viewFilter = new ViewFilter(this);

	}

//	初始化
	private void initVaule() {

		mViewArray.add(viewLeft);
		mViewArray.add(viewMiddle);
		mViewArray.add(viewRight);
		mViewArray.add(viewFilter);
		ArrayList<String> mTextArray = new ArrayList<String>();
	    mTextArray.add("附近");
		mTextArray.add("美食");
		mTextArray.add("智能排序");
		mTextArray.add("筛选");
		expandTabView.setValue(mTextArray, mViewArray);
		expandTabView.setTitle(viewLeft.getShowText(), 0);
		expandTabView.setTitle(viewMiddle.getShowText(), 1);
		expandTabView.setTitle(viewRight.getShowText(), 2);
		expandTabView.setTitle(viewFilter.getShowText(), 3);

	}

	private void initListener() {

		viewLeft.setOnSelectListener(new ViewLeft.OnSelectListener() {

			@Override
			public void getValue(String distance, String showText) {
				onRefresh(viewLeft, showText);
			}
		});

		viewMiddle.setOnSelectListener(new ViewMiddle.OnSelectListener() {

			@Override
			public void getValue(String showText) {onRefresh(viewMiddle,showText);

			}
		});

		viewRight.setOnSelectListener(new ViewRight.OnSelectListener() {

			@Override
			public void getValue(String distance, String showText) {
				onRefresh(viewRight, showText);
			}
		});

		viewFilter.setOnSelectListener(new ViewFilter.OnSelectListener() {

			@Override
			public void getValue(String distance, String showText) {
				onRefresh(viewFilter, showText);
			}
		});

	}

	private void onRefresh(View view, String showText) {

		expandTabView.onPressBack();
		int position = getPositon(view);
		if (position >= 0 && !expandTabView.getTitle(position).equals(showText)) {
			expandTabView.setTitle(showText, position);
		}

		Toast.makeText(ReservationActivity.this, showText, Toast.LENGTH_SHORT).show();

	}

	private int getPositon(View tView) {
		for (int i = 0; i < mViewArray.size(); i++) {
			if (mViewArray.get(i) == tView) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public void onBackPressed() {

		if (!expandTabView.onPressBack()) {
			finish();
		}

	}

	public void showJingu(View view){
		Intent intent = new Intent(ReservationActivity.this, SellerActivity.class);
		intent.addFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
		startActivity(intent);

	}



}
