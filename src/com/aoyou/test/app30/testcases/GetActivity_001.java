package com.aoyou.test.app30.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aoyou.test.app.Result.model.GetActivityResult;
import com.aoyou.test.app.request.GetActivityRequest;
import com.aoyou.test.base.Data;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.templates.RestServiceTemplate;
import com.aoyou.test.util.HttpStatus;

public class GetActivity_001 extends TestBase{

	@BeforeClass
	public void setUp(){
		Data.currentClassName=this.getClass().getSimpleName();
	}
	
	@Test
	public void getActivity_001(){
		
		this.test=new GetActivityRequest();
		this.test.sendPost();
		
		//System.out.println(this.test.getResponseString());
		
		int runTime=((RestServiceTemplate) this.test).getRunTime();
		int status=this.test.getStatus();
		if(status==HttpStatus.OK.value()){
			GetActivityResult getActivityResult=(GetActivityResult) ((RestServiceTemplate) this.test).getResponseMode();
			this.checkPoint.equals(getActivityResult.Message, "获取App活动详情数据成功", "执行消息值不正确,返回值为:["+getActivityResult.Message+"],期望值为:[获取App活动详情数据成功]");
		}else{
			this.checkPoint.isFaild("接口请求失败！状态码:"+status);
		}
		
		this.checkPoint.result("[执行时间:"+runTime+"ms]获取App活动详情数据成功");
	}
}
