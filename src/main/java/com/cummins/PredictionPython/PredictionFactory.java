package com.cummins.PredictionPython;

import java.util.ArrayList;

import com.cummins.Stocks.Stock;

public class PredictionFactory {

ArrayList<Stock> buyStock=new ArrayList<Stock>();
	

	ArrayList<Stock> sellStock=new ArrayList<Stock>();
	public ArrayList<Stock> getBuyStock() {
		return buyStock;
	}
	public void setBuyStock(ArrayList<Stock> buyStock) {
		this.buyStock = buyStock;
	}
	public ArrayList<Stock> getSellStock() {
		return sellStock;
	}
	public void setSellStock(ArrayList<Stock> sellStock) {
		this.sellStock = sellStock;
	}
	
	public PredictionFactory(ArrayList<Stock> stocks)
	{
		CSVWrite csvwrite=new CSVWrite();
		csvwrite.FileWrite(stocks);
		PredictionExec prediction =new PredictionExec();
		prediction.ExecFile();
		ReadFile readfile =new ReadFile();
		readfile.FileRead(stocks,this);
		
	}
}
