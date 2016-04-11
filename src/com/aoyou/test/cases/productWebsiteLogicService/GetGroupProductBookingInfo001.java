package com.aoyou.test.cases.productWebsiteLogicService;

import java.util.List;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.aoyou.test.base.Data;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.templates.productWebsiteLogicService.GetGroupProductBookingInfo;
import com.aoyou.test.listener.TestngRetry;

public class GetGroupProductBookingInfo001 extends TestBase{
	
	@BeforeClass  
    public void setUp(){
    	Data.currentClassName = this.getClass().getSimpleName();
    }
	
	@Test(retryAnalyzer = TestngRetry.class)
	public void getGroupProductBookingInfo001(){
		String id = "80861";
		List<String> date = null;
		test = new GetGroupProductBookingInfo();
		test.setParams("ProductID", id);
		test.sendPost();
		if(test.getStatus()==200){
			px.addNameSpace("a", "http://schemas.datacontract.org/2004/07/CYTS.Aoyou.Product.WebsiteLogic.Entity");
			px.addNameSpace("b", "http://schemas.microsoft.com/2003/10/Serialization/Arrays");
			px.Load(test.getResponseString());
			date = px.getElementsText("//b:dateTime");
			checkPoint.notEquals(date, null);
			checkPoint.notEquals(date, "");
			
		}else {checkPoint.isFaild("接口请求失败!状态码："+test.getStatus());};
		
		checkPoint.result("Clubmed产品："+id+" 获取产品预订信息正确！共"+date.size()+"个可售日期！");
		
	}
}
