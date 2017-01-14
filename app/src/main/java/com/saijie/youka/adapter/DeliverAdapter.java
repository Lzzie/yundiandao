package com.saijie.youka.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.saijie.youka.R;
import com.saijie.youka.bean.GoodsInfoDeliver;

import java.util.List;

//import com.squareup.picasso.Picasso;

//import butterknife.BindView;
//import butterknife.ButterKnife;

/**
 * 2017-01-12
 *
 */

public class DeliverAdapter extends BaseAdapter {
	private Context myContextd;
	private List<GoodsInfoDeliver> data;
	public DeliverAdapter(Context context, List<GoodsInfoDeliver> list) {
		myContextd = context;
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
		GoodsInfoDeliver goodsInfoDeliver = data.get(position);
		ViewHolder viewHolder;
		if (view==null){
			view = LayoutInflater.from(myContextd).inflate(R.layout.deliver_item_layout, null);
			viewHolder = new ViewHolder();
			viewHolder.deliversellerName= (TextView) view.findViewById(R.id.deliver_seller_name);
			viewHolder.deliversellerVolume= (TextView) view.findViewById(R.id.deliver_seller_volume);
			viewHolder.deliversellerTime= (TextView) view.findViewById(R.id.deliver_seller_time);
			viewHolder.deliversellerCondition= (TextView) view.findViewById(R.id.deliver_seller_condition);
			viewHolder.deliversellerJl= (TextView) view.findViewById(R.id.deliver_seller_jl);
			viewHolder.deliversellerHd1= (TextView) view.findViewById(R.id.deliver_seller_hd1);
			viewHolder.deliversellerHd2= (TextView) view.findViewById(R.id.deliver_seller_hd2);
			viewHolder.deliversellerHd3= (TextView) view.findViewById(R.id.deliver_seller_hd3);

			view.setTag(viewHolder);

		}else {
			viewHolder= (ViewHolder) view.getTag();
		}
		viewHolder.deliversellerName.setText(goodsInfoDeliver.getDeliver_seller_name()+"");
		viewHolder.deliversellerVolume.setText(goodsInfoDeliver.getDeliver_seller_volume()+"");
		viewHolder.deliversellerTime.setText(goodsInfoDeliver.getDeliver_seller_time()+"");
		viewHolder.deliversellerCondition.setText(goodsInfoDeliver.getDeliver_seller_condition()+"");
		viewHolder.deliversellerJl.setText(goodsInfoDeliver.getDeliver_seller_jl()+"");
		viewHolder.deliversellerHd1.setText(goodsInfoDeliver.getDeliver_seller_hd1()+"");
		viewHolder.deliversellerHd2.setText(goodsInfoDeliver.getDeliver_seller_hd2()+"");
		viewHolder.deliversellerHd3.setText(goodsInfoDeliver.getDeliver_seller_hd3()+"");


		return view;
	}

	 class ViewHolder {
		 ImageView deliversellerImg;
		 TextView  deliversellerName;
		 TextView  deliversellerVolume;
		 TextView  deliversellerTime;
		 TextView  deliversellerCondition;
		 TextView  deliversellerJl;
		 TextView  deliversellerHd1;
		 TextView  deliversellerHd2;
		 TextView  deliversellerHd3;

	}

}
