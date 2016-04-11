package com.aoyou.test.cases.productWebsiteLogicService;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aoyou.test.base.Action;
import com.aoyou.test.base.Data;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.listener.TestngRetry;
import com.aoyou.test.templates.productWebsiteLogicService.GetPackageProductPriceList;


/**
 * @author liuze
 * @ClassName: GetPackageProductPriceList001
 * @Description: 随机获取一个自由行产品ID，获取详情页信息，检查productId、showPrice
 */

public class GetPackageProductPriceList001 extends TestBase{
	
	@BeforeClass  
    public void setUp(){
    	Data.currentClassName = this.getClass().getSimpleName();
    }
	
	@Test(retryAnalyzer = TestngRetry.class)
	public void getPackageProductPriceList001(){
		
		int priceNumber = 0;
		List<String> Pid = new ArrayList<String>();
		List<String> showPrice = new ArrayList<String>();	
		List<String> productID = Action.getProductID(1, "1");

		test = new GetPackageProductPriceList();
		test.setParams("ProductID", productID.get(0));
		test.sendPost();
			
		if(test.getStatus()==200){
			responseString = test.getResponseString();
   		    px.addNameSpace("a", "http://schemas.datacontract.org/2004/07/CYTS.Aoyou.Product.WebsiteLogic.Entity");
			px.Load(responseString);				
			priceNumber = px.getElementObjects("//a:PackageProductPriceDTO").size();
			Pid = px.getElementsText("//a:ProductID");
			showPrice = px.getElementsText("//a:ShowPrice");
			
			checkPoint.equals(Pid, productID.get(0), "产品ID不符!");
			checkPoint.notEquals(showPrice,"0.00");
			checkPoint.notEquals(showPrice,"0");
			checkPoint.notEquals(showPrice,"1.00");
			checkPoint.notEquals(showPrice,"1");
			checkPoint.notEquals(showPrice,null);
			
		}else{checkPoint.isFaild("接口请求失败!状态码："+test.getStatus());};

		checkPoint.result("产品："+productID.get(0)+" 共返回"+priceNumber+"个报价，基础信息全部正确！");
	}
	
}
