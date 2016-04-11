package com.aoyou.test.cases.orderservice;

import org.testng.annotations.Test;
import com.aoyou.test.base.SetTest;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.listener.TestngRetry;
import com.aoyou.test.templates.orderservice.GetTravelNotification;

/**
 * @author renwei
 * @ClassName: GetTravelNotification001
 * @Description: 获取订单出团通知
 *
 */
public class GetTravelNotification001 extends TestBase{
	
	@Test(retryAnalyzer = TestngRetry.class)
	
	public void getTravelNotification001(){
			
		SetTest test = new GetTravelNotification();
		test.setParams("subOrderID", "1428078");
		test.sendPost();

		if(test.getStatus()==200){
			responseString = test.getResponseString();
			px.addNameSpace("a", "http://schemas.datacontract.org/2004/07/CYTS.Aoyou.Data.Order.Entity");
			px.Load(responseString);
			
			String IsSuccess = px.getElementText("//a:IsSuccess");
	
		checkPoint.equals(IsSuccess, "true", "GetTravelNotification接口返回值异常!");
			
		}else{checkPoint.isFaild("接口请求失败!状态码："+test.getStatus());}
		checkPoint.result("GetTravelNotification获取订单出团通知接口正确");
	}	
	
}
