package com.aoyou.test.cases.bookingWebsiteLogicService;

import java.util.List;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.aoyou.test.base.Data;
import com.aoyou.test.base.SetTest;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.listener.TestngRetry;
import com.aoyou.test.templates.bookingWebsiteLogicService.HutongCardReserve;


/**
 * @author renwei
 * @ClassName: HutongCardReserve001
 * @Description:  互通卡预定接口
 *
 */
public class HutongCardReserve001 extends TestBase{
	
	@BeforeClass
    
    public void setUp(){
    	Data.currentClassName = this.getClass().getSimpleName();
    }
	
	@Test(retryAnalyzer = TestngRetry.class)
	
	public void hutongCardReserve001(){
			
		SetTest test = new HutongCardReserve();

		test.sendPost();
		
		if(test.getStatus()==200){
			responseString = test.getResponseString();
			px.addNameSpace("a", "http://schemas.datacontract.org/2004/07/CYTS.Aoyou.Booking.WebsiteLogic.Entity.Reserve");
			px.Load(responseString);
			List<String> Contact = px.getElementsText("//a:Contact");
			List<String> ContactMobile = px.getElementsText("//a:ContactMobile");
			List<String> MainOrderID = px.getElementsText("//a:MainOrderID");
			List<String> OrderID = px.getElementsText("//a:OrderID");
			List<String> OrderNo = px.getElementsText("//a:OrderNo");
			List<String> PayID = px.getElementsText("//a:PayID");
			
			checkPoint.notEquals(Contact, "");
			checkPoint.notEquals(Contact, "0");
			checkPoint.notEquals(Contact, null);
			checkPoint.notEquals(ContactMobile, "");
			checkPoint.notEquals(ContactMobile, "0");
			checkPoint.notEquals(ContactMobile, null);
			checkPoint.notEquals(MainOrderID, "");
			checkPoint.notEquals(MainOrderID, "0");
			checkPoint.notEquals(MainOrderID, null);
			checkPoint.notEquals(OrderID, "");
			checkPoint.notEquals(OrderID, "0");
			checkPoint.notEquals(OrderID, null);
			checkPoint.notEquals(OrderNo, "");
			checkPoint.notEquals(OrderNo, "0");
			checkPoint.notEquals(OrderNo, null);
			checkPoint.notEquals(PayID, "");
			checkPoint.notEquals(PayID, "0");
			checkPoint.notEquals(PayID, null);
			
		}else{checkPoint.isFaild("接口请求失败!状态码："+test.getStatus());}
		checkPoint.result("HutongCardReserve互通卡预定接口正确");
	}	
	
}
