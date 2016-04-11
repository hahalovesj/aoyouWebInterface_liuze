package com.aoyou.test.cases.bookingWebsiteLogicService;

import java.util.List;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.aoyou.test.base.Data;
import com.aoyou.test.base.SetTest;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.listener.TestngRetry;
import com.aoyou.test.templates.bookingWebsiteLogicService.VisaOrderReserve;

/**
 * @author renwei
 * @ClassName: VisaOrderReserve001
 * @Description:  签证产品预定接口
 *
 */
public class VisaOrderReserve001 extends TestBase{
	
	@BeforeClass
    
    public void setUp(){
    	Data.currentClassName = this.getClass().getSimpleName();
    }
	
	@Test(retryAnalyzer = TestngRetry.class)
	
	public void visaOrderReserve001(){
			
		SetTest test = new VisaOrderReserve();

		test.sendPost();
		
		if(test.getStatus()==200){
			responseString = test.getResponseString();
			px.addNameSpace("a", "http://schemas.datacontract.org/2004/07/CYTS.Aoyou.Booking.WebsiteLogic.Entity.Reserve");
			px.Load(responseString);
			List<String> IsCanPay = px.getElementsText("//a:IsCanPay");
			List<String> IsStockDeducted = px.getElementsText("//a:IsStockDeducted");
			List<String> MainOrderID = px.getElementsText("//a:MainOrderID");
			
			checkPoint.notEquals(IsCanPay, "");
			checkPoint.notEquals(IsCanPay, "0");
			checkPoint.notEquals(IsCanPay, null);
			checkPoint.notEquals(IsStockDeducted, "");
			checkPoint.notEquals(IsStockDeducted, "0");
			checkPoint.notEquals(IsStockDeducted, null);
			checkPoint.notEquals(MainOrderID, "");
			checkPoint.notEquals(MainOrderID, null);
			
		}else{checkPoint.isFaild("接口请求失败!状态码："+test.getStatus());}
		checkPoint.result("VisaOrderReserve签证产品预定接口正确");
	}	
	
}
