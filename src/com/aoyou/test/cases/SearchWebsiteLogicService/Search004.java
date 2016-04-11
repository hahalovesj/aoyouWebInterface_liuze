package com.aoyou.test.cases.SearchWebsiteLogicService;

import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aoyou.test.base.Data;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.templates.SearchWebsiteLogicService.Search;
import com.aoyou.test.listener.TestngRetry;


/**
 * @author liuze
 * @ClassName: Search004
 * @Description:  排序项、分页功能验证
 */
public class Search004 extends TestBase{
	
	@BeforeClass  
    public void setUp(){
    	Data.currentClassName = this.getClass().getSimpleName();
    }
	
	@Test(retryAnalyzer = TestngRetry.class)	
	public void search004(){

		test = new Search();
		test.setParams("Key", "1");
		test.setParams("SortBy", "2");
		test.setParams("SortType", "0");
		test.setParams("PageIndex", "5");
		test.setParams("PageSize", "100");
		test.sendPost();
		
		if(test.getStatus()==200){	
			responseString = test.getResponseString();
			px.addNameSpace("a", "http://schemas.datacontract.org/2004/07/CYTS.Aoyou.Search.WebsiteLogic.Entity");
			px.Load(responseString);
			int proNumber = px.getElementObjects("//a:ProductView").size();
			List<String> SalePrice = px.getElementsText("//a:ProductView//a:SalePrice");
			
		        	for(int i=0;i<SalePrice.size()-1;i++){
		     		    if(Integer.valueOf(SalePrice.get(i).substring(0, SalePrice.get(i).length()-3))>Integer.valueOf(SalePrice.get(i+1).substring(0, SalePrice.get(i+1).length()-3))){
		     			 checkPoint.isFaild("从低到高价格排序出错了！");
		     	        }
		          }
		    checkPoint.equals(proNumber, 100,"每页产品数与请求参数不符");   
		}else{checkPoint.isFaild("接口请求失败!状态码："+test.getStatus());};
		
		checkPoint.result("排序项、分页搜索功能正确");
	}
		
}
