package com.saijie.youka.reservation;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.saijie.youka.R;
import com.saijie.youka.adapter.DeliverAdapter;
import com.saijie.youka.base.BaseActivity;
import com.saijie.youka.bean.GoodsInfoDeliver;

import java.util.ArrayList;
import java.util.List;

public class DeliverActivity extends BaseActivity {
	private ExpandTabView expandTabView;
	private ArrayList<View> mViewArray = new ArrayList<View>();
	private ViewLeft viewLeft;
	private ViewMiddle viewMiddle;
	private ViewRight viewRight;
	private ViewFilter viewFilter;

	ListView goodsLv;
	private List<GoodsInfoDeliver> list;
	private DeliverAdapter adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_deliver);

		initView();
		initVaule();
		initListener();

		initData();//goodsLv

	}
	private void initData() {
		list = new ArrayList<>();
		adapter = new DeliverAdapter(this,list);
		goodsLv.setAdapter(adapter);
		for(int i =0;i<8;i++){
			GoodsInfoDeliver goodsInfoDeliver = new GoodsInfoDeliver();
			goodsInfoDeliver.setDeliver_seller_name("集集小镇(临沂三店)"+i);
			goodsInfoDeliver.setDeliver_seller_volume("月售"+(357+i)+"单");
			goodsInfoDeliver.setDeliver_seller_time(i+25+"分钟");
			goodsInfoDeliver.setDeliver_seller_condition("起送￥20|配送￥5");
			goodsInfoDeliver.setDeliver_seller_jl("1.2km");
			goodsInfoDeliver.setDeliver_seller_hd1("满20减5;满30减7");
			goodsInfoDeliver.setDeliver_seller_hd2("邀请新用户抢4元代金券课同享");
			goodsInfoDeliver.setDeliver_seller_hd3("全场八折");
			list.add(goodsInfoDeliver);
		}
		adapter.notifyDataSetChanged();
	}


	private void initView() {

		goodsLv =(ListView)findViewById(R.id.deliver_goods_lv);//初始化
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

		Toast.makeText(DeliverActivity.this, showText, Toast.LENGTH_SHORT).show();

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

}
