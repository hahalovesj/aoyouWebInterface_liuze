package com.aoyou.test.cases.ProductLogicService;

import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aoyou.test.base.Action;
import com.aoyou.test.base.Data;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.templates.ProductLogicService.GetPackageProductPriceCalendar;
import com.aoyou.test.listener.TestngRetry;

public class GetPackageProductPriceCalendar001 extends TestBase{
	
	@BeforeClass  
    public void setUp(){
    	Data.currentClassName = this.getClass().getSimpleName();
    }
	
	@Test(retryAnalyzer = TestngRetry.class)
	public void getPackageProductPriceCalendar001(){

		List<String> productID = Action.getProductID(1, "1");
		List<String> price = null;
		test = new GetPackageProductPriceCalendar();
		test.setParams("ProductID", productID.get(0));
		test.sendPost();
		
		if(test.getStatus()==200){
			responseString = test.getResponseString();
			px.addNameSpace("a", "http://schemas.datacontract.org/2004/07/CYTS.Aoyou.Product.WebsiteLogic.Entity");
			px.Load(responseString);
			price = px.getElementsText("//a:ShowPrice");
			checkPoint.notEquals(price,"0.00");
			checkPoint.notEquals(price,"0");
			checkPoint.notEquals(price,"1.00");
			checkPoint.notEquals(price,"1");
			checkPoint.notEquals(price,null);
			
		}else {checkPoint.isFaild("接口请求失败!状态码："+test.getStatus());};
		
		checkPoint.result("产品："+productID+"价格日历返回"+price.size()+"个价格正常！");
	}	
}
