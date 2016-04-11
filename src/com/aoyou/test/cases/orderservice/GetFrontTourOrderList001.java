package com.aoyou.test.cases.orderservice;

import org.testng.annotations.Test;
import com.aoyou.test.base.SetTest;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.listener.TestngRetry;
import com.aoyou.test.templates.orderservice.GetFrontTourOrderList;

/**
 * @author renwei
 * @ClassName: GetFrontTourOrderList001
 * @Description:��ȡ�û����µļ���������Ϣ��������ҳ����Χ�����۹⡢�ȼ١����֣�����Ƶ꣩
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
		
	
		}else{checkPoint.isFaild("�ӿ�����ʧ��!״̬�룺"+test.getStatus());}
		checkPoint.result("GetFrontTourOrderList��ȡ�û����µļ���������Ϣ��������ҳ����Χ�����۹⡢�ȼ١����֣�����Ƶ꣩�ӿ���ȷ");
	}	
	
}
