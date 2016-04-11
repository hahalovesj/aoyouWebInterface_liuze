package com.aoyou.test.cases.SearchWebsiteLogicService;

import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aoyou.test.base.Data;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.templates.SearchWebsiteLogicService.Search;
import com.aoyou.test.util.HandleDate;
import com.aoyou.test.listener.TestngRetry;



/**
 * @author liuze
 * @ClassName: Search003
 * @Description:  filterCondition搜索条件验证
 *
 */
public class Search003 extends TestBase{

	@BeforeClass  
    public void setUp(){
    	Data.currentClassName = this.getClass().getSimpleName();
    }
	
	@Test(retryAnalyzer = TestngRetry.class)	
	public void search003(){
		
		String nowDay = HandleDate.getNowDayString();
		String endDepartDate = HandleDate.getForwardDayString(nowDay, 40);
		String startDepartDate = HandleDate.getForwardDayString(nowDay, 10);
		String isInstantConfirm = "true";
		String maxPrice = "3000";
		String minPrice = "2000";
		
		test = new Search();
		test.setParams("Key", "1");
		test.setParams("EndDepartDate", endDepartDate);
		test.setParams("StartDepartDate",startDepartDate);
		test.setParams("IsInstantConfirm",isInstantConfirm);
		test.setParams("MaxPrice",maxPrice);
		test.setParams("MinPrice",minPrice);
		test.sendPost();
		
		if(test.getStatus()==200){
			responseString = test.getResponseString();
			px.addNameSpace("a", "http://schemas.datacontract.org/2004/07/CYTS.Aoyou.Search.WebsiteLogic.Entity");
			px.Load(responseString);
			List<String> salePrice = px.getElementsText("//a:ProductView//a:SalePrice");
			List<String> productSubType = px.getElementsText("//a:ProductView//a:ProductSubType");
			
			for(String s:salePrice){
				int price = Integer.valueOf(s.substring(0, s.length()-3));
				if(!(price>=Integer.valueOf(minPrice)&&price<=Integer.valueOf(maxPrice))){
					checkPoint.isFaild("产品优惠价超出搜索区间！"+price);
				}
			}			
			checkPoint.equals(productSubType, "2", "产品及时确认产品标示错误");

		}else{checkPoint.isFaild("接口请求失败!状态码："+test.getStatus());};
		checkPoint.result("filterCondition搜索条件正确");
	}

}
