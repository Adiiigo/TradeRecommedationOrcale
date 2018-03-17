package com.cummins.Stocks;

import java.util.ArrayList;
import java.util.GregorianCalendar;

/*
This is a POJO class for all the variables we are retrieving.
*/

public class Stock {

	String code;
	String freeFloatMarketCap;
	String change;
	String deliveryQuantity;
	String quantityTraded;
	String open;
	String low52;
	String securityVar;
	String priceBandUpper;
	String totalTradedValue;
	String faceValue;
	String previousClose;
	String varMargin;
	String lastPrice;
	String pChange;
	String averagePrice;
	String priceBandLower;
	String high52;
	String closePrice;
	String totalSellQuantity;
	String dayHigh;
	String applicableMargin;
	String dayLow;
	String deliveryToTradedQuaantity;
	String totalTradedVolume;
	String eps;
	private ArrayList<Integer> dates;
	private ArrayList<Double> opens;
	private ArrayList<Double> highs;
	private ArrayList<Double> lows;
	private ArrayList<Double> closes;
	private ArrayList<Integer> volumes;
	private ArrayList<Double> adjcloses;
	
	
	public Stock(String freeFloatMarketCap,String change,String deliveryQuantity,String quantityTraded,String open,	String low52,String securityVar,String priceBandUpper,String totalTradedValue,String faceValue,	String previousClose,String varMargin,String lastPrice,	String pChange,String averagePrice,String priceBandLower,String high52,String closePrice,String totalSellQuantity,String dayHigh,String applicableMargin,String dayLow,String deliveryToTradedQuaantity,String totalTradedVolume,String eps) {	
		this.freeFloatMarketCap = freeFloatMarketCap; 
		this.change = change;	
		this.deliveryQuantity = deliveryQuantity; 
		this.quantityTraded = quantityTraded; 
		this.open = open; 
		this.low52 = low52; 
		this.securityVar = securityVar; 
		this.priceBandUpper = priceBandUpper; 
		this.totalTradedValue = totalTradedValue; 
		this.faceValue = faceValue; 
		this.previousClose = previousClose;
		this.varMargin = varMargin;
		this.lastPrice = lastPrice;
		this.pChange= pChange;
		this.averagePrice = averagePrice;
		this.priceBandLower = priceBandLower;
		this.high52 = high52;
		this.closePrice = closePrice;
		this.totalSellQuantity= totalSellQuantity;
		this.dayHigh = dayHigh;
		this.applicableMargin = applicableMargin;
		this.dayLow = dayLow;
		this.deliveryToTradedQuaantity = deliveryToTradedQuaantity;
		this.totalTradedVolume = totalTradedVolume;
		this.eps = eps;
		dates=new ArrayList<Integer>();
		opens=new ArrayList<Double>();
		highs=new ArrayList<Double>();
		lows=new ArrayList<Double>();
		closes=new ArrayList<Double>();
		volumes=new ArrayList<Integer>();
		adjcloses=new ArrayList<Double>();
		
	} 
	
   public Stock() {
		// TODO Auto-generated constructor stub
	}

public void setEps(String eps) {
		this.eps = eps;
	}

	public String getEps() {
		return eps;
	}

	public void setFreeFloatMarketCap(String freeFloatMarketCap) {
		this.freeFloatMarketCap = freeFloatMarketCap;
	}

	public void setChange(String change) {
		this.change = change;
	}

	public void setDeliveryQuantity(String deliveryQuantity) {
		this.deliveryQuantity = deliveryQuantity;
	}

	public void setQuantityTraded(String quantityTraded) {
		this.quantityTraded = quantityTraded;
	}

	public void setOpen(String open) {
		this.open = open;
	}

	public void setLow52(String low52) {
		this.low52 = low52;
	}

	public void setSecurityVar(String securityVar) {
		this.securityVar = securityVar;
	}

	public void setPriceBandUpper(String priceBandUpper) {
		this.priceBandUpper = priceBandUpper;
	}

	public void setTotalTradedValue(String totalTradedValue) {
		this.totalTradedValue = totalTradedValue;
	}

	public void setFaceValue(String faceValue) {
		this.faceValue = faceValue;
	}

