package com.aoyou.test.cases.ProductLogicService;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aoyou.test.base.Action;
import com.aoyou.test.base.Data;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.templates.ProductLogicService.GetCombinedProductPriceList;
import com.aoyou.test.listener.TestngRetry;

public class GetCombinedProductPriceList001 extends TestBase{
	
	@BeforeClass  
    public void setUp(){
    	Data.currentClassName = this.getClass().getSimpleName();
    }
	
	@Test(retryAnalyzer = TestngRetry.class)
	public void getCombinedProductPriceList001(){
		
		int priceNumber = 0;
		List<String> showPrice = new ArrayList<String>();	
		String productID = Action.getPackageProductID(1);

		test = new GetCombinedProductPriceList();
		test.setParams("ProductID", productID);
		test.sendPost();
			
		if(test.getStatus()==200){
			responseString = test.getResponseString();
   		    px.addNameSpace("a", "http://schemas.datacontract.org/2004/07/CYTS.Aoyou.Product.WebsiteLogic.Entity");
			px.Load(responseString);				
			priceNumber = px.getElementObjects("//a:PriceCalendarDTO").size();
			showPrice = px.getElementsText("//a:ShowPrice");
			
			checkPoint.notEquals(showPrice,"0.00");
			checkPoint.notEquals(showPrice,"0");
			checkPoint.notEquals(showPrice,"1.00");
			checkPoint.notEquals(showPrice,"1");
			checkPoint.notEquals(showPrice,null);
			
		}else{checkPoint.isFaild("接口请求失败!状态码："+test.getStatus());};

		checkPoint.result("产品："+productID+" 共返回"+priceNumber+"个报价，基础信息全部正确！");
	}
	
}
