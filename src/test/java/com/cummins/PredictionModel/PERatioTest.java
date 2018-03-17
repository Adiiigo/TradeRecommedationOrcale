package com.cummins.PredictionModel;

import static org.junit.Assert.*;

import org.junit.Test;

public class PERatioTest {

	@Test
	public void test() {
		PERatio per= new PERatio();
		per.setMarketValuePerShare(120.00);
		per.setEarningsPerShare(150.00);
		double actualresult=per.calcPE();
		assertEquals(actualresult,0.8,0);
		
	}

}
