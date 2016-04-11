package com.aoyou.test.cases.BookingOrderService;

import java.util.List;
import java.util.Map;
import org.testng.annotations.Test;
import com.aoyou.test.base.Action;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.listener.TestngRetry;
import com.aoyou.test.templates.BookingOrderService.VisaOrderReserve;

/**
 * @author renwei
 * @ClassName: VisaOrderReserve001
 * @Description:  签证产品预定和取消接口
 *
 */
public class VisaOrderReserve001 extends TestBase{
	
	@Test(retryAnalyzer = TestngRetry.class)
	
	public void visaOrderReserve001() throws Exception{
			
		String MainOrderID = null;
		
		test = new VisaOrderReserve();

		test.sendPost();
		
		if(test.getStatus()==200){
			responseString = test.getResponseString();
			px.addNameSpace("a", "http://schemas.datacontract.org/2004/07/CYTS.Aoyou.Booking.WebsiteLogic.Entity.Reserve");
			px.Load(responseString);
			List<String> IsCanPay = px.getElementsText("//a:IsCanPay");
			List<String> IsStockDeducted = px.getElementsText("//a:IsStockDeducted");
		    MainOrderID = px.getElementText("//a:MainOrderID");

			checkPoint.notEquals(IsCanPay, "");
			checkPoint.notEquals(IsCanPay, "0");
			checkPoint.notEquals(IsCanPay, null);
			checkPoint.notEquals(IsStockDeducted, "");
			checkPoint.notEquals(IsStockDeducted, "0");
			checkPoint.notEquals(IsStockDeducted, null);
			checkPoint.notEqual(MainOrderID, "");
			checkPoint.notEqual(MainOrderID, null);

//			
		}else{checkPoint.isFaild("VisaOrderReserve接口请求失败!状态码："+test.getStatus());}
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 Map<String,String> map = Action.getTourDetail(MainOrderID);

		 Action.CancelOrder(map);
		
        checkPoint.result("VisaOrderReserve签证产品预定和取消接口正确");
	}	
	
}
