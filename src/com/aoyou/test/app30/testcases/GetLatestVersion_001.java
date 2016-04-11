package com.aoyou.test.app30.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.aoyou.test.app.request.GetLatestVersionRequest;
import com.aoyou.test.base.*;

public class GetLatestVersion_001 extends TestBase{

	@BeforeClass  
    public void setUp(){
    	Data.currentClassName = this.getClass().getSimpleName();
    }
	
	@Test
	public void getLatestVersion_001(){
	
		this.test=new GetLatestVersionRequest();
		this.test.sendPost();		
		//System.out.println(this.test.getResponseString());
		
	}
}
