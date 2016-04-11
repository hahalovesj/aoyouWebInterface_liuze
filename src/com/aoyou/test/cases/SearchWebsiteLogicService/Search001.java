package com.aoyou.test.cases.SearchWebsiteLogicService;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aoyou.test.base.Data;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.templates.SearchWebsiteLogicService.Search;
import com.aoyou.test.listener.TestngRetry;
import com.aoyou.test.util.URLAvailability;

/**
 * @author liuze
 * @ClassName: Search001
 * @Description: 入参无非必填项，回参ProductBaseView检查
 */
public class Search001 extends TestBase{
	

	@BeforeClass  
    public void setUp(){
    	Data.currentClassName = this.getClass().getSimpleName();
    }
	
	@Test(retryAnalyzer = TestngRetry.class)
	public void search001(){

		test = new Search();
		test.setParams("Key", "1");
		test.sendPost();
		
		if(test.getStatus()==200){		
			responseString = test.getResponseString();
			px.addNameSpace("a", "http://schemas.datacontract.org/2004/07/CYTS.Aoyou.Search.WebsiteLogic.Entity");
			px.Load(responseString);
			List<String> productName = px.getElementsText("//a:ProductView//a:ProductName");
			List<String> ProductPrice = px.getElementsText("//a:ProductView//a:ProductPrice");
			List<String> SalePrice = px.getElementsText("//a:ProductView//a:SalePrice");
			List<String> ImageSurl = px.getElementsText("//a:ProductView//a:ProductImageSurl");
			List<String> ImageMurl = px.getElementsText("//a:ProductView//a:ProductImageMurl");
			List<String> Imageurl  = new ArrayList<String>();		
			Imageurl.addAll(ImageSurl);
			Imageurl.addAll(ImageMurl);
			
			checkPoint.notEquals(productName, "");
			checkPoint.notEquals(productName, null);
			checkPoint.notEquals(ProductPrice,"0.00");
			checkPoint.notEquals(ProductPrice,"0");
			checkPoint.notEquals(ProductPrice,"1.00");
			checkPoint.notEquals(ProductPrice,"1");
			checkPoint.notEquals(ProductPrice,null);
			checkPoint.notEquals(SalePrice,"0.00");
			checkPoint.notEquals(SalePrice,"0");
			checkPoint.notEquals(SalePrice,"1.00");
			checkPoint.notEquals(SalePrice,"1");
			checkPoint.notEquals(SalePrice,null);
			checkPoint.equals(URLAvailability.isConnect(Imageurl), true);  
			
		}else{checkPoint.isFaild("接口请求失败!状态码："+test.getStatus());}
			checkPoint.result("ProductBaseView信息正确");
	}
	
	
}

	
	
	

