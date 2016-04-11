package com.aoyou.test.cases.ProductLogicService;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aoyou.test.base.Action;
import com.aoyou.test.base.Data;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.templates.ProductLogicService.GetCombinedProduct;
import com.aoyou.test.listener.TestngRetry;

public class GetCombinedProduct001 extends TestBase{
	
	@BeforeClass  
    public void setUp(){
    	Data.currentClassName = this.getClass().getSimpleName();
    }
	
	@Test(retryAnalyzer = TestngRetry.class)
	public void getCombinedProduct001(){
		
		List<String> searchPrice = new ArrayList<String>();	
		String productID = Action.getPackageProductID(1);

		test = new GetCombinedProduct();
		test.setParams("ProductID", productID);
		test.sendPost();
			
		if(test.getStatus()==200){
			responseString = test.getResponseString();
   		    px.addNameSpace("a", "http://schemas.datacontract.org/2004/07/CYTS.Aoyou.Product.WebsiteLogic.Entity");
			px.Load(responseString);				
			searchPrice = px.getElementsText("//a:SearchPrice");
			checkPoint.equals((px.getElementText("//a:ProductID")), productID, "返回产品id与入参id不符!");
			checkPoint.notEquals(searchPrice,"0.00");
			checkPoint.notEquals(searchPrice,"0");
			checkPoint.notEquals(searchPrice,"1.00");
			checkPoint.notEquals(searchPrice,"1");
			checkPoint.notEquals(searchPrice,null);
			
		}else{checkPoint.isFaild("接口请求失败!状态码："+test.getStatus());};

		checkPoint.result("产品："+productID+"的价格和id返回正常！");
	}
	
}
