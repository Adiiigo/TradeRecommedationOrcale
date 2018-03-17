package com.cummins.StockDownloader;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.Date;

import com.cummins.Stocks.*;
/*
This is factory class which call our historical data class and current data downloader class.
@param ArrayList stocks of stock class
@see stock HistoricalStock CurrentStockData
*/
public class StockFactory {
	
	public void stockFactory(ArrayList<Stock> stocks){
	//Scanner in=new Scanner(System.in);
	GregorianCalendar today = new GregorianCalendar();
	int todayMonth = today.get(Calendar.MONTH);
    int todayDayOfMonth = today.get(Calendar.DAY_OF_MONTH);
    int todayYear = today.get(Calendar.YEAR);
    
    Calendar calendar = Calendar.getInstance(); // this would default to now
    //System.out.println("Date 2 weeks-"calendar.add(Calendar.DATE, -14));
    calendar.add(Calendar.DATE, -14);
    int historyMonth=calendar.get(Calendar.MONTH);
    int historyDayOfMonth=calendar.get(Calendar.DAY_OF_MONTH);
    int historyYear=calendar.get(Calendar.YEAR);
    GregorianCalendar start=new GregorianCalendar(todayYear,todayMonth,todayDayOfMonth);
    GregorianCalendar end=new GregorianCalendar(historyYear,historyMonth,historyDayOfMonth);
//    System.out.println("Enter the company name");
//    String symbol=in.nextLine();

    for(int i=0;i<stocks.size();i++)
    {
	HistoricalStock stockdownloader=new HistoricalStock();
	stockdownloader.historicalStock(stocks.get(i),stocks.get(i).getCode(),start,end);
	CurrentStockData currentstockdata=new CurrentStockData();
	currentstockdata.getStock(stocks.get(i),stocks.get(i).getCode());
    }
//	System.out.println(stock.getAveragePrice());
//	System.out.println(stock.getOpens());
//	System.out.println(stock.getEps());
//	System.out.println(stock.getCloses());
//	System.out.println(stock.getDeliveryToTradedQuaantity());
	}
}
