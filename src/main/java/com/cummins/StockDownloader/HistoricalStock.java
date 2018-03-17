package com.cummins.StockDownloader;
import com.cummins.Stocks.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.ArrayList;
import java.util.Calendar;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

/*
This is a class for extracting the historical data from yahoo api
@param Stock class object,symbol stock symbol,start Gregorian calendar start date,end Gregorian calendar end date
saves the data in the respective variables
@See Stock 
8*/

public class HistoricalStock {
	
	
	private ArrayList<Integer> dates;
	private ArrayList<Double> opens;
	private ArrayList<Double> highs;
	private ArrayList<Double> lows;
	private ArrayList<Double> closes;
	private ArrayList<Integer> volumes;
	private ArrayList<Double> adjcloses;
	
	
	
	public void historicalStock(Stock s,String symbol,GregorianCalendar start,GregorianCalendar end){
		
		dates=new ArrayList<Integer>();
		opens=new ArrayList<Double>();
		highs=new ArrayList<Double>();
		lows=new ArrayList<Double>();
		closes=new ArrayList<Double>();
		volumes=new ArrayList<Integer>();
		adjcloses=new ArrayList<Double>();
		
	System.out.println(end.get(Calendar.MONTH));	
	
	String Start = start.get(Calendar.DAY_OF_MONTH)+ "+" + start.get(Calendar.MONTH) + "+" + start.get(Calendar.YEAR); 
	String End = end.get(Calendar.DAY_OF_MONTH)+ "+" + end.get(Calendar.MONTH) + "+" + end.get(Calendar.YEAR); 
	
	String url="https://finance.google.com/finance/historical?q=" + s +"&startdate=" + Start + "&enddate+" + End + "&output=csv" ;           
	
	try
	{
		URL yhoofin=new URL(url);
		URLConnection data=yhoofin.openConnection();
		Scanner in=new Scanner(data.getInputStream());
		if(in.hasNext())
			in.nextLine();
		
		
		while(in.hasNextLine())
		{
			String line=in.nextLine();
			String[] attributes = line.split(",");


			DateFormat format = new SimpleDateFormat( "yyyy-MM-dd" );
			Date       date = format.parse(attributes[0] );
			//Calendar   calendar = new GregorianCalendar();
			
			
			int date_curr=date.getDate();
			double open=Double.parseDouble(attributes[1]);
			double high=Double.parseDouble(attributes[2]);
			double low=Double.parseDouble(attributes[3]);
			double close=Double.parseDouble(attributes[4]);
			int volume=Integer.parseInt(attributes[5]);
			double adjclose=Double.parseDouble(attributes[6]);
		
			dates.add(date_curr);
			opens.add(open);
			highs.add(high);
			lows.add(low);
			closes.add(close);
			volumes.add(volume);
			adjcloses.add(adjclose);	
			
		}
		s.setDates(dates);
		s.setOpens(opens);
		s.setCloses(closes);
		s.setHighs(highs);
		s.setAdjcloses(adjcloses);
		s.setVolumes(volumes);
		s.setLows(lows);
			
	}
	catch(Exception e)
	{
		System.err.println(e);
	}
}

	
	
		
}






	
		

