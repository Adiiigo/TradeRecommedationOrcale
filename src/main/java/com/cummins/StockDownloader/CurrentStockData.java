package com.cummins.StockDownloader;


import java.io.BufferedReader;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.jsoup.Jsoup;  
import org.jsoup.nodes.*;  
import org.jsoup.select.Elements;

import com.cummins.Stocks.Stock;

public class CurrentStockData {  
	
	/*
	* Returns a Stock Object that contains info about a specified stock.
	* @param 	symbol the company's stock symbol
	* @return 	a stock object containing info about the company's stock
	* @see Stock
	*/
	void getStock(Stock s1,String symbol) {  
		
		
		String eps;
		
		
		try { 
	
			// Retrieve CSV File
			URL yahoo = new URL("http://finance.google.com/finance/historical?q="+symbol+"&output=csv");
			Document doc = Jsoup.connect("https://www.nseindia.com/live_market/dynaContent/live_watch/get_quote/ajaxGetQuoteJSON.jsp?symbol="+symbol).get();
			URLConnection connection = yahoo.openConnection(); 
			InputStreamReader is = new InputStreamReader(connection.getInputStream());
			BufferedReader br = new BufferedReader(is);  
			
			
			 eps = br.readLine();
		//Only split on commas that aren't in quotes
			s1.setEps(eps);
			Element body1=doc.body();
			String line=body1.toString();
			//System.out.println(line);
			
			String[] stockInfo;
			String[] tempStockInfo1;
			stockInfo = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
			//int line1=Integer.parseInt(stockInfo[0]);
			int i=0;
			String[] stockInfo1 = new String[stockInfo.length];
		
			while(i<stockInfo.length)
			{
				//System.out.println(stockInfo[i]);
				String line1=stockInfo[i];
				tempStockInfo1=line1.split(":");
				stockInfo1[i]=tempStockInfo1[1];
				i++;
			}
			/*while( j<stockInfo1.length)
			{
				System.out.println(stockInfo1[j]);
				j++;
			}*/
//			Stock s1=new Stock();
			s1.setFreeFloatMarketCap(stockInfo1[5]);
		    s1.setChange(stockInfo1[7]);
			s1.setDeliveryQuantity(stockInfo1[14]);
		    s1.setQuantityTraded(stockInfo1[17]);
		    s1.setOpen(stockInfo1[21]);
			s1.setLow52(stockInfo1[22]);
			s1.setSecurityVar(stockInfo1[23]);
			s1.setPriceBandUpper(stockInfo1[25]);
			s1.setTotalTradedValue(stockInfo1[26]);
			s1.setFaceValue(stockInfo1[27]);
			s1.setPreviousClose(stockInfo1[29]);
			s1.setVarMargin(stockInfo1[31]);
			s1.setLastPrice(stockInfo1[32]);
			s1.setpChange(stockInfo1[33]);
			s1.setAveragePrice(stockInfo1[36]);
			s1.setPriceBandLower(stockInfo1[41]);
			s1.setHigh52(stockInfo1[43]);
			s1.setClosePrice(stockInfo1[46]);
			s1.setTotalSellQuantity(stockInfo1[50]);
			s1.setDayHigh(stockInfo1[51]);
			s1.setApplicableMargin(stockInfo1[63]);
			s1.setDayLow(stockInfo1[67]);
			s1.setDeliveryToTradedQuaantity(stockInfo1[68]);
			s1.setTotalTradedVolume(stockInfo1[69]);
		
		} catch (IOException e) {
			Logger log = Logger.getLogger(CurrentStockData.class.getName()); 
			log.log(Level.SEVERE, e.toString(), e);
			
		}
		catch(NullPointerException se)
		{
			se.printStackTrace();
		}
		
		//return new Stock(sym, price, volume, pe, eps, week52low, week52high, daylow, dayhigh, movingav50day, marketcap, name,currency, shortRatio,previousClose,open,exchange);
	
	}
}











