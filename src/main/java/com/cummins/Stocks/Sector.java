package com.cummins.Stocks;

import java.io.Serializable;
/*
This is a POJO class for required classes
Variables name symbol
*/
public class Sector implements Serializable {
	private String name;
	private String symbol;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	

}
