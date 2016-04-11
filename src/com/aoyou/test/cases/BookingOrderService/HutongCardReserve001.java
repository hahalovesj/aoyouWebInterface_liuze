package com.aoyou.test.cases.BookingOrderService;

import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import com.aoyou.test.base.Action;
import com.aoyou.test.base.SetTest;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.listener.TestngRetry;
import com.aoyou.test.templates.BookingOrderService.HutongCardReserve;

/**
 * @author renwei
 * @ClassName: HutongCardReserve001
 * @Description:  互通卡预定和取消接口
 *
 */
public class HutongCardReserve001 extends TestBase{
	
	@Test(retryAnalyzer = TestngRetry.class)
	
	public void hutongCardReserve001() throws Exception{
		
		String MainOrderID = null;
			
		SetTest test = new HutongCardReserve();

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
			
			System.out.println(MainOrderID);
			
		}else{checkPoint.isFaild("HutongCardReserve接口请求失败!状态码："+test.getStatus());}
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 Map<String,String> map = Action.getTourDetail(MainOrderID);

		 Action.CancelOrder(map);
		checkPoint.result("HutongCardReserve互通卡预定和取消接口正确");
	}	
	
}
