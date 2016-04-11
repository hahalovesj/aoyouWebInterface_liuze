package com.aoyou.test.cases.SearchWebsiteLogicService;

import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aoyou.test.base.Data;
import com.aoyou.test.base.SetTest;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.templates.SearchWebsiteLogicService.Search;
import com.aoyou.test.listener.TestngRetry;


/**
 * @author liuze
 * @ClassName: Search002
 * @Description:  searchCondition搜索条件验证
 *
 */
public class Search002 extends TestBase{
	
	@BeforeClass
    
    public void setUp(){
    	Data.currentClassName = this.getClass().getSimpleName();
    }
	
	@Test(retryAnalyzer = TestngRetry.class)
	
	public void search002(){
			
		SetTest test = new Search();
		test.setParams("Key", "1");
		test.setParams("DepartCityID", "838");
		test.setParams("KeyWord","首尔");
		test.sendPost();
		
		if(test.getStatus()==200){
			responseString = test.getResponseString();
			px.addNameSpace("a", "http://schemas.datacontract.org/2004/07/CYTS.Aoyou.Search.WebsiteLogic.Entity");
			px.Load(responseString);
			List<String> beginCityName = px.getElementsText("//a:ProductView//a:BeginCityName");
			List<String> productName = px.getElementsText("//a:ProductView//a:ProductName");
			checkPoint.contains(beginCityName, "广州", "产品出发城市");
			checkPoint.contains(productName, "首尔", "产品标题未包含搜索关键字");
			
		}else{checkPoint.isFaild("接口请求失败!状态码："+test.getStatus());}
		checkPoint.result("searchCondition搜索条件正确");
	}	
	
}
