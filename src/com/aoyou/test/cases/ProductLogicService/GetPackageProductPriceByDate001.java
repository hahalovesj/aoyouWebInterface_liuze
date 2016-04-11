package com.aoyou.test.cases.ProductLogicService;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aoyou.test.base.Action;
import com.aoyou.test.base.Data;
import com.aoyou.test.base.InterfaceCallException;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.templates.ProductLogicService.GetPackageProductPriceByDate;
import com.aoyou.test.templates.ProductLogicService.GetPackageProductPriceList;
import com.aoyou.test.listener.TestngRetry;


public class GetPackageProductPriceByDate001 extends TestBase{

	@BeforeClass  
    public void setUp(){
    	Data.currentClassName = this.getClass().getSimpleName();
    }
	
	@Test(retryAnalyzer = TestngRetry.class)
	public void getPackageProductPriceByDate001(){
		
		String id = Action.getProductID(1, "1").get(0);
		String departDate = null;
		
		test = new GetPackageProductPriceList();
		test.setParams("ProductID", id);
		test.sendPost();
		
		if(test.getStatus()==200){
			px.addNameSpace("a", "http://schemas.datacontract.org/2004/07/CYTS.Aoyou.Product.WebsiteLogic.Entity");
			px.Load(test.getResponseString());
			departDate = px.getElementsText("//a:DepartDate").get(0);
		}else throw new InterfaceCallException("GetPackageProductPriceList�ӿ�����ʧ��!״̬�룺"+test.getStatus());
		
		test = new GetPackageProductPriceByDate();
		test.setParams("ProductID", id);
		test.setParams("DepartDate", departDate);
		test.sendPost();
		
		if(test.getStatus()==200){
			px.clearNameSpace();
			px.addNameSpace("a", "http://schemas.datacontract.org/2004/07/CYTS.Aoyou.Product.WebsiteLogic.Entity");
			px.Load(test.getResponseString());
			String showPrice = px.getElementText("//a:ShowPrice");
			checkPoint.equals((px.getElementText("//a:ProductID")), id, "���ز�Ʒid�����id����!");
			checkPoint.equals((px.getElementText("//a:DepartDate")), departDate, "���ز�Ʒ������������ڲ���!");
			checkPoint.notEquals(showPrice,"0.00","showPriceΪ0.00");
			checkPoint.notEquals(showPrice,"0","showPriceΪ0");
			checkPoint.notEquals(showPrice,"1.00","showPriceΪ1.00");
			checkPoint.notEquals(showPrice,"1","showPriceΪ1");
			checkPoint.notEquals(showPrice,null,"showPriceΪnull");		
		}else {checkPoint.isFaild("�ӿ�����ʧ��!״̬�룺"+test.getStatus());};
		
		checkPoint.result("��Ʒ��"+id+" ����"+departDate+"��ѯ�ز���Ϣȫ����ȷ��");
		
	}
}
