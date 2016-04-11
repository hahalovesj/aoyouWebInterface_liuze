package com.aoyou.test.cases.ProductLogicService;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aoyou.test.base.Action;
import com.aoyou.test.base.Data;
import com.aoyou.test.base.InterfaceCallException;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.templates.ProductLogicService.GetCombinedProductPriceList;
import com.aoyou.test.templates.ProductLogicService.GetHotelStaySolutionViewList;
import com.aoyou.test.listener.TestngRetry;

public class GetHotelStaySolutionViewList001 extends TestBase{

	@BeforeClass  
    public void setUp(){
    	Data.currentClassName = this.getClass().getSimpleName();
    }
	
	@Test(retryAnalyzer = TestngRetry.class)
	public void getHotelStaySolutionViewList001(){
		
		String id = Action.getPackageProductID(1);
		String departDate = null;
		String hotelPrice = null;
		test = new GetCombinedProductPriceList();
		test.setParams("ProductID", id);
		test.sendPost();
		
		if(test.getStatus()==200){
			px.addNameSpace("a", "http://schemas.datacontract.org/2004/07/CYTS.Aoyou.Product.WebsiteLogic.Entity");
			px.Load(test.getResponseString());
			departDate = px.getElementsText("//a:DepartDate").get(0);
		
		}else throw new InterfaceCallException("GetCombinedProductPriceList接口请求失败!状态码："+test.getStatus());
		
		test = new GetHotelStaySolutionViewList();
		test.setParams("ProductID", id);
		test.setParams("DepartDate", departDate);
		test.sendPost();
		
		if(test.getStatus()==200){
			px.clearNameSpace();
			px.addNameSpace("a", "http://schemas.datacontract.org/2004/07/CYTS.Aoyou.Product.WebsiteLogic.Entity");
			px.addNameSpace("b", "http://schemas.microsoft.com/2003/10/Serialization/Arrays");
			px.Load(test.getResponseString());
			
			hotelPrice = px.getElementText("//a:HotelPrice");
			
			checkPoint.notEquals(hotelPrice,"0.00","价格为0.00");
			checkPoint.notEquals(hotelPrice,"0","价格为0");
			checkPoint.notEquals(hotelPrice,"1.00","价格为1.00");
			checkPoint.notEquals(hotelPrice,"1","价格为1");
			checkPoint.notEquals(hotelPrice,null,"价格为空");
		
		}else {checkPoint.isFaild("接口请求失败!状态码："+test.getStatus());};
		
		checkPoint.result("产品："+id+"的价格正常！");
		
	}
}
