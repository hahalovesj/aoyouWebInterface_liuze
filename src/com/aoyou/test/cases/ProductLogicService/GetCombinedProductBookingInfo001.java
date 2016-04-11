package com.aoyou.test.cases.ProductLogicService;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aoyou.test.base.Action;
import com.aoyou.test.base.Data;
import com.aoyou.test.base.InterfaceCallException;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.templates.ProductLogicService.GetCombinedProductBookingInfo;
import com.aoyou.test.templates.ProductLogicService.GetCombinedProductPriceList;
import com.aoyou.test.listener.TestngRetry;

public class GetCombinedProductBookingInfo001 extends TestBase{

	@BeforeClass  
    public void setUp(){
    	Data.currentClassName = this.getClass().getSimpleName();
    }
	
	@Test(retryAnalyzer = TestngRetry.class)
	public void getCombinedProductBookingInfo001(){
		
		String id = Action.getPackageProductID(1);
		String departDate = null;
		List<String> departDateList = new ArrayList<String>();
		List<String> dateTime = new ArrayList<String>();
		
		test = new GetCombinedProductPriceList();
		test.setParams("ProductID", id);
		test.sendPost();
		
		if(test.getStatus()==200){
			px.addNameSpace("a", "http://schemas.datacontract.org/2004/07/CYTS.Aoyou.Product.WebsiteLogic.Entity");
			px.Load(test.getResponseString());
			departDate = px.getElementsText("//a:DepartDate").get(0);
			departDateList = px.getElementsText("//a:DepartDate");
		}else throw new InterfaceCallException("GetCombinedProductPriceList�ӿ�����ʧ��!״̬�룺"+test.getStatus());
		
		test = new GetCombinedProductBookingInfo();
		test.setParams("ProductID", id);
		test.setParams("DepartDate", departDate);
		test.sendPost();
		
		if(test.getStatus()==200){
			px.clearNameSpace();
			px.addNameSpace("a", "http://schemas.datacontract.org/2004/07/CYTS.Aoyou.Product.WebsiteLogic.Entity");
			px.addNameSpace("b", "http://schemas.microsoft.com/2003/10/Serialization/Arrays");
			px.Load(test.getResponseString());
			dateTime = px.getElementsText("//b:dateTime");
			
			checkPoint.equals(dateTime, departDateList, "���صĳ���������ʵ�ʳ������ڲ�����");
		
		}else {checkPoint.isFaild("�ӿ�����ʧ��!״̬�룺"+test.getStatus());};
		
		checkPoint.result("��Ʒ��"+id+" ����"+departDate+"��ѯ�ز���Ϣȫ����ȷ��");
		
	}
}
