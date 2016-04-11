package com.aoyou.test.cases.orderservice;

import org.testng.annotations.Test;
import com.aoyou.test.base.SetTest;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.listener.TestngRetry;
import com.aoyou.test.templates.orderservice.GetGroupOrderFeeDetail;

/**
 * @author renwei
 * @ClassName: GetGroupOrderFeeDetail001
 * @Description: 获取参团产品订单价格列表
 *
 */
public class GetGroupOrderFeeDetail001 extends TestBase{
	
	@Test(retryAnalyzer = TestngRetry.class)
	
	public void getGroupOrderFeeDetail001(){
			
		SetTest test = new GetGroupOrderFeeDetail();
		test.setParams("subOrderID", "1429527");
		test.sendPost();

		if(test.getStatus()==200){
			responseString = test.getResponseString();
			px.addNameSpace("a", "http://schemas.datacontract.org/2004/07/CYTS.Aoyou.Data.Order.Entity");
			px.Load(responseString);
			
			String BizID = px.getElementText("//a:BizID");
			String BizName = px.getElementText("//a:BizName");
			String Num = px.getElementText("//a:Num");
			String Price = px.getElementText("//a:Price");
			String Remark = px.getElementText("//a:Remark");
			
			checkPoint.notEqual(BizID, "");
			checkPoint.notEqual(BizID, "0");
			checkPoint.notEqual(BizID, null);
			checkPoint.notEqual(BizName, "");
			checkPoint.notEqual(BizName, "0");
			checkPoint.notEqual(BizName, null);
			checkPoint.notEqual(Num, "");
			checkPoint.notEqual(Num, "0");
			checkPoint.notEqual(Num, null);
			checkPoint.notEqual(Price, "");
			checkPoint.notEqual(Price, "0");
			checkPoint.notEqual(Price, "1");
			checkPoint.notEqual(Price, null);
			checkPoint.notEqual(Remark, "");
			checkPoint.notEqual(Remark, "0");
			checkPoint.notEqual(Remark, null);
			
		}else{checkPoint.isFaild("接口请求失败!状态码："+test.getStatus());}
		checkPoint.result("GetGroupOrderFeeDetail获取参团产品订单价格列表接口正确");
	}	
	
}
