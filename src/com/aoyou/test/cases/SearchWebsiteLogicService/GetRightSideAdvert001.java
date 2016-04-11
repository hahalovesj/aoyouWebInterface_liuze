package com.aoyou.test.cases.SearchWebsiteLogicService;

import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aoyou.test.base.Data;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.templates.SearchWebsiteLogicService.GetRightSideAdvert;
import com.aoyou.test.listener.TestngRetry;
import com.aoyou.test.util.URLAvailability;

public class GetRightSideAdvert001 extends TestBase{
	
	@BeforeClass  
    public void setUp(){
    	Data.currentClassName = this.getClass().getSimpleName();
    }
	
	@Test(retryAnalyzer = TestngRetry.class)
	public void getRightSideAdvert001(){

		test = new GetRightSideAdvert();
		test.sendPost();
		
		if(test.getStatus()==200){
			responseString = test.getResponseString();
			px.addNameSpace("a", "http://schemas.datacontract.org/2004/07/CYTS.Aoyou.Search.WebsiteLogic.Entity");
			px.Load(responseString);
			List<String> imageUrl = px.getElementsText("//a:ImageUrl");
			List<String> linkUrl = px.getElementsText("//a:LinkUrl");
			List<String> title = px.getElementsText("//a:Title");
	
			checkPoint.equals(URLAvailability.isConnect(imageUrl), true);
			checkPoint.equals(URLAvailability.isConnect(linkUrl), true);
			checkPoint.notEquals(title, "");
			checkPoint.notEquals(title, null);
			
		}else{checkPoint.isFaild("接口请求失败!状态码："+test.getStatus());}
		
		checkPoint.result("RightSideAdvertResult信息正确");
	}	
	
}

