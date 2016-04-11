package com.aoyou.test.cases.productWebsiteLogicService;

import java.util.List;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.aoyou.test.base.Data;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.templates.productWebsiteLogicService.GetPackageJourneyPrintInfo;
import com.aoyou.test.listener.TestngRetry;

public class GetPackageJourneyPrintInfo002 extends TestBase{

	@BeforeClass  
    public void setUp(){
    	Data.currentClassName = this.getClass().getSimpleName();
    }
	
	@Test(retryAnalyzer = TestngRetry.class)
	public void getPackageJourneyPrintInfo002(){
		String id = "80861";
		test = new GetPackageJourneyPrintInfo();
		test.setParams("ProductID", id);
		test.sendPost();
		if(test.getStatus()==200){
			px.addNameSpace("a", "http://schemas.datacontract.org/2004/07/CYTS.Aoyou.Product.WebsiteLogic.Entity");
			px.Load(test.getResponseString());
			List<String> proDesc = px.getElementsText("//a:ProductFeature//a:Desc");
			List<String> arriveCityText = px.getElementsText("//a:JourneyDTO/a:ArriveCityText");

			checkPoint.notEquals(proDesc, null);
			checkPoint.notEquals(proDesc, "");
			checkPoint.notEquals(arriveCityText, null);
			checkPoint.notEquals(arriveCityText, "");
			
		}else{checkPoint.isFaild("接口请求失败!状态码："+test.getStatus());};
		
		checkPoint.result("产品："+id+" 获取Clubmed产品打印行程信息正确！");
	}
	
}
