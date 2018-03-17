/*package com.cummins.StockDownloader;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;
import org.mockito.Mock;

import com.cummins.Stocks.Stock;

public class StockFactoryTest {
	@Mock
	ArrayList<Stock> stocks=new ArrayList<Stock>();

	@Test
	public void test() {
		Stock stock1=new Stock();
		stock1.setCode("BHEL");
		stocks.add(stock1);
		StockFactory stockfactory=new StockFactory();
		stockfactory.stockFactory(stocks);
		assertNotNull(stock1.getCloses());
		assertNotNull(stock1.getOpen());
		
		//doNothing().when(stockfactory).stockFactory(stocks);
		
		
		
	}

}
*/