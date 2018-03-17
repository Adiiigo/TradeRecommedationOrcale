package com.cummins.demoDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.cummins.UserDetails.Userdetail;

public class UserDetailsDB {
	//Userdetail userDetail=new Userdetail();
	public void getUserDetails(DataBaseConn connection, Userdetail user) {
		//String password = new String();
		 
		

		String query = "select * from user_details where email_id=?";
		try {
			PreparedStatement statement = connection.getConnection().prepareStatement(query);
			statement.setString(1, user.getEmail_id());

			ResultSet rst = statement.executeQuery();

			while (rst.next()) {
				user.setFirst_name(rst.getString("first_name"));
				user.setLast_name(rst.getString("last_name"));
				user.setPhn_no(rst.getString("phone_no"));
			}
			rst.close();
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	
}
