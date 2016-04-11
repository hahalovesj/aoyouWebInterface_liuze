package com.aoyou.test.base;

import org.testng.annotations.BeforeClass;

import com.aoyou.test.util.CheckPoint;
import com.aoyou.test.util.ParseXmlString;

public class TestBase {
	protected ParseXmlString px = new ParseXmlString();
	protected CheckPoint checkPoint =new CheckPoint();
	protected SetTest test;
	protected String  responseString = "";
	
	@BeforeClass
	public void setUp(){
		Data.currentClassName=this.getClass().getSimpleName();
	}
}
