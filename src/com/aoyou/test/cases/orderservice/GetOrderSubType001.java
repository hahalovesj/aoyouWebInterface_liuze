package com.aoyou.test.cases.orderservice;

import org.testng.annotations.Test;
import com.aoyou.test.base.SetTest;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.listener.TestngRetry;
import com.aoyou.test.templates.orderservice.GetOrderSubType;

/**
 * @author renwei
 * @ClassName: GetOrderSubType001
 * @Description: ��ȡ����������
 *
 */
public class GetOrderSubType001 extends TestBase{
	
	@Test(retryAnalyzer = TestngRetry.class)
	
	public void getOrderSubType001(){
			
		SetTest test = new GetOrderSubType();
		test.setParams("suborderID", "1429527");
		test.sendPost();

		if(test.getStatus()==200){
			responseString = test.getResponseString();
			px.addNameSpace("a", "http://schemas.datacontract.org/2004/07/CYTS.Aoyou.Data.Order.Entity");
			px.Load(responseString);
			
			if(!responseString.contains("<GetOrderSubTypeResult>1</GetOrderSubTypeResult>")){
				checkPoint.isFaild("GetOrderSubType�ӿڷ���ֵ�쳣��");
			}
			
		}
		checkPoint.result("GetOrderSubType��ȡ���������ͽӿ���ȷ");
	}	
	
}
