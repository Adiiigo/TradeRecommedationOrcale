package com.cummins.UserDetails;

import java.io.Serializable;

import java.sql.Date;
import java.util.Calendar;

public class AccountDetail implements Serializable  {
	 String securityCode;
	 String status;
	String volume, curr_price;
	Date last_update_date;
	Date sell_date;
	Date buy_date;
	public String getSecurityCode() {
		return securityCode;
	}
	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getVolume() {
		return volume;
	}
	public void setVolume(String volume) {
		this.volume = volume;
	}
	public String getCurr_price() {
		return curr_price;
	}
	public void setCurr_price(String curr_price) {
		this.curr_price = curr_price;
	}
	public Date getLast_update_date() {
		return last_update_date;
	}
	public void setLast_update_date(Date last_update_date) {
		this.last_update_date = last_update_date;
	}
	public Date getSell_date() {
		return sell_date;
	}
	public void setSell_date(Date date) {
		this.sell_date = date;
	}
	public Date getBuy_date() {
		return buy_date;
	}
	public void setBuy_date(Date date) {
		this.buy_date = date;
	}
}
