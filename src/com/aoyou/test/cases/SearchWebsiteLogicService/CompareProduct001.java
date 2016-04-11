package com.aoyou.test.cases.SearchWebsiteLogicService;

import java.util.List;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.aoyou.test.base.Action;
import com.aoyou.test.base.Data;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.templates.SearchWebsiteLogicService.CompareProduct;
import com.aoyou.test.listener.TestngRetry;

public class CompareProduct001 extends TestBase{

	@BeforeClass  
    public void setUp(){
    	Data.currentClassName = this.getClass().getSimpleName();
    }
	
	@Test(retryAnalyzer = TestngRetry.class)
	public void compareProduct001(){
		
		List<String> productID = Action.getProductID(2, "0");
		test = new CompareProduct();
		test.setParams("ProductID", productID.get(0));
		test.setParams("ProductID", productID.get(1));
		test.sendPost();
		
		if(test.getStatus()==200){
			responseString = test.getResponseString();
			px.Load(responseString);
			checkPoint.notEquals(px.getElementsText("//a:MainTitle"), "");
			checkPoint.notEquals(px.getElementsText("//a:MainTitle"), null);
		}else{checkPoint.isFaild("接口请求失败!状态码："+test.getStatus());};
		
		checkPoint.result("CompareProduct:产品信息正确！");		
	}	
}
