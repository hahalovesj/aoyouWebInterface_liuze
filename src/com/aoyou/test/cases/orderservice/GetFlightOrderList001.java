package com.aoyou.test.cases.orderservice;

import java.util.List;
import org.testng.annotations.Test;
import com.aoyou.test.base.SetTest;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.listener.TestngRetry;
import com.aoyou.test.templates.orderservice.GetFlightOrderList;

/**
 * @author renwei
 * @ClassName: GetFlightOrderList001
 * @Description: 分页获取机票订单列表
 *
 */
public class GetFlightOrderList001 extends TestBase{
	
	@Test(retryAnalyzer = TestngRetry.class)
	
	public void getFlightOrderList001(){
			
		SetTest test = new GetFlightOrderList();
		test.setParams("MemberID", "11266537");
		test.setParams("PageIndex", "1");
		test.setParams("PageCount","10");
		test.sendPost();

		if(test.getStatus()==200){
			responseString = test.getResponseString();
			px.addNameSpace("a", "http://schemas.datacontract.org/2004/07/CYTS.Aoyou.Data.Order.Entity");
			px.Load(responseString);
			List<String> MainOrderID = px.getElementsText("//a:MainOrderID");
			List<String> OrderName = px.getElementsText("//a:OrderName");
			List<String> OrderNO = px.getElementsText("//a:OrderNO");
			List<String> SubOrderID = px.getElementsText("//a:SubOrderID");
			List<String> TicketStatus = px.getElementsText("//a:TicketStatus");
			List<String> TimeLimit = px.getElementsText("//a:TimeLimit");
			
			
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
			checkPoint.notEquals(TicketStatus, "");
			checkPoint.notEquals(TicketStatus, "0");
			checkPoint.notEquals(TicketStatus, null);
			checkPoint.notEquals(TimeLimit, "");
			checkPoint.notEquals(TimeLimit, "0");
			checkPoint.notEquals(TimeLimit, null);
						
		}else{checkPoint.isFaild("接口请求失败!状态码："+test.getStatus());}
		checkPoint.result("GetFlightOrderList分页获取机票订单列表接口正确");
	}	
	
}
