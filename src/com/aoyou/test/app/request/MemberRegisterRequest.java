package com.aoyou.test.app.request;

import com.aoyou.test.app.request.param.model.MemberRegisterParamModel;
import com.aoyou.test.templates.RestServiceTemplate;

public class MemberRegisterRequest extends RestServiceTemplate{

	@Override
	public void initParams() {
		// TODO Auto-generated method stub
		MemberRegisterParamModel memberRegisterParamModel=new MemberRegisterParamModel();
		memberRegisterParamModel.Mobile="13132169010";
		memberRegisterParamModel.Password="Fiona19870907";
		memberRegisterParamModel.Name="Mr Lee";
		this.paramModel=memberRegisterParamModel;
	}

	@Override
	public void setMethodVersion() {
		// TODO Auto-generated method stub
		this.version="app3.5";
	}

}
