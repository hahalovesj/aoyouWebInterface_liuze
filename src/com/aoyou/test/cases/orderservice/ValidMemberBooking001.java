package com.aoyou.test.cases.orderservice;

import org.testng.annotations.Test;
import com.aoyou.test.base.SetTest;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.listener.TestngRetry;
import com.aoyou.test.templates.orderservice.ValidMemberBooking;

/**
 * @author renwei
 * @ClassName: ValidMemberBooking001
 * @Description: 判断订单是否属于某会员
 *
 */
public class ValidMemberBooking001 extends TestBase{
	
	@Test(retryAnalyzer = TestngRetry.class)
	
	public void validMemberBooking001(){
			
		SetTest test = new ValidMemberBooking();
		test.setParams("memberID", "11266537");
		test.setParams("mainOrderID", "1341446");
		test.sendPost();

		if(test.getStatus()==200){
			responseString = test.getResponseString();
			px.addNameSpace("a", "http://schemas.datacontract.org/2004/07/CYTS.Aoyou.Data.Order.Entity");
			px.Load(responseString);
			if(!responseString.contains("<ValidMemberBookingResult>true</ValidMemberBookingResult>")){
				checkPoint.isFaild("ValidMemberBooking接口返回结果不正确");
			}  
		
		}else{checkPoint.isFaild("接口请求失败!状态码："+test.getStatus());}
		checkPoint.result("ValidMemberBooking判断订单是否属于某会员接口正确");
	}	
	
}
