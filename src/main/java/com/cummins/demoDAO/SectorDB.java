package com.cummins.demoDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.cummins.Stocks.Sector;

public class SectorDB {
	ArrayList<Sector> sectors    = new ArrayList<Sector>();
	public ArrayList<Sector> getSectors(DataBaseConn connection)
	{
		 
		int i=0;
		ArrayList<Sector> sector_table=new ArrayList<Sector>();
		String query="select sector_name,sector_code from sector_table";
		try {
			Statement statement=connection.getConnection().createStatement();
			
			ResultSet rst= statement.executeQuery(query);
			
			while(rst.next())
			{
				
				Sector sector = new Sector();
				sector.setName(rst.getString("sector_name"));
				sector.setSymbol(rst.getString("sector_code"));
				sector_table.add(i, sector);
			}
			rst.close();
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sector_table;
		
	}
	
}
