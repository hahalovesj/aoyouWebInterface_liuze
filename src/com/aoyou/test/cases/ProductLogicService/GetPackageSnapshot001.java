package com.aoyou.test.cases.ProductLogicService;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aoyou.test.base.Action;
import com.aoyou.test.base.Data;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.templates.ProductLogicService.GetPackageSnapshot;
import com.aoyou.test.listener.TestngRetry;

public class GetPackageSnapshot001 extends TestBase{
		
	@BeforeClass  
	public void setUp(){
	   Data.currentClassName = this.getClass().getSimpleName();
	}
		
	@Test(retryAnalyzer = TestngRetry.class)
	public void getPackageSnapshot001(){
	   String id = Action.getPackageProductID(0);
	   test = new GetPackageSnapshot();
	   test.setParams("ProductID", id);
	   test.sendPost();
	   if(test.getStatus()==200){
		   px.addNameSpace("a", "http://schemas.datacontract.org/2004/07/CYTS.Aoyou.Product.WebsiteLogic.Entity");
		   px.Load(test.getResponseString());
		   checkPoint.equals(px.getElementText("//a:ProductID"), id, "产品id与入参不符！");
		   
	   }else{checkPoint.isFaild("接口请求失败!状态码："+test.getStatus());};

		checkPoint.result("产品："+id+" 获取Snapshot信息正确！");
	   
	}
			
}
