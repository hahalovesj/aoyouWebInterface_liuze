package com.aoyou.test.app35.testcases;

import java.util.Date;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aoyou.test.app.Result.model.GetCombinedProductPriceCalendarResult;
import com.aoyou.test.app.request.GetCombinedProductPriceCalendarRequest;
import com.aoyou.test.app.request.param.model.GetCombinedProductPriceCalendarParamModel;
import com.aoyou.test.base.Data;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.templates.RestServiceTemplate;
import com.aoyou.test.util.Common;
import com.aoyou.test.util.HttpStatus;

public class GetCombinedProductPriceCalendar_001 extends TestBase{

	@BeforeClass
	public void setUp(){
		Data.currentClassName=this.getClass().getSimpleName();
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void getCombinedProductPriceCalendarRequest(){
		
		this.test=new GetCombinedProductPriceCalendarRequest();
		this.test.sendPost();
		//System.out.println(this.test.getResponseString());
		GetCombinedProductPriceCalendarParamModel getCombinedProductPriceCalendar=((RestServiceTemplate) this.test).getRequestParamMode();
		
		int runTime=((RestServiceTemplate) this.test).getRunTime();
		int status=this.test.getStatus();
		
		if(status==HttpStatus.OK.value()){
			GetCombinedProductPriceCalendarResult getCombinedProductPriceCalendarResult=(GetCombinedProductPriceCalendarResult) ((RestServiceTemplate) this.test).getResponseMode();
			if(getCombinedProductPriceCalendarResult.ReturnCode==0){
				this.checkPoint.equals(getCombinedProductPriceCalendarResult.Message,"成功", "执行消息值不正确,返回值为:["+getCombinedProductPriceCalendarResult.Message+"],期望值为:[成功]");
				int itemSize=getCombinedProductPriceCalendarResult.Data.ItemList.size();
				if(itemSize>0){
					for(int i=0;i<itemSize;i++){
						int year=getCombinedProductPriceCalendarResult.Data.ItemList.get(i).year;
						int month=getCombinedProductPriceCalendarResult.Data.ItemList.get(i).month;
						int salesItemSize=getCombinedProductPriceCalendarResult.Data.ItemList.get(i).SalesItemViewList.size();
						if(salesItemSize>0){
							for(int j=0;j<salesItemSize;j++){
								Date date=Common.getDate(getCombinedProductPriceCalendarResult.Data.ItemList.get(i).SalesItemViewList.get(j).DepartDate);
								//System.out.println(date);
								this.checkPoint.equals(date.getYear()+1900, year, "返回价格日历的出发日期年份不匹配,产品中出发日期年份为["+(date.getYear()+1900)+"],年份为["+year+"]");
								this.checkPoint.equals(date.getMonth()+1, month, "返回价格日历的出发日期月份不匹配,产品中出发日期月份为["+(date.getMonth()+1)+"],年份为["+month+"]");
							}
						}
					}
				}
			}
		}else{
			this.checkPoint.isFaild("接口请求失败！状态码:"+status);
		}
		
		this.checkPoint.result("[执行时间:"+runTime+"ms]产品ID["+getCombinedProductPriceCalendar.productID+"]价格日历获取成功！");
	}
}
