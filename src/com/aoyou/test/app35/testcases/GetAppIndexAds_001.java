package com.aoyou.test.app35.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aoyou.test.app.Result.model.GetAppIndexAdsResult;
import com.aoyou.test.app.request.GetAppIndexAdsRequest;
import com.aoyou.test.base.Data;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.templates.RestServiceTemplate;
import com.google.gson.Gson;

public class GetAppIndexAds_001 extends TestBase{

	@BeforeClass
	public void setUp(){
		Data.currentClassName=this.getClass().getSimpleName();
	}
	
	@Test
	public void getAppIndexAds_001(){
		
		this.test=new GetAppIndexAdsRequest();
		this.test.sendPost();
		int runTime=((RestServiceTemplate)this.test).getRunTime();
		int status=this.test.getStatus();
		if(status==200){
			Gson gson=new Gson();
			String responseString=this.test.getResponseString();
			GetAppIndexAdsResult getAppIndexAdsResult=gson.fromJson(responseString, GetAppIndexAdsResult.class);
			
			if(getAppIndexAdsResult.ReturnCode==0){
				this.checkPoint.equals(getAppIndexAdsResult.Message, "获取App首页广告列表成功!", "执行消息值不正确,返回值为:["+getAppIndexAdsResult.Message+"],期望值为:[获取App首页广告列表成功!]");
				
				//针对returncode=0 但是没有数据返回的情况
				int size=getAppIndexAdsResult.Data.size();
				if(size>0){
					//此处加入子节点验证
				}else{
					
				}
			}
		}else{
			this.checkPoint.isFaild("接口请求失败!状态码"+status);
		}
		
		this.checkPoint.result("[执行时间:"+runTime+"ms]获取首页广告列表成功！");
	}
}
