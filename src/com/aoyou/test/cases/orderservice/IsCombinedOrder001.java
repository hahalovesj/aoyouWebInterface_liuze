package com.aoyou.test.cases.orderservice;

import org.testng.annotations.Test;
import com.aoyou.test.base.SetTest;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.listener.TestngRetry;
import com.aoyou.test.templates.orderservice.IsCombinedOrder;

/**
 * @author renwei
 * @ClassName: IsCombinedOrder001
 * @Description: �ж϶����Ƿ�Ϊ�����ƶ���
 *
 */
public class IsCombinedOrder001 extends TestBase{
	
	@Test(retryAnalyzer = TestngRetry.class)
	
	public void isCombinedOrder001(){
			
		SetTest test = new IsCombinedOrder();
		test.setParams("suborderID", "1430191");
		test.sendPost();

		if(test.getStatus()==200){
			responseString = test.getResponseString();
			px.addNameSpace("a", "http://schemas.datacontract.org/2004/07/CYTS.Aoyou.Data.Order.Entity");
			px.Load(responseString);
			
			if(!responseString.contains("<IsCombinedOrderResult>true</IsCombinedOrderResult>")){
				checkPoint.isFaild("IsCombinedOrder�ӿڷ���ֵ�쳣��");
			}
			
		}
		checkPoint.result("IsCombinedOrder�ж϶����Ƿ�Ϊ�����ƶ����ӿ���ȷ");
	}	
	
}
