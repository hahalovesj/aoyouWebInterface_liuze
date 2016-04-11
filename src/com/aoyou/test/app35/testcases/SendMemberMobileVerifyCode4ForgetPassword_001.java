package com.aoyou.test.app35.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aoyou.test.app.Result.model.SendMemberMobileVerifyCode4ForgetPasswordResult;
import com.aoyou.test.app.request.SendMemberMobileVerifyCode4ForgetPasswordRequest;
import com.aoyou.test.app.request.param.model.SendMemberMobileVerifyCodeParamModel;
import com.aoyou.test.base.Data;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.templates.RestServiceTemplate;
import com.aoyou.test.util.HttpStatus;

public class SendMemberMobileVerifyCode4ForgetPassword_001 extends TestBase{

	@BeforeClass
	public void setUp(){
		Data.currentClassName=this.getClass().getSimpleName();
	}
	
	@Test
	public void sendMemberMobileVerifyCode4ForgetPassword_001(){
		
		this.test=new SendMemberMobileVerifyCode4ForgetPasswordRequest();
		this.test.sendPost();
		
		int status=this.test.getStatus();
		int runTime=((RestServiceTemplate) this.test).getRunTime();
		SendMemberMobileVerifyCodeParamModel sendMemberMobileVerifyCode=((RestServiceTemplate) this.test).getRequestParamMode();
		if(status==HttpStatus.OK.value()){
			SendMemberMobileVerifyCode4ForgetPasswordResult sendMemberMobileVerifyCodeResult=(SendMemberMobileVerifyCode4ForgetPasswordResult) ((RestServiceTemplate) this.test).getResponseMode();
			this.checkPoint.equals(sendMemberMobileVerifyCodeResult.Data,0,"���ŷ���ʧ��");
		}else{
			this.checkPoint.isFaild("�ӿ�����ʧ�ܣ�״̬��:"+status);
		}
		
		this.checkPoint.result("[ִ��ʱ��:"+runTime+"ms]���ֻ�["+sendMemberMobileVerifyCode.mobile+"]���ŷ��ͳɹ�");
	}
}