	public void setPreviousClose(String previousClose) {
		this.previousClose = previousClose;
	}

	public void setVarMargin(String varMargin) {
		this.varMargin = varMargin;
	}

	public void setLastPrice(String lastPrice) {
		this.lastPrice = lastPrice;
	}

	public void setpChange(String pChange) {
		this.pChange = pChange;
	}

	public void setAveragePrice(String averagePrice) {
		this.averagePrice = averagePrice;
	}

	public void setPriceBandLower(String priceBandLower) {
		this.priceBandLower = priceBandLower;
	}

	public void setHigh52(String high52) {
		this.high52 = high52;
	}

	public void setClosePrice(String closePrice) {
		this.closePrice = closePrice;
	}

	public void setTotalSellQuantity(String totalSellQuantity) {
		this.totalSellQuantity = totalSellQuantity;
	}

	public void setDayHigh(String dayHigh) {
		this.dayHigh = dayHigh;
	}

	public void setApplicableMargin(String applicableMargin) {
		this.applicableMargin = applicableMargin;
	}

	public void setDayLow(String dayLow) {
		this.dayLow = dayLow;
	}

	public void setDeliveryToTradedQuaantity(String deliveryToTradedQuaantity) {
		this.deliveryToTradedQuaantity = deliveryToTradedQuaantity;
	}

	public void setTotalTradedVolume(String totalTradedVolume) {
		this.totalTradedVolume = totalTradedVolume;
	}
	
	public String getFreeFloatMarketCap() {
		return freeFloatMarketCap;
	}

	public String getChange() {
		return change;
	}

	public String getDeliveryQuantity() {
		return deliveryQuantity;
	}

	public String getQuantityTraded() {
		return quantityTraded;
	}

	public String getLow52() {
		return low52;
	}

	public String getSecurityVar() {
		return securityVar;
	}

	public String getPriceBandUpper() {
		return priceBandUpper;
	}

	public String getTotalTradedValue() {
		return totalTradedValue;
	}

	public String getFaceValue() {
		return faceValue;
	}

	public String getVarMargin() {
		return varMargin;
	}

	public String getLastPrice() {
		return lastPrice;
	}

	public String getpChange() {
		return pChange;
	}

	public String getAveragePrice() {
		return averagePrice;
	}

	public String getPriceBandLower() {
		return priceBandLower;
	}

	public String getHigh52() {
		return high52;
	}

	public String getClosePrice() {
		return closePrice;
	}

	public String getTotalSellQuantity() {
		return totalSellQuantity;
	}

	public String getDayHigh() {
		return dayHigh;
	}

	public String getApplicableMargin() {
		return applicableMargin;
	}

	public String getDayLow() {
		return dayLow;
	}

	public String getDeliveryToTradedQuaantity() {
		return deliveryToTradedQuaantity;
	}

	public String getTotalTradedVolume() {
		return totalTradedVolume;
	}
	



	public void setDates(ArrayList<Integer> dates) {
		this.dates = dates;
	}

	public void setOpens(ArrayList<Double> opens) {
		this.opens = opens;
	}

	public void setHighs(ArrayList<Double> highs) {
		this.highs = highs;
	}

	public void setLows(ArrayList<Double> lows) {
		this.lows = lows;
	}

	public void setCloses(ArrayList<Double> closes) {
		this.closes = closes;
	}

	public void setVolumes(ArrayList<Integer> volumes) {
		this.volumes = volumes;
	}

	public void setAdjcloses(ArrayList<Double> adjcloses) {
		this.adjcloses = adjcloses;
	}
	
	public ArrayList<Integer> getDates() {
		return dates;
	}
	public ArrayList<Double> getOpens() {
		return opens;
	}



	public ArrayList<Double> getHighs() {
		return highs;
	}


	public ArrayList<Double> getLows() {
		return lows;
	}



	public ArrayList<Double> getCloses() {
		return closes;
	}



	public ArrayList<Integer> getVolumes() {
		return volumes;
	}



	public ArrayList<Double> getAdjcloses() {
		return adjcloses;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getOpen() {
		
		return open;
	}

	
	
		
}



		