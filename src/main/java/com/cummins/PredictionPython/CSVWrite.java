package com.cummins.PredictionPython;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.cummins.Stocks.Stock;

public class CSVWrite {

	public void FileWrite(ArrayList<Stock> stocks){
		
	
		try {
			FileWriter file=new FileWriter("/home/acer/Desktop/citiProjects/TradeRecomm/src/main/java/com/cummins/PredictionPython/dummyInp.csv");
			BufferedWriter out=new BufferedWriter(file);
			for(int i=0;i<stocks.size();i++)
			{
				String company=stocks.get(i).getCode();
				out.write(company + "\n");
				for(int j=0;j<stocks.get(i).getCloses().size();j++)
				{
					String date=stocks.get(i).getDates().get(j).toString();
					String value=stocks.get(i).getCloses().get(j).toString();
				
					out.write(date + "," + value);
				}
			}
			
			file.close();
			out.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
}
