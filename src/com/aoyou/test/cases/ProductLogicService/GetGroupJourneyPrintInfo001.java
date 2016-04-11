package com.aoyou.test.cases.ProductLogicService;

import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aoyou.test.base.Action;
import com.aoyou.test.base.Data;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.templates.ProductLogicService.GetGroupJourneyPrintInfo;
import com.aoyou.test.listener.TestngRetry;

public class GetGroupJourneyPrintInfo001 extends TestBase{
	
	@BeforeClass  
    public void setUp(){
    	Data.currentClassName = this.getClass().getSimpleName();
    }
	
	@Test(retryAnalyzer = TestngRetry.class)
	public void getGroupJourneyPrintInfo001(){
		List<String> productID = Action.getProductID(1, "2");
		String searchPrice = null;
		test = new GetGroupJourneyPrintInfo();
		test.setParams("ProductID", productID.get(0));
		test.sendPost();
		
		if(test.getStatus()==200){
			responseString = test.getResponseString();
			px.addNameSpace("a", "http://schemas.datacontract.org/2004/07/CYTS.Aoyou.Product.WebsiteLogic.Entity");
			px.Load(responseString);
			searchPrice = px.getElementText("//a:SearchPrice");
			checkPoint.notEquals(searchPrice,"0.00","价格为0.00");
			checkPoint.notEquals(searchPrice,"0","价格为0");
			checkPoint.notEquals(searchPrice,"1.00","价格为1.00");
			checkPoint.notEquals(searchPrice,"1","价格为1");
			checkPoint.notEquals(searchPrice,null,"价格为空");
			
		}else {checkPoint.isFaild("接口请求失败!状态码："+test.getStatus());};
		
		checkPoint.result("产品："+productID+"的价格正常！");
	}	

}
