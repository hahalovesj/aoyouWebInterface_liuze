package com.aoyou.test.app35.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aoyou.test.base.*;
import com.aoyou.test.templates.RestServiceTemplate;
import com.aoyou.test.app.Result.model.GetMessageInfoResult;
import com.aoyou.test.app.request.GetNewMessageInfoRequest;
import com.google.gson.*;

public class GetNewMessageInfo_001 extends TestBase{

	@BeforeClass  
    public void setUp(){
    	Data.currentClassName = this.getClass().getSimpleName();
    }
	
	@Test
	public void getNewMessageInfo_001(){
		
		this.test=new GetNewMessageInfoRequest();
		this.test.sendPost();
		int runTime=((RestServiceTemplate)this.test).getRunTime();
		System.out.println(this.test.getResponseString());
		int status=this.test.getStatus();
		if(status==200){
			Gson gson=new Gson();
			String responseString=this.test.getResponseString();
			GetMessageInfoResult getMessageInfoResult=gson.fromJson(responseString, GetMessageInfoResult.class);
			if(getMessageInfoResult.ReturnCode==0){
				this.checkPoint.equals(getMessageInfoResult.Message,"获取最新消息列表成功","执行消息值不正确,返回值为:["+getMessageInfoResult.Message+"],期望值为:[获取最新消息列表成功]");
			}
		}else{
			this.checkPoint.isFaild("接口请求失败!状态码"+status);
		}
		
		this.checkPoint.result("[执行时间:"+runTime+"ms]获取最新消息成功！");
	}
}
