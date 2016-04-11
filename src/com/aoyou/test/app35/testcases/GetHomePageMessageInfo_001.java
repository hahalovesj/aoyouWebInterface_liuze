package com.aoyou.test.app35.testcases;

import com.aoyou.test.base.Data;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.templates.RestServiceTemplate;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aoyou.test.app.Result.model.GetHomePageMessageInfoResult;
import com.aoyou.test.app.request.GetHomePageMessageInfoRequest;
import com.google.gson.Gson;

public class GetHomePageMessageInfo_001 extends TestBase{

	@BeforeClass
	public void setUp(){
		Data.currentClassName=this.getClass().getSimpleName();
	}
	
	@Test
	public void getHomePageMessageInfo_001(){
		
		this.test=new GetHomePageMessageInfoRequest();
		this.test.sendPost();
		int runTime=((RestServiceTemplate)this.test).getRunTime();
		int status=this.test.getStatus();
		if(status==200){
			Gson gson=new Gson();
			String requestString=this.test.getResponseString();
			GetHomePageMessageInfoResult getHomePageMessageInfoResult=gson.fromJson(requestString, GetHomePageMessageInfoResult.class);
			if(getHomePageMessageInfoResult.ReturnCode==0){
				int size=getHomePageMessageInfoResult.Data.size();
				if(size<=0){
					//this.checkPoint.equals(size>0, true, "获取的首页消息为空");
				}else{
					this.checkPoint.equals(getHomePageMessageInfoResult.Message,"获取首页消息成功","执行消息值不正确,返回值为:["+getHomePageMessageInfoResult.Message+"],期望值为:[获取首页消息成功]");
				}
			}
		}else{
			this.checkPoint.isFaild("接口请求失败!状态码"+status);
		}
		
		this.checkPoint.result("[执行时间:"+runTime+"ms]获取首页傲游头条消息成功");
	}
}
