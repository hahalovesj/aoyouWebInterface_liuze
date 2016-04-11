package com.aoyou.test.cases.ProductLogicService;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aoyou.test.base.Action;
import com.aoyou.test.base.Data;
import com.aoyou.test.base.InterfaceCallException;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.templates.ProductLogicService.GetCombinedProductPriceList;
import com.aoyou.test.templates.ProductLogicService.GetHotelStaySolutionViewList;
import com.aoyou.test.listener.TestngRetry;

public class GetHotelStaySolutionViewList001 extends TestBase{

	@BeforeClass  
    public void setUp(){
    	Data.currentClassName = this.getClass().getSimpleName();
    }
	
	@Test(retryAnalyzer = TestngRetry.class)
	public void getHotelStaySolutionViewList001(){
		
		String id = Action.getPackageProductID(1);
		String departDate = null;
		String hotelPrice = null;
		test = new GetCombinedProductPriceList();
		test.setParams("ProductID", id);
		test.sendPost();
		
		if(test.getStatus()==200){
			px.addNameSpace("a", "http://schemas.datacontract.org/2004/07/CYTS.Aoyou.Product.WebsiteLogic.Entity");
			px.Load(test.getResponseString());
			departDate = px.getElementsText("//a:DepartDate").get(0);
		
		}else throw new InterfaceCallException("GetCombinedProductPriceList�ӿ�����ʧ��!״̬�룺"+test.getStatus());
		
		test = new GetHotelStaySolutionViewList();
		test.setParams("ProductID", id);
		test.setParams("DepartDate", departDate);
		test.sendPost();
		
		if(test.getStatus()==200){
			px.clearNameSpace();
			px.addNameSpace("a", "http://schemas.datacontract.org/2004/07/CYTS.Aoyou.Product.WebsiteLogic.Entity");
			px.addNameSpace("b", "http://schemas.microsoft.com/2003/10/Serialization/Arrays");
			px.Load(test.getResponseString());
			
			hotelPrice = px.getElementText("//a:HotelPrice");
			
			checkPoint.notEquals(hotelPrice,"0.00","�۸�Ϊ0.00");
			checkPoint.notEquals(hotelPrice,"0","�۸�Ϊ0");
			checkPoint.notEquals(hotelPrice,"1.00","�۸�Ϊ1.00");
			checkPoint.notEquals(hotelPrice,"1","�۸�Ϊ1");
			checkPoint.notEquals(hotelPrice,null,"�۸�Ϊ��");
		
		}else {checkPoint.isFaild("�ӿ�����ʧ��!״̬�룺"+test.getStatus());};
		
		checkPoint.result("��Ʒ��"+id+"�ļ۸�������");
		
	}
}
