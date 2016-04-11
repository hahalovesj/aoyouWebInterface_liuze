package com.aoyou.test.cases.orderservice;

import org.testng.annotations.Test;
import com.aoyou.test.base.SetTest;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.listener.TestngRetry;
import com.aoyou.test.templates.orderservice.GetOrderPriceDetails;

/**
 * @author renwei
 * @ClassName: GetOrderPriceDetails001
 * @Description: 获取订单价格明细列表
 *
 */
public class GetOrderPriceDetails001 extends TestBase{
	
	@Test(retryAnalyzer = TestngRetry.class)
	
	public void getOrderPriceDetails001(){
			
		SetTest test = new GetOrderPriceDetails();
		test.setParams("suborderID", "1429527");
		test.sendPost();

		if(test.getStatus()==200){
			responseString = test.getResponseString();
			px.addNameSpace("a", "http://schemas.datacontract.org/2004/07/CYTS.Aoyou.Data.Order.Entity");
			px.Load(responseString);
			
			String BizID = px.getElementText("//a:BizID");
			String DetailID = px.getElementText("//a:DetailID");
			String DetailIntro = px.getElementText("//a:DetailIntro");
			String DetailName = px.getElementText("//a:DetailName");
			String DetailNum = px.getElementText("//a:DetailNum");
			String DetailPrice = px.getElementText("//a:DetailPrice");
			String DetailType = px.getElementText("//a:DetailType");
			
			checkPoint.notEqual(BizID, "");
			checkPoint.notEqual(BizID, "0");
			checkPoint.notEqual(BizID, null);
			checkPoint.notEqual(DetailID, "");
			checkPoint.notEqual(DetailID, "0");
			checkPoint.notEqual(DetailID, null);
			checkPoint.notEqual(DetailIntro, "");
			checkPoint.notEqual(DetailIntro, "0");
			checkPoint.notEqual(DetailIntro, null);
			checkPoint.notEqual(DetailName, "");
			checkPoint.notEqual(DetailName, "0");
			checkPoint.notEqual(DetailName, null);
			checkPoint.notEqual(DetailNum, "");
			checkPoint.notEqual(DetailNum, "0");
			checkPoint.notEqual(DetailNum, null);
			checkPoint.notEqual(DetailPrice, "");
			checkPoint.notEqual(DetailPrice, "0");
			checkPoint.notEqual(DetailPrice, null);
			checkPoint.notEqual(DetailType, "");
			checkPoint.notEqual(DetailType, "0");
			checkPoint.notEqual(DetailType, null);
			
		}else{checkPoint.isFaild("接口请求失败!状态码："+test.getStatus());}
		checkPoint.result("GetOrderPriceDetails获取订单价格明细列表接口正确");
	}	
	
}
