package com.cummins.demoDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.cummins.Stocks.Sector;
import com.cummins.Stocks.Stock;


public class SecurityDB {
	ArrayList<Stock> security=new ArrayList<Stock>();   
	public SecurityDB(DataBaseConn connection ,String symbol)
	{
		 
		int i=0;
		
		String query="select security_code from security_table where security_id IN (select security_id from sector_security_map where sector_id=(select sector_id from sector_table where sector_code=?))";
		try {
			PreparedStatement statement=connection.getConnection().prepareStatement(query);
			statement.setString(1, symbol);
			
			ResultSet rst= statement.executeQuery();
			
			while(rst.next())
			{
				Stock stock = new Stock();
				stock.setCode(rst.getString("security_code"));
				security.add(i, stock);
				i++;
				System.out.println(rst.getString("security_code"));
			}
			rst.close();
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}
	public ArrayList<Stock> returnStocks()
	{
		System.out.println(security);
		return security;
	}
}
