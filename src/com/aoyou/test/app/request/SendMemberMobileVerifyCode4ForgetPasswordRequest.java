package com.aoyou.test.app.request;

import com.aoyou.test.app.request.param.model.SendMemberMobileVerifyCodeParamModel;
import com.aoyou.test.templates.RestServiceTemplate;

public class SendMemberMobileVerifyCode4ForgetPasswordRequest extends RestServiceTemplate{

	@Override
	public void initParams() {
		// TODO Auto-generated method stub
		SendMemberMobileVerifyCodeParamModel sendMemberMobileVerifyCode=new SendMemberMobileVerifyCodeParamModel();
		sendMemberMobileVerifyCode.mobile="18612370907";
		this.paramModel=sendMemberMobileVerifyCode;
	}

	@Override
	public void setMethodVersion() {
		// TODO Auto-generated method stub
		this.version="app3.5";
	}


}
