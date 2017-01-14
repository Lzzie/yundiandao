package com.saijie.youka.bean;

/**
 * 2017-01-12 Reservation
 * 订餐
 */
public class GoodsInfoReser {
	private String reser_goods_img; //商品名称
	private String reser_seller_name;//商家名称
	private String reser_seller_pj;//商户评价星
	private String reser_seller_type;//商户菜类
	private String reser_seller_addres;//商户地址（套餐说明）
	private String reser_seller_jl;//用户与商户的距离

	public String getReser_goods_img(){
		return reser_goods_img;
	}
	public void setReser_goods_img(String reser_goods_img){
		this.reser_goods_img = reser_goods_img;
	}

	public String getReser_seller_name(){
		return reser_seller_name;
	}
	public void setReser_seller_name(String reser_seller_name){
		this.reser_seller_name = reser_seller_name;
	}

	public String getReser_seller_pj(){
		return reser_seller_pj;
	}
	public void setReser_seller_pj(String reser_seller_pj){
		this.reser_seller_pj = reser_seller_pj;
	}

	public String getReser_seller_type(){
		return reser_seller_type;
	}
	public void setReser_seller_type(String reser_seller_type){
		this.reser_seller_type = reser_seller_type;
	}

	public String getReser_seller_addres(){
		return reser_seller_addres;
	}
	public void setReser_seller_addres(String reser_seller_addres){
		this.reser_seller_addres = reser_seller_addres;
	}

	public String getReser_seller_jl(){
		return reser_seller_jl;
	}
	public void setReser_seller_jl(String reser_seller_jl){
		this.reser_seller_jl = reser_seller_jl;
	}

}
