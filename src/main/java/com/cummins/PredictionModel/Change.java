package com.cummins.PredictionModel;

import java.util.ArrayList;

import com.cummins.Stocks.*;
/*
This is a class which predicts whether we should buy a stock or sell it according to the opens and highs of historical data.
@param stocks ArrayList of stock class Prediction object of class prediction
saves into arrayList of buy or sell according to the prediction
@see Prediction Stock
*/

public class Change {
	
	double average=0.0;

	
	

	public void delta(ArrayList<Stock> stocks,Prediction prediction) {
		// TODO Auto-generated method stub

		for (int i = 0; i < stocks.size(); i++) {
			double change1 = 0;
			for (int j = 0; j < stocks.get(i).getOpens().size(); j++) {

				change1 += (stocks.get(i).getCloses().get(j) - stocks.get(i).getOpens().get(j))
						/ stocks.get(i).getOpens().get(j);
				//
			}
		 average = change1 / stocks.get(i).getOpens().size();
			if (average >= 0) {

				prediction.getBuyStock().add(stocks.get(i));
			} else
				prediction.getSellStock().add(stocks.get(i));

		}

	}

public double getAverage() {
		return average;
	}

}
