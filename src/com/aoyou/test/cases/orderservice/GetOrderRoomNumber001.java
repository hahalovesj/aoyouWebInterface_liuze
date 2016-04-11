package com.aoyou.test.cases.orderservice;

import org.testng.annotations.Test;
import com.aoyou.test.base.SetTest;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.listener.TestngRetry;
import com.aoyou.test.templates.orderservice.GetOrderRoomNumber;

/**
 * @author renwei
 * @ClassName: GetOrderRoomNumber001
 * @Description: 获取订单的房间数
 *
 */
public class GetOrderRoomNumber001 extends TestBase{
	
	@Test(retryAnalyzer = TestngRetry.class)
	
	public void getOrderRoomNumber001(){
			
		SetTest test = new GetOrderRoomNumber();
		test.setParams("suborderID", "1430191");
		test.sendPost();

		if(test.getStatus()==200){
			responseString = test.getResponseString();
			px.addNameSpace("a", "http://schemas.datacontract.org/2004/07/CYTS.Aoyou.Data.Order.Entity");
			px.Load(responseString);
			
			if(!responseString.contains("<GetOrderRoomNumberResult>1</GetOrderRoomNumberResult>")){
				checkPoint.isFaild("GetOrderRoomNumber接口返回值异常！");
			}
			
		}
		checkPoint.result("GetOrderRoomNumber获取订单的房间数接口正确");
	}	
	
}
