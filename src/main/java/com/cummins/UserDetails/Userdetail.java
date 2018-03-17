package com.cummins.UserDetails;

import java.io.Serializable;

public class Userdetail implements Serializable{
	String first_name;
	String last_name;
	String phn_no;
	String email_id,password;

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

	public void setPhn_no(String phn_no) {
		this.phn_no = phn_no;
	}


	
	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getPhn_no() {
		return phn_no;
	}

}
