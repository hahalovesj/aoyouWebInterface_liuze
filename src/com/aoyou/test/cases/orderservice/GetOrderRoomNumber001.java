package com.aoyou.test.cases.orderservice;

import org.testng.annotations.Test;
import com.aoyou.test.base.SetTest;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.listener.TestngRetry;
import com.aoyou.test.templates.orderservice.GetOrderRoomNumber;

/**
 * @author renwei
 * @ClassName: GetOrderRoomNumber001
 * @Description: ��ȡ�����ķ�����
 *
 */
public class GetOrderRoomNumber001 extends TestBase{
	
	@Test(retryAnalyzer = TestngRetry.class)
	
	public void getOrderRoomNumber001(){
			
		SetTest test = new GetOrderRoomNumber();
		test.setParams("suborderID", "1430191");
		test.sendPost();

		if(test.getStatus()==200){
			responseString = test.getResponseString();
			px.addNameSpace("a", "http://schemas.datacontract.org/2004/07/CYTS.Aoyou.Data.Order.Entity");
			px.Load(responseString);
			
			if(!responseString.contains("<GetOrderRoomNumberResult>1</GetOrderRoomNumberResult>")){
				checkPoint.isFaild("GetOrderRoomNumber�ӿڷ���ֵ�쳣��");
			}
			
		}
		checkPoint.result("GetOrderRoomNumber��ȡ�����ķ������ӿ���ȷ");
	}	
	
}
