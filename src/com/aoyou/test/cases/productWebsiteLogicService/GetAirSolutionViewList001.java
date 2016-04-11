package com.aoyou.test.cases.productWebsiteLogicService;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aoyou.test.base.Action;
import com.aoyou.test.base.Data;
import com.aoyou.test.base.InterfaceCallException;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.listener.TestngRetry;
import com.aoyou.test.templates.productWebsiteLogicService.GetAirSolutionViewList;
import com.aoyou.test.templates.productWebsiteLogicService.GetCombinedProductPriceList;


public class GetAirSolutionViewList001 extends TestBase{

	@BeforeClass  
    public void setUp(){
    	Data.currentClassName = this.getClass().getSimpleName();
    }
	
	@Test(retryAnalyzer = TestngRetry.class)
	public void getAirSolutionViewList001(){
		
		String id = Action.getPackageProductID(1);
		String departDate = null;
		
		test = new GetCombinedProductPriceList();
		test.setParams("ProductID", id);
		test.sendPost();
		
		if(test.getStatus()==200){
			px.addNameSpace("a", "http://schemas.datacontract.org/2004/07/CYTS.Aoyou.Product.WebsiteLogic.Entity");
			px.Load(test.getResponseString());
			departDate = px.getElementsText("//a:DepartDate").get(0);
		}else throw new InterfaceCallException("GetCombinedProductPriceList�ӿ�����ʧ��!״̬�룺"+test.getStatus());
		
		test = new GetAirSolutionViewList();
		test.setParams("ProductID", id);
		test.setParams("DepartDate", departDate);
		test.sendPost();
		
		if(test.getStatus()==200){
			px.clearNameSpace();
			px.addNameSpace("a", "http://schemas.datacontract.org/2004/07/CYTS.Aoyou.Product.WebsiteLogic.Entity");
			px.Load(test.getResponseString());
			String adultPrice = px.getElementText("//a:AdultPrice");
			String childPrice = px.getElementText("//a:ChildPrice");
			
			checkPoint.notEquals(adultPrice,"0.00","adultPriceΪ0.00");
			checkPoint.notEquals(adultPrice,"0","adultPriceΪ0");
			checkPoint.notEquals(adultPrice,"1.00","adultPriceΪ1.00");
			checkPoint.notEquals(adultPrice,"1","adultPriceΪ1");
			checkPoint.notEquals(adultPrice,null,"adultPriceΪnull");
			
			checkPoint.notEquals(childPrice,"0.00","childPriceΪ0.00");
			checkPoint.notEquals(childPrice,"0","childPriceΪ0");
			checkPoint.notEquals(childPrice,"1.00","childPriceΪ1.00");
			checkPoint.notEquals(childPrice,"1","childPriceΪ1");
			checkPoint.notEquals(childPrice,null,"childPriceΪnull");
			
		}else {checkPoint.isFaild("�ӿ�����ʧ��!״̬�룺"+test.getStatus());};
		
		checkPoint.result("��Ʒ��"+id+" ����"+departDate+"��ѯ�ز���Ϣȫ����ȷ��");
		
	}
}
