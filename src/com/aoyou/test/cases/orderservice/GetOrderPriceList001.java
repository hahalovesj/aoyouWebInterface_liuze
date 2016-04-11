package com.aoyou.test.cases.orderservice;

import org.testng.annotations.Test;
import com.aoyou.test.base.SetTest;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.listener.TestngRetry;
import com.aoyou.test.templates.orderservice.GetOrderPriceList;

/**
 * @author renwei
 * @ClassName: GetOrderPriceList001
 * @Description: 获取订单价格列表
 *
 */
public class GetOrderPriceList001 extends TestBase{
	
	@Test(retryAnalyzer = TestngRetry.class)
	
	public void getOrderPriceList001(){
			
		SetTest test = new GetOrderPriceList();
		test.setParams("suborderID", "1429527");
		test.sendPost();

		if(test.getStatus()==200){
			responseString = test.getResponseString();
			px.addNameSpace("a", "http://schemas.datacontract.org/2004/07/CYTS.Aoyou.Data.Order.Entity");
			px.Load(responseString);
			
			String PriceID = px.getElementText("//a:PriceID");
			String PriceType = px.getElementText("//a:PriceType");
			String PriceTypeText = px.getElementText("//a:PriceTypeText");
			String ReserveCount = px.getElementText("//a:ReserveCount");
			
			checkPoint.notEqual(PriceID, "");
			checkPoint.notEqual(PriceID, "0");
			checkPoint.notEqual(PriceID, null);
			checkPoint.notEqual(PriceType, "");
			checkPoint.notEqual(PriceType, "0");
			checkPoint.notEqual(PriceType, null);
			checkPoint.notEqual(PriceTypeText, "");
			checkPoint.notEqual(PriceTypeText, "0");
			checkPoint.notEqual(PriceTypeText, null);
			checkPoint.notEqual(ReserveCount, "");
			checkPoint.notEqual(ReserveCount, "0");
			checkPoint.notEqual(ReserveCount, null);
			
			
		}else{checkPoint.isFaild("接口请求失败!状态码："+test.getStatus());}
		checkPoint.result("GetOrderPriceList获取订单价格列表接口正确");
	}	
	
}
