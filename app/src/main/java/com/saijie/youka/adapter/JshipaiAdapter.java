package com.saijie.youka.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.saijie.youka.R;
import com.saijie.youka.bean.GoodsInfo;
//import com.squareup.picasso.Picasso;

import java.util.List;

//import butterknife.BindView;
//import butterknife.ButterKnife;

/**
 * Created by qiancheng on 2017/1/10.
 */

public class JshipaiAdapter extends BaseAdapter {
	private Context myContext;
	private List<GoodsInfo> data;
	public JshipaiAdapter(Context context, List<GoodsInfo> list) {
		myContext= context;
		data=list;
	}

	@Override
	public int getCount() {
		return data.size();
	}

	@Override
	public Object getItem(int i) {
		return data.get(i);
	}

	@Override
	public long getItemId(int i) {
		return i;
	}

	@Override
	public View getView(int position, View view, ViewGroup viewGroup) {
		GoodsInfo goodsInfo = data.get(position);
		ViewHolder viewHolder;
		if (view==null){
			view = LayoutInflater.from(myContext).inflate(R.layout.jishipai_item_layout, null);
			viewHolder = new ViewHolder();
			viewHolder.sellerName= (TextView) view.findViewById(R.id.seller_name);
			viewHolder.sellerAddress=(TextView) view.findViewById(R.id.seller_address);
			viewHolder.goodsAddress=(TextView) view.findViewById(R.id.goods_address);
			viewHolder.goodsName=(TextView) view.findViewById(R.id.goods_name);
			viewHolder.goodsNum0=(TextView) view.findViewById(R.id.goods_num_0);
			viewHolder.goodsNum1=(TextView) view.findViewById(R.id.goods_num_1);
			viewHolder.goodsPriceNow=(TextView) view.findViewById(R.id.goods_price_now);
			viewHolder.goodsPriceFirst=(TextView) view.findViewById(R.id.goods_price_first);
			viewHolder.buyButton= (Button) view.findViewById(R.id.buy_button);
			view.setTag(viewHolder);
		}else{
			viewHolder= (ViewHolder) view.getTag();
		}
		viewHolder.sellerName.setText(goodsInfo.getSeller_name()+"");
		viewHolder.sellerAddress.setText(goodsInfo.getCoordinate());
		viewHolder.goodsAddress.setText(goodsInfo.getAddress());
		viewHolder.goodsName.setText(goodsInfo.getGoods_name());
		viewHolder.goodsNum0.setText(goodsInfo.getGoods_num_0()+"");
		viewHolder.goodsNum1.setText(goodsInfo.getGoods_num_1()+"");
		viewHolder.goodsPriceNow.setText(goodsInfo.getGoods_price_now()+"");
		viewHolder.goodsPriceFirst.setText(goodsInfo.getGoods_price_first()+"");
		switch (goodsInfo.getNormal()){
			case -1:
				viewHolder.buyButton.setText("已结束");
				viewHolder.buyButton.setEnabled(false);
				viewHolder.buyButton.setClickable(false);
				break;
			case 0:
				viewHolder.buyButton.setText("立即抢购");
				viewHolder.buyButton.setEnabled(true);
				viewHolder.buyButton.setOnClickListener(new View.OnClickListener( ) {
					@Override
					public void onClick(View view) {
					}
				});
				break;
			case 1:
				viewHolder.buyButton.setText("即将开抢");
				viewHolder.buyButton.setEnabled(false);
				viewHolder.buyButton.setClickable(false);
				break;

		}
//		Picasso.with(myContext).load(goodsInfo.getGoods_img()).into(viewHolder.goodsImg);

		return view;
	}

	class ViewHolder {
		ImageView goodsImg;
		TextView sellerName;
		TextView goodsName;
		TextView goodsAddress;
		TextView goodsNum1;
		TextView goodsNum0;
		TextView goodsPriceNow;
		TextView goodsPriceFirst;
		TextView sellerAddress;
		Button buyButton;

	}
}
