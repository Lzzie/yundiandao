package com.saijie.youka.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.saijie.youka.R;
import com.saijie.youka.bean.GoodsInfoReser;

import java.util.List;

//import com.squareup.picasso.Picasso;

//import butterknife.BindView;
//import butterknife.ButterKnife;

/**
 * 2017-01-12
 * 订餐，预约
 *
 */

public class ReservationAdapter extends BaseAdapter {
	private Context myContextr;
	private List<GoodsInfoReser> data;
	public ReservationAdapter(Context context, List<GoodsInfoReser> list) {
		myContextr = context;
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
		GoodsInfoReser goodsInfoReser = data.get(position);
		ViewHolder viewHolder;
		if (view==null){
			view = LayoutInflater.from(myContextr).inflate(R.layout.reservation_item_layout, null);
			viewHolder = new ViewHolder();
			viewHolder.resersellerName= (TextView) view.findViewById(R.id.reser_seller_name);
//			viewHolder.resersellerPj= (ImageView) view.findViewById(R.id.reser_seller_pj);
			viewHolder.resersellerType= (TextView) view.findViewById(R.id.reser_seller_type);
			viewHolder.resersellerAddres= (TextView) view.findViewById(R.id.reser_seller_addres);
			viewHolder.resersellerJl= (TextView) view.findViewById(R.id.reser_seller_jl);

			view.setTag(viewHolder);

		}else {
			viewHolder= (ViewHolder) view.getTag();
		}
		//		viewHolder.resersellerPj.(goodsInfoReser.getReser_seller_name()+"");
		viewHolder.resersellerName.setText(goodsInfoReser.getReser_seller_name()+"");
		viewHolder.resersellerType.setText(goodsInfoReser.getReser_seller_type()+"");
		viewHolder.resersellerAddres.setText(goodsInfoReser.getReser_seller_addres()+"");
		viewHolder.resersellerJl.setText(goodsInfoReser.getReser_seller_jl()+"");

		return view;
	}

	 class ViewHolder {
		 ImageView resergoodsImg;
		 ImageView resersellerPj;
		 TextView resersellerName;
		 TextView resersellerType;
		 TextView resersellerAddres;
		 TextView resersellerJl;
	}

}
