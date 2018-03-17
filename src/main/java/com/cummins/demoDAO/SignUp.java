package com.cummins.demoDAO;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.cummins.UserDetails.Userdetail;

public class SignUp implements Serializable {
 
	private static  int user_id;
	public SignUp(DataBaseConn connection,Userdetail signup)
	{
		
		
		String query_id="select max(user_id) as user_id1 from user_details";
		String query = "insert into user_details  (user_id,first_name,last_name,phone_no,email_id,password) values (?,?,?,?,?,?)";
		
		try {
			Statement result_stmt=connection.getConnection().createStatement();
			ResultSet rst=result_stmt.executeQuery(query_id);
			while (rst.next()) {
				user_id=rst.getInt("user_id1");
				
			}
			user_id++;
			System.out.println(user_id);
			PreparedStatement  statement = connection.getConnection().prepareStatement(query);
			statement.setInt(1,user_id);
			statement.setString(2, signup.getFirst_name());
			statement.setString(3,signup.getLast_name());
			statement.setString(4,signup.getPhn_no());
			statement.setString(5,signup.getEmail_id());
			statement.setString(6,signup.getPassword());
			statement.executeQuery();
			rst.close();
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
