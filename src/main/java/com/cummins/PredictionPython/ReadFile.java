package com.cummins.PredictionPython;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.cummins.Stocks.Stock;

public class ReadFile {


	public void FileRead(ArrayList<Stock> stocks,PredictionFactory predict)
	{
		int i=0;
		BufferedReader out=null;
		try {
			FileReader file=new FileReader("/home/acer/Desktop/citiProjects/TradeRecomm/src/main/java/com/cummins/PredictionPython/final_output.csv");
			out=new BufferedReader(file);
			
			while(out.readLine()!="SELL")
			{
				
					if(out.readLine()==stocks.get(i).getCode())
					{
						predict.getBuyStock().add(stocks.get(i));
					}
					i++;
				
			}
			i=0;
			while(out.readLine() != null)
			{
				if(out.readLine()==stocks.get(i).getCode())
				{
					predict.getSellStock().add(stocks.get(i));
				}
				i++;
			}
			
			file.close();
			out.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}
	
}
