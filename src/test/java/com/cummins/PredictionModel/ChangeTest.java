package com.cummins.PredictionModel;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;
import org.mockito.Mock;

import com.cummins.Stocks.Stock;



public class ChangeTest {

@Mock
ArrayList<Double> MockedOpens=new ArrayList<>();
ArrayList<Double> MockedCloses=new ArrayList<>();
ArrayList<Stock> stocks=new ArrayList<Stock>();

	@Test
	public void test() {
		//Change change=new Change();
		
		Stock stock1=new Stock();
		MockedOpens.add(100.0);
		MockedOpens.add(100.0);
		MockedCloses.add(100.0);
		MockedCloses.add(100.0);
		stock1.setOpens(MockedOpens);
		stock1.setCloses(MockedCloses);
		stocks.add(stock1);
		stocks.add(stock1);
		stocks.add(stock1);
		Prediction predict=new Prediction(stocks);
		//change.delta(stocks,predict);
		//System.out.println(predict.getBuyStock());
		assertEquals(stocks,predict.getBuyStock());
	}

}
