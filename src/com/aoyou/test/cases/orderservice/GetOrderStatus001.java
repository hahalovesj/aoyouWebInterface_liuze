package com.aoyou.test.cases.orderservice;

import org.testng.annotations.Test;
import com.aoyou.test.base.SetTest;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.listener.TestngRetry;
import com.aoyou.test.templates.orderservice.GetOrderStatus;

/**
 * @author renwei
 * @ClassName: GetOrderStatus001
 * @Description: ��ȡ����״̬��Ϣ
 *
 */
public class GetOrderStatus001 extends TestBase{
	
	@Test(retryAnalyzer = TestngRetry.class)
	
	public void getOrderStatus001(){
			
		SetTest test = new GetOrderStatus();
		test.setParams("subOrderID", "1429527");
		test.sendPost();

		if(test.getStatus()==200){
			responseString = test.getResponseString();
			px.addNameSpace("a", "http://schemas.datacontract.org/2004/07/CYTS.Aoyou.Data.Order.Entity");
			px.Load(responseString);
			
			if(!responseString.contains("<GetOrderStatusResult>19</GetOrderStatusResult>")){
				checkPoint.isFaild("GetOrderStatus�ӿڷ���ֵ�쳣��");
			}
			
		}
		checkPoint.result("GetOrderStatus��ȡ����״̬��Ϣ�ӿ���ȷ");
	}	
	
}
