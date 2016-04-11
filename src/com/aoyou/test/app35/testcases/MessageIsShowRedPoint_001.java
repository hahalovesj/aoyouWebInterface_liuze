package com.aoyou.test.app35.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aoyou.test.app.Result.model.MessageIsShowRedPointResult;
import com.aoyou.test.app.request.MessageIsShowRedPointRequest;
import com.aoyou.test.base.Data;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.templates.RestServiceTemplate;
import com.google.gson.Gson;

public class MessageIsShowRedPoint_001 extends TestBase{

	@BeforeClass
	public void setUp(){
		Data.currentClassName=this.getClass().getSimpleName();
	}
	
	@Test
	public void messageIsShowRedPoint_001(){
		
		this.test=new MessageIsShowRedPointRequest();
		this.test.sendPost();
		int runTime=((RestServiceTemplate)this.test).getRunTime();
		int status=this.test.getStatus();
		if(status==200){
			Gson gson=new Gson();
			String responseString=this.test.getResponseString();
			MessageIsShowRedPointResult messageIsShowRedPointResult=gson.fromJson(responseString, MessageIsShowRedPointResult.class);
			
			if(messageIsShowRedPointResult.ReturnCode==0){
				this.checkPoint.equals(messageIsShowRedPointResult.Message, "获取是否显示红点成功", "执行消息值不正确,返回值为:["+messageIsShowRedPointResult.Message+"],期望值为:[获取是否显示红点成功]");
			}else{
				this.checkPoint.equals(messageIsShowRedPointResult.Message, "获取是否显示红点失败", "执行消息值不正确,返回值为:["+messageIsShowRedPointResult.Message+"],期望值为:[获取是否显示红点失败]");
				this.checkPoint.equals(messageIsShowRedPointResult.Data.IsShowRedPoint,false,"是否显示红点结果验证失败，返回值为:["+messageIsShowRedPointResult.Data.IsShowRedPoint+"],期望值为：[false]");
			}	
		}else{
			this.checkPoint.isFaild("接口请求失败!状态码"+status);
		}
		
		this.checkPoint.result("[执行时间:"+runTime+"ms]获取是否显示红点成功");
	}
}
