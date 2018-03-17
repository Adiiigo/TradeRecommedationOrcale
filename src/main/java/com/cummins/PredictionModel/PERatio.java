package com.cummins.PredictionModel;

/*
This is a class which returns prediction according to the PERatio calculated
@param none
@return PERatio calculated
*/
public class PERatio {

	public double marketValuePerShare;
	public double earningsPerShare;

	
	public double PE=0;
	
	public double calcPE() {
		// TODO Auto-generated method stub
			
			double PE = marketValuePerShare/earningsPerShare;
			System.out.println("P/E ratio is:");
			System.out.println(PE);
			return PE;
	}
	
	public double getMarketValuePerShare() {
		return marketValuePerShare;
	}

	public void setMarketValuePerShare(double marketValuePerShare) {
		this.marketValuePerShare = marketValuePerShare;
	}

	public double getEarningsPerShare() {
		return earningsPerShare;
	}

	public void setEarningsPerShare(double earningsPerShare) {
		this.earningsPerShare = earningsPerShare;
	}
	
}
