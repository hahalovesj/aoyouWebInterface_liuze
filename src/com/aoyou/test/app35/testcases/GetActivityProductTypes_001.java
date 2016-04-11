package com.aoyou.test.app35.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aoyou.test.app.Result.model.GetActivityProductTypesResult;
import com.aoyou.test.app.request.GetActivityProductTypesRequest;
import com.aoyou.test.app.request.param.model.GetDeptCityAdsParamModel;
import com.aoyou.test.base.Data;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.templates.RestServiceTemplate;
import com.aoyou.test.util.HttpStatus;

public class GetActivityProductTypes_001 extends TestBase{

	@BeforeClass
	public void setUp(){
		Data.currentClassName=this.getClass().getSimpleName();
	}
	
	@Test
	public void getActivityProductTypes_001(){
		
		this.test=new GetActivityProductTypesRequest();
		this.test.sendPost();
		
		int runTime=((RestServiceTemplate) this.test).getRunTime();
		int status=this.test.getStatus();
		GetDeptCityAdsParamModel getDeptCityAdsParamModel=((RestServiceTemplate) this.test).getRequestParamMode();
		if(status==HttpStatus.OK.value()){
			GetActivityProductTypesResult getActivityProductTypesResult=(GetActivityProductTypesResult) ((RestServiceTemplate) this.test).getResponseMode();
			if(getActivityProductTypesResult.ReturnCode==0){
				this.checkPoint.equals(getActivityProductTypesResult.Message, "获取抢优惠筛选产品类型成功!", "执行消息值不正确,返回值为:["+getActivityProductTypesResult.Message+"],期望值为:[获取抢优惠筛选产品类型成功!]");
			
				//针对returncode=0 但是没有数据返回的情况
				int size=getActivityProductTypesResult.Data.size();
				if(size>0){
					//此处加入子节点验证
				}else{
					
				}
			}
		}else{
			this.checkPoint.isFaild("接口请求失败！状态码:"+status);
		}
		
		this.checkPoint.result("[执行时间:"+runTime+"ms]CityID["+getDeptCityAdsParamModel.CityID+"]获取抢优惠筛选产品类型成功!");
	}
}
