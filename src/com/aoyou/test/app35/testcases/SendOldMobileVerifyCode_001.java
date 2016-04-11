package com.aoyou.test.app35.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.aoyou.test.app.Result.model.SendOldMobileVerifyCodeResult;
import com.aoyou.test.app.request.SendOldMobileVerifyCodeRequest;
import com.aoyou.test.base.Data;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.templates.RestServiceTemplate;
import com.aoyou.test.util.HttpStatus;

public class SendOldMobileVerifyCode_001 extends TestBase{

	@BeforeClass
	public void setUp(){
		Data.currentClassName=this.getClass().getSimpleName();
	}
	
	@Test
	public void sendOldMobileVerifyCode_001(){
		
		this.test=new SendOldMobileVerifyCodeRequest();
		this.test.sendPost();
		
		int runTime=((RestServiceTemplate)this.test).getRunTime();
		int status=this.test.getStatus();
		//SendOldMobileVerifyCodeParamModel sendOldMobileVerifyCodeParamModel=((RestServiceTemplate) this.test).getRequestParamMode();
		if(status==HttpStatus.OK.value()){
			SendOldMobileVerifyCodeResult getPopularSearchListResult=(SendOldMobileVerifyCodeResult) ((RestServiceTemplate)this.test).getResponseMode();
			if(getPopularSearchListResult.ReturnCode==0){
				this.checkPoint.equals(getPopularSearchListResult.Data, 0, "发送手机验证码失败");
				
			}
		}else{
			this.checkPoint.isFaild("接口请求失败!状态码为:"+status);
		}
		
		this.checkPoint.result("[执行时间:"+runTime+"ms]发送手机验证码成功");
	}
}
