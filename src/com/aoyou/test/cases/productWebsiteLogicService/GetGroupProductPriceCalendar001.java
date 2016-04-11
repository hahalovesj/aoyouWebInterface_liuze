package com.aoyou.test.cases.productWebsiteLogicService;

import java.util.List;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.aoyou.test.base.Data;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.templates.productWebsiteLogicService.GetGroupProductPriceCalendar;
import com.aoyou.test.listener.TestngRetry;

public class GetGroupProductPriceCalendar001 extends TestBase{

	@BeforeClass  
    public void setUp(){
    	Data.currentClassName = this.getClass().getSimpleName();
    }
	
	@Test(retryAnalyzer = TestngRetry.class)
	public void getGroupProductPriceCalendar001(){
		String id = "80861";
		List<String> deparDate = null;
		test = new GetGroupProductPriceCalendar();
		test.setParams("ProductID", id);
		test.sendPost();
		if(test.getStatus()==200){
			px.addNameSpace("a", "http://schemas.datacontract.org/2004/07/CYTS.Aoyou.Product.WebsiteLogic.Entity");
			px.Load(test.getResponseString());
			deparDate = px.getElementsText("//a:PriceView/a:DepartDate");

			checkPoint.notEquals(deparDate, null);
			checkPoint.notEquals(deparDate, "");
		
		}else{checkPoint.isFaild("�ӿ�����ʧ��!״̬�룺"+test.getStatus());};
		
		checkPoint.result("Clubmed��Ʒ��"+id+" ��ȡ�۸�������Ϣ��ȷ����"+deparDate.size()+"����Ԥ������");
		
	}
}
