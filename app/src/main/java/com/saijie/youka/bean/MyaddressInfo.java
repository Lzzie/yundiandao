package com.saijie.youka.bean;

/**
 * 2017-01-13 收货地址
 * 收货地址
 */
public class MyaddressInfo {

	private String myaddress_sjr;
	private String myaddress_user;
	private String myaddress_dz;
	private String myaddress_useraddress;
	private boolean checked;//Butoon
	public boolean getChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public String getMyaddress_sjr() {
		return myaddress_sjr;
	}

	public void setMyaddress_sjr(String myaddress_sjr) {
		this.myaddress_sjr = myaddress_sjr;
	}

	public String getMyaddress_user() {
		return myaddress_user;
	}

	public void setMyaddress_user(String myaddress_user) {
		this.myaddress_user = myaddress_user;
	}

	public String getMyaddress_dz() {
		return myaddress_dz;
	}

	public void setMyaddress_dz(String myaddress_dz) {
		this.myaddress_dz = myaddress_dz;
	}

	public String getMyaddress_useraddress() {
		return myaddress_useraddress;
	}

	public void setMyaddress_useraddress(String myaddress_useraddress) {
		this.myaddress_useraddress = myaddress_useraddress;
	}



}
