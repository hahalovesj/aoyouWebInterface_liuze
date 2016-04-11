package com.aoyou.test.cases.orderservice;

import org.testng.annotations.Test;
import com.aoyou.test.base.SetTest;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.listener.TestngRetry;
import com.aoyou.test.templates.orderservice.GetOrderType;

/**
 * @author renwei
 * @ClassName: GetOrderType001
 * @Description: ��ȡ��������
 *
 */
public class GetOrderType001 extends TestBase{
	
	@Test(retryAnalyzer = TestngRetry.class)
	
	public void getOrderType001(){
			
		SetTest test = new GetOrderType();
		test.setParams("suborderID", "1429527");
		test.sendPost();

		if(test.getStatus()==200){
			responseString = test.getResponseString();
			px.addNameSpace("a", "http://schemas.datacontract.org/2004/07/CYTS.Aoyou.Data.Order.Entity");
			px.Load(responseString);
			
			if(!responseString.contains("<GetOrderTypeResult>3</GetOrderTypeResult>")){
				checkPoint.isFaild("GetOrderType�ӿڷ���ֵ�쳣��");
			}
			
		}
		checkPoint.result("GetOrderType��ȡ�������ͽӿ���ȷ");
	}	
	
}
