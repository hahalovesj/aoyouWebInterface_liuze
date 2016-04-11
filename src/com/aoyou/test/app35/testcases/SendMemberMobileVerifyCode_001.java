package com.aoyou.test.app35.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aoyou.test.app.Result.model.SendMemberMobileVerifyCodeResult;
import com.aoyou.test.app.request.SendMemberMobileVerifyCodeRequest;
import com.aoyou.test.app.request.param.model.SendMemberMobileVerifyCodeParamModel;
import com.aoyou.test.base.Data;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.templates.RestServiceTemplate;
import com.aoyou.test.util.HttpStatus;

public class SendMemberMobileVerifyCode_001 extends TestBase{

	@BeforeClass
	public void setUp(){
		Data.currentClassName=this.getClass().getSimpleName();
	}
	
	@Test
	public void sendMemberMobileVerifyCode_001(){
		
		this.test=new SendMemberMobileVerifyCodeRequest();
		this.test.sendPost();
		
		int status=this.test.getStatus();
		int runTime=((RestServiceTemplate) this.test).getRunTime();
		SendMemberMobileVerifyCodeParamModel sendMemberMobileVerifyCode=((RestServiceTemplate) this.test).getRequestParamMode();
		if(status==HttpStatus.OK.value()){
			SendMemberMobileVerifyCodeResult sendMemberMobileVerifyCodeResult=(SendMemberMobileVerifyCodeResult) ((RestServiceTemplate) this.test).getResponseMode();
			this.checkPoint.equals(sendMemberMobileVerifyCodeResult.Data,0,"短信发送失败");
		}else{
			this.checkPoint.isFaild("接口请求失败！状态码:"+status);
		}
		
		this.checkPoint.result("[执行时间:"+runTime+"ms]新手机["+sendMemberMobileVerifyCode.mobile+"]短信发送成功");
	}
}
