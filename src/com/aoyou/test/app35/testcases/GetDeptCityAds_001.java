package com.aoyou.test.app35.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aoyou.test.app.Result.model.GetDeptCityAdsResult;
import com.aoyou.test.app.request.GetDeptCityAdsRequest;
import com.aoyou.test.app.request.param.model.GetDeptCityAdsParamModel;
import com.aoyou.test.base.Data;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.templates.RestServiceTemplate;
import com.aoyou.test.util.HttpStatus;

public class GetDeptCityAds_001 extends TestBase{

	@BeforeClass
	public void setUp(){
		Data.currentClassName=this.getClass().getSimpleName();
	}
	
	@Test
	public void getDeptCityAds_001(){
		
		this.test=new GetDeptCityAdsRequest();
		this.test.sendPost();
		
		int runTime=((RestServiceTemplate)this.test).getRunTime();
		GetDeptCityAdsParamModel getDeptCityAdsParamModel=((RestServiceTemplate)this.test).getRequestParamMode();
		int status=this.test.getStatus();
		
		if(status==HttpStatus.OK.value()){
			GetDeptCityAdsResult getDeptCityAdsResult=(GetDeptCityAdsResult)((RestServiceTemplate)this.test).getResponseMode();
			if(getDeptCityAdsResult.ReturnCode==0){
				this.checkPoint.equals(getDeptCityAdsResult.Message, "获取App首页广告列表成功!", "执行消息值不正确,返回值为:["+getDeptCityAdsResult.Message+"],期望值为:[获取App首页广告列表成功!]");
				
				//针对returncode=0 但是没有数据返回的情况
				int size=getDeptCityAdsResult.Data.size();
				if(size>0){
					//此处加入子节点验证
				}else{
					
				}
			}
		}else{
			this.checkPoint.isFaild("接口请求失败！状态码为:"+status);
		}
		
		this.checkPoint.result("[执行时间:"+runTime+"ms]CityID为["+getDeptCityAdsParamModel.CityID+"]的目的地图片获取成功");
	}
}
