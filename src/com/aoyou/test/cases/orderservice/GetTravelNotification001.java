package com.aoyou.test.cases.orderservice;

import org.testng.annotations.Test;
import com.aoyou.test.base.SetTest;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.listener.TestngRetry;
import com.aoyou.test.templates.orderservice.GetTravelNotification;

/**
 * @author renwei
 * @ClassName: GetTravelNotification001
 * @Description: ��ȡ��������֪ͨ
 *
 */
public class GetTravelNotification001 extends TestBase{
	
	@Test(retryAnalyzer = TestngRetry.class)
	
	public void getTravelNotification001(){
			
		SetTest test = new GetTravelNotification();
		test.setParams("subOrderID", "1428078");
		test.sendPost();

		if(test.getStatus()==200){
			responseString = test.getResponseString();
			px.addNameSpace("a", "http://schemas.datacontract.org/2004/07/CYTS.Aoyou.Data.Order.Entity");
			px.Load(responseString);
			
			String IsSuccess = px.getElementText("//a:IsSuccess");
	
		checkPoint.equals(IsSuccess, "true", "GetTravelNotification�ӿڷ���ֵ�쳣!");
			
		}else{checkPoint.isFaild("�ӿ�����ʧ��!״̬�룺"+test.getStatus());}
		checkPoint.result("GetTravelNotification��ȡ��������֪ͨ�ӿ���ȷ");
	}	
	
}
