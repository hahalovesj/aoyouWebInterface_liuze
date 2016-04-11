package com.aoyou.test.app35.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aoyou.test.app.Result.model.GetMessageInfoResult;
import com.aoyou.test.app.request.GetAllNewMessageInfoRequest;
import com.aoyou.test.base.Data;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.templates.RestServiceTemplate;
import com.google.gson.Gson;

public class GetAllNewMessageInfo_001 extends TestBase{

	@BeforeClass  
    public void setUp(){
    	Data.currentClassName = this.getClass().getSimpleName();
    }
	
	@Test
	public void getAllNewMessageInfo_001(){
		
		this.test=new GetAllNewMessageInfoRequest();
		this.test.sendPost();
		int runTime=((RestServiceTemplate)this.test).getRunTime();
		//System.out.println(this.test.getResponseString());
		int status=this.test.getStatus();
		if(status==200){
			Gson gson=new Gson();
			String responseString=this.test.getResponseString();
			GetMessageInfoResult getMessageInfoResult=gson.fromJson(responseString, GetMessageInfoResult.class);
			if(getMessageInfoResult.ReturnCode==0){
				this.checkPoint.equals(getMessageInfoResult.Message,"","执行消息值不正确");
			}
		}else{
			this.checkPoint.isFaild("接口请求失败!状态码"+status);
		}
		
		this.checkPoint.result("[执行时间:"+runTime+"ms]获取最新消息成功！");
	}
}
