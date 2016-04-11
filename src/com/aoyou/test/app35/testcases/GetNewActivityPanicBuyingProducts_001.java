package com.aoyou.test.app35.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.aoyou.test.app.Result.model.GetNewActivityPanicBuyingProductsResult;
import com.aoyou.test.app.request.GetNewActivityPanicBuyingProductsRequest;
import com.aoyou.test.app.request.param.model.GetNewActivityPanicBuyingProductsParamModel;
import com.aoyou.test.base.Data;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.templates.RestServiceTemplate;
import com.aoyou.test.util.HttpStatus;

public class GetNewActivityPanicBuyingProducts_001 extends TestBase{

	@BeforeClass
	public void setUp(){
		Data.currentClassName=this.getClass().getSimpleName();
	}
	
	@Test
	public void getNewActivityPanicBuyingProducts_001(){
		
		this.test=new GetNewActivityPanicBuyingProductsRequest();
		this.test.sendPost();
		
		GetNewActivityPanicBuyingProductsParamModel getDeptCityAdsParamModel=((RestServiceTemplate)this.test).getRequestParamMode();
		int runTime=((RestServiceTemplate)this.test).getRunTime();
		int status=this.test.getStatus();
		//System.out.println(this.test.getResponseString());
		if(status==HttpStatus.OK.value()){
			GetNewActivityPanicBuyingProductsResult getActivityPanicBuyingProductsResult=(GetNewActivityPanicBuyingProductsResult)((RestServiceTemplate)this.test).getResponseMode();
			
			if(getActivityPanicBuyingProductsResult.ReturnCode==0){
				this.checkPoint.equals(getActivityPanicBuyingProductsResult.Message, "获取App抢购产品数据成功!", "执行消息值不正确,返回值为:["+getActivityPanicBuyingProductsResult.Message+"],期望值为:[获取App抢购产品数据成功!]");
				
				//针对returncode=0 但是没有数据返回的情况
				int size=getActivityPanicBuyingProductsResult.Data.size();
				if(size>0){
					//此处加入子节点验证
					
				}else{
					
				}
			}
		}else{
			this.checkPoint.isFaild("接口请求失败！状态码为:"+status);
		}
		
		this.checkPoint.result("[执行时间:"+runTime+"ms]CityID["+getDeptCityAdsParamModel.CityID+"]获取App抢购产品数据成功!");
	}
}
