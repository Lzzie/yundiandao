package com.saijie.youka.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.saijie.youka.R;
import com.saijie.youka.bean.MyaddressInfo;

import java.util.List;

//import com.squareup.picasso.Picasso;

//import butterknife.BindView;
//import butterknife.ButterKnife;

/**
 * 2017-01-13
 * 我的收货地址
 *
 */

public class MyaddressAdapter extends BaseAdapter {
	private Context myContexta;
	private List<MyaddressInfo> data;
	public MyaddressAdapter(Context context, List<MyaddressInfo> list) {
		myContexta = context;
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
		final MyaddressInfo myaddressInfo = data.get(position);
		ViewHolder viewHolder;

		if (view==null){
			view = LayoutInflater.from(myContexta).inflate(R.layout.myaddress_item_layout, null);
			viewHolder = new ViewHolder();
			viewHolder.myaddressSjr= (TextView) view.findViewById(R.id.myaddress_sjr);
			viewHolder.myaddressUser= (TextView) view.findViewById(R.id.myaddress_user);
			viewHolder.myaddressDz= (TextView) view.findViewById(R.id.myaddress_dz);
			viewHolder.myaddressUseraddress= (TextView) view.findViewById(R.id.myaddress_useraddress);

			viewHolder.unButton = (Button) view.findViewById(R.id.unselect);//findId

			view.setTag(viewHolder);

		}else {
			viewHolder= (ViewHolder) view.getTag();
		}
		viewHolder.myaddressSjr.setText(myaddressInfo.getMyaddress_sjr()+"");
		viewHolder.myaddressUser.setText(myaddressInfo.getMyaddress_user()+"");
		viewHolder.myaddressDz.setText(myaddressInfo.getMyaddress_dz()+"");
		viewHolder.myaddressUseraddress.setText(myaddressInfo.getMyaddress_useraddress()+"");
		//getChecked--》Info,實體類種
		if (myaddressInfo.getChecked()){
			viewHolder.unButton.setSelected(true);
		}else{
			viewHolder.unButton.setSelected(false);
		}
		//Button 設置監聽事件
		viewHolder.unButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				for (int i = 0; i < data.size(); i++) {
					data.get(i).setChecked(false);
				}
				myaddressInfo.setChecked(true);
				notifyDataSetChanged();//更新數據
			}
		});

		return view;
	}

	 class ViewHolder {

		 TextView myaddressSjr; //收件人
		 TextView myaddressUser;//用户信息
		 TextView myaddressDz;  //地址
		 TextView myaddressUseraddress;//用户收货地址
		 Button unButton;

	}

}
