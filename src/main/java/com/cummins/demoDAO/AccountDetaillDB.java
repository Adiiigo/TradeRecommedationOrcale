package com.cummins.demoDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cummins.UserDetails.AccountDetail;
import com.cummins.UserDetails.Userdetail;
/*
 * This is the class which fetches the details of  user account from database oracle 11g xe
 * */

public class AccountDetaillDB {
	
	public void getUser(DataBaseConn connection, Userdetail login,ArrayList<AccountDetail> savedetail) {
		
		
		int i=0;
		
		String query_id="select entry_id from user_account_map where user_id =(select user_id from user_details where email_id=?)";
		String query = "select * from account_details where entry_id IN (select entry_id from user_account_map where user_id =(select user_id from user_details where email_id=?))";
		try {
			PreparedStatement valid_state=connection.getConnection().prepareStatement(query_id);
			valid_state.setString(1,login.getEmail_id());
			ResultSet rst = valid_state.executeQuery();
			//rst.next();
			if(rst.next())
			{
				PreparedStatement statement = connection.getConnection().prepareStatement(query);
				statement.setString(1, login.getEmail_id());

			 rst = statement.executeQuery();

				while (rst.next()) {
					AccountDetail save=new AccountDetail();
					save.setSecurityCode(rst.getString("security_code"));
					save.setStatus(rst.getString("status"));
					save.setCurr_price(rst.getString("current_price"));
					save.setVolume(rst.getString("volume"));
					save.setLast_update_date(rst.getDate("last_update_date"));
					savedetail.add(save);
					i++;
				}
				
			}
			else{
				savedetail=null;
				rst.close();
				valid_state.close();
					
				}
				rst.close();
				valid_state.close();
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		

	}
	


}
