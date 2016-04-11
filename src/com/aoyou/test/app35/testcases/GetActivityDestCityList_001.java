package com.aoyou.test.app35.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aoyou.test.app.Result.model.GetActivityDestCityListResult;
import com.aoyou.test.app.request.GetActivityDestCityListRequest;
import com.aoyou.test.app.request.param.model.GetActivityDestCityListParamModel;
import com.aoyou.test.base.Data;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.templates.RestServiceTemplate;
import com.aoyou.test.util.HttpStatus;

public class GetActivityDestCityList_001 extends TestBase{

	@BeforeClass
	public void setUp(){
		Data.currentClassName=this.getClass().getSimpleName();
	}
	
	@Test
	public void getActivityDestCityList_001(){
		
		this.test=new GetActivityDestCityListRequest();
		this.test.sendPost();
		
		int runTime=((RestServiceTemplate) this.test).getRunTime();
		int status=this.test.getStatus();
		GetActivityDestCityListParamModel getActivityDestCityListParamModel=((RestServiceTemplate) this.test).getRequestParamMode();
		if(status==HttpStatus.OK.value()){
			GetActivityDestCityListResult getActivityDestCityListResult=(GetActivityDestCityListResult)((RestServiceTemplate) this.test).getResponseMode();
			if(getActivityDestCityListResult.ReturnCode==0){
				this.checkPoint.equals(getActivityDestCityListResult.Message, "获取抢游惠筛选目的地数据成功!", "执行消息值不正确,返回值为:["+getActivityDestCityListResult.Message+"],期望值为:[获取抢游惠筛选目的地数据成功!]");
			
				int size =getActivityDestCityListResult.Data.size();
				if(size>0){
					//此处加入子节点验证
				}else{
					
				}
			}
		}else{
			this.checkPoint.isFaild("接口请求失败！状态码:"+status);
		}
		
		this.checkPoint.result("[执行时间:"+runTime+"ms]CityID["+getActivityDestCityListParamModel.CityID+"]ProductType["+getActivityDestCityListParamModel.ProductType+"]获取抢游惠筛选目的地数据成功!");
	}
}
