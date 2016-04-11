package com.aoyou.test.cases.ProductLogicService;

import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aoyou.test.base.Action;
import com.aoyou.test.base.Data;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.templates.ProductLogicService.GetPackageProductForReserve;
import com.aoyou.test.listener.TestngRetry;

public class GetPackageProductForReserve001 extends TestBase{

	@BeforeClass  
    public void setUp(){
    	Data.currentClassName = this.getClass().getSimpleName();
    }
	
	@Test(retryAnalyzer = TestngRetry.class)
	public void getPackageProductForReserve001(){
		
		String id = Action.getProductID(1, "1").get(0);
		test = new GetPackageProductForReserve();
		test.setParams("ProductID", id);
		test.sendPost();
		if(test.getStatus()==200){
			px.addNameSpace("a", "http://schemas.datacontract.org/2004/07/CYTS.Aoyou.Product.WebsiteLogic.Entity");
			px.Load(test.getResponseString());
			List<String> proDesc = px.getElementsText("//a:Desc");
			List<String> hotelDesc = px.getElementsText("//a:HotelDesc");
			checkPoint.equals((px.getElementText("//a:ProductID")), id, "���ز�Ʒid�����id����!");
			checkPoint.notEquals(proDesc, null);
			checkPoint.notEquals(proDesc, "");
			checkPoint.notEquals(hotelDesc, null);
			checkPoint.notEquals(hotelDesc, "");
		}else{checkPoint.isFaild("�ӿ�����ʧ��!״̬�룺"+test.getStatus());};
		
		checkPoint.result("��Ʒ��"+id+" ��ѯԤ����ϸ��Ϣ�ز���ȷ��");
	}

}
