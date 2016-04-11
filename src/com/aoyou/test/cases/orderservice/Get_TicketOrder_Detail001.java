package com.aoyou.test.cases.orderservice;

import java.util.List;
import org.testng.annotations.Test;
import com.aoyou.test.base.SetTest;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.listener.TestngRetry;
import com.aoyou.test.templates.orderservice.Get_TicketOrder_Detail;

/**
 * @author renwei
 * @ClassName: Get_TicketOrder_Detail001
 * @Description: 查询门票订单详情
 *
 */
public class Get_TicketOrder_Detail001 extends TestBase{
	
	@Test(retryAnalyzer = TestngRetry.class)
	
	public void get_TicketOrder_Detail001(){
			
		SetTest test = new Get_TicketOrder_Detail();
		test.setParams("MainOrderID", "1335877");
		test.setParams("NotNeedPassagers", "false");
		test.setParams("OrderNo", "011512075959");
		test.setParams("SubOrderID", "1422512");
		test.sendPost();

		if(test.getStatus()==200){
			responseString = test.getResponseString();
			px.addNameSpace("a", "http://schemas.datacontract.org/2004/07/CYTS.Aoyou.Data.Order.Entity");
			px.Load(responseString);
			List<String> MainOrderID = px.getElementsText("//a:MainOrderID");
			List<String> OrderName = px.getElementsText("//a:OrderName");
			List<String> OrderNO = px.getElementsText("//a:OrderNO");
			List<String> SubOrderID = px.getElementsText("//a:SubOrderID");
			List<String> BookingRestriction = px.getElementsText("//a:BookingRestriction");
			List<String> ChangePolicy = px.getElementsText("//a:ChangePolicy");
			List<String> ContactPerson = px.getElementsText("//a:ContactPerson");
			List<String> ContactPhone = px.getElementsText("//a:ContactPhone");
			List<String> ConvertInfo = px.getElementsText("//a:ConvertInfo");
			List<String> CustomerID = px.getElementsText("//a:CustomerID");
			List<String> FeeInfo = px.getElementsText("//a:FeeInfo");
			List<String> IDCardType = px.getElementsText("//a:IDCardType");
			List<String> Name = px.getElementsText("//a:Name");
			List<String> Phone = px.getElementsText("//a:Phone");
			List<String> ProductName = px.getElementsText("//a:ProductName");
					
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
			checkPoint.notEquals(BookingRestriction, "");
			checkPoint.notEquals(BookingRestriction, "0");
			checkPoint.notEquals(BookingRestriction, null);
			checkPoint.notEquals(ChangePolicy, "");
			checkPoint.notEquals(ChangePolicy, "0");
			checkPoint.notEquals(ChangePolicy, null);
			checkPoint.notEquals(ContactPerson, "");
			checkPoint.notEquals(ContactPerson, "0");
			checkPoint.notEquals(ContactPerson, null);
			checkPoint.notEquals(ContactPhone, "");
			checkPoint.notEquals(ContactPhone, "0");
			checkPoint.notEquals(ContactPhone, null);
			checkPoint.notEquals(ConvertInfo, "");
			checkPoint.notEquals(ConvertInfo, "0");
			checkPoint.notEquals(ConvertInfo, null);
			checkPoint.notEquals(CustomerID, "");
			checkPoint.notEquals(CustomerID, "0");
			checkPoint.notEquals(CustomerID, null);
			checkPoint.notEquals(FeeInfo, "");
			checkPoint.notEquals(FeeInfo, "0");
			checkPoint.notEquals(FeeInfo, null);
			checkPoint.notEquals(IDCardType, "");
			checkPoint.notEquals(IDCardType, "0");
			checkPoint.notEquals(IDCardType, null);
			checkPoint.notEquals(Name, "");
			checkPoint.notEquals(Name, "0");
			checkPoint.notEquals(Name, null);
			checkPoint.notEquals(Phone, "");
			checkPoint.notEquals(Phone, "0");
			checkPoint.notEquals(Phone, null);
			checkPoint.notEquals(ProductName, "");
			checkPoint.notEquals(ProductName, "0");
			checkPoint.notEquals(ProductName, null);
	
		}else{checkPoint.isFaild("接口请求失败!状态码："+test.getStatus());}
		checkPoint.result("Get_TicketOrder_Detail查询门票订单详情接口正确");
	}	
	
}
