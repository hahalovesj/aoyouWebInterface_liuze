package com.aoyou.test.cases.ProductLogicService;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aoyou.test.base.Action;
import com.aoyou.test.base.Data;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.templates.ProductLogicService.GetGroupProductForReserve;
import com.aoyou.test.listener.TestngRetry;

public class GetGroupProductForReserve001 extends TestBase{
	
	@BeforeClass  
    public void setUp(){
    	Data.currentClassName = this.getClass().getSimpleName();
    }
	
	@Test(retryAnalyzer = TestngRetry.class)
	public void getGroupProductForReserve001(){
		String productID = Action.getSingleProductID("2");
		String responseproductID = null;
		test = new GetGroupProductForReserve();
		test.setParams("ProductID", productID);
		test.sendPost();
		
		if(test.getStatus()==200){
			responseString = test.getResponseString();
			px.addNameSpace("a", "http://schemas.datacontract.org/2004/07/CYTS.Aoyou.Product.WebsiteLogic.Entity");
			px.Load(responseString);
			responseproductID = px.getElementText("//a:ProductID");
			checkPoint.equals(responseproductID, productID, "返回的产品ID不正确");
			
		}else {checkPoint.isFaild("接口请求失败!状态码："+test.getStatus());};
	
		checkPoint.result("产品："+productID+"返回的产品ID正确！");
	}	

}
