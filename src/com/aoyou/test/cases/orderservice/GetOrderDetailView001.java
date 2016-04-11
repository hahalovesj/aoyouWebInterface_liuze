package com.aoyou.test.cases.orderservice;

import org.testng.annotations.Test;
import com.aoyou.test.base.SetTest;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.listener.TestngRetry;
import com.aoyou.test.templates.orderservice.GetOrderDetailView;

/**
 * @author renwei
 * @ClassName: GetOrderDetailView001
 * @Description: 获取订单详细信息
 *
 */
public class GetOrderDetailView001 extends TestBase{
	
	@Test(retryAnalyzer = TestngRetry.class)
	
	public void getOrderDetailView001(){
			
		SetTest test = new GetOrderDetailView();
		test.setParams("mainOrderID", "1335877");
		test.sendPost();

		if(test.getStatus()==200){
			responseString = test.getResponseString();
			px.addNameSpace("a", "http://schemas.datacontract.org/2004/07/CYTS.Aoyou.Data.Order.Entity");
			px.Load(responseString);
			
			String AdultNum = px.getElementText("//a:AdultNum");
			String Contact = px.getElementText("//a:Contact");
			String Contactor = px.getElementText("//a:Contactor");
			String DepartureDate = px.getElementText("//a:DepartureDate");
			String MainOrderNO = px.getElementText("//a:MainOrderNO");
			String ProductID = px.getElementText("//a:ProductID");
			String ProductName = px.getElementText("//a:ProductName");
			
			checkPoint.notEqual(AdultNum, "");
			checkPoint.notEqual(AdultNum, "0");
			checkPoint.notEqual(AdultNum, null);
			checkPoint.notEqual(Contact, "");
			checkPoint.notEqual(Contact, "0");
			checkPoint.notEqual(Contact, null);
			checkPoint.notEqual(Contactor, "");
			checkPoint.notEqual(Contactor, "0");
			checkPoint.notEqual(Contactor, null);
			checkPoint.notEqual(DepartureDate, "");
			checkPoint.notEqual(DepartureDate, "0");
			checkPoint.notEqual(DepartureDate, null);
			checkPoint.notEqual(MainOrderNO, "");
			checkPoint.notEqual(MainOrderNO, "0");
			checkPoint.notEqual(MainOrderNO, null);
			checkPoint.notEqual(ProductID, "");
			checkPoint.notEqual(ProductID, "0");
			checkPoint.notEqual(ProductID, null);
			checkPoint.notEqual(ProductName, "");
			checkPoint.notEqual(ProductName, "0");
			checkPoint.notEqual(ProductName, null);
			
		}else{checkPoint.isFaild("接口请求失败!状态码："+test.getStatus());}
		checkPoint.result("GetOrderDetailView获取订单详细信息接口正确");
	}	
	
}
