package com.cummins.testPackage;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import com.cummins.Stocks.Sector;
import com.cummins.Stocks.Security;
import com.cummins.Stocks.Stock;
import com.cummins.UserDetails.AccountDetail;
import com.cummins.UserDetails.Userdetail;

public class GetterSetterTest{
/*	@Mock
	Date*/

	@Test
	    public void testSetOpen() {
	        Stock stock = new Stock();
	        stock.setOpen("134.14");
	        assertTrue(stock.getOpen() == "134.14");
	    }
	@Test
		public void testSetEps(){
		Stock stock = new Stock();
        stock.setEps("587.73");
        assertTrue(stock.getEps() == "587.73");
	}
	@Test
	public void testSetSecurityCode(){
		AccountDetail accountdetail=new AccountDetail();
		accountdetail.setSecurityCode("BHEL");
		 assertTrue(accountdetail.getSecurityCode() == "BHEL");
		}
	@Test
	public void testSetFirst_name(){
		Userdetail userdetail=new Userdetail();
		userdetail.setFirst_name("Hermione");
		 assertTrue(userdetail.getFirst_name() == "Hermione");
		}
	@Test
	public void testSetEmail_id(){
		Userdetail userdetail=new Userdetail();
		userdetail.setEmail_id("abc123@somesite.com");
		 assertTrue(userdetail.getEmail_id() == "abc123@somesite.com");
		}
//	@Test
//	public void testSetVolume(){
//		AccountDetail accountdetail=new AccountDetail();
//		accountdetail.setVolume(100000);
//		 assertTrue(accountdetail.getVolume() == 100000);
//		}
	@Test
	public void testSetStatus(){
		AccountDetail accountdetail=new AccountDetail();
		accountdetail.setStatus("BUY");
		 assertTrue(accountdetail.getStatus() == "BUY");
		}
	@Test
	public void testSetPassword(){
		Userdetail userdetail=new Userdetail();
		userdetail.setPassword("abcde123");
		 assertTrue(userdetail.getPassword() == "abcde123");
		}
	@Test
	public void testSetPhn_no(){
		Userdetail userdetail=new Userdetail();
		userdetail.setPhn_no("987654321");
		 assertTrue(userdetail.getPhn_no() == "987654321");
		}
	@Test
	public void testSetLastName(){
		Userdetail userdetail=new Userdetail();
		userdetail.setLast_name("Granger");
		 assertTrue(userdetail.getLast_name() == "Granger");
		}
//	@Test
//	public void testSetCurrPrice(){
//		AccountDetail accountdetail=new AccountDetail();
//		accountdetail.setCurr_price(123);
//		assertTrue(accountdetail.getCurr_price() == 123);
//		}
	@Test
	public void testSec_Name(){
		Security security=new Security();
		security.setName("Adani Ports");
		assertTrue(security.getName() == "Adani Ports");
	}
	@Test
	public void testSec_symbol(){
		Security security=new Security();
		security.setSymbol("RELIANCE");
		assertTrue(security.getSymbol() == "RELIANCE");
	}
	
	@Test
	public void testSector_Name(){
		Sector sector=new Sector();
		sector.setName("Automobiles");
		assertTrue(sector.getName() == "Automobiles");
	}
	@Test
	public void testSector_symbol(){
		Sector sector=new Sector();
		sector.setSymbol("AUTO");
		assertTrue(sector.getSymbol() == "AUTO");
	}
	@Test
    public void testSetChange() {
        Stock stock = new Stock();
        stock.setChange("0.99");
        assertTrue(stock.getChange() == "0.99");
    }
	@Test
    public void testSetMarketCap() {
        Stock stock = new Stock();
        stock.setFreeFloatMarketCap("12341000");
        assertTrue(stock.getFreeFloatMarketCap() == "12341000");
    }
	@Test
    public void testSetDeliveryQuan() {
        Stock stock = new Stock();
        stock.setDeliveryQuantity("1234000");
        assertTrue(stock.getDeliveryQuantity() == "1234000");
    }
	@Test
    public void testSetQuantity() {
        Stock stock = new Stock();
        stock.setQuantityTraded("6,051");
        assertTrue(stock.getQuantityTraded() == "6,051");
    }
	@Test
    public void testSetLow52() {
        Stock stock = new Stock();
        stock.setLow52("888.10");
        assertTrue(stock.getLow52() == "888.10");
    }
	@Test
    public void testSetHigh52() {
        Stock stock = new Stock();
        stock.setHigh52("1129.11");
        assertTrue(stock.getHigh52() == "1129.11");
    }
	@Test
    public void testSetFaceValue() {
        Stock stock = new Stock();
        stock.setFaceValue("10");
        assertTrue(stock.getFaceValue() == "10");
    }
	
	@Test
    public void testSetVarMargin() {
        Stock stock = new Stock();
        stock.setVarMargin("7.50");
        assertTrue(stock.getVarMargin() == "7.50");
    }
	
	@Test
    public void testSetLastPrice() {
        Stock stock = new Stock();
        stock.setLastPrice("1,032.45 ");
        assertTrue(stock.getLastPrice() == "1,032.45 ");
    }
	
	@Test
    public void testSetClosePrice() {
        Stock stock = new Stock();
        stock.setClosePrice("1,033.70");
        assertTrue(stock.getClosePrice() == "1,033.70");
    }
	
	@Test
    public void testSetSecurityVar() {
        Stock stock = new Stock();
        stock.setSecurityVar("4.37");;
        assertTrue(stock.getSecurityVar() == "4.37");
    }
	
	@Test
    public void testSetdayHigh() {
        Stock stock = new Stock();
        stock.setDayHigh("1,045.30");
        assertTrue(stock.getDayHigh() == "1,045.30");
    }
	@Test
    public void testSetdayLow() {
        Stock stock = new Stock();
        stock.setDayLow("1,031.00");
        assertTrue(stock.getDayLow() == "1,031.00");
    }
	@Test
    public void testSetTotTradedVol() {
        Stock stock = new Stock();
        stock.setTotalTradedVolume("34,93,728");
        assertTrue(stock.getTotalTradedVolume() == "34,93,728");
    }
	@Test
    public void testSetDeltoTradedQuan() {
        Stock stock = new Stock();
        stock.setDeliveryToTradedQuaantity("24,67,726");;
        assertTrue(stock.getDeliveryToTradedQuaantity() == "24,67,726");
    }
	
	
	
	
	
	
	
	
	/*
	@Test
	public void testSetUpdateLastTime()
	{
		AccountDetail ad=new AccountDetail();
		ad.setLast_update_date();
	}
	*/

}
