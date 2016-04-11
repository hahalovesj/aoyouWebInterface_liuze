package com.aoyou.test.cases.productWebsiteLogicService;

import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aoyou.test.base.Action;
import com.aoyou.test.base.Data;
import com.aoyou.test.base.InterfaceCallException;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.templates.productWebsiteLogicService.GetPackageProductBookingInfo;
import com.aoyou.test.templates.productWebsiteLogicService.GetPackageProductPriceList;
import com.aoyou.test.listener.TestngRetry;

public class GetPackageProductBookingInfo001 extends TestBase{
	

	@BeforeClass 
    public void setUp(){
    	Data.currentClassName = this.getClass().getSimpleName();
    }
	
	@Test(retryAnalyzer = TestngRetry.class)
	public void getPackageProductBookingInfo001(){
		
		String id = Action.getPackageProductID(0);
		String departDate = null;
		List<String> dateTime = null;
		
		test = new GetPackageProductPriceList();
		test.setParams("ProductID", id);
		test.sendPost();
		
		if(test.getStatus()==200){
			px.addNameSpace("a", "http://schemas.datacontract.org/2004/07/CYTS.Aoyou.Product.WebsiteLogic.Entity");
			px.Load(test.getResponseString());
			departDate = px.getElementsText("//a:DepartDate").get(0);
		}else throw new InterfaceCallException("GetPackageProductPriceList接口请求失败!状态码："+test.getStatus());
		
		test = new GetPackageProductBookingInfo();
		test.setParams("ProductID", id);
		test.setParams("DepartDate", departDate);
		test.sendPost();
		if(test.getStatus()==200){
			px.clearNameSpace();
			px.addNameSpace("b", "http://schemas.microsoft.com/2003/10/Serialization/Arrays");
			px.Load(test.getResponseString());
			dateTime = px.getElementsText("//b:dateTime");
			checkPoint.notEquals(dateTime, "");
			checkPoint.notEquals(dateTime, null);
		}else{checkPoint.isFaild("接口请求失败!状态码："+test.getStatus());};
		
		checkPoint.result("产品："+id+" 返回"+dateTime.size()+"个可预订的日期");
	}
}
