package com.aoyou.test.cases.BookingOrderService;

import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import com.aoyou.test.base.Action;
import com.aoyou.test.base.SetTest;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.listener.TestngRetry;
import com.aoyou.test.templates.BookingOrderService.FreeOrderReserve;

/**
 * @author renwei
 * @ClassName: FreeOrderReserve001
 * @Description:  普通自由行预定和取消接口
 *
 */
public class FreeOrderReserve001 extends TestBase{
	
	@Test(retryAnalyzer = TestngRetry.class)
	
	public void freeOrderReserve001() throws Exception{
		
		String MainOrderID = null;
			
		SetTest test = new FreeOrderReserve();

		test.sendPost();
		
		if(test.getStatus()==200){
			responseString = test.getResponseString();
			px.addNameSpace("a", "http://schemas.datacontract.org/2004/07/CYTS.Aoyou.Booking.WebsiteLogic.Entity.Reserve");
			px.Load(responseString);
			List<String> Contact = px.getElementsText("//a:Contact");
			List<String> ContactMobile = px.getElementsText("//a:ContactMobile");
			MainOrderID = px.getElementText("//a:MainOrderID");
			List<String> OrderID = px.getElementsText("//a:OrderID");
			List<String> OrderNo = px.getElementsText("//a:OrderNo");
			List<String> PayID = px.getElementsText("//a:PayID");
			List<String> ProductName = px.getElementsText("//a:ProductName");
			

			checkPoint.notEquals(Contact, "");
			checkPoint.notEquals(Contact, "0");
			checkPoint.notEquals(Contact, null);
			checkPoint.notEquals(ContactMobile, "");
			checkPoint.notEquals(ContactMobile, "0");
			checkPoint.notEquals(ContactMobile, null);
			checkPoint.notEqual(MainOrderID, "");
			checkPoint.notEqual(MainOrderID, "0");
			checkPoint.notEqual(MainOrderID, null);
			checkPoint.notEquals(OrderID, "");
			checkPoint.notEquals(OrderID, "0");
			checkPoint.notEquals(OrderID, null);
			checkPoint.notEquals(OrderNo, "");
			checkPoint.notEquals(OrderNo, "0");
			checkPoint.notEquals(OrderNo, null);
			checkPoint.notEquals(PayID, "");
			checkPoint.notEquals(PayID, "0");
			checkPoint.notEquals(PayID, null);
			checkPoint.notEquals(ProductName, "");
			checkPoint.notEquals(ProductName, "0");
			checkPoint.notEquals(ProductName, null);
			
		}else{checkPoint.isFaild("HutongCardReserve接口请求失败!状态码："+test.getStatus());}
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 Map<String,String> map = Action.getTourDetail(MainOrderID);

		 Action.CancelOrder(map);
		 
		checkPoint.result("FreeOrderReserve普通自由行预定和取消接口正确");
	}	
	
}
