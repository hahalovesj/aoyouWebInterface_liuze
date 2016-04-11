package com.aoyou.test.cases.orderservice;

import java.util.List;
import org.testng.annotations.Test;
import com.aoyou.test.base.SetTest;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.listener.TestngRetry;
import com.aoyou.test.templates.orderservice.Get_TouristOrder_Detail;

/**
 * @author renwei
 * @ClassName: Get_TouristOrder_Detail001
 * @Description: 查询旅游订单详情
 *
 */
public class Get_TouristOrder_Detail001 extends TestBase{
	
	@Test(retryAnalyzer = TestngRetry.class)
	
	public void get_TouristOrder_Detail001(){
			
		SetTest test = new Get_TouristOrder_Detail();
		test.setParams("MainOrderID", "1333377");
		test.setParams("MemberID", "11266537");
		test.sendPost();

		if(test.getStatus()==200){
			responseString = test.getResponseString();
			px.addNameSpace("a", "http://schemas.datacontract.org/2004/07/CYTS.Aoyou.Data.Order.Entity");
			px.Load(responseString);
			List<String> MainOrderID = px.getElementsText("//a:MainOrderID");
			List<String> OrderName = px.getElementsText("//a:OrderName");
			List<String> OrderNO = px.getElementsText("//a:OrderNO");
			List<String> SubOrderID = px.getElementsText("//a:SubOrderID");
			List<String> CustomerID = px.getElementsText("//a:CustomerID");
			List<String> CustomerName = px.getElementsText("//a:CustomerName");
			List<String> Email = px.getElementsText("//a:Email");
			List<String> Mobile = px.getElementsText("//a:Mobile");
			
			checkPoint.notEquals(MainOrderID, "");
			checkPoint.notEquals(MainOrderID, "0");
			checkPoint.notEquals(MainOrderID, null);
			checkPoint.notEquals(OrderName, "");
			checkPoint.notEquals(OrderName, "0");
			checkPoint.notEquals(OrderName, null);
			checkPoint.notEquals(OrderNO, "");
			checkPoint.notEquals(OrderNO, "0");
			checkPoint.notEquals(OrderNO, null);
			checkPoint.notEquals(SubOrderID, "");
			checkPoint.notEquals(SubOrderID, "0");
			checkPoint.notEquals(SubOrderID, null);
			checkPoint.notEquals(CustomerID, "");
			checkPoint.notEquals(CustomerID, "0");
			checkPoint.notEquals(CustomerID, null);
			checkPoint.notEquals(CustomerName, "");
			checkPoint.notEquals(CustomerName, "0");
			checkPoint.notEquals(CustomerName, null);
			checkPoint.notEquals(Email, "");
			checkPoint.notEquals(Email, "0");
			checkPoint.notEquals(Email, null);
			checkPoint.notEquals(Mobile, "");
			checkPoint.notEquals(Mobile, "0");
			checkPoint.notEquals(Mobile, null);
		
		}else{checkPoint.isFaild("接口请求失败!状态码："+test.getStatus());}
		checkPoint.result("Get_TouristOrder_Detail查询旅游订单详情接口正确");
	}	
	
}
