package com.aoyou.test.app30.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aoyou.test.app.request.GetJourneyRecommendRequest;
import com.aoyou.test.base.Data;
import com.aoyou.test.base.TestBase;

public class GetJourneyRecommend_001 extends TestBase{

	@BeforeClass
	public void setUp(){
		Data.currentClassName=this.getClass().getSimpleName();
	}
	
	@Test
	public void getJourneyRecommend_001(){
		
		this.test=new GetJourneyRecommendRequest();
		this.test.sendPost();
		
		System.out.println(this.test.getResponseString());
	}
}
