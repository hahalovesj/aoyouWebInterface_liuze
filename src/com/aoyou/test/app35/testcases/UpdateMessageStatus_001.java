package com.aoyou.test.app35.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aoyou.test.base.*;
import com.aoyou.test.templates.RestServiceTemplate;
import com.aoyou.test.app.Result.model.UpdateMessageStatusResult;
import com.aoyou.test.app.request.UpdateMessageStatusRequest;
import com.google.gson.*;
import com.aoyou.test.app.request.param.model.UpdateMessageStatusParamModel;

public class UpdateMessageStatus_001 extends TestBase{

	@BeforeClass
	public void setUp(){
		Data.currentClassName=this.getClass().getSimpleName();
	}
	
	@Test
	public void updateMessageStatus_001(){
		
		this.test=new UpdateMessageStatusRequest();
		this.test.sendPost();
		int runTime=((RestServiceTemplate)this.test).getRunTime();
		int status=this.test.getStatus();
		if(status==200){
			String responseString=this.test.getResponseString();
			Gson gson=new Gson();
			UpdateMessageStatusResult updateMessageStatusResult=gson.fromJson(responseString, UpdateMessageStatusResult.class);
			if(updateMessageStatusResult.ReturnCode==0){
				this.checkPoint.equals(updateMessageStatusResult.Message, "消息状态回写成功", "执行消息值不正确,返回值为:["+updateMessageStatusResult.Message+"],期望值为:[消息状态回写成功]");
				this.checkPoint.equals(updateMessageStatusResult.Data, true, "执行结果不正确,返回值为 :["+updateMessageStatusResult.Data+"],期望值为:[true]");
			}
		}else{
			this.checkPoint.isFaild("接口请求失败!状态码"+status);
		}
		
		UpdateMessageStatusParamModel updateMessageStatusParamModel=((RestServiceTemplate)this.test).getRequestParamMode();
		this.checkPoint.result("[执行时间:"+runTime+"ms]消息ID:["+updateMessageStatusParamModel.MessageId+"]更新状态成功！");
	}
}
