package com.aoyou.test.cases.orderservice;

import org.testng.annotations.Test;
import com.aoyou.test.base.SetTest;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.listener.TestngRetry;
import com.aoyou.test.templates.orderservice.GetFrontTourOrderList;

/**
 * @author renwei
 * @ClassName: GetFrontTourOrderList001
 * @Description:获取用户最新的几条订单信息，不带分页，范围：（观光、度假、邮轮，单项、酒店）
 *
 */
public class GetFrontTourOrderList001 extends TestBase{
	
	@Test(retryAnalyzer = TestngRetry.class)
	
	public void getFrontTourOrderList001(){
			
		SetTest test = new GetFrontTourOrderList();
		test.setParams("MemberID", "11266537");
		test.setParams("PageCount", "5");
		test.setParams("OrderType", "3");
		test.sendPost();

		if(test.getStatus()==200){
			responseString = test.getResponseString();
			px.addNameSpace("a", "http://schemas.datacontract.org/2004/07/CYTS.Aoyou.Data.Order.Entity");
			px.Load(responseString);
			System.out.println(responseString);
//			List<String> MainOrderID = px.getElementsText("//a:MainOrderID");
//			List<String> OrderName = px.getElementsText("//a:OrderName");
//			List<String> OrderNO = px.getElementsText("//a:OrderNO");
//			List<String> SubOrderID = px.getElementsText("//a:SubOrderID");
//		
//			checkPoint.notEquals(MainOrderID, "");
//			checkPoint.notEquals(MainOrderID, "0");
//			checkPoint.notEquals(MainOrderID, null);
//			checkPoint.notEquals(OrderName, "");
//			checkPoint.notEquals(OrderName, "0");
//			checkPoint.notEquals(OrderName, null);
//			checkPoint.notEquals(OrderNO, "");
//			checkPoint.notEquals(OrderNO, "0");
//			checkPoint.notEquals(OrderNO, null);
//			checkPoint.notEquals(SubOrderID, "");
//			checkPoint.notEquals(SubOrderID, "0");
//			checkPoint.notEquals(SubOrderID, null);
		
	
		}else{checkPoint.isFaild("接口请求失败!状态码："+test.getStatus());}
		checkPoint.result("GetFrontTourOrderList获取用户最新的几条订单信息，不带分页，范围：（观光、度假、邮轮，单项、酒店）接口正确");
	}	
	
}
