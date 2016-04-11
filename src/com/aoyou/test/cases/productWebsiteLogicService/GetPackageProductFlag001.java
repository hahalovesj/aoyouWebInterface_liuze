package com.aoyou.test.cases.productWebsiteLogicService;

import org.dom4j.Element;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aoyou.test.base.Action;
import com.aoyou.test.base.Data;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.templates.productWebsiteLogicService.GetPackageProductFlag;
import com.aoyou.test.listener.TestngRetry;

public class GetPackageProductFlag001 extends TestBase{
	
	@BeforeClass 
    public void setUp(){
    	Data.currentClassName = this.getClass().getSimpleName();
    }
	
	@Test(retryAnalyzer = TestngRetry.class)
	public void getPackageProductFlag001(){
		String id = Action.getProductID(1, "1").get(0);
		String productStatu = null;
		test = new GetPackageProductFlag();
		test.setParams("ProductID", id);
		test.sendPost();
		if(test.getStatus()==200){
			px.addNameSpace("s", "http://schemas.xmlsoap.org/soap/envelope/");
			px.Load(test.getResponseString());
			Element e  = px.getElementObject("//s:Body");
			productStatu = e.element("GetPackageProductFlagResponse").element("GetPackageProductFlagResult").getText();
			
			if(productStatu.equals("1") || productStatu.equals("2") || productStatu.equals("3")){
				checkPoint.isSuccess("");
			}else{checkPoint.isFaild("产品类型返回错误"+productStatu);};
			
		}else{checkPoint.isFaild("接口请求失败!状态码："+test.getStatus());};
		
		checkPoint.result("产品："+id+"类型为："+productStatu);
	}
}
