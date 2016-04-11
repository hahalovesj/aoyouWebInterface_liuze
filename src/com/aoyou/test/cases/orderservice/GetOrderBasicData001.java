package com.aoyou.test.cases.orderservice;

import org.testng.annotations.Test;
import com.aoyou.test.base.SetTest;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.listener.TestngRetry;
import com.aoyou.test.templates.orderservice.GetOrderBasicData;

/**
 * @author renwei
 * @ClassName: GetOrderBasicData001
 * @Description: 获取订单基本信息
 *
 */
public class GetOrderBasicData001 extends TestBase{
	
	@Test(retryAnalyzer = TestngRetry.class)
	
	public void getOrderBasicData001(){
			
		SetTest test = new GetOrderBasicData();
		test.setParams("subOrderID", "1429527");
		test.sendPost();

		if(test.getStatus()==200){
			responseString = test.getResponseString();
			px.addNameSpace("a", "http://schemas.datacontract.org/2004/07/CYTS.Aoyou.Data.Order.Entity");
			px.Load(responseString);
			
			String AdultCount = px.getElementText("//a:AdultCount");
			String Contact = px.getElementText("//a:Contact");
			String ContactEmail = px.getElementText("//a:ContactEmail");
			String ContactMobile = px.getElementText("//a:ContactMobile");
			String CustomerID = px.getElementText("//a:CustomerID");
			String DepartDate = px.getElementText("//a:DepartDate");
			String OrderID = px.getElementText("//a:OrderID");
			String MainOrderID = px.getElementText("//a:MainOrderID");
			String OrderNO = px.getElementText("//a:OrderNO");
			String OrderName = px.getElementText("//a:OrderName");
			String ProductID = px.getElementText("//a:ProductID");

			checkPoint.notEqual(AdultCount, "");
			checkPoint.notEqual(AdultCount, "0");
			checkPoint.notEqual(AdultCount, null);
			checkPoint.notEqual(Contact, "");
			checkPoint.notEqual(Contact, "0");
			checkPoint.notEqual(Contact, null);
			checkPoint.notEqual(ContactEmail, "");
			checkPoint.notEqual(ContactEmail, "0");
			checkPoint.notEqual(ContactEmail, null);
			checkPoint.notEqual(ContactMobile, "");
			checkPoint.notEqual(ContactMobile, "0");
			checkPoint.notEqual(ContactMobile, null);
			checkPoint.notEqual(CustomerID, "");
			checkPoint.notEqual(CustomerID, "0");
			checkPoint.notEqual(CustomerID, null);
			checkPoint.notEqual(DepartDate, "");
			checkPoint.notEqual(DepartDate, "0");
			checkPoint.notEqual(DepartDate, null);
			checkPoint.notEqual(OrderID, "");
			checkPoint.notEqual(OrderID, "0");
			checkPoint.notEqual(OrderID, null);
			checkPoint.notEqual(OrderName, "");
			checkPoint.notEqual(OrderName, "0");
			checkPoint.notEqual(OrderName, null);
			checkPoint.notEqual(MainOrderID, "");
			checkPoint.notEqual(MainOrderID, "0");
			checkPoint.notEqual(MainOrderID, null);
			checkPoint.notEqual(OrderNO, "");
			checkPoint.notEqual(OrderNO, "0");
			checkPoint.notEqual(OrderNO, null);
			checkPoint.notEqual(ProductID, "");
			checkPoint.notEqual(ProductID, "0");
			checkPoint.notEqual(ProductID, null);
			
		}else{checkPoint.isFaild("接口请求失败!状态码："+test.getStatus());}
		checkPoint.result("GetOrderBasicData获取订单基本信息接口正确");
	}	
	
}
