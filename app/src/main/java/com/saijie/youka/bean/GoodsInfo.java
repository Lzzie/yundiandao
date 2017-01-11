package com.saijie.youka.bean;

/**
 * Created by qiancheng on 2017/1/10.
 */
public class GoodsInfo {
	private String seller_name;//商家名称
	private String address;//商家地址
	private String coordinate;//商家坐标
	private String goods_name;//商品名称
	private String goods_num_0;//剩余商品数量
	private String goods_num_1;//已经抢购的商品数量
	private float goods_price_first;//原始价格
	private float goods_price_now;//当前价格(特价价格)
	private String goods_img;//商品图片

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCoordinate() {
		return coordinate;
	}

	public void setCoordinate(String coordinate) {
		this.coordinate = coordinate;
	}

	public String getGoods_img() {
		return goods_img;
	}

	public void setGoods_img(String goods_img) {
		this.goods_img = goods_img;
	}

	public String getGoods_name() {
		return goods_name;
	}

	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}

	public String getGoods_num_0() {
		return goods_num_0;
	}

	public void setGoods_num_0(String goods_num_0) {
		this.goods_num_0 = goods_num_0;
	}

	public String getGoods_num_1() {
		return goods_num_1;
	}

	public void setGoods_num_1(String goods_num_1) {
		this.goods_num_1 = goods_num_1;
	}

	public float getGoods_price_first() {
		return goods_price_first;
	}

	public void setGoods_price_first(float goods_price_first) {
		this.goods_price_first = goods_price_first;
	}

	public float getGoods_price_now() {
		return goods_price_now;
	}

	public void setGoods_price_now(float goods_price_now) {
		this.goods_price_now = goods_price_now;
	}

	public String getSeller_name() {
		return seller_name;
	}

	public void setSeller_name(String seller_name) {
		this.seller_name = seller_name;
	}
}
