package com.aoyou.test.cases.ProductLogicService;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aoyou.test.base.Action;
import com.aoyou.test.base.Data;
import com.aoyou.test.base.InterfaceCallException;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.listener.TestngRetry;
import com.aoyou.test.templates.ProductLogicService.GetAirSolutionViewList;
import com.aoyou.test.templates.ProductLogicService.GetCombinedProductPriceList;


public class GetAirSolutionViewList001 extends TestBase{

	@BeforeClass  
    public void setUp(){
    	Data.currentClassName = this.getClass().getSimpleName();
    }
	
	@Test(retryAnalyzer = TestngRetry.class)
	public void getAirSolutionViewList001(){
		
		String id = Action.getPackageProductID(1);
		String departDate = null;
		
		test = new GetCombinedProductPriceList();
		test.setParams("ProductID", id);
		test.sendPost();
		
		if(test.getStatus()==200){
			px.addNameSpace("a", "http://schemas.datacontract.org/2004/07/CYTS.Aoyou.Product.WebsiteLogic.Entity");
			px.Load(test.getResponseString());
			departDate = px.getElementsText("//a:DepartDate").get(0);
		}else throw new InterfaceCallException("GetCombinedProductPriceList接口请求失败!状态码："+test.getStatus());
		
		test = new GetAirSolutionViewList();
		test.setParams("ProductID", id);
		test.setParams("DepartDate", departDate);
		test.sendPost();
		
		if(test.getStatus()==200){
			px.clearNameSpace();
			px.addNameSpace("a", "http://schemas.datacontract.org/2004/07/CYTS.Aoyou.Product.WebsiteLogic.Entity");
			px.Load(test.getResponseString());
			String adultPrice = px.getElementText("//a:AdultPrice");
	
			checkPoint.notEquals(adultPrice,"0.00","adultPrice为0.00");
			checkPoint.notEquals(adultPrice,"0","adultPrice为0");
			checkPoint.notEquals(adultPrice,"1.00","adultPrice为1.00");
			checkPoint.notEquals(adultPrice,"1","adultPrice为1");
			checkPoint.notEquals(adultPrice,null,"adultPrice为null");
			
			
		}else {checkPoint.isFaild("接口请求失败!状态码："+test.getStatus());};
		
		checkPoint.result("产品："+id+" 日期"+departDate+"查询回参信息全部正确！");
		
	}
}
