package com.aoyou.test.app.request;

import com.aoyou.test.app.request.param.model.SendOldMobileVerifyCodeParamModel;
import com.aoyou.test.templates.RestServiceTemplate;

public class SendOldMobileVerifyCodeRequest extends RestServiceTemplate{

	@Override
	public void initParams() {
		// TODO Auto-generated method stub
		SendOldMobileVerifyCodeParamModel sendOldMobileVerifyCodeParamModel=new SendOldMobileVerifyCodeParamModel();
		this.paramModel=sendOldMobileVerifyCodeParamModel;
	}

	@Override
	public void setMethodVersion() {
		// TODO Auto-generated method stub
		this.version="app3.5";
	}

}
