package com.aoyou.test.cases.orderservice;

import java.util.List;
import org.testng.annotations.Test;
import com.aoyou.test.base.SetTest;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.listener.TestngRetry;
import com.aoyou.test.templates.orderservice.GetSelfGuidedOrderList;

/**
 * @author renwei
 * @ClassName: GetSelfGuidedOrderList001
 * @Description: 获取aoyouERP订单列表信息，不带分页，范围：（aoyouERP自由行）
 *
 */
public class GetSelfGuidedOrderList001 extends TestBase{
	
	@Test(retryAnalyzer = TestngRetry.class)
	
	public void getSelfGuidedOrderList001(){
			
		SetTest test = new GetSelfGuidedOrderList();
		test.setParams("userID", "11266537");
		test.setParams("orderType", "1001");
		test.sendPost();

		if(test.getStatus()==200){
			responseString = test.getResponseString();
			px.addNameSpace("a", "http://schemas.datacontract.org/2004/07/CYTS.Aoyou.Data.Order.Entity");
			px.Load(responseString);
			List<String> MainOrderID = px.getElementsText("//a:MainOrderID");
			List<String> OrderName = px.getElementsText("//a:OrderName");
			List<String> OrderNO = px.getElementsText("//a:OrderNO");
			List<String> OrderMoney = px.getElementsText("//a:OrderMoney");
		
			checkPoint.notEquals(MainOrderID, "");
			checkPoint.notEquals(MainOrderID, "0");
			checkPoint.notEquals(MainOrderID, null);
			checkPoint.notEquals(OrderName, "");
			checkPoint.notEquals(OrderName, "0");
			checkPoint.notEquals(OrderName, null);
			checkPoint.notEquals(OrderNO, "");
			checkPoint.notEquals(OrderNO, "0");
			checkPoint.notEquals(OrderNO, null);
			checkPoint.notEquals(OrderMoney, "");
			checkPoint.notEquals(OrderMoney, "0");
			checkPoint.notEquals(OrderMoney, null);
		
		}else{checkPoint.isFaild("接口请求失败!状态码："+test.getStatus());}
		checkPoint.result("GetSelfGuidedOrderList001获取aoyouERP订单列表信息，不带分页，范围：（aoyouERP自由行）接口正确");
	}	
	
}
