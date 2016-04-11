package com.aoyou.test.cases.orderservice;

import java.util.List;
import org.testng.annotations.Test;
import com.aoyou.test.base.SetTest;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.listener.TestngRetry;
import com.aoyou.test.templates.orderservice.Get_FlightOrder_Detail;

/**
 * @author renwei
 * @ClassName: Get_FlightOrder_Detail001
 * @Description: 查询机票订单详情
 *
 */
public class Get_FlightOrder_Detail001 extends TestBase{
	
	@Test(retryAnalyzer = TestngRetry.class)
	
	public void get_FlightOrder_Detail001(){
			
		SetTest test = new Get_FlightOrder_Detail();
		test.setParams("SubOrderID", "1390401");
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
			List<String> AdultAmount = px.getElementsText("//a:AdultAmount");
			List<String> ContactName = px.getElementsText("//a:ContactName");
			List<String> ContactTel = px.getElementsText("//a:ContactTel");
			List<String> AirLineCode = px.getElementsText("//a:AirLineCode");
			List<String> AirLineName = px.getElementsText("//a:AirLineName");
			List<String> AirLineShortName = px.getElementsText("//a:AirLineShortName");
			List<String> DepartAirportTerm = px.getElementsText("//a:DepartAirportTerm");
			List<String> DepartCityName = px.getElementsText("//a:DepartCityName");
			List<String> DepartPortName = px.getElementsText("//a:DepartPortName");
					
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
			checkPoint.notEquals(AdultAmount, "");
			checkPoint.notEquals(AdultAmount, "0");
			checkPoint.notEquals(AdultAmount, null);
			checkPoint.notEquals(ContactName, "");
			checkPoint.notEquals(ContactName, "0");
			checkPoint.notEquals(ContactName, null);
			checkPoint.notEquals(ContactTel, "");
			checkPoint.notEquals(ContactTel, "0");
			checkPoint.notEquals(ContactTel, null);
			checkPoint.notEquals(AirLineCode, "");
			checkPoint.notEquals(AirLineCode, "0");
			checkPoint.notEquals(AirLineCode, null);
			checkPoint.notEquals(AirLineName, "");
			checkPoint.notEquals(AirLineName, "0");
			checkPoint.notEquals(AirLineName, null);
			checkPoint.notEquals(AirLineShortName, "");
			checkPoint.notEquals(AirLineShortName, "0");
			checkPoint.notEquals(AirLineShortName, null);
			checkPoint.notEquals(DepartAirportTerm, "");
			checkPoint.notEquals(DepartAirportTerm, "0");
			checkPoint.notEquals(DepartAirportTerm, null);
			checkPoint.notEquals(DepartCityName, "");
			checkPoint.notEquals(DepartCityName, "0");
			checkPoint.notEquals(DepartCityName, null);
			checkPoint.notEquals(DepartPortName, "");
			checkPoint.notEquals(DepartPortName, "0");
			checkPoint.notEquals(DepartPortName, null);
	
		}else{checkPoint.isFaild("接口请求失败!状态码："+test.getStatus());}
		checkPoint.result("Get_FlightOrder_Detail查询机票订单详情接口正确");
	}	
	
}
