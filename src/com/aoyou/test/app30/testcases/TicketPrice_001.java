package com.aoyou.test.app30.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aoyou.test.app.request.TicketPriceRequest;
import com.aoyou.test.base.Data;
import com.aoyou.test.base.TestBase;

public class TicketPrice_001 extends TestBase{

	@BeforeClass
	public void setUp(){
		Data.currentClassName=this.getClass().getSimpleName();
	}
	
	@Test
	public void ticketPrice_001(){
		
		this.test=new TicketPriceRequest();
		test.sendPost();
		
		System.out.println(test.getResponseString());
	}
}
