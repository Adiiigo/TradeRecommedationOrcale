package com.cummins.UserDetails;

import java.sql.Connection;
import java.util.ArrayList;

import com.cummins.demoDAO.DataBaseConn;
import com.cummins.demoDAO.AccountDetaillDB;
import com.cummins.demoDAO.UserDetailsDB;

public class UserFactory {
	Userdetail login;
	ArrayList<AccountDetail> savedetail=new ArrayList<AccountDetail>();
	public UserFactory()
	{
		
	}
	public UserFactory(DataBaseConn conn,	Userdetail log) {
		login=log;
		UserDetailsDB userDetail=new UserDetailsDB();
		userDetail.getUserDetails(conn, login);
		AccountDetaillDB savedb=new AccountDetaillDB();
		savedb.getUser(conn, login, savedetail);
	}
	public Userdetail getLogin() {
		return login;
	}
	public void setLogin(Userdetail login) {
		this.login = login;
	}
	public ArrayList<AccountDetail> getSavedetail() {
		return savedetail;
	}
	public void setSavedetail(ArrayList<AccountDetail> savedetail) {
		this.savedetail = savedetail;
	}
}
